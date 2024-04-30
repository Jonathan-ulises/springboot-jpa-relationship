package com.jonathan.curso.springboot.jpa.springbootjparelationship;

import java.util.Arrays;
import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.jonathan.curso.springboot.jpa.springbootjparelationship.entities.Address;
import com.jonathan.curso.springboot.jpa.springbootjparelationship.entities.Client;
import com.jonathan.curso.springboot.jpa.springbootjparelationship.entities.Invoice;
import com.jonathan.curso.springboot.jpa.springbootjparelationship.repositories.ClientRepository;
import com.jonathan.curso.springboot.jpa.springbootjparelationship.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements  CommandLineRunner {


	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// manyToOne();
		// oneToMany();
		oneToManyFindById();
	}

	@Transactional
	public void oneToManyFindById() {
		
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address addres1 = new Address("El verjel", 1234);
			Address addres2 = new Address("Vasco de Gama", 9875);

			client.setAdresses(Arrays.asList(addres1, addres2));

			clientRepository.save(client);

			System.out.println(client);
		});
	}

	@Transactional
	public void oneToMany() {
		Client client = new Client("Fran", "Moras");
		Address addres1 = new Address("El verjel", 1234);
		Address addres2 = new Address("Vasco de Gama", 9875);

		client.getAdresses().add(addres1);
		client.getAdresses().add(addres2);

		clientRepository.save(client);

		System.out.println(client);
	}

	@Transactional
	public void manyToOne() {

		Client client = new Client("John", "Doe");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compras de oficina", 2000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println(invoiceDb);
	}

	@Transactional
	public void manyToOneFindByIdClient() {

		Optional<Client> optionalClient = clientRepository.findById(1L);

		if (optionalClient.isPresent()) {
			Client client = optionalClient.get();
			
			Invoice invoice = new Invoice("Compras de oficina", 2000L);
			invoice.setClient(client);
			Invoice invoiceDb = invoiceRepository.save(invoice);
			System.out.println(invoiceDb);
		}
		
	}
}
