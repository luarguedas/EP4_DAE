package com.example.EP4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;


    public Rol(String nombre) {
        this.nombre = nombre;
    }
}
