package com.example.kkcbackend.controller;

import com.example.kkcbackend.model.Contact;
import com.example.kkcbackend.model.Ulb;
import com.example.kkcbackend.model.Unit;
import com.example.kkcbackend.payload.request.ContactRequest;
import com.example.kkcbackend.payload.request.UnitRequest;
import com.example.kkcbackend.payload.responce.StringResponce;
import com.example.kkcbackend.service.ContactService;
import com.example.kkcbackend.service.UlbService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ContactController {
    @Autowired
    ContactService contactService;
    @Autowired
    UlbService ulbService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addContact(@Valid @NotNull @RequestBody ContactRequest c){
        String responce;
        if(c.getAddress()!=null && c.getUlbName()!=null && c.getPersonName()!=null && c.getPersonMobile()!=null){
            Boolean flag = contactService.checkPersonExistsByMobile(c.getPersonMobile());
            Ulb ulb = ulbService.findByUlbName(c.getUlbName());
            if (flag) {
                Contact contact = new Contact(c.getPersonName(), c.getPersonMobile(), c.getAddress(), ulb);
                contactService.insertPerson(contact);
                responce = "Contact Added";
                return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.OK);

            } else {
                responce = "Contact exists";
                return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
            }
        }
        else {
            responce = "Parameter missing";
            return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "{ulbname}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<? extends Object> getContacts(@PathVariable("ulbname") String ulbname){
        List<Contact> c = contactService.getContactByUlb(ulbname);
        if(!c.isEmpty()){
            return new ResponseEntity<List<Contact>>(c,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<StringResponce>(new StringResponce("Invalid ulb name or no contacts"),HttpStatus.UNAUTHORIZED);
        }

    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateContact(@Valid @NotNull @RequestBody ContactRequest c){
        Boolean flag = contactService.checkPersonExistsById(c.getId());
        Ulb ulb = ulbService.findByUlbName(c.getUlbName());
        String responce;
        if(ulb != null ){
            if(!flag){
                Contact contact = new Contact(c.getId(),c.getPersonName(),c.getPersonMobile(),c.getAddress(),ulb);
                contactService.updateContact(contact);
                responce = "Contact Updated";
                return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.OK);
            }
            else {
                responce = "Contact not exists";
                return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
            }

        }
        else {
            responce = "Ulb not exists";
            return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping(path = "{mobile}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteContact(@PathVariable("mobile") Long mobile){
        Boolean flag = contactService.checkPersonExistsByMobile(mobile);
        String responce;
        if(!flag){
            contactService.deleteContact(mobile);
            responce = "Contact Deleted";
            return new ResponseEntity<StringResponce>(new StringResponce(responce), HttpStatus.OK);

        }
        else {
            responce = "Contact not exists";
            return new ResponseEntity<StringResponce >(new StringResponce(responce), HttpStatus.UNAUTHORIZED);
        }
    }
}
