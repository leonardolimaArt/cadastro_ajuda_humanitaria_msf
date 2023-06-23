package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Cidade;

import java.util.List;

public interface CidadeRepository extends CrudRepository<Cidade, Long> {

    @Query("select c from Cidade c")
    List<Cidade> list();

    @Query("select c from Cidade c where c.ibge = :parIbge")
    Cidade findOneByIbge(String parIbge);
}
