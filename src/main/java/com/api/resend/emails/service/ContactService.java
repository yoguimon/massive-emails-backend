package com.api.resend.emails.service;

import com.api.resend.emails.models.Contact;

import java.util.List;

public interface ContactService {
    Contact createContact(Contact contact);
    List<Contact> getAllContacts();
    Contact getContactById(int id);
    Contact updateContact(int id, Contact contactDetails);
    void deleteContact(int id);
}
