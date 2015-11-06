package fund.cyber.xchange.model.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * Volume DTO
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
public class VolumeDto {
    @JsonProperty("native")
    private BigDecimal nativeVolume;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal usd;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal btc;

    public BigDecimal getNativeVolume() {
        return nativeVolume;
    }

    public void setNativeVolume(BigDecimal nativeVolume) {
        this.nativeVolume = nativeVolume;
    }

    public BigDecimal getUsd() {
        return usd;
    }

    public void setUsd(BigDecimal usd) {
        this.usd = usd;
    }

    public BigDecimal getBtc() {
        return btc;
    }

    public void setBtc(BigDecimal btc) {
        this.btc = btc;
    }
}
