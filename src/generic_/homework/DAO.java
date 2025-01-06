package generic_.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DAO<T> {
    HashMap<String, T> map;

    public DAO() {
        map = new HashMap<>();
    }

    public void save(String key, T value) {
        map.put(key, value);
    }

    public T get(String key) {
        return map.get(key);
    }

    public void update(String key, T value) {
        map.put(key, value);
    }

    public List<T> list() {
//        ArrayList<T> list = new ArrayList<>();
//        HashSet<String> set = (HashSet<String>) map.keySet();
//        for (String key : set) {
//            list.add(get(k
//        }
        return new ArrayList<>(map.values());
    }

    public void delete(String key) {
        map.remove(key);
    }
}
