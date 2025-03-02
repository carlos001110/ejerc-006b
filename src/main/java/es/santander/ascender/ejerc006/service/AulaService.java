package es.santander.ascender.ejerc006.service;

import es.santander.ascender.ejerc006.model.Aula;
import es.santander.ascender.ejerc006.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AulaService {

    @Autowired
    private AulaRepository repository;

    public Aula create(Aula aula) {
        if (aula.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro de aula utilizando la creación",
                    CrudOperation.CREATE,
                    aula.getId());
        }
        return repository.save(aula);
    }

    @Transactional(readOnly = true)
    public Aula read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Aula> read() {
        return repository.findAll();
    }

    public Aula update(Aula aula) {
        if (aula.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro de aula utilizando la modificación",
                    CrudOperation.UPDATE,
                    null);
        }
        return repository.save(aula);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
