package com.bsuir.lab8;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Set;
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
}
