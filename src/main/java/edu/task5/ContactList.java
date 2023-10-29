package edu.task5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContactList {
    private static final String ORDER_ASC = "ASC";
    private static final String ORDER_DESC = "DESC";
    private static final String VALID_REGEX = "^[a-zA-Z]+( [a-zA-Z]+)?$";

    private ContactList() {
    }

    private static Contact getContact(String[] inform) {
        Contact contact;
        if (inform.length == 1) {
            contact = new Contact(inform[0]);
        } else {
            contact = new Contact(inform[0], inform[1]);
        }
        return contact;
    }



    public static List<Contact> parseContacts(String[] inform, String sort) {
        if (inform == null || inform.length == 0) {
            return Collections.emptyList();
        }
        List<Contact> contacts = new ArrayList<>();
        for (var per : inform) {
            if (!per.matches(VALID_REGEX)) {
                throw new IllegalArgumentException("Wrong information about person");
            }
            Contact contact = getContact(per.split(" "));
            contacts.add(contact);
        }
        if (sort.equals(ORDER_ASC)) {
            contacts.sort(new ComparatorAsc());
        }
        if (sort.equals(ORDER_DESC)) {
            contacts.sort(new ComparatorDesk());
        }
        return contacts;
    }

}
