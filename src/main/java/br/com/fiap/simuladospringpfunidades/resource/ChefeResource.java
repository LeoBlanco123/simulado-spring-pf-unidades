package br.com.fiap.simuladospringpfunidades.resource;

import br.com.fiap.simuladospringpfunidades.entity.Chefe;
import br.com.fiap.simuladospringpfunidades.repository.ChefeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Permission;
import java.util.Collection;

@RestController
@RequestMapping(value = "/chefe")
public class ChefeResource {

    @Autowired
    private ChefeRepository repo;

    @GetMapping
    public Collection<Chefe> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Chefe findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Chefe save(@RequestBody Chefe chefe) {
        return repo.save(chefe);
    }
}
