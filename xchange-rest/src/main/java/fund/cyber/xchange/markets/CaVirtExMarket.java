package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.virtex.v2.VirtExExchange;
import com.xeiam.xchange.virtex.v2.service.polling.VirtExMarketDataService;
import org.springframework.stereotype.Service;

/**
 * CaVirtEx Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class CaVirtExMarket extends AbstractMarket<VirtExMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(VirtExExchange.class.getName());
    }

}