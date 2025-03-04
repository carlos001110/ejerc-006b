package es.santander.ascender.ejerc006.controller;

import es.santander.ascender.ejerc006.model.Aula;
import es.santander.ascender.ejerc006.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aulas")
public class AulaController {

    @Autowired
    private AulaRepository aulaRepository;

    @PostMapping
    public ResponseEntity<Aula> createAula(@RequestBody Aula aula) {
        Aula savedAula = aulaRepository.save(aula);
        return new ResponseEntity<>(savedAula, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> getAulaById(@PathVariable Long id) {
        Optional<Aula> aula = aulaRepository.findById(id);
        return aula.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aula> updateAula(@PathVariable Long id, @RequestBody Aula aula) {
        if (!aulaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        aula.setId(id);
        Aula updatedAula = aulaRepository.save(aula);
        return ResponseEntity.ok(updatedAula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAula(@PathVariable Long id) {
        if (!aulaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        aulaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
