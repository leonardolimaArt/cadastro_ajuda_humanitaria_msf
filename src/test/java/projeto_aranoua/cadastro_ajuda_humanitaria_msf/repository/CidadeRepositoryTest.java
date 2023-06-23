package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Cidade;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Pais;


@DataJpaTest
public class CidadeRepositoryTest {

    @Autowired
    CidadeRepository cidadeRepository;

    @Autowired
    PaisRepository paisRepository;

    public Pais preparaPreCondicao(){
        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais.setSigla("BR");
        paisRepository.save(pais);

        Pais paisBd = paisRepository.findOneBySigla(pais.getSigla());

        return paisBd;
    }

    @Test
    @DisplayName("Deve salvar com os dados corretos")
    public void deveSalvarComOsDadosCorretos(){

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setIbge("15");
        cidade.setPais(preparaPreCondicao());

        cidadeRepository.save(cidade);

        Cidade cidadeBd = cidadeRepository.findOneByIbge(cidade.getIbge());

        Assertions.assertEquals(cidadeBd.getIbge(), cidade.getIbge());

    }

    @Test
    @DisplayName("Não Deve salvar com o com IBGE já inserido")
    public void naoDeveSalvarComOIbgeJaInserido(){

        Pais pais = preparaPreCondicao();

        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setIbge("15");
        cidade.setPais(pais);

        cidadeRepository.save(cidade);

        Cidade cidade01 = new Cidade();
        cidade01.setNome("Belém");
        cidade01.setIbge("15");
        cidade01.setPais(pais);

        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> cidadeRepository.save(cidade01));


    }

}
