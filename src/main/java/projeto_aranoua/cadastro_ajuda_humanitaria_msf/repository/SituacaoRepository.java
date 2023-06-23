package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.SituacaoSaude;

import java.util.List;

public interface SituacaoRepository extends CrudRepository<SituacaoSaude, Long> {

    @Query("select s from SituacaoSaude s")
    List<SituacaoSaude> list();

}
