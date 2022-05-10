package Base.Map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = createMap();

        for (Map.Entry<String, String> entry: map.entrySet()) {
            System.out.println("key为" + entry.getKey() + ", value为" + entry.getValue());
        }

        System.out.println("=========");

        for (String key: map.keySet()) {
            System.out.println("key为" + key);
        }

        System.out.println("=========");

        for (String value: map.values()) {
            System.out.println("value为" + value);
        }
    }

    private static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put("key" + i, String.valueOf(i));
        }

        return map;
    }
}
