package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.SituacaoSaude;

@DataJpaTest
public class SituacaoSauderepositoryTest {

    @Autowired
    SituacaoRepository situacaoRepository;

    @Test
    @DisplayName("Deve salvar com os dados corretos")
    public void deveSalvarComOsDadosCorretos(){
        SituacaoSaude situacaoSaude = new SituacaoSaude();
        situacaoSaude.setSituacao(1);

        situacaoRepository.save(situacaoSaude);

        SituacaoSaude situacaoSaudeBd = situacaoRepository.findById(situacaoSaude.getId()).get();

        Assertions.assertEquals(situacaoSaudeBd.getSituacao(),situacaoSaude.getSituacao());

    }

//    @Test
//    @DisplayName("Não deve salvar situacao com valor maior que 3")
//    public void naoDeveSalvarSituacaoComValorMaiorQue3(){
//        SituacaoSaude situacaoSaude = new SituacaoSaude();
//        situacaoSaude.setSituacao(4);
//
//        Assertions.assertThrows(DataIntegrityViolationException.class, () -> situacaoRepository.save(situacaoSaude).);
//    }
}
