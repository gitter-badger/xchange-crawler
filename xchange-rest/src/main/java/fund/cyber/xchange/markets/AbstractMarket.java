package fund.cyber.xchange.markets;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.poloniex.PoloniexExchange;
import com.xeiam.xchange.poloniex.service.polling.PoloniexMarketDataServiceRaw;
import com.xeiam.xchange.service.BaseExchangeService;
import com.xeiam.xchange.service.polling.marketdata.PollingMarketDataService;
import fund.cyber.xchange.model.api.TickerDto;
import fund.cyber.xchange.service.ChaingearDataLoader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by andreyl on 04.11.15.
 */
public abstract class AbstractMarket<T extends BaseExchangeService> implements InitializingBean {

    protected Exchange exchange;

    protected PollingMarketDataService dataService;

    private Map<CurrencyPair, TickerDto> tickers;

    @Autowired
    private ChaingearDataLoader chaingearDataLoader;

    @Override
    public void afterPropertiesSet() throws Exception {
        initExchange();
        dataService = exchange.getPollingMarketDataService();
        tickers = new HashMap<>();
    }

    public abstract void initExchange();

    public List<CurrencyPair> getCurrencyPairs() throws IOException {
        return ((T) dataService).getExchangeSymbols();
    }

    public Ticker getTicker(CurrencyPair currencyPair) throws IOException {
        return dataService.getTicker(currencyPair);
    }

    public String getMarketUrl() {
        return "http://" + exchange.getDefaultExchangeSpecification().getHost() + "/";
    }

    protected void loadData() throws IOException {
        List<TickerDto> tickers = new ArrayList<TickerDto>();
        for (CurrencyPair pair : getCurrencyPairs()) {
            if (!isCurrency(pair.counterSymbol) || !isCurrency(pair.baseSymbol)) {
                continue;
            }
            try {
                this.tickers.put(pair, chaingearDataLoader.createTickerDto(getTicker(pair), getMarketUrl()));
            } catch (IOException e) {
                System.out.print("Host: " + exchange.getDefaultExchangeSpecification().getHost() + ". Pair: " + pair.baseSymbol + "/" + pair.counterSymbol);
                System.out.println(e);
            }
        }
    }

    public Collection<TickerDto> getLastData() {
        return tickers.values();
    }

    boolean isCurrency(String code) {
        return Currency.getAvailableCurrencies().stream()
                .anyMatch(currency -> currency.getCurrencyCode().equals(code)) ||
                chaingearDataLoader.isCurrency(code);
    }

}