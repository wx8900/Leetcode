package onsite.trade;

import onsite.test.EquityPositionInterface;
import onsite.test.Operation;
import onsite.test.TradeAction;
import onsite.test.Transaction;

import java.util.*;

/**
 * This is a implement class of Equity Position
 *
 * @author Wenxian Cai
 * @version V1.0
 * @date 2019/12/3 15:52
 */
public class EquityPositionImpl3 implements EquityPositionInterface {

    @Override
    public List<List<String>> getPosition(List<Transaction> tradeInfos) {
        if (null == tradeInfos || tradeInfos.isEmpty()) {
            throw new IllegalArgumentException("tradeInfos is null or empty!!!");
        }

        List<List<String>> result = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();
        for (int i = 0; i < tradeInfos.size(); i++) {
            Transaction tradeInfo = tradeInfos.get(i);
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
            List<String> str1 = processPosition("REL", map);
            List<String> str2 = processPosition("ITC", map);
            List<String> str3 = processPosition("INF", map);
            result = Arrays.asList(str1, str2, str3);
        }

        return result;
    }

    private List<String> processPosition(String inputKey, Map<String, List<Transaction>> map) {
        List result = new ArrayList();
        List<Transaction> insertList = new ArrayList<>();
        List<Transaction> updateList = new ArrayList<>();
        List<Transaction> cancelList = new ArrayList<>();

        for (String key : map.keySet()) {
            if (inputKey.equals(key)) {
                List TradeInfoList = map.get(key);
                for (int i = 0, size = TradeInfoList.size(); i < size; i++) {
                    Transaction t = (Transaction) TradeInfoList.get(i);
                    if (TradeAction.INSERT.equals(t.getTradeAction())) {
                        insertList.add(t);
                    } else if (TradeAction.UPDATE.equals(t.getTradeAction())) {
                        updateList.add(t);
                    } else if (TradeAction.CANCEL.equals(t.getTradeAction())) {
                        cancelList.add(t);
                        break;
                    }
                }

                result = caculateInsertPosition(result, insertList, key);
                result = caculateUpdatePosition(result, updateList, key);
                result = caculateCancelPosition(result, cancelList, key);
            }
        }

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
            result.add(" 0");
        }
        return result;
    }
}
