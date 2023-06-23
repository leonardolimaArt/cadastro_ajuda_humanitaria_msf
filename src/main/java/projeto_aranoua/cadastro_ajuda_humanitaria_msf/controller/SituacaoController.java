package projeto_aranoua.cadastro_ajuda_humanitaria_msf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.SituacaoSaude;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository.SituacaoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/situacoes")
public class SituacaoController {

    @Autowired
    SituacaoRepository situacoesRepository;

    @GetMapping
    public List<SituacaoSaude> list(){
        return situacoesRepository.list();
    }

    @GetMapping("/{id}")
    public Optional<SituacaoSaude> situacaoById(@PathVariable Long id){
        return situacoesRepository.findById(id);
    }
}
