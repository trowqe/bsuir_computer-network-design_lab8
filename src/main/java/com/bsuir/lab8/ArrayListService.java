package com.bsuir.lab8;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayListService implements ListService<ArrayList, String> {

    public void defaultAdd(ArrayList arrayList, String s) {
        arrayList.add(s);
    }

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
}
