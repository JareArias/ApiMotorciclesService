package com.motos.moto01.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.motos.moto01.dto.ContactInDTO;
import com.motos.moto01.persistence.entity.Contact;

@Component
public class ContacInDTOToContac implements IMapper<ContactInDTO, Contact> {

    @Override
    public Contact map(ContactInDTO in) {
        Contact contact = new Contact();
        contact.setId(in.getId());
        contact.setFirstName(in.getFirstName());
        contact.setLastName(in.getLastName());
        contact.setCreationDate(LocalDateTime.now());

        return contact;
    }

    @Override
    public void update(ContactInDTO contactDto, Contact contact) {
        if ( contactDto == null ) {
            return;
        }

        if ( contactDto.getFirstName() != null ) {
            contact.setFirstName( contactDto.getFirstName() );
        }
        if ( contactDto.getLastName() != null ) {
            contact.setLastName( contactDto.getLastName() );
        }
    }
}

    