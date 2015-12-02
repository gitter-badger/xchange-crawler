package fund.cyber.xchange.markets;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.service.BaseExchangeService;
import com.xeiam.xchange.service.polling.marketdata.PollingMarketDataService;
import fund.cyber.xchange.model.api.TickerDto;
import fund.cyber.xchange.service.ChaingearDataLoader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Abstract Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
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
        return exchange.getDefaultExchangeSpecification().getHost() != null ?
                "http://" + exchange.getDefaultExchangeSpecification().getHost() + "/" :
                exchange.getDefaultExchangeSpecification().getSslUri();
    }

    protected void loadData() throws IOException {
        List<TickerDto> tickers = new ArrayList<TickerDto>();
        for (CurrencyPair pair : getCurrencyPairs()) {
            if (!isCurrency(pair.counterSymbol) || !isCurrency(pair.baseSymbol)) {
                continue;
            }
            try {
                Ticker ticker = getTicker(pair);
                this.tickers.put(pair, chaingearDataLoader.createTickerDto(ticker, getMarketUrl()));
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