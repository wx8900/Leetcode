package oaphone.ebay;

import java.time.Duration;
import java.time.Instant;

/**
 *          快捷键
 * ⌃R      （Control 和 R 的组合键）D运行代码
 * ⌃D      （Control 和  的组合键） 调试代码
 * Control + Option + O    优化 import
 * Command + N  生成代码（getter、setter、hashCode、equals、toString、构造函数等）
 * Control + O   覆盖方法（重写父类方法）
 * Control + I   实现方法（实现接口中的方法）
 * ⌘⌥T     包围代码   （使用if..else, try..catch, for, synchronized等包围选中的代码）
 *
 * ⌃Space   基本的代码补全（补全任何类、方法、变量）
 * ⌃⇧Space  智能代码补全（过滤器方法列表和变量的预期类型）
 * Ctrl左/右   上下文件翻页
 *
 * ⌘⌥M     将选中的代码提取为方法
 * ⌘⌥V     提取变量
 * ⌘⌥P     提取参数
 * ⌘F1     在错误或警告处显示具体描述信息
 * ⌘⌥L     格式化代码
 * ⌥F7 / ⌘F7 在文件中查找用法 / 在类中查找用法
 ⌘⇧F7 在文件中突出显示的用法
 *
 * @Author Jeff
 * @Date 2019/3/28 00:37
 * @Version V1.0
 */
public class AllTest {
    // u  n  m  s  f  y  x  a  z
    public static final String input = "aaaazzzzzzzzrrrrrbcccggggggtttkkoooooooaaaayyyyyyyyyyyydhhhjmmmmmmmmmmmmmmmmmmlllxxxxxxxxxxxwwwwwwssssssssssssssspppppppqqqqffffffffffffiiivvvvvvnnnnnnnnnnnnnnnnnnnnuuuuuuuuuuuuuuuuuuuuuuuuu";

    public static void main(String[] args) {

        /*long startTime2 = System.currentTimeMillis();
        DescendingFrequencyOfCharacterII dfc2 = new DescendingFrequencyOfCharacterII();
        System.out.println(" Version 2: Return String is : "+dfc2.getMostAppearance(input));
        long endTime2 = System.currentTimeMillis();
        System.out.println("程序2运行时间： "+(endTime2 - startTime2)+"ms"); // 程序运行时间： 74ms  65ms   67ms

        long startTime3 = System.currentTimeMillis();
        DescendingFrequencyOfCharacterIII dfc3 = new DescendingFrequencyOfCharacterIII();
        System.out.println(" Version 3: Return String is : "+dfc3.getMostAppearance(input));
        long endTime3 = System.currentTimeMillis();
        System.out.println("程序3运行时间： "+(endTime3 - startTime3)+"ms"); // 程序运行时间： 1ms  2ms  2ms

        long startTime4 = System.currentTimeMillis();
        DescendingFrequencyOfCharacterIV dfc4 = new DescendingFrequencyOfCharacterIV();
        System.out.println(" Version 4: Return String is : "+dfc4.getMostAppearance(input));
        long endTime4 = System.currentTimeMillis();
        System.out.println("程序4运行时间： "+(endTime4 - startTime4)+"ms"); //  程序运行时间： 72ms  62ms  62ms */

        Instant start5 = Instant.now();
        DescendingFrequencyOfCharacterV d5 = new DescendingFrequencyOfCharacterV();
        System.out.println(" Version 5: Return String is : "+d5.frequencySort(input));
        Instant end5 = Instant.now();
        long time5 = Duration.between(start5, end5).toMillis();
        System.out.println("程序5 : "+time5 + " ms");
        //System.out.println("程序5运行时间： "+(endTime5 - startTime5)+"ms"); // 程序运行时间： 97ms  68ms  63ms

        Instant start6 = Instant.now();
        DescendingFrequencyOfCharacterVI d6 = new DescendingFrequencyOfCharacterVI();
        System.out.println(" Version 6: Return String is : " + d6.frequencySort(input));
        Instant end6 = Instant.now();
        long time6 = Duration.between(start6, end6).toMillis();
        System.out.println("程序6 : "+time6 + " ms");

        // 比较第一个方法是不是比第二个执行得更快
        /*boolean fast = time5.minus(time6).isNegative();
        System.out.println(fast);*/

        //System.out.println("程序6运行时间： " + (endTime6 - startTime6) + "ms"); // 程序运行时间： 72ms  56ms   64ms
    }


}
