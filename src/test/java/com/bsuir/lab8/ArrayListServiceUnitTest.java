package com.bsuir.lab8;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArrayListServiceUnitTest {
    ArrayListService service = new ArrayListService();

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
    public void reverseEntities() {
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

    @Test
    public void charCharacteristic() {
        List list = new ArrayList<String>();
        list.add("эники");
        list.add("беники");
        list.add("ели");
        list.add("вареники");
        Map result = new HashMap<Character, Integer>();
        result.put('а', 1);
        result.put('р', 1);
        result.put('б', 1);
        result.put('в', 1);
        result.put('е', 3);
        result.put('и', 7);
        result.put('к', 3);
        result.put('л', 1);
        result.put('э', 1);
        result.put('н', 3);
        Map characteristic = service.charCharacteristic(list);
        assertEquals(result, characteristic);
    }

    @Test
    public void findSubElement() {
        List list = new ArrayList<String>();
        list.add("эники");
        list.add("беники");
        list.add("ели");
        list.add("вареники");
        assertEquals("вареники", service.findSubElement(list, "ре"));
        assertEquals("эники", service.findSubElement(list, "и"));
        assertEquals("беники", service.findSubElement(list, "беники"));
        assertEquals("ели", service.findSubElement(list, "ел"));
        assertEquals("", service.findSubElement(list, "."));
    }

    @Test
    public void readFromFileToList() {
        service.readFromFileToListAndSout("src/main/resources/text.txt");
    }

    @Test
    public void readFromNotExistingFileToList() {
        assertEquals(Collections.EMPTY_LIST, service.readFromFileToListAndSout("lalalalololo"));
    }

    @Test
    public void compareInnerObjects() {
        List list = new ArrayList<String>();
        list.add("эники");
        list.add("беники");
        list.add("беники");
        list.add("ели");
        assertEquals(0, service.compareInnerObjects(list, 1, 2));
        assertTrue(service.compareInnerObjects(list, 1, 0) < 0);
        assertTrue(service.compareInnerObjects(list, 0, 2) > 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void compareInnerObjectsNotExistingIndexes() {
        List list = new ArrayList();
        service.compareInnerObjects(list, 1, 2);
    }

    @Test
    public void countLengthOfElements(){
        List list = new ArrayList<String>();
        list.add("эники");
        list.add("беники");
        list.add("ели");
        System.out.println(service.countLengthOfElements(list));
    }

}
