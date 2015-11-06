package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.poloniex.PoloniexExchange;
import com.xeiam.xchange.poloniex.service.polling.PoloniexMarketDataServiceRaw;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Poloniex Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class PoloniexMarket extends AbstractMarket<PoloniexMarketDataServiceRaw> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(PoloniexExchange.class.getName());
    }

    @Scheduled(fixedDelay = 30000)
    protected void loadData() throws IOException {
        super.loadData();
    }

}
