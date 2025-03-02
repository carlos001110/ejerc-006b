package es.santander.ascender.ejerc006.controller;

import es.santander.ascender.ejerc006.model.Edificio;
import es.santander.ascender.ejerc006.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edificio")
public class EdificioController {

    @Autowired
    private EdificioService edificioService;

    // Crear un nuevo Edificio
    @PostMapping()
    public Edificio create(@RequestBody Edificio edificio) {
        return edificioService.create(edificio);
    }

    // Leer un Edificio por su ID
    @GetMapping("/{id}")
    public Edificio read(@PathVariable("id") Long id) {
        return edificioService.read(id);
    }

    // Leer todos los Edificios
    @GetMapping
    public List<Edificio> list() {
        return edificioService.read();
    }

    // Actualizar un Edificio existente
    @PutMapping
    public Edificio update(@RequestBody Edificio edificio) {
        return edificioService.update(edificio);
    }

    // Eliminar un Edificio por su ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        edificioService.delete(id);
    }
}
