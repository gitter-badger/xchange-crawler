package com.xeiam.xchange.bitbay.service.polling;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.bitbay.BitbayAdapters;
import com.xeiam.xchange.currency.CurrencyPair;
import com.xeiam.xchange.dto.marketdata.OrderBook;
import com.xeiam.xchange.dto.marketdata.Ticker;
import com.xeiam.xchange.dto.marketdata.Trades;
import com.xeiam.xchange.service.polling.marketdata.PollingMarketDataService;

import java.io.IOException;

/**
 * @author kpysniak
 */
public class BitbayMarketDataService extends BitbayMarketDataServiceRaw implements PollingMarketDataService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public BitbayMarketDataService(Exchange exchange) {

    super(exchange);
  }

  public Ticker getTicker(CurrencyPair currencyPair, Object... args) throws IOException {

    return BitbayAdapters.adaptTicker(getBitbayTicker(currencyPair), currencyPair);
  }

  public OrderBook getOrderBook(CurrencyPair currencyPair, Object... args) throws IOException {

    return BitbayAdapters.adaptOrderBook(getBitbayOrderBook(currencyPair), currencyPair);
  }

  public Trades getTrades(CurrencyPair currencyPair, Object... args) throws IOException {

    return BitbayAdapters.adaptTrades(getBitbayTrades(currencyPair), currencyPair);
  }
}
