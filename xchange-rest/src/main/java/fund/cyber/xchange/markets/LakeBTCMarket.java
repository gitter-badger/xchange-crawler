package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.lakebtc.LakeBTCExchange;
import com.xeiam.xchange.lakebtc.service.polling.LakeBTCMarketDataService;
import org.springframework.stereotype.Service;

/**
 * LakeBTC Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class LakeBTCMarket extends AbstractMarket<LakeBTCMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(LakeBTCExchange.class.getName());
    }

}
