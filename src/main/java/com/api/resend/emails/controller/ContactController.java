package com.api.resend.emails.controller;

import com.api.resend.emails.models.Contact;
import com.api.resend.emails.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @PostMapping
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        Contact newContact = contactService.createContact(contact);
        return ResponseEntity.ok(newContact);
    }
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        List<Contact> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable int id) {
        Contact contact = contactService.getContactById(id);
        return ResponseEntity.ok(contact);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable int id, @RequestBody Contact contactDetails) {
        Contact updatedContact = contactService.updateContact(id, contactDetails);
        return ResponseEntity.ok(updatedContact);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}
