package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.loyalbit.LoyalbitExchange;
import com.xeiam.xchange.loyalbit.service.polling.LoyalbitMarketDataService;
import org.springframework.stereotype.Service;

/**
 * Loyalbit Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class LoyalbitMarket extends AbstractMarket<LoyalbitMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(LoyalbitExchange.class.getName());
    }

}