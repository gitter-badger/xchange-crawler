package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.mexbt.MeXBTExchange;
import com.xeiam.xchange.mexbt.service.polling.MeXBTMarketDataService;
import org.springframework.stereotype.Service;

/**
 * MeXBT Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class MeXBTMarket extends AbstractMarket<MeXBTMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(MeXBTExchange.class.getName());
    }

}