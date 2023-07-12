package com.example.EP4.exeption;

public class Exeptionvisita extends RuntimeException{

    public Exeptionvisita(Long id){
        super("Visita no existe");
    }

}

