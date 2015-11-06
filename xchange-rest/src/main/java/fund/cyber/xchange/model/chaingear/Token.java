package fund.cyber.xchange.model.chaingear;

/**
 * Token DTO. Contains trade symbol.
 * <p>
 * @author Andrey Lobarev nxtpool@gmail.com
 */
public class Token {
    private String token_name;
    private String token_symbol;

    public String getToken_name() {
        return token_name;
    }

    public void setToken_name(String token_name) {
        this.token_name = token_name;
    }

    public String getToken_symbol() {
        return token_symbol;
    }

    public void setToken_symbol(String token_symbol) {
        this.token_symbol = token_symbol;
    }
}
