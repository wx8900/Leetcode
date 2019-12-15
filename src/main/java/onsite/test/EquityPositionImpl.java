package onsite.test;

import java.util.*;
import java.util.concurrent.locks.Lock;

/**
 * This is a implement class of Equity Position interface
 *
 * @author  Jack
 * @version V1.0
 * @date    12/03/2019 15:52
 */
public class EquityPositionImpl implements EquityPositionInterface {

    Lock lock;

    @Override
    public List<List<String>> getPosition(List<Transaction> transactions) {
        if (null == transactions || transactions.isEmpty()) {
            throw new IllegalArgumentException("Transactions are null or empty!!!");
        }

        boolean notNull = false;
        int transactionSize = transactions.size();
        for (int i = 0; i < transactionSize; i++) {
            if (null != transactions.get(i)) {
                notNull = true;
                break;
            }
        }

        if (!notNull) {
            throw new IllegalArgumentException("Every element of input transactions list is null!!!");
        }

        List<Transaction> list;
        List<List<String>> result = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>(16);
        for (int i = 0; i < transactionSize; i++) {
            Transaction transaction = transactions.get(i);
            if (null != transaction) {
                String key = transaction.getSecurityCode();
                if (!map.containsKey(key)) {
                    list = new ArrayList<>();
                    list.add(transaction);
                    map.put(key, list);
                } else {
                    list = map.get(key);
                    list.add(transaction);
                    map.put(key, list);
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

    private synchronized List<String> processPosition(String key, List<Transaction> transactionList) {
        List result = new ArrayList();
        List<Transaction> insertList = new ArrayList<>();
        List<Transaction> updateList = new ArrayList<>();
        List<Transaction> cancelList = new ArrayList<>();

        if (transactionList != null && transactionList.size() > 0) {
            for (int i = 0, size = transactionList.size(); i < size; i++) {
                Transaction t = transactionList.get(i);
                TradeAction tradeAction = t.getTradeAction();
                if (TradeAction.INSERT.equals(tradeAction)) {
                    insertList.add(t);
                } else if (TradeAction.UPDATE.equals(tradeAction)) {
                    updateList.add(t);
                } else if (TradeAction.CANCEL.equals(tradeAction)) {
                    cancelList.add(t);
                    break;
                }
            }
        }

        result = insertPosition(result, insertList, key);
        result = updatePosition(result, updateList, key);
        result = cancelPosition(result, cancelList, key);

        return result;
    }

    private synchronized List insertPosition(List result, List<Transaction> insertList, String key) {
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

    private synchronized List updatePosition(List result, List<Transaction> updateList, String key) {
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

    private synchronized List cancelPosition(List result, List<Transaction> cancelList, String key) {
        if (cancelList != null && cancelList.size() > 0) {
            result = new ArrayList<>();
            result.add(key);
            result.add("0");
        }
        return result;
    }
}