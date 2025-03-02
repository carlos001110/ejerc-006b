package es.santander.ascender.ejerc006.controller;

import es.santander.ascender.ejerc006.model.Mesa;
import es.santander.ascender.ejerc006.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaRepository mesaRepository;

    // Crear una mesa
    @PostMapping
    public ResponseEntity<Mesa> createMesa(@RequestBody Mesa mesa) {
        Mesa savedMesa = mesaRepository.save(mesa);
        return new ResponseEntity<>(savedMesa, HttpStatus.CREATED);
    }

    // Obtener todas las mesas
    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    // Obtener una mesa por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable Long id) {
        Optional<Mesa> mesa = mesaRepository.findById(id);
        return mesa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar una mesa por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
        if (!mesaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        mesa.setId(id);
        Mesa updatedMesa = mesaRepository.save(mesa);
        return ResponseEntity.ok(updatedMesa);
    }

    // Eliminar una mesa por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesa(@PathVariable Long id) {
        if (!mesaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        mesaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
