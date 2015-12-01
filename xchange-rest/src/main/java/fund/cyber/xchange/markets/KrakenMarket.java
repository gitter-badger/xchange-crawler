package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.kraken.KrakenExchange;
import com.xeiam.xchange.kraken.service.polling.KrakenMarketDataService;
import org.springframework.stereotype.Service;

/**
 *  Kraken Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class KrakenMarket extends AbstractMarket<KrakenMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(KrakenExchange.class.getName());
    }

}