package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bter.BTERExchange;
import com.xeiam.xchange.bter.service.polling.BTERPollingMarketDataService;
import org.springframework.stereotype.Service;

/**
 * BTER Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class BTERMarket extends AbstractMarket<BTERPollingMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(BTERExchange.class.getName());
    }

}