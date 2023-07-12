package com.example.EP4.controllers;

import com.example.EP4.dto.UsuarioRegistroDTO;
import com.example.EP4.servicio.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/registro")
public class UsuarioController {

    @Autowired
    private UsuarioServicio usuarioservice;

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO nuevousuario() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrar() {
        return "registro";
    }
    @PostMapping
    public String registrarCuenta(@ModelAttribute("Usuario")UsuarioRegistroDTO registroDTO){
        usuarioservice.save(registroDTO);
        return "redirect:/registro?exito";

    }
}
