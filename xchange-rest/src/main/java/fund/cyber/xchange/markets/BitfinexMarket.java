package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bitfinex.v1.BitfinexExchange;
import com.xeiam.xchange.bitfinex.v1.service.polling.BitfinexMarketDataServiceRaw;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Bitfinex Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class BitfinexMarket extends AbstractMarket<BitfinexMarketDataServiceRaw> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());
    }

}
