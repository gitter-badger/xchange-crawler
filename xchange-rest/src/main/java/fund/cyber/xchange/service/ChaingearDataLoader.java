package fund.cyber.xchange.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xeiam.xchange.dto.marketdata.Ticker;
import fund.cyber.xchange.model.api.LastPriceDto;
import fund.cyber.xchange.model.api.TickerDto;
import fund.cyber.xchange.model.api.VolumeDto;
import fund.cyber.xchange.model.chaingear.Currency;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Chaingear project Data loader. Used to have standardized names for currencies. And filter out 'trash' coins.
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Component
public class ChaingearDataLoader implements InitializingBean {

    public static final String CHAINGEAR_URL = "http://chaingear.cyber.fund/chaingear.json";

    private Map<String, String> currencyNames;

    public List<Currency> loadCurrencies() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL url = new URL(CHAINGEAR_URL);

        return objectMapper.readValue(url, objectMapper.getTypeFactory().
                constructCollectionType(List.class, Currency.class));
    }

    public Map<String, String> loadCurrencyNames() throws IOException {
        return loadCurrencies().stream().collect(Collectors.toMap(
                currency -> currency.getToken().getToken_symbol(),
                Currency::getSystem,
                (first, last) -> last));
    }

    public String getCurrencyName(String symbol) {
        return currencyNames.get(symbol);
    }

    public boolean isCurrency(String symbol) {
        return currencyNames.containsKey(symbol);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        currencyNames = loadCurrencyNames();
    }

    private String getNameOrLeaveSymbol(String symbol) {
        String name = getCurrencyName(symbol);
        if (name != null) {
            return name;
        }
        try {
           return java.util.Currency.getInstance(symbol).getDisplayName();
        } catch (IllegalArgumentException ex) {
            return symbol;
        }
    }

    public TickerDto createTickerDto(Ticker ticker, String market) {
        TickerDto dto = new TickerDto();
        dto.setReceived(new Date());
        dto.setTimestamp(ticker.getTimestamp());
        dto.setMarket(market);
        dto.setBase(getNameOrLeaveSymbol(ticker.getCurrencyPair().counterSymbol));
        dto.setQuote(getNameOrLeaveSymbol(ticker.getCurrencyPair().baseSymbol));
        LastPriceDto price = new LastPriceDto();
        price.setNativePrice(ticker.getLast());
        dto.setLast(price);
        VolumeDto volume = new VolumeDto();
        volume.setNativeVolume(ticker.getVolume());
        dto.setVolume(volume);
        return dto;
    }
}
