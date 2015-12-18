package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.jubi.JubiExchange;
import com.xeiam.xchange.jubi.service.polling.JubiMarketDataService;
import org.springframework.stereotype.Service;

/**
 * Jubi Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class JubiMarket extends AbstractMarket<JubiMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(JubiExchange.class.getName());
    }

    @Override
    public boolean useCurrentDate() {
        return true;
    }

}