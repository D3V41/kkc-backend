package com.example.kkcbackend.service;

import com.example.kkcbackend.dao.ContactDao;
import com.example.kkcbackend.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactDao contactDao;

    public Boolean insertPerson(Contact contact){
        contactDao.save(contact);
        return true;
    }

    public List<Contact> getContactByUlb(String ulbname){
        return contactDao.getContactsByUlbname(ulbname);
    }

    public Boolean checkPersonExistsByMobile(Long mobile){
        List<Contact> contacts = contactDao.checkPersonExistsByMobile(mobile);
        return contacts.isEmpty();
    }

    public Boolean checkPersonExistsById(Long id){
        List<Contact> contacts = contactDao.checkPersonExistsById(id);
        return contacts.isEmpty();
    }

    public Boolean updateContact(Contact c){
        contactDao.updatePerson(c.getId(),c.getPersonName(),c.getPersonMobile(),c.getAddress(),c.getUlb());
        return true;
    }

    public Boolean deleteContact(Long mobile){
        contactDao.deletePerson(mobile);
        return true;
    }
}
