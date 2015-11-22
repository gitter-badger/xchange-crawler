package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.okcoin.OkCoinExchange;
import com.xeiam.xchange.okcoin.service.polling.OkCoinMarketDataService;
import com.xeiam.xchange.poloniex.PoloniexExchange;
import com.xeiam.xchange.poloniex.service.polling.PoloniexMarketDataServiceRaw;
import org.springframework.stereotype.Service;

/**
 * OkCoin Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class OkCoinMarket extends AbstractMarket<OkCoinMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(OkCoinExchange.class.getName());
    }

}
