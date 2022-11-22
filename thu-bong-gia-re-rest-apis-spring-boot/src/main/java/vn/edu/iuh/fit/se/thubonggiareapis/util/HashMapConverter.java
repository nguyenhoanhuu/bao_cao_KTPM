package vn.edu.iuh.fit.se.thubonggiareapis.util;

import vn.edu.iuh.fit.se.thubonggiareapis.dto.AbstractDTO;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class HashMapConverter {
    public static HashMap<String, Object> toHashMap(Object object) {
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                hashMap.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return hashMap;
    }

    public static List<HashMap<String, Object>> toListOf(List<?> list) {
        List<HashMap<String, Object>> listOfHashMap = new ArrayList<>();
        list.forEach(o -> {
            HashMap<String, Object> item = toHashMap(o);
            if (o instanceof AbstractDTO) {
                item.put("id", ((AbstractDTO) o).getId());
            }
            listOfHashMap.add(item);
        });
        return listOfHashMap;
    }
}
