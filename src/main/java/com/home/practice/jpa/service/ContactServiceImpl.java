package com.home.practice.jpa.service;

import java.util.List;
import java.util.stream.IntStream;

import com.home.practice.jpa.exception.ContactNotFoundException;
import com.home.practice.jpa.pojo.Contact;
import com.home.practice.jpa.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;


@Service
//@ConditionalOnProperty(name="server.port",havingValue = "9090")
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact getContactById(String id) {
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    public void updateContact(String id, Contact contact) {
        contactRepository.updateContact(findIndexById(id), contact);
    }

    @Override
    public void deleteContact(String id) {
        contactRepository.deleteContact(findIndexById(id)); 
    }

    @Override
    public List<Contact> getContacts() {
        return contactRepository.getContacts();
    }


    private int findIndexById(String id) {
        return IntStream.range(0, contactRepository.getContacts().size())
            .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
            .findFirst()
                .orElseThrow(()->new ContactNotFoundException(id));

    }

}
