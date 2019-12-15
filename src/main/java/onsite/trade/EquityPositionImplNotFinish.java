package onsite.trade;
import onsite.test.EquityPositionInterface;
import onsite.test.Operation;
import onsite.test.TradeAction;
import onsite.test.Transaction;

import java.util.*;

/**
 * This is a implement class of Equity Position interface
 *
 * @author Wenxian Cai
 * @version V1.0
 * @date 2019/12/3 15:52
 */
public class EquityPositionImplNotFinish implements EquityPositionInterface {

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

        Map<Integer, List<Transaction>> map = new HashMap<> ();
        for (int i = 0; i < transactions.size(); i++) {
            Transaction transaction = transactions.get(i);
            if (transaction != null) {
                Integer key = transaction.getTradeId();
                if (!map.containsKey(key)) {
                    List<Transaction> list = new ArrayList<>();
                    list.add(transaction);
                    map.put(key, list);
                } else {
                    List<Transaction> oldList = map.get(key);
                    oldList.add(transaction);
                    map.put(key, oldList);
                }
            }
        }

        List<List<String>> resultList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            Integer tradeId = (Integer) entry.getKey();
            List result = new ArrayList();
            List<Transaction> transactionList = (List<Transaction>) entry.getValue();
            for (int i = 0; i < transactionList.size(); i++) {
                Transaction transaction = transactionList.get(i);
                int version = transaction.getVersion();
                int quantity = transaction.getQuantity();
                String securityCode = transaction.getSecurityCode();
                Operation buyOrSell = transaction.getBuyOrSell();
                TradeAction tradeAction = transaction.getTradeAction();

                // INSERT
                if (version == 1) {
                    int sum = 0;
                    Map<String, Integer> mapAll = new HashMap<>();
                    if (Operation.BUY.equals(buyOrSell)) {
                        sum += quantity;
                    } else if (Operation.SELL.equals(buyOrSell)) {
                        sum -= quantity;
                    }
                    if (mapAll.containsKey(securityCode)) {
                        int oldVal = mapAll.get(securityCode);
                        mapAll.put(securityCode, sum + oldVal);
                    } else {
                        mapAll.put(securityCode, sum);
                    }
                    int res = mapAll.get(securityCode);
                    result.add(securityCode);
                    result.add(String.valueOf((res > 0) ? "+" + res : res));
                }
                // UPDATE OR CANCEL
                if (version >= 2) {
                    int sum2= 0;
                    if (TradeAction.UPDATE == tradeAction) {
                        result = new ArrayList();
                        transaction.setSecurityCode(securityCode);
                        transaction.setQuantity(transaction.getQuantity());
                        transaction.setBuyOrSell(transaction.getBuyOrSell());

                        result.add(transaction.getSecurityCode());
                        sum2 = transaction.getQuantity();
                        result.add(String.valueOf((sum2 > 0) ? "+" + sum2 : sum2));
                    }
                    if (TradeAction.CANCEL == tradeAction) {
                        result = new ArrayList();
                        result.add(securityCode);
                        result.add("0");
                        break;
                    }
                }
            }
            resultList.add(result);
        }

        return resultList;
    }

}