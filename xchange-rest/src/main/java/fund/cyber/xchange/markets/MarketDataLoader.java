package fund.cyber.xchange.markets;

import com.xeiam.xchange.btc38.Btc38;
import fund.cyber.xchange.model.api.TickerDto;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MarketDataLoader implements InitializingBean {

    @Autowired
    private PoloniexMarket poloniex;

    @Autowired
    private CryptsyMarket cryptsy;

    @Autowired
    private BitfinexMarket bitfinex;

    @Autowired
    private OkCoinMarket okCoin;

    @Autowired
    private BitstampMarket bitstamp;

    @Autowired
    private LakeBTCMarket lakeBTC;

    @Autowired
    private BTCEMarket btce;

    @Autowired
    private CoinbaseMarket coinbase;

    @Autowired
    private KrakenMarket kraken;

    @Autowired
    private Btc38Market btc38;

    private List<AbstractMarket> markets;

    @Override
    public void afterPropertiesSet() throws Exception {
        markets = new ArrayList<>();
        /*
        markets.add(poloniex);
        markets.add(cryptsy);
        markets.add(bitfinex);
        markets.add(okCoin);
        markets.add(bitstamp);
        markets.add(lakeBTC);
        markets.add(btce);
        markets.add(coinbase);
        */
        markets.add(kraken);
        markets.add(btc38);
    }

    @Scheduled(fixedRate = 15000)
    protected void loadData() throws IOException {

        System.out.print("Request started: ");
        System.out.println(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(Calendar.getInstance().getTime()));

        markets.forEach(abstractMarket -> {
                    try {
                        abstractMarket.loadData();
                    } catch (IOException e) {
                        System.out.print("Host: " + abstractMarket.exchange.getDefaultExchangeSpecification().getHost());
                        System.out.println(e);
                    }
                }
        );
    }

    public List<TickerDto> getLastData() {
        Stream<TickerDto> stream = markets.stream().flatMap(market -> market.getLastData().stream());
        return stream.collect(Collectors.toList());
    }

}
