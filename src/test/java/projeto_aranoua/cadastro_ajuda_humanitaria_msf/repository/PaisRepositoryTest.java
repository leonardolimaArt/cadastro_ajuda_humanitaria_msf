package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Pais;

@DataJpaTest
public class PaisRepositoryTest {

    @Autowired
    private PaisRepository paisRepository;

    @Test
    @DisplayName("Deve salvar com os dados corretos")
    public void deveSalvarComOsDadosCorretos(){
        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais.setSigla("Br");

        paisRepository.save(pais);

        Pais paisBd = paisRepository.findOneBySigla(pais.getSigla());
        Assertions.assertEquals(pais.getSigla(), paisBd.getSigla());
    }

    @Test
    @DisplayName("Não Deve salvar com a Sigla já inserido")
    public void naoDeveSalvarComASiglaJaInserido(){

        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais.setSigla("BR");
        paisRepository.save(pais);

        Pais pais01 = new Pais();
        pais01.setNome("Inglatera");
        pais01.setSigla("BR");

        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> paisRepository.save(pais01));
    }


}
