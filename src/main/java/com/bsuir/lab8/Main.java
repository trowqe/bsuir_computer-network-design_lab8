package com.bsuir.lab8;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayListService service = new ArrayListService();

        List list = new ArrayList<String>();
        list.add("эники");
        list.add("беники");
        list.add("ели");
        list.add("вареники");
        service.writeToXmlFile(list);
        System.out.println("written list tj xml file");
        System.out.println("equals strings in first list: " + service.countEqualsElements(list));


        List list2 = new ArrayList<String>();
        list2.add("one");
        list2.add("one");
        list2.add("one");
        list2.add("two");
        list2.add("two");
        list2.add("two");
        list2.add("two");
        list2.add("three");
        System.out.println("equals strings in second list: " + service.countEqualsElements(list2));

        System.out.println("revert entries: " + service.reverseEntities(list));

        System.out.println("count chars: " + service.charCharacteristic(list));

        System.out.println("find sub elements: " + service.findSubElement(list, "и"));

        System.out.println("read from file lo arrayList");
        service.readFromFileToListAndSout("src/main/resources/text.txt");

        System.out.println("compare inner objects in firstList:" + service.compareInnerObjects(list, 1, 2));

        System.out.println("count length of elements: " + service.countLengthOfElements(list));

        System.out.println("add in list like in queue");
        service.addAsInQueue(list, 4, "sd");
    }
}
