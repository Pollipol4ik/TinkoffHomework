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
        switch (inform.length) {
            case 1:
                contact = new Contact(inform[0]);
                break;
            case 2:
                contact = new Contact(inform[0], inform[1]);
                break;
            default:
                throw new IllegalArgumentException("Invalid number of elements in inform array");
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

        switch (sort) {
            case ORDER_ASC:
                contacts.sort(new ComparatorAsc());
                break;
            case ORDER_DESC:
                contacts.sort(new ComparatorDesc());
                break;
            default:
                throw new IllegalArgumentException("Invalid sorting order");
        }

        return contacts;
    }
}
