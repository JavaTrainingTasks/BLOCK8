import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ElementCounter {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(1);
        array.add(3);
        array.add(1);
        countForOneCycle(array);
        countForOneCycleWithStream(array);
    }

    static HashMap<Integer, Integer> countForOneCycle(ArrayList<Integer> list) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (Integer el : list) {
            if (result.get(el) == null) {
                result.put(el, 1);
            } else {
                result.put(el, result.get(el) + 1);
            }
        }
        System.out.println(result);
        return result;
    }

    static Map<Integer, Integer> countForOneCycleWithStream(ArrayList<Integer> list) {
        Map<Integer, Integer> result = list.stream().collect(HashMap::new, (map, key) -> {
            if (map.containsKey(key))
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }, HashMap::putAll);
        System.out.println(result);
        return result;
    }
}

