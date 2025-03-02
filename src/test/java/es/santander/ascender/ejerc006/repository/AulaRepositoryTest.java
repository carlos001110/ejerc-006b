package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc006.model.Aula;

@SpringBootTest
public class AulaRepositoryTest {

    @Autowired
    private AulaRepository repository;

    @Test
    public void testCreate() {
        // Crear un aula
        Aula aula = new Aula();
        aula.setNombre("Aula 1");
        aula.setCapacidad(30);
        aula.setTieneVentanas(true);
        aula.setTipoPizarra("Blanca");

        // Guardar el aula
        Aula savedAula = repository.save(aula);

        // Verificar que el aula se guardó correctamente
        assertNotNull(savedAula.getId());  // El id debería ser generado
        assertTrue(repository.findById(savedAula.getId()).isPresent());
    }

    @Test
    public void testRead() {
        // Crear un aula
        Aula aula = new Aula();
        aula.setNombre("Aula 2");
        aula.setCapacidad(25);
        aula.setTieneVentanas(false);
        aula.setTipoPizarra("Verde");

        // Guardar el aula
        Aula savedAula = repository.save(aula);

        // Leer el aula por ID
        Optional<Aula> foundAula = repository.findById(savedAula.getId());

        // Verificar que el aula fue encontrada y que los datos son correctos
        assertTrue(foundAula.isPresent());
        assertEquals("Aula 2", foundAula.get().getNombre());
        assertEquals(25, foundAula.get().getCapacidad());
        assertFalse(foundAula.get().isTieneVentanas());
        assertEquals("Verde", foundAula.get().getTipoPizarra());
    }

    @Test
    public void testUpdate() {
        // Crear un aula
        Aula aula = new Aula();
        aula.setNombre("Aula 3");
        aula.setCapacidad(20);
        aula.setTieneVentanas(true);
        aula.setTipoPizarra("Blanca");

        // Guardar el aula
        Aula savedAula = repository.save(aula);

        // Actualizar los datos del aula
        savedAula.setNombre("Aula 3 Modificada");
        savedAula.setCapacidad(35);
        savedAula.setTieneVentanas(false);
        savedAula.setTipoPizarra("Verde");

        // Guardar el aula actualizada
        Aula updatedAula = repository.save(savedAula);

        // Verificar que los datos se actualizaron correctamente
        assertEquals("Aula 3 Modificada", updatedAula.getNombre());
        assertEquals(35, updatedAula.getCapacidad());
        assertFalse(updatedAula.isTieneVentanas());
        assertEquals("Verde", updatedAula.getTipoPizarra());
    }

    @Test
    public void testDelete() {
        // Crear un aula
        Aula aula = new Aula();
        aula.setNombre("Aula 4");
        aula.setCapacidad(40);
        aula.setTieneVentanas(true);
        aula.setTipoPizarra("Blanca");

        // Guardar el aula
        Aula savedAula = repository.save(aula);
        Long id = savedAula.getId();

        // Eliminar el aula por su ID
        repository.deleteById(id);

        // Verificar que el aula fue eliminada
        assertFalse(repository.findById(id).isPresent());
    }
}
