package com.bsuir.lab8;

import java.io.FileNotFoundException;
import java.util.List;

public interface ListService<L, T>{
    void defaultAdd(L l, T t);
    int countEqualsElements(L l);
    void writeToXmlFile(L l) throws FileNotFoundException;
}
