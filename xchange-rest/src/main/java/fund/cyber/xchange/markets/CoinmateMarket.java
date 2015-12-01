package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.coinmate.CoinmateExchange;
import com.xeiam.xchange.coinmate.service.polling.CoinmateMarketDataService;
import org.springframework.stereotype.Service;

/**
 * Coinmate Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class CoinmateMarket extends AbstractMarket<CoinmateMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(CoinmateExchange.class.getName());
    }

}