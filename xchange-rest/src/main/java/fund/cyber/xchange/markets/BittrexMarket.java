package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bittrex.v1.BittrexExchange;
import com.xeiam.xchange.bittrex.v1.service.polling.BittrexMarketDataService;
import org.springframework.stereotype.Service;

/**
 * Bittrex Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class BittrexMarket extends AbstractMarket<BittrexMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(BittrexExchange.class.getName());
    }

}