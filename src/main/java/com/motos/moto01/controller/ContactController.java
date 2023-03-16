package com.motos.moto01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motos.moto01.dto.ContactInDTO;
import com.motos.moto01.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    private Map<String, Object> response = new HashMap<>();

    @GetMapping("/all")
    private ResponseEntity<?> findAllContact(){
        response.clear();
        response.put("contacts", this.contactService.getAllContact());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<?> findContactById(@PathVariable("id") Long id){
        response.clear();
        response.put("contact", this.contactService.geContactById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/new")
    private ResponseEntity<?> saveContact(@RequestBody ContactInDTO contactInDTO){
        response.clear();
        this.contactService.saveContact(contactInDTO);
        response.put("message", "save contact succesfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> updateContactById(@PathVariable("id") Long id, @RequestBody ContactInDTO contactInDTO){
        response.clear();
        this.contactService.updateContact(id, contactInDTO);
        response.put("contact", "contact update sucessfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteContactById(@PathVariable("id") Long id){
        response.clear();
        this.contactService.deletePersonById(id);
        response.put("message", "contact delete succesfully");
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
