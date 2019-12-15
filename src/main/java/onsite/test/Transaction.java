package onsite.test;

/**
 * This is a transaction information class
 *
 * @author  Jack
 * @version V1.0
 * @date    12/03/2019 15:40
 */
public class Transaction {

    private int transactionId;
    private int tradeId;
    private int version;
    private String securityCode;
    private int quantity;
    private TradeAction tradeAction;
    private Operation buyOrSell;

    public Transaction() {
    }

    public Transaction(int transactionId, int tradeId, int version, String securityCode, int quantity, TradeAction tradeAction, Operation buyOrSell) {
        this.transactionId = transactionId;
        this.tradeId = tradeId;
        this.version = version;
        this.securityCode = securityCode;
        this.quantity = quantity;
        this.tradeAction = tradeAction;
        this.buyOrSell = buyOrSell;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTradeId() {
        return tradeId;
    }

    public void setTradeId(int tradeId) {
        this.tradeId = tradeId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TradeAction getTradeAction() {
        return tradeAction;
    }

    public void setTradeAction(TradeAction tradeAction) {
        this.tradeAction = tradeAction;
    }

    public Operation getBuyOrSell() {
        return buyOrSell;
    }

    public void setBuyOrSell(Operation buyOrSell) {
        this.buyOrSell = buyOrSell;
    }

    @Override
    public String toString() {
        return "TransAction{" +
                "transactionId=" + transactionId +
                ", tradeId=" + tradeId +
                ", version=" + version +
                ", securityCode=" + securityCode +
                ", quantity=" + quantity +
                ", tradeAction=" + tradeAction +
                ", buyOrSell=" + buyOrSell +
                '}';
    }
}

