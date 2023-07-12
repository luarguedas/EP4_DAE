package com.example.EP4.controllers;

import com.example.EP4.models.Visita;
import com.example.EP4.servicio.Visitaservicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.lang.Long;
import java.lang.String;

@AllArgsConstructor
@Controller
@RequestMapping("/home")
public class ControllerHome {
    @Autowired
    private final Visitaservicio visitaservice;

    @GetMapping("")
    public String index(Model model) throws Exception {

        List<Visita> visitaList = visitaservice.obtenerVisita();
        model.addAttribute("visita", visitaList);
        model.addAttribute("fecha", LocalDate.now().toString());
        model.addAttribute("hora", LocalTime.now().toString());
        return "index";
    }
        @GetMapping("/actualizar")
        public String actualizar(@RequestParam Long id, Model model) throws Exception {
            model.addAttribute("visitas", visitaservice.obtenerPorId(id));
            model.addAttribute("fecha", LocalDate.now().toString());
            model.addAttribute("hora", LocalTime.now().toString());
            return "editar";
        }

    @PostMapping("")
    public String add(@ModelAttribute("visitas") Visita visita){
        visitaservice.addVisita(visita);
        return "redirect:/home";
    }

    @PutMapping("/editar")
    public String actualizar(@ModelAttribute("visitas") Visita visita, @PathVariable Long id){
        visita.setId(id);
        visitaservice.addVisita(visita);
        return "redirect:/home";
    }

    @GetMapping("/{id}")
    public String eliminar(@PathVariable("id") Long id){
        visitaservice.eliminate(id);
        return "redirect:/home";
    }
}
