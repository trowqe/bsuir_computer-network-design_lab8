package com.bsuir.lab8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayListServiceIntegrationTest {

    ListService service = new ArrayListService();

    @Test
    public void countEqualsElementsDoNotHaveEquals(){
        List list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals(0, service.countEqualsElements(list));
    }

    @Test
    public void countEqualsElementsFiveEquals(){
        List list = new ArrayList<String>();
        list.add("one");
        list.add("one");
        list.add("one");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("two");
        list.add("three");
        assertEquals(5, service.countEqualsElements(list));
    }
}
