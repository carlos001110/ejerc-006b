package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc006.model.Silla;

@SpringBootTest
public class SillaRepositoryTest {

    @Autowired
    private SillaRepository repository;

    @Test
    public void testCreate() {
        // Crear una silla
        Silla silla = new Silla();
        silla.setMaterial("Cuero");
        silla.setTieneRespaldo(true);
        silla.setTieneCojin(true);
        silla.setColor("Negro");

        // Guardar la silla
        Silla savedSilla = repository.save(silla);

        // Verificar que la silla se guardó correctamente
        assertNotNull(savedSilla.getId());  // El id debería ser generado
        assertTrue(repository.findById(savedSilla.getId()).isPresent());
    }

    @Test
    public void testRead() {
        // Crear una silla
        Silla silla = new Silla();
        silla.setMaterial("Plástico");
        silla.setTieneRespaldo(false);
        silla.setTieneCojin(true);
        silla.setColor("Azul");

        // Guardar la silla
        Silla savedSilla = repository.save(silla);

        // Leer la silla por ID
        Optional<Silla> foundSilla = repository.findById(savedSilla.getId());

        // Verificar que la silla fue encontrada y que los datos son correctos
        assertTrue(foundSilla.isPresent());
        assertEquals("Plástico", foundSilla.get().getMaterial());
        assertFalse(foundSilla.get().isTieneRespaldo());
        assertTrue(foundSilla.get().isTieneCojin());
        assertEquals("Azul", foundSilla.get().getColor());
    }

    @Test
    public void testUpdate() {
        // Crear una silla
        Silla silla = new Silla();
        silla.setMaterial("Madera");
        silla.setTieneRespaldo(true);
        silla.setTieneCojin(false);
        silla.setColor("Rojo");

        // Guardar la silla
        Silla savedSilla = repository.save(silla);

        // Actualizar los datos de la silla
        savedSilla.setMaterial("Metal");
        savedSilla.setTieneRespaldo(false);
        savedSilla.setTieneCojin(true);
        savedSilla.setColor("Blanco");

        // Guardar la silla actualizada
        Silla updatedSilla = repository.save(savedSilla);

        // Verificar que los datos se actualizaron correctamente
        assertEquals("Metal", updatedSilla.getMaterial());
        assertFalse(updatedSilla.isTieneRespaldo());
        assertTrue(updatedSilla.isTieneCojin());
        assertEquals("Blanco", updatedSilla.getColor());
    }

    @Test
    public void testDelete() {
        // Crear una silla
        Silla silla = new Silla();
        silla.setMaterial("Aluminio");
        silla.setTieneRespaldo(true);
        silla.setTieneCojin(false);
        silla.setColor("Verde");

        // Guardar la silla
        Silla savedSilla = repository.save(silla);
        Long id = savedSilla.getId();

        // Eliminar la silla por su ID
        repository.deleteById(id);

        // Verificar que la silla fue eliminada
        assertFalse(repository.findById(id).isPresent());
    }
}
