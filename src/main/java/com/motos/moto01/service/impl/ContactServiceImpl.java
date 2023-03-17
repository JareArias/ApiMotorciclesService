package com.motos.moto01.service.impl;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import com.motos.moto01.dto.ContactInDTO;
import com.motos.moto01.exception.NotFoundException;
import com.motos.moto01.mapper.ContacInDTOToContac;
import com.motos.moto01.persistence.entity.Contact;
import com.motos.moto01.persistence.repository.ContactRepository;
import com.motos.moto01.service.ContactService;
import com.motos.moto01.util.MessageUtil;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;
    private final ContacInDTOToContac contacInDTOToContac;
    private final MessageUtil messageUtil;

    public ContactServiceImpl(ContactRepository contactRepository, ContacInDTOToContac contacInDTOToContac, MessageUtil messageUtil) {
        this.contactRepository = contactRepository;
        this.contacInDTOToContac = contacInDTOToContac;
        this.messageUtil = messageUtil;
    }

    @Override
    public Contact geContactById(Long id) {
      return this.contactRepository.findById(id).orElseThrow(
                () ->   new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
      );
    }

    @Override
    public List<Contact> getAllContact() {
       List<Contact> contacts = contactRepository.findAll();
       return contacts;
    }

    @Override
    public void saveContact(ContactInDTO contactInDTO) {
        Contact contact = this.contacInDTOToContac.map(contactInDTO);
        this.contactRepository.save(contact);
    }

    @Override
    public void updateContact(Long id, ContactInDTO contactInDTO) {
        Contact contact = this.contactRepository.findById(id).orElseThrow(
            () ->   new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
      );
        this.contacInDTOToContac.update(contactInDTO, contact);
        this.contactRepository.save(contact);
    }

    @Override
    public void deletePersonById(Long id) {
        Contact contact = this.contactRepository.findById(id).orElseThrow(
            () ->   new NotFoundException(messageUtil.getMessage("notFound", null, Locale.getDefault()))
      );
        this.contactRepository.delete(contact);
        //this.contactRepository.deleteById(id);
    }
    
}
