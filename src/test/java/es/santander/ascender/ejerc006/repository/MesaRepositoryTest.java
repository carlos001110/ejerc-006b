package es.santander.ascender.ejerc006.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejerc006.model.Mesa;

@SpringBootTest
public class MesaRepositoryTest {

    @Autowired
    private MesaRepository repository;

    @Test
    public void testCreate() {
        // Crear una mesa
        Mesa mesa = new Mesa();
        mesa.setMaterial("Madera");
        mesa.setAltura(1.2);
        mesa.setAncho(0.8);
        mesa.setLargo(1.5);

        // Guardar la mesa
        Mesa savedMesa = repository.save(mesa);

        // Verificar que la mesa se guardó correctamente
        assertNotNull(savedMesa.getId());  // El id debería ser generado
        assertTrue(repository.findById(savedMesa.getId()).isPresent());
    }

    @Test
    public void testRead() {
        // Crear una mesa
        Mesa mesa = new Mesa();
        mesa.setMaterial("Plástico");
        mesa.setAltura(1.0);
        mesa.setAncho(0.6);
        mesa.setLargo(1.2);

        // Guardar la mesa
        Mesa savedMesa = repository.save(mesa);

        // Leer la mesa por ID
        Optional<Mesa> foundMesa = repository.findById(savedMesa.getId());

        // Verificar que la mesa fue encontrada y que los datos son correctos
        assertTrue(foundMesa.isPresent());
        assertEquals("Plástico", foundMesa.get().getMaterial());
        assertEquals(1.0, foundMesa.get().getAltura());
        assertEquals(0.6, foundMesa.get().getAncho());
        assertEquals(1.2, foundMesa.get().getLargo());
    }

    @Test
    public void testUpdate() {
        // Crear una mesa
        Mesa mesa = new Mesa();
        mesa.setMaterial("Acero");
        mesa.setAltura(1.1);
        mesa.setAncho(0.75);
        mesa.setLargo(1.3);

        // Guardar la mesa
        Mesa savedMesa = repository.save(mesa);

        // Actualizar los datos de la mesa
        savedMesa.setMaterial("Vidrio");
        savedMesa.setAltura(1.2);
        savedMesa.setAncho(0.8);
        savedMesa.setLargo(1.4);

        // Guardar la mesa actualizada
        Mesa updatedMesa = repository.save(savedMesa);

        // Verificar que los datos se actualizaron correctamente
        assertEquals("Vidrio", updatedMesa.getMaterial());
        assertEquals(1.2, updatedMesa.getAltura());
        assertEquals(0.8, updatedMesa.getAncho());
        assertEquals(1.4, updatedMesa.getLargo());
    }

    @Test
    public void testDelete() {
        // Crear una mesa
        Mesa mesa = new Mesa();
        mesa.setMaterial("Metal");
        mesa.setAltura(1.0);
        mesa.setAncho(0.7);
        mesa.setLargo(1.1);

        // Guardar la mesa
        Mesa savedMesa = repository.save(mesa);
        Long id = savedMesa.getId();

        // Eliminar la mesa por su ID
        repository.deleteById(id);

        // Verificar que la mesa fue eliminada
        assertFalse(repository.findById(id).isPresent());
    }
}
