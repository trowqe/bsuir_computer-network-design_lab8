package com.bsuir.lab8;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayListService implements ListService<ArrayList, String> {

    @Override
    public void defaultAdd(ArrayList arrayList, String s) {
        arrayList.add(s);
    }

    @Override
    public int countEqualsElements(ArrayList arrayList) {
        Set set = (Set) arrayList.stream()
                .collect(Collectors.toSet());
        return
                arrayList.size() - set.size();

    }

    @Override
    public void writeToXmlFile(ArrayList arrayList) throws FileNotFoundException {
        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream("arrayList.xml")));
        e.writeObject(arrayList);
        e.close();
    }

    @Override
    public ArrayList reverseEntities(ArrayList arrayList) {
        return (ArrayList) arrayList.stream()
                .map(s -> new StringBuffer((String) s).reverse().toString())
                .collect(Collectors.toList());
    }

    @Override
    public Map charCharacteristic(ArrayList arrayList) {
        HashMap<Character, Integer> characteristics = new HashMap<>();
        arrayList.forEach(s -> countCharsInString(s.toString(), characteristics));
        return characteristics;
    }

    @Override
    public String findSubElement(ArrayList arrayList, String s) {
        try {
            String result = (String) arrayList.stream().filter(str -> str.toString().contains(s)).findFirst().get();
            return result;
        } catch (NoSuchElementException e) {
            return "";
        }
    }


    private void countCharsInString(String s, HashMap<Character, Integer> map) {
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
    }


}
