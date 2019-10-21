package com.bsuir.lab8;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayListServiceUnitTest {
    ListService service = new ArrayListService();

    @Test
    public void defaultAdd() {
        List list = mock(ArrayList.class);
        when(list.add(anyString())).thenReturn(true);
        service.defaultAdd(list, "lololo");
        Mockito.verify(list).add(anyString());
    }


    @Test
    public void countEqualsElements() {
        Set set = new HashSet<String>();
        List list = mock(ArrayList.class);
        when(list.stream()).thenReturn(Stream.empty());
        assertEquals(0, service.countEqualsElements(list));
    }

    @Test
    public void writeToXmlFile() {
        List list = new ArrayList<String>();
        list.add("эники");
        list.add("беники");
        list.add("ели");
        list.add("вареники");
        try {
            service.writeToXmlFile(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void reverseEntities(){
        List list = new ArrayList<String>();
        list.add("эники");
        list.add("беники");
        list.add("ели");
        List result = new ArrayList<String>();
        result.add("икинэ");
        result.add("икинеб");
        result.add("иле");

        ArrayList<String> reversed = (ArrayList<String>) service.reverseEntities(list);
        assertEquals(result, reversed);
    }



}
