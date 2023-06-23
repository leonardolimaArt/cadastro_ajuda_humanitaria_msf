package projeto_aranoua.cadastro_ajuda_humanitaria_msf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Pais;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository.PaisRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    @Autowired
    PaisRepository paisRepository;

    @GetMapping
    public List<Pais> list(){
        return paisRepository.list();
    }

    @GetMapping("/{id}")
    public Optional<Pais> paisById(@PathVariable Long id){
        return paisRepository.findById(id);
    }
}
