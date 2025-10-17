package com.api.chamadosjdk.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.api.chamadosjdk.Enums.EnumStatusChamado.StatusChamado;
import com.api.chamadosjdk.model.Chamado;
import com.api.chamadosjdk.service.ChamadoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chamados")
public class ChamadoController {
    
    @Autowired
    private ChamadoService chamadoService;
    
    @GetMapping
    public List<Chamado> listarChamados() {
        return chamadoService.listarTodos();
    }
    
    // Adicione esta anotação em todos os métodos que precisam de autenticação 
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ROLE_USER')")
    public ResponseEntity<Chamado> buscarChamado(@PathVariable Long id) {
        Optional<Chamado> chamado = chamadoService.buscarPorId(id);
        return chamado.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Chamado abrirChamado(@RequestBody Chamado chamado) {
        return chamadoService.abrirChamado(chamado);
    }
    
    @PutMapping("/{id}/status")
    public ResponseEntity<Chamado> atualizarStatus(
            @PathVariable Long id, 
            @RequestParam StatusChamado status) {
        Chamado chamado = chamadoService.atualizarStatus(id, status);
        return chamado != null ? ResponseEntity.ok(chamado) : ResponseEntity.notFound().build();
    }
    
    @GetMapping("/status/{status}")
    public List<Chamado> buscarPorStatus(@PathVariable StatusChamado status) {
        return chamadoService.buscarPorStatus(status);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarChamado(@PathVariable Long id) {
        boolean deletado = chamadoService.deletarChamado(id);
        return deletado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
