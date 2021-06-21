package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HMap {

    public List<List<Object>> map = new ArrayList<>();
    public Integer mapIndex = 0;

    public void put(Integer key, Object value) {
        int keyAddress = key.hashCode();

        if (mapIndex < keyAddress + 1) {

            while (keyAddress > mapIndex) {
                map.add(mapIndex++, null);
            }

            map.add(keyAddress, List.of(value));
        } else {
            List<Object> valueList = map.get(keyAddress);
            if (valueList != null) {
                valueList.add(value);
            } else {
                valueList = new LinkedList<>();
                valueList.add(value);
            }
            map.set(keyAddress, valueList);

        }
    }

    public Object get(Integer key) {
        return map.get(key.hashCode());
    }

}