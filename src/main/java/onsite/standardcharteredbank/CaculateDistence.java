package onsite.standardcharteredbank;

/**
 * 多线程，分布式，Java虚拟机问的问题比较多
 *
 * @author Jeff
 * @version V1.0
 * @date 2019/11/29 10:12
 */
public class CaculateDistence {

    static String words = "This ia a good day. How happy it is. I like \n" +
            "swimming and hiking. Do you know KFC?";

    public int caculate(String words) {
        if (null == words && words.length() <= 0) {
            return -1;
        }


        return 0;
    }

    public static int caculateHalfWord(String word, boolean isFirstWord) {
        if (null == word && word.length() <= 0) {
            throw new IllegalArgumentException("The length of input word must large than 0.");
        }

        int length = word.length();
        int result;
        if ((length & 1) == 1) {
            // 奇数 Odd
            if (isFirstWord) {
                result = (int) Math.ceil(new Double(length / 2));
            } else {
                result = (int) Math.floor(new Double(length / 2));
            }
        } else {
            result = length / 2;
        }

        return result;
    }



}
