package projeto_aranoua.cadastro_ajuda_humanitaria_msf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Voluntario;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository.VoluntarioRepository;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/voluntarios")
public class VoluntarioController {

    @Autowired
    VoluntarioRepository voluntarioRepository;

    @GetMapping
    public List<Voluntario> list(){
        return voluntarioRepository.list();
    }

    @GetMapping("/{id}")
    public Optional<Voluntario> voluntarioById(@PathVariable Long id){
        return voluntarioRepository.findById(id);
    }

    @GetMapping("/passaport/{passaport}")
    public Voluntario voluntarioByPassaport(@PathVariable String passaport){
        return voluntarioRepository.findOneByPassaporte(passaport);
    }
}
