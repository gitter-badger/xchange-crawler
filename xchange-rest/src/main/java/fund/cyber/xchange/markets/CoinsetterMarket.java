package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.coinsetter.CoinsetterExchange;
import com.xeiam.xchange.coinsetter.service.polling.CoinsetterMarketDataService;
import org.springframework.stereotype.Service;

/**
 * Coinsetter Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class CoinsetterMarket extends AbstractMarket<CoinsetterMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(CoinsetterExchange.class.getName());
    }

}