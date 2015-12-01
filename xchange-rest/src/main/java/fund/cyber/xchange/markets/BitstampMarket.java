package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bitstamp.BitstampExchange;
import com.xeiam.xchange.bitstamp.service.polling.BitstampMarketDataService;
import org.springframework.stereotype.Service;

/**
 *  Bitstamp Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class BitstampMarket extends AbstractMarket<BitstampMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());
    }

}