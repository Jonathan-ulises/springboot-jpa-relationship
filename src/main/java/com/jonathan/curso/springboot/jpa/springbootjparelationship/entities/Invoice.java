package com.jonathan.curso.springboot.jpa.springbootjparelationship.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Long total;
    
    // Clase donde esta el atributo - clase hacia
    // Muchas facturas - un cliente
    // nombre columna de relacion por defecto: client_id
    @ManyToOne
    private Client client;

    public Invoice() {
    }
    
    public Invoice(String description, Long total) {
        this.description = description;
        this.total = total;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "{id=" + id + ", description=" + description + ", total=" + total + ", client=" + client + "}";
    }
    
}
