package br.com.fiap.simuladospringpfunidades.resource;

import br.com.fiap.simuladospringpfunidades.entity.Unidade;
import br.com.fiap.simuladospringpfunidades.repository.UnidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/unidade")
public class UnidadeResource {

    @Autowired
    private UnidadeRepository repo;

    @GetMapping
    public Collection<Unidade> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Unidade findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Unidade save(@RequestBody Unidade unidade) {
        return repo.save(unidade);
    }
}
