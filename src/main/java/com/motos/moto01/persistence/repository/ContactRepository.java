package com.motos.moto01.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.motos.moto01.persistence.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
    
}
