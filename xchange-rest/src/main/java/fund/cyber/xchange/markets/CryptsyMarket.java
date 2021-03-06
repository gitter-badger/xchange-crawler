package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.cryptsy.CryptsyExchange;
import com.xeiam.xchange.cryptsy.service.polling.CryptsyPublicMarketDataService;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Cryptsy Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class CryptsyMarket extends AbstractMarket<CryptsyPublicMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(CryptsyExchange.class.getName());
    }


}


