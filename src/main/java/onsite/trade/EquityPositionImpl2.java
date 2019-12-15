package onsite.trade;

import onsite.test.EquityPositionInterface;
import onsite.test.Operation;
import onsite.test.TradeAction;
import onsite.test.Transaction;

import java.util.*;

/**
 * This is a implement class of Equity Position interface
 *
 * @author Jack
 * @version V1.0
 * @date 2019/12/3 15:52
 */
public class EquityPositionImpl2 implements EquityPositionInterface {

    @Override
    public List<List<String>> getPosition(List<Transaction> transactions) {
        if (null == transactions || transactions.isEmpty()) {
            throw new IllegalArgumentException("Transactions are null or empty!!!");
        }

        boolean notNull = false;
        for (int i = 0; i < transactions.size(); i++) {
            if (null != transactions.get(i)) {
                notNull = true;
            }
        }

        if (!notNull) {
            //throw new IllegalArgumentException("Every element of Transactions is null!!!");
            System.out.println("Every element of Transactions is null!!!");
        }

        List<List<String>> result = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction tradeInfo = transactions.get(i);
            if (null != tradeInfo) {
                String key = tradeInfo.getSecurityCode();
                if (!map.containsKey(key)) {
                    List<Transaction> list = new ArrayList<>();
                    list.add(tradeInfo);
                    map.put(key, list);
                } else {
                    List<Transaction> oldList = map.get(key);
                    oldList.add(tradeInfo);
                    map.put(key, oldList);
                }
            }
        }

        if (!map.isEmpty()) {
            result = Arrays.asList(
                    processPosition("REL", map.get("REL")),
                    processPosition("ITC", map.get("ITC")),
                    processPosition("INF", map.get("INF"))
            );
        }

        return result;
    }

    private List<String> processPosition(String key, List<Transaction> transactionList) {
        List result = new ArrayList();
        List<Transaction> insertList = new ArrayList<>();
        List<Transaction> updateList = new ArrayList<>();
        List<Transaction> cancelList = new ArrayList<>();

        if (transactionList != null && transactionList.size() > 0) {
            for (int i = 0, size = transactionList.size(); i < size; i++) {
                Transaction t = transactionList.get(i);
                if (TradeAction.INSERT.equals(t.getTradeAction())) {
                    insertList.add(t);
                } else if (TradeAction.UPDATE.equals(t.getTradeAction())) {
                    updateList.add(t);
                } else if (TradeAction.CANCEL.equals(t.getTradeAction())) {
                    cancelList.add(t);
                    break;
                }
            }
        }

        result = caculateInsertPosition(result, insertList, key);
        result = caculateUpdatePosition(result, updateList, key);
        result = caculateCancelPosition(result, cancelList, key);

        return result;
    }

    private List caculateInsertPosition(List result, List<Transaction> insertList, String key) {
        if (insertList != null && insertList.size() > 0) {
            result.add(key);
            int sum = 0;
            for (int i = 0; i < insertList.size(); i++) {
                Transaction tradeInfo = insertList.get(i);
                if (Operation.BUY.equals(tradeInfo.getBuyOrSell())) {
                    sum += tradeInfo.getQuantity();
                } else if (Operation.SELL.equals(tradeInfo.getBuyOrSell())) {
                    sum -= tradeInfo.getQuantity();
                }
            }
            result.add(String.valueOf((sum > 0) ? "+" + sum : "-" + sum));
        }
        return result;
    }

    private List caculateUpdatePosition(List result, List<Transaction> updateList, String key) {
        if (updateList != null && updateList.size() > 0) {
            result = new ArrayList<>();
            result.add(key);
            int sum = 0;
            for (int i = 0; i < updateList.size(); i++) {
                Transaction tradeInfo = updateList.get(i);
                sum = tradeInfo.getQuantity();
            }
            result.add(String.valueOf((sum > 0) ? "+" + sum : "-" + sum));
        }
        return result;
    }

    private List caculateCancelPosition(List result, List<Transaction> cancelList, String key) {
        if (cancelList != null && cancelList.size() > 0) {
            result = new ArrayList<>();
            result.add(key);
            result.add("0");
        }
        return result;
    }
}
