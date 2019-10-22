package com.bsuir.lab8;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ArrayListService implements ListService<List, String> {

    @Override
    public void defaultAdd(List arrayList, String s) {
        arrayList.add(s);
    }

    @Override
    public int countEqualsElements(List arrayList) {
        Set set = (Set) arrayList.stream()
                .collect(Collectors.toSet());
        return
                arrayList.size() - set.size();

    }

    @Override
    public void writeToXmlFile(List arrayList) throws FileNotFoundException {
        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(
                new FileOutputStream("arrayList.xml")));
        e.writeObject(arrayList);
        e.close();
    }

    @Override
    public List reverseEntities(List arrayList) {
        return (ArrayList) arrayList.stream()
                .map(s -> new StringBuffer((String) s).reverse().toString())
                .collect(Collectors.toList());
    }

    @Override
    public Map charCharacteristic(List arrayList) {
        HashMap<Character, Integer> characteristics = new HashMap<>();
        arrayList.forEach(s -> countCharsInString(s.toString(), characteristics));
        return characteristics;
    }

    @Override
    public String findSubElement(List arrayList, String s) {
        try {
            String result = (String) arrayList.stream().filter(str -> str.toString().contains(s)).findFirst().get();
            return result;
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    @Override
    public List readFromFileToListAndSout(String filePath) {
        try {
            Scanner s = new Scanner(new File(filePath));
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()) {
                list.add(s.nextLine());
            }
            s.close();
            list.forEach(str -> System.out.println(str));
            return list;
        } catch (FileNotFoundException e) {
            return Collections.EMPTY_LIST;
        }

    }

    @Override
    public int compareInnerObjects(List list, int firstIndex, int secondIndex) {
        return list.get(firstIndex).toString().compareTo(list.get(secondIndex).toString());
    }

    public Map countLengthOfElements(List list) {
        return (HashMap<String, Integer>) list.stream()
                .collect(Collectors.toMap(i -> i, i -> i.toString().length()));
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
