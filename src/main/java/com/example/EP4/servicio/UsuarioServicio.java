package com.example.EP4.servicio;

import com.example.EP4.dto.UsuarioRegistroDTO;
import com.example.EP4.models.Rol;
import com.example.EP4.models.Usuario;
import com.example.EP4.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsuarioServicio {
    private UsuarioRepository usuarioRepository;

    public UsuarioServicio(UsuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(UsuarioRegistroDTO registroDTO){
        Usuario usuario = new Usuario(registroDTO.getNombre(),registroDTO.getApellido(),
                registroDTO.getPassword(), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepository.save(usuario);
    }


    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
