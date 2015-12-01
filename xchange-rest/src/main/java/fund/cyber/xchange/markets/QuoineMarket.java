package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.quoine.QuoineExchange;
import com.xeiam.xchange.quoine.service.polling.QuoineMarketDataService;
import com.xeiam.xchange.quoine.service.polling.QuoineMarketDataServiceRaw;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Quoine Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class QuoineMarket extends AbstractMarket<QuoineMarketDataService> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(QuoineExchange.class.getName());
    }

}