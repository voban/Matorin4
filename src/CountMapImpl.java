import java.util.HashMap;
import java.util.Map;

/**
 * Created by Владимир on 10.11.2016.
 */
public class CountMapImpl<T> implements CountMap<T> {
    private Map<T, Integer> map = new HashMap<>();

    @Override
    public void add(T o) {
        if (!map.containsKey(o))
            map.put(o, 1);
        else map.put(o, map.get(o) + 1);
    }

    @Override
    public int getCount(T o) {
        return map.get(o);
    }

    @Override
    public int remove(T o) {
        return map.remove(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        try {
            Map<T, Integer> data = (Map<T, Integer>) source.toMap();
            for (Map.Entry<T, Integer> pair : data.entrySet())
                if (!map.containsKey(pair.getKey()))
                    map.put(pair.getKey(), 1);
                else map.put(pair.getKey(), map.get(pair.getKey()) + pair.getValue());
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map toMap() {
        return map;
    }

    @Override
    public void toMap(Map destination) {
        destination = map;
    }

    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);
        int count1 = map.getCount(5); // 2
        int count2 = map.getCount(6); // 1
        int count3 = map.getCount(10); // 3
        System.out.println(count1);
        System.out.println(count2);
        System.out.println(count3);
    }
}
