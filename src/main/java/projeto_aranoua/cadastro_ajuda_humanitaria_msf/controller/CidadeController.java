package projeto_aranoua.cadastro_ajuda_humanitaria_msf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Cidade;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository.CidadeRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cidades")
public class CidadeController {

    @Autowired
    CidadeRepository cidadeRepository;

    @GetMapping
    public List<Cidade> list(){
        return cidadeRepository.list();
    }

    @GetMapping("/{id}")
    public Optional<Cidade> cidadeById(@PathVariable Long id){
        return cidadeRepository.findById(id);
    }

    @GetMapping("/ibge/{ibge}")
    public Cidade cidadeByPassaport(@PathVariable String ibge){
        return cidadeRepository.findOneByIbge(ibge);
    }
}
