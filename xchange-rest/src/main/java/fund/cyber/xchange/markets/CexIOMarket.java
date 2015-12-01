package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.cexio.CexIOExchange;
import com.xeiam.xchange.cexio.service.polling.CexIOMarketDataService;
import org.springframework.stereotype.Service;

/**
 * CexIO Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class CexIOMarket extends AbstractMarket<CexIOMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(CexIOExchange.class.getName());
    }

}