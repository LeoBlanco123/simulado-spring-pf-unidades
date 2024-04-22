package br.com.fiap.simuladospringpfunidades.resource;

import br.com.fiap.simuladospringpfunidades.entity.Pessoa;
import br.com.fiap.simuladospringpfunidades.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository repo;

    @GetMapping
    public Collection<Pessoa> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        return repo.save(pessoa);
    }
}
