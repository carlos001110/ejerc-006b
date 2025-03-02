package es.santander.ascender.ejerc006.controller;

import es.santander.ascender.ejerc006.model.Silla;
import es.santander.ascender.ejerc006.repository.SillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sillas")
public class SillaController {

    @Autowired
    private SillaRepository sillaRepository;

    // Crear una silla
    @PostMapping
    public ResponseEntity<Silla> createSilla(@RequestBody Silla silla) {
        Silla savedSilla = sillaRepository.save(silla);
        return new ResponseEntity<>(savedSilla, HttpStatus.CREATED);
    }

    // Obtener todas las sillas
    @GetMapping
    public List<Silla> getAllSillas() {
        return sillaRepository.findAll();
    }

    // Obtener una silla por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Silla> getSillaById(@PathVariable Long id) {
        Optional<Silla> silla = sillaRepository.findById(id);
        return silla.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar una silla por su ID
    @PutMapping("/{id}")
    public ResponseEntity<Silla> updateSilla(@PathVariable Long id, @RequestBody Silla silla) {
        if (!sillaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        silla.setId(id);
        Silla updatedSilla = sillaRepository.save(silla);
        return ResponseEntity.ok(updatedSilla);
    }

    // Eliminar una silla por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSilla(@PathVariable Long id) {
        if (!sillaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        sillaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
