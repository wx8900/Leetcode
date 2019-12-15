package oaphone.cognizant;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Ctrl+Shift+Space，自动补全代码
 * 输入psvm 自动生成public static void main(String[] args) {}
 * Idea： 输入sout，出现提示
 * 选中想被try/catch, while包围的语句，同时按下ctrl+alt+t
 * Ctrl+Enter，导入包，自动修正
 * Ctrl+Alt+L，格式化代码
 * 快捷键返回，默认是ctrl+alt+方向键
 */
public class Java8Example {
    public static void main(String[] args) {
        Java8Example java8Example = new Java8Example();
        Optional<String> result1 = java8Example.neverThrowNullPointerExceptionWhenInputNull();
        System.out.println("Optional example : " + result1);
        java8Example.whenCreatesEmptyOptional();
        java8Example.getSortDataByGroup();
        System.out.println();
        java8Example.getCountOfGroupBy();
    }

    /**
     * @description  Group by the name + Count or Sum the Qty
     * @author  Jeff
     * @date    2019/04/06 12:01
     * @return  0 when input is null or empty, else return value of input
     */
    private void getCountOfGroupBy() {
        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));

        System.out.println("Group by + Count: " + counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        System.out.println("Group by + Sum qty :    " +sum);

        //group by price
        Map<BigDecimal, List<Item>> groupByPriceMap =
                items.stream().collect(Collectors.groupingBy(Item::getPrice));

        System.out.println("group by price : " + groupByPriceMap);

        // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<BigDecimal, Set<String>> result =
                items.stream().collect(
                        Collectors.groupingBy(Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        System.out.println("group by + mapping to Set : " + result);

    }

    /**
     * @description  get int value by input string
     * @author  Jeff
     * @date    2019/04/06 11:16
     * @param   input user input Id
     * @return  0 when input is null or empty, else return value of input
     */
    private void getSortDataByGroup() {
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        System.out.println(result);
        System.out.println("-------Sort---------");

        Map<String, Long> finalMap = new LinkedHashMap<>();

        //Sort a map and add to finalMap
        result.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue()
                        .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

        System.out.println(finalMap);
    }

    /**
     * 例子：入参可以为Null，不会抛空指针异常
     *
     * @return "Optional example : Optional.empty" when the input is null
     */
    public Optional<String> neverThrowNullPointerExceptionWhenInputNull() {
        String name = null;
        // if use Optional.of(name) in below, it will throw java.lang.NullPointerException
        Optional<String> opt = Optional.ofNullable(name);
        return opt;
    }
    /**
     * 例子：出参可以为Null，不会抛空指针异常
     * @return
     */
    /*public Optional<String> neverThrowNullPointerExceptionWhenInputNull() {
        Optional<String> optional = service.findUserById("667290");
        optional.ifPresent(user -> {
            System.out.println("User's name = " + user.getName());
        });
        return optional;
    }*/

    /**
     * Create an empty Optional
     * Optional.empty example : false
     */
    public void whenCreatesEmptyOptional() {
        Optional<String> empty = Optional.empty();
        System.out.println("Optional.empty example : " + empty.isPresent());
    }

    /**
     * Returning default value using orElse()
     */
    private void getDefaullValueByOrElse() {
        // return "Unknown User" if user is null
        // User finalUser = optionalUser.orElse(new User("0", "Unknown User"));
    }

    /**
     * Checking the presence of a value
     * <p>
     * isPresent() method returns true if the Optional contains a non-null value, otherwise it returns false.
     */
    public void getIsPresent() {
        /*if(optional.isPresent()) {
            // value is present inside Optional
            System.out.println("Value found - " + optional.get());
        } else {
            // value is absent
            System.out.println("Optional is empty");
        }*/
    }

    /**
     * ifPresent() method allows you to pass a Consumer function that is executed if a value is present inside the Optional object.
     */
    public void getIfPresent() {
        /*optional.ifPresent(value -> {
            System.out.println("Value found - " + value);
        });*/
    }
    
    /**
     * @Description: 
     * @Author:     Jack
     * @Date:       2019/3/22 04:47
     * @params:      
     * @returns:    
     */
    public void filterExample(String[] args) {
        /*Person[] men = people.stream()
                .filter(p -> p.getGender() == MALE)
                .toArray(Person[]::new);*/
    }
}
