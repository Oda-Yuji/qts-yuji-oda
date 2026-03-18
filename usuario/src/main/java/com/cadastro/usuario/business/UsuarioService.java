package com.cadastro.usuario.business;

import org.springframework.stereotype.Service;
import com.cadastro.usuario.infrastructure.entity.Usuario;
import com.cadastro.usuario.infrastructure.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service

public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void deletarUsuarioPorId(Integer id) {
        repository.deleteById(id);
    }

    public void atualizarUsuario(Usuario usuario, Integer id) {
        Usuario usuarioEntity = repository.findById(usuario.getId()).orElse(null);
        Usuario usuarioAtualizado = Usuario.builder()
                .id(usuarioEntity.getId())
                .email(usuario.getEmail() != null ? usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .build();
        repository.saveAndFlush(usuarioAtualizado);
    }
}
