package fund.cyber.xchange.markets;

import fund.cyber.xchange.model.api.TickerDto;
import fund.cyber.xchange.model.common.IndexHolder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

    @Autowired
    private QuoineMarket quoine;

    @Autowired
    private JubiMarket jubi;

    @Autowired
    private BitbayMarket bitbay;

    @Autowired
    private HitbtcMarket hitbtc;

    @Autowired
    private BittrexMarket bittrex;

    @Autowired
    private LoyalbitMarket loyalbit;

    @Autowired
    private CexIOMarket cexIO;

    @Autowired
    private BTERMarket bter;

    @Autowired
    private CoinmateMarket coinmate;

    @Autowired
    private CaVirtExMarket caVirtEx;

    @Autowired
    private CoinsetterMarket coinsetter;

    @Autowired
    private MeXBTMarket meXBT;

    @Autowired
    private BleutradeMarket bleutrade;

    @Autowired
    private RippleMarket ripple;

    @Autowired
    private GatecoinMarket gatecoin;

    private List<AbstractMarket> markets;

    private final IndexHolder indexHolder = new IndexHolder();

    @Override
    public void afterPropertiesSet() throws Exception {
        markets = new ArrayList<>();

        markets.add(poloniex);
        markets.add(cryptsy);
        markets.add(bitfinex);
        markets.add(okCoin);
        markets.add(bitstamp);
        markets.add(lakeBTC);
        markets.add(btce);
        markets.add(coinbase);
        markets.add(kraken);
        markets.add(btc38);
        markets.add(quoine);
        markets.add(jubi);
        markets.add(bitbay);
        markets.add(hitbtc);
        markets.add(bittrex);
        markets.add(loyalbit);
        markets.add(cexIO);
        markets.add(bter);
        markets.add(coinmate);
        markets.add(caVirtEx);
        markets.add(coinsetter);
        markets.add(meXBT);
        markets.add(bleutrade);
        markets.add(gatecoin);

        //Not yetImplemented
        //markets.add(ripple);

        indexHolder.setLength(markets.size());
    }

    private AbstractMarket getNextMarket() {
        synchronized (indexHolder) {
            AbstractMarket market = markets.get(indexHolder.getIndex());
            indexHolder.increaseIndex();
            return market;
        }
    }

    @Autowired
    private TaskExecutor taskExecutor;

    @Scheduled(fixedRate = 2000)
    protected void loadData() throws IOException {
        taskExecutor.execute(() -> {
            AbstractMarket market = getNextMarket();

            Calendar start = Calendar.getInstance();

            try {
                market.loadData();
            } catch (IOException e) {
                System.out.print("Host: " + market.exchange.getDefaultExchangeSpecification().getHost());
                System.out.println(e);
            }
            /*
            System.out.print("Market: ");
            System.out.print(market.getMarketUrl());
            System.out.print(". Request started at: ");
            System.out.print(DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM).format(start.getTime()));
            System.out.print(". request takes : ");
            System.out.print((Calendar.getInstance().getTimeInMillis() - start.getTimeInMillis()) / 1000.0);
            System.out.println(" seconds.");
            */

        });
    }

    public List<TickerDto> getLastData() {
        Stream<TickerDto> stream = markets.stream().flatMap(market -> market.getLastData().stream());
        return stream.collect(Collectors.toList());
    }

}
