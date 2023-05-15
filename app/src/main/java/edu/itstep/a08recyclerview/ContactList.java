package edu.itstep.a08recyclerview;

import java.util.ArrayList;
import java.util.List;

public class ContactList {

    public static List<Contact> returnList(){
        List<Contact> listData = new ArrayList<>();
        for (int i = 1; i <= 300; i++) {
            listData.add(new Contact("John", "Smith"));
            listData.get(i-1).setPhone("32154634634");
        }
        return listData;
    }
}
