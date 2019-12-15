package leetcode.apple;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8 {
    static List<Employee> employeeList = Arrays.asList(
            new Employee(23, "Som", 26),
            new Employee(9,"Jetty", 21),
            new Employee(39,"Jeff", 35),
            new Employee(107,"Jimmy", 50),
            new Employee(5, "Steven", 19)
    );

    public static void main(String[] args) {
        System.out.println(doIt(Arrays.asList(1, 2, 3, 4, 5, 6 ,7, 8, 9, 10, 11, 12)));
        System.out.println("===searchFirst===" + searchFirstObject(employeeList));
        System.out.println("===searchList===" + searchList(employeeList));
        System.out.println("===searchAllResults===" + searchAllResults(employeeList));
        System.out.println("===searchList===" + searchList(employeeList));
        System.out.println("===searchSum===" + searchSum(employeeList));
    }

    private static String doIt(List<Integer> list) {
        return list.parallelStream()
                .filter(i -> ((i & 1) == 0))
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static Employee searchFirstObject(List<Employee> list) {
        return list.parallelStream()          // Convert to steam
                .filter((x) -> (x.getName().startsWith("J") && x.getId() > 10)) // we want "J" start only
                .findFirst()          // If 'findAny' then return found
                .orElse(null);
    }

    private static String searchList(List<Employee> list) {
        return list.parallelStream()
                .filter(i -> ((i.getId()) > 10))
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));// Return is String
    }

    private static List<Employee> searchAllResults(List<Employee> list) {
        return list.parallelStream()
                .filter(i -> ((i.getId()) > 10))
                .collect(Collectors.toList());
    }

    // return sum of all ids those who name start "J"
    private static int searchSum(List<Employee> list) {
        int sum = list.parallelStream()         //  多核CPU，可以多个核同时处理
                .filter(b -> b.getName().startsWith("Je"))
                .mapToInt(b -> b.getId())
                .sum();
        return sum;
    }

}
