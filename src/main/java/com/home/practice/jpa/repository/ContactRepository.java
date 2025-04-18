package com.home.practice.jpa.repository;

import com.home.practice.jpa.pojo.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ContactRepository {
    
    private List<Contact> contacts = new ArrayList<>();

            /*Arrays.asList(
            new Contact("123","John Snow","123456"),
            new Contact("456","Tyrion Lannister","2343455"),
            new Contact("789","Arya Stark","5756657")
    );*/

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int index) {
        return contacts.get(index);
    }

    public void saveContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(int index, Contact contact) { 
        contacts.set(index, contact); 
    }
    
    public void deleteContact(int index) {
        contacts.remove(index);
    }

}
