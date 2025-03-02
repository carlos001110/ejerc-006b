package es.santander.ascender.ejerc006.service;

import es.santander.ascender.ejerc006.model.Silla;
import es.santander.ascender.ejerc006.repository.SillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SillaService {

    @Autowired
    private SillaRepository repository;

    public Silla create(Silla silla) {
        if (silla.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro de silla utilizando la creación",
                    CrudOperation.CREATE,
                    silla.getId());
        }
        return repository.save(silla);
    }

    @Transactional(readOnly = true)
    public Silla read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Silla> read() {
        return repository.findAll();
    }

    public Silla update(Silla silla) {
        if (silla.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro de silla utilizando la modificación",
                    CrudOperation.UPDATE,
                    null);
        }
        return repository.save(silla);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
