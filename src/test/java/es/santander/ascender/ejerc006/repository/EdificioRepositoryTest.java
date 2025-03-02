package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc006.model.Edificio;

@SpringBootTest
public class EdificioRepositoryTest {

    @Autowired
    private EdificioRepository repository;

    @Test
    public void testCreate() {
        // Crear un edificio
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio Central");
        edificio.setDireccion("Calle 123");
        edificio.setNumerosalas(10);
        edificio.setSuperficie(500.0);

        // Guardar el edificio
        Edificio savedEdificio = repository.save(edificio);

        // Verificar que el edificio se guardó correctamente
        assertNotNull(savedEdificio.getId());  // El id debería ser generado
        assertTrue(repository.findById(savedEdificio.getId()).isPresent());
    }

    @Test
    public void testRead() {
        // Crear un edificio
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio Norte");
        edificio.setDireccion("Avenida 456");
        edificio.setNumerosalas(20);
        edificio.setSuperficie(1000.0);

        // Guardar el edificio
        Edificio savedEdificio = repository.save(edificio);

        // Leer el edificio por ID
        Optional<Edificio> foundEdificio = repository.findById(savedEdificio.getId());

        // Verificar que el edificio fue encontrado y que los datos son correctos
        assertTrue(foundEdificio.isPresent());
        assertEquals("Edificio Norte", foundEdificio.get().getNombre());
        assertEquals("Avenida 456", foundEdificio.get().getDireccion());
        assertEquals(20, foundEdificio.get().getNumerosalas());
        assertEquals(1000.0, foundEdificio.get().getSuperficie());
    }

    @Test
    public void testUpdate() {
        // Crear un edificio
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio Sur");
        edificio.setDireccion("Calle 789");
        edificio.setNumerosalas(5);
        edificio.setSuperficie(300.0);

        // Guardar el edificio
        Edificio savedEdificio = repository.save(edificio);

        // Actualizar los datos del edificio
        savedEdificio.setNombre("Edificio Sur Modificado");
        savedEdificio.setDireccion("Calle 789 Actualizada");
        savedEdificio.setNumerosalas(6);
        savedEdificio.setSuperficie(350.0);

        // Guardar el edificio actualizado
        Edificio updatedEdificio = repository.save(savedEdificio);

        // Verificar que los datos se actualizaron correctamente
        assertEquals("Edificio Sur Modificado", updatedEdificio.getNombre());
        assertEquals("Calle 789 Actualizada", updatedEdificio.getDireccion());
        assertEquals(6, updatedEdificio.getNumerosalas());
        assertEquals(350.0, updatedEdificio.getSuperficie());
    }

    @Test
    public void testDelete() {
        // Crear un edificio
        Edificio edificio = new Edificio();
        edificio.setNombre("Edificio Este");
        edificio.setDireccion("Avenida Este 123");
        edificio.setNumerosalas(8);
        edificio.setSuperficie(450.0);

        // Guardar el edificio
        Edificio savedEdificio = repository.save(edificio);
        Long id = savedEdificio.getId();

        // Eliminar el edificio por su ID
        repository.deleteById(id);

        // Verificar que el edificio fue eliminado
        assertFalse(repository.findById(id).isPresent());
    }
}
