package com.jonathan.curso.springboot.jpa.springbootjparelationship.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jonathan.curso.springboot.jpa.springbootjparelationship.entities.Client;

public interface InvoiceRepository extends CrudRepository<Client, Long> {

}
