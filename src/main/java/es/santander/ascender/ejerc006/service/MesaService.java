package es.santander.ascender.ejerc006.service;

import es.santander.ascender.ejerc006.model.Mesa;
import es.santander.ascender.ejerc006.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MesaService {

    @Autowired
    private MesaRepository repository;

    public Mesa create(Mesa mesa) {
        if (mesa.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro de mesa utilizando la creación",
                    CrudOperation.CREATE,
                    mesa.getId());
        }
        return repository.save(mesa);
    }

    @Transactional(readOnly = true)
    public Mesa read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Mesa> read() {
        return repository.findAll();
    }

    public Mesa update(Mesa mesa) {
        if (mesa.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro de mesa utilizando la modificación",
                    CrudOperation.UPDATE,
                    null);
        }
        return repository.save(mesa);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
