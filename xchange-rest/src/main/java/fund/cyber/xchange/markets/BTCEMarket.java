package fund.cyber.xchange.markets;

import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.btce.v3.BTCEExchange;
import com.xeiam.xchange.btce.v3.dto.marketdata.BTCEExchangeInfo;
import com.xeiam.xchange.btce.v3.service.polling.BTCEMarketDataServiceRaw;
import com.xeiam.xchange.currency.CurrencyPair;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * BTCE Market Service
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Service
public class BTCEMarket extends AbstractMarket<BTCEMarketDataServiceRaw> {

    @Override
    public void initExchange() {
        exchange = ExchangeFactory.INSTANCE.createExchange(BTCEExchange.class.getName());
    }

    @Override
    public List<CurrencyPair> getCurrencyPairs() throws IOException {
        BTCEExchangeInfo info = ((BTCEMarketDataServiceRaw) dataService).getBTCEInfo();
        List<CurrencyPair> result = new ArrayList<>();
        info.getPairs().keySet().forEach(p -> result.add(new CurrencyPair(p.toUpperCase().replace('_','/'))));
        return result;
    }
}
