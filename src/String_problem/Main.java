package String_problem;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String str = "javaprogramming";
        //count the characters
        Map<String, Long> collect = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
        
        //find non repeating characters
        List<Map.Entry<String, Long>> nonRepeatiangCharacters = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .collect(Collectors.toList());
        System.out.println(nonRepeatiangCharacters);

        //find repeating characters
        List<Map.Entry<String, Long>> repeatiangCharacters = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1)
                .collect(Collectors.toList());
        System.out.println(repeatiangCharacters);

        //find first nonRepeating characters
        Map.Entry<String, Long> firstNonRepeating = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() == 1)
                .findFirst().get();

        System.out.println(firstNonRepeating);

        //find first Repeating characters
        Map.Entry<String, Long> firstRepeating = Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1)
                .findFirst().get();

        System.out.println(firstRepeating);
    }
}
