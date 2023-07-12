package com.example.EP4.servicio;
import com.example.EP4.exeption.Exeptionvisita;
import com.example.EP4.repository.Repository;
import com.example.EP4.models.Visita;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class Visitaservicio{


        private final Repository repository;
        public List<Visita> obtenerVisita(){
            return repository.findAll();
        }

        public Visita obtenerPorId(Long id) throws Exception{
            Optional<Visita> visita = repository.findById(id);
            if (visita.isPresent()){
                return visita.get();
            }else {
                throw new Exception("El alumno no existe");
            }
        }

        public  Visita addVisita(Visita visita){
            return repository.save(visita);
        }
        public void eliminate(Long id){
           repository.deleteById(id);

        }

}
