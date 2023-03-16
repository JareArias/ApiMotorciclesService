package com.motos.moto01.service;

import java.util.List;

import com.motos.moto01.dto.ContactInDTO;
import com.motos.moto01.persistence.entity.Contact;

public interface ContactService {
    Contact geContactById(Long id);
    List<Contact> getAllContact();
    void saveContact(ContactInDTO contactInDTO);
    void updateContact(Long id, ContactInDTO contactInDTO);
    void deletePersonById(Long id);
}
