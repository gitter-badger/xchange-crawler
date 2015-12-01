package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.coinbase.CoinbaseExchange;
import com.xeiam.xchange.coinbase.service.polling.CoinbaseMarketDataService;
import org.springframework.stereotype.Service;

/**
 *  Coinbase Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class CoinbaseMarket extends AbstractMarket<CoinbaseMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(CoinbaseExchange.class.getName());
    }

}