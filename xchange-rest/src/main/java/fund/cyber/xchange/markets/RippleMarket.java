package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.ripple.RippleExchange;
import com.xeiam.xchange.ripple.service.polling.RippleMarketDataService;
import com.xeiam.xchange.ripple.service.polling.RippleMarketDataServiceRaw;
import org.springframework.stereotype.Service;

/**
 * Ripple Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class RippleMarket extends AbstractMarket<RippleMarketDataServiceRaw> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(RippleExchange.class.getName());
    }

}