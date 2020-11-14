package com.springframework.hotel.services.Impl;

import com.springframework.hotel.models.Contact;
import com.springframework.hotel.repositories.ContactRepository;
import com.springframework.hotel.services.IContactService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements IContactService {
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = new ArrayList<>();
        contactRepository.findAll().forEach(contacts::add);
        return contacts;
    }

    @Override
    public Contact findById(Integer integer) {
        Optional<Contact> contact = contactRepository.findById(integer);
        return contact.orElse(null);
    }

    @Override
    public Contact save(Contact object) {
        return contactRepository.save(object);
    }

    @Override
    public void delete(Contact object) {
        contactRepository.delete(object);
    }

    @Override
    public void deleteById(Integer integer) {
        contactRepository.deleteById(integer);
    }
}
