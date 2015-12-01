package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.btc38.Btc38Exchange;
import com.xeiam.xchange.btc38.service.polling.Btc38MarketDataService;
import org.springframework.stereotype.Service;

/**
 *  Btc38 Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class Btc38Market extends AbstractMarket<Btc38MarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(Btc38Exchange.class.getName());
    }

}