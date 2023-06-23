package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Pais;

import java.util.List;

public interface PaisRepository extends CrudRepository<Pais, Long> {

    @Query("select p from Pais p")
    List<Pais> list();
}
