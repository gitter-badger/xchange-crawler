package fund.cyber.xchange.model.api;

import java.util.Date;

/**
 * Main REST service output DTO to display tickers
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
public class TickerDto {

    private Date timestamp;
    private String market;
    private String base;
    private String quote;
    private LastPriceDto last;
    private VolumeDto volume;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public LastPriceDto getLast() {
        return last;
    }

    public void setLast(LastPriceDto last) {
        this.last = last;
    }

    public VolumeDto getVolume() {
        return volume;
    }

    public void setVolume(VolumeDto volume) {
        this.volume = volume;
    }
}
