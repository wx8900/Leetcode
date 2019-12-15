package ooddesign;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SideEffectWrongUseFix {
    public static void main (String[] args) {
        long startTime=System.currentTimeMillis();
        IntStream stream = IntStream.range(0, 10000000);
        List<Integer> list = stream
                //.parallel()
                .filter(s -> s % 2 == 0)
                .boxed()
                .collect(Collectors.toList());
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间 ： "+(endTime - startTime)+" ms");
        //System.out.println(list);
    }
}
