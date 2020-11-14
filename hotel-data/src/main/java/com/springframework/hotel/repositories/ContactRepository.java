package com.springframework.hotel.repositories;

import com.springframework.hotel.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
}
