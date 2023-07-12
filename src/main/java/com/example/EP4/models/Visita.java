package com.example.EP4.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name  ="tbl_visita")
@Data
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String local;
    @Column(name = "DNI_AFILIADO", length = 8, unique = true)
    private String dni_afiliado;
    private String fecha;
    private String hora;
}
