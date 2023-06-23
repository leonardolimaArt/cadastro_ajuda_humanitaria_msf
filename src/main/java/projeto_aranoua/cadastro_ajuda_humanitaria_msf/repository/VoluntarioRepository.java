package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Voluntario;

import java.util.List;

public interface VoluntarioRepository extends CrudRepository<Voluntario, Long> {

    @Query("select v from Voluntario v")
    List<Voluntario> list();

    @Query("select v from Voluntario v where v.passaporte = :parPassaporte")
    Voluntario findOneByPassaporte(String parPassaporte);

}
