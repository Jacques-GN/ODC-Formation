package com.example.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

/**
 * Représente un employé et regroupe ses informations ainsi que les méthodes
 * permettant de les modifier.
 */

@Data
@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Prénom de l'employé. */
    @Column(name = "first_name")
    private String firstName;
    /** Nom de famille de l'employé. */
    @Column(name = "last_name")
    private String lastName;
    /** Adresse e-mail de l'employé. */
    @Column(name = "mail", unique = true)
    private String mail;
    /** Poste occupé par l'employé. */
    @Column(name = "position")
    private String position;
    /** Mot de passe associé au compte. */
    @Column(name = "password")
    private String password;

    
}