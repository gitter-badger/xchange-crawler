package fund.cyber.xchange.rest;


import fund.cyber.xchange.markets.BitfinexMarket;
import fund.cyber.xchange.markets.CryptsyMarket;
import fund.cyber.xchange.markets.MarketDataLoader;
import fund.cyber.xchange.markets.PoloniexMarket;
import fund.cyber.xchange.model.api.CalendarDto;
import fund.cyber.xchange.model.api.TickerDto;
import fund.cyber.xchange.model.chaingear.Currency;
import fund.cyber.xchange.service.ChaingearDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

/**
 * REST service to display actual market tickers
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    private MarketDataLoader marketData;

    @Autowired
    private ChaingearDataLoader chaingearDataLoader;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public CalendarDto getTime() {
        return new CalendarDto(Calendar.getInstance());
    }

    @RequestMapping(value = "/chaingear", method = RequestMethod.GET)
    @ResponseBody
    public List<Currency> getChaingear() throws IOException {
        return chaingearDataLoader.loadCurrencies();
    }

    @RequestMapping(value = "/markets", method = RequestMethod.GET)
    @ResponseBody
    public Collection<TickerDto> getMarkets() throws IOException {
        Collection<TickerDto> result = new ArrayList<>();
        result.addAll(marketData.getLastData());
        return result;
    }
}

