package onsite.test;

import java.util.List;

/**
 * This is a interface of Equity Position
 *
 * @author  Jack
 * @version V1.0
 * @date    12/03/2019 15:51
 */
public interface EquityPositionInterface {

    /**
     * get positions by security code
     *
     * @param transaction
     * @return List<List<String>>
     * @throws IllegalArgumentException if input parameters has null or empty
     */
    List<List<String>> getPosition(List<Transaction> transaction) throws Exception;

}
