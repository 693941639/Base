package Base.Lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//
//        map.put("k1", "v1");
//        map.put("k2", "v2");
//        map.put("k3", "v3");

//        BiConsumer<String, String> bi = new BiConsumer<String, String>() {
//            @Override
//            public void accept(String s, String s2) {
//                System.out.println(s + ", " + s2);
//            }
//        };
//
//        map.forEach(bi);

//        map.forEach((s1, s2) -> System.out.println(s1 + ", " + s2));
//
//        List<String> list = new ArrayList<>();
//
//        list.add("str1");
//        list.add("str2");
//        list.add("str3");
//        list.add("str4");
//
//        list.stream().filter(s -> s.length() > 4).map(String::toUpperCase).collect(Collectors.toList());

        String rel = randomData(String::valueOf);
    }

    public static String randomData(Function<Double, String> converter) {
        return converter.apply(Math.random());
    }

    public static void processKV(String key, String val) {
        System.out.println("K:" + key + ", V:" + val);
    }
}
