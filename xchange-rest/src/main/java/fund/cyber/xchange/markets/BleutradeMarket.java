package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bleutrade.BleutradeExchange;
import com.xeiam.xchange.bleutrade.service.polling.BleutradeMarketDataService;
import org.springframework.stereotype.Service;

/**
 * Bleutrade Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class BleutradeMarket extends AbstractMarket<BleutradeMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(BleutradeExchange.class.getName());
    }

}