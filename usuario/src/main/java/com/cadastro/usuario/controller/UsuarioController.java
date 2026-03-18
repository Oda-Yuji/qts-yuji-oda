package com.cadastro.usuario.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cadastro.usuario.business.UsuarioService;
import com.cadastro.usuario.infrastructure.entity.Usuario;

import lombok.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor

public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> buscarUsuarioPorId(@RequestParam Integer id) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorId(@RequestParam Integer id) {
        usuarioService.deletarUsuarioPorId(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarUsuario(@RequestBody Usuario usuario, @RequestParam Integer id) {
        usuarioService.atualizarUsuario(usuario, id);
        return ResponseEntity.ok().build();
    }
}
