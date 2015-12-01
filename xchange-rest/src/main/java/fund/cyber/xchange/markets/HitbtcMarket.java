package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.btce.v3.dto.marketdata.BTCEExchangeInfo;
import com.xeiam.xchange.btce.v3.service.polling.BTCEMarketDataServiceRaw;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.hitbtc.HitbtcExchange;
import com.xeiam.xchange.hitbtc.dto.marketdata.HitbtcSymbols;
import com.xeiam.xchange.hitbtc.service.polling.HitbtcMarketDataService;
import com.xeiam.xchange.hitbtc.service.polling.HitbtcMarketDataServiceRaw;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Bitbay Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class HitbtcMarket extends AbstractMarket<HitbtcMarketDataServiceRaw> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(HitbtcExchange.class.getName());
    }

    @Override
    public List<CurrencyPair> getCurrencyPairs() throws IOException {
        HitbtcSymbols info = ((HitbtcMarketDataServiceRaw) dataService).getHitbtcSymbols();
        return info.getHitbtcSymbols().stream()
            .map(p -> new CurrencyPair(p.getCommodity(), p.getCurrency()))
                .collect(Collectors.toList());
    }

}