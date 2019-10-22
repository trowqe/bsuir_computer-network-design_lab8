package com.bsuir.lab8;

import java.io.FileNotFoundException;


public interface ListService<L, T> {
    void defaultAdd(L l, T t);

    int countEqualsElements(L l);

    void writeToXmlFile(L l) throws FileNotFoundException;

    L reverseEntities(L l);

    L readFromFileToListAndSout(String filePath);

    int compareInnerObjects(L l, int firstIndex, int secondIndex);

    void addAsInQueue(L l, int capacity, T t);

}
