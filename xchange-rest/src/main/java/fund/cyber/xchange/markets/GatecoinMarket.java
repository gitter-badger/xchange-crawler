package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.gatecoin.GatecoinExchange;
import com.xeiam.xchange.gatecoin.service.polling.GatecoinMarketDataService;
import org.springframework.stereotype.Service;

/**
 * Gatecoin Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class GatecoinMarket extends AbstractMarket<GatecoinMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(GatecoinExchange.class.getName());
    }

}