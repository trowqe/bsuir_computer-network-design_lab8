package com.bsuir.lab8;

import java.io.FileNotFoundException;
import java.util.Map;

public interface ListService<L, T>{
    void defaultAdd(L l, T t);
    int countEqualsElements(L l);
    void writeToXmlFile(L l) throws FileNotFoundException;
    L reverseEntities(L l);
    Map charCharacteristic(L l);
}
