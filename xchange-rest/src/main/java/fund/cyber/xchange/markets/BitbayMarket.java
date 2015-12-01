package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bitbay.BitbayExchange;
import com.xeiam.xchange.bitbay.service.polling.BitbayMarketDataService;
import org.springframework.stereotype.Service;

/**
 * Bitbay Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class BitbayMarket extends AbstractMarket<BitbayMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(BitbayExchange.class.getName());
    }

}