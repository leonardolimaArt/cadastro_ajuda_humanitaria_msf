package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Cidade;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Pais;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.SituacaoSaude;
import projeto_aranoua.cadastro_ajuda_humanitaria_msf.model.Voluntario;

@DataJpaTest
public class VoluntarioRepositoryTest {

    @Autowired
    private VoluntarioRepository voluntarioRepository;

    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private SituacaoRepository situacaoRepository;

    public Pais preparaPreCondicao(){
        Pais pais = new Pais();
        pais.setNome("Brasil");
        pais.setSigla("BR");
        paisRepository.save(pais);

        Pais paisBd = paisRepository.findById(pais.getId()).get();

        return paisBd;
    }

    public Cidade preparaPreCondicao1(){
        Cidade cidade = new Cidade();
        cidade.setNome("Manaus");
        cidade.setIbge("15");
        cidade.setPais(preparaPreCondicao());

        cidadeRepository.save(cidade);

        Cidade cidadeBd = cidadeRepository.findOneByIbge(cidade.getIbge());

        return cidadeBd;
    }

    public SituacaoSaude preparaPreCondicao2(){
        SituacaoSaude situacaoSaude = new SituacaoSaude();
        situacaoSaude.setSituacao(1);

        situacaoRepository.save(situacaoSaude);

        SituacaoSaude situacaoSaudeBd = situacaoRepository.findById(situacaoSaude.getId()).get();

        return situacaoSaudeBd;
    }

    @Test
    @DisplayName("Deve salvar com os dados corretos")
    public void deveSalvarComOsDadosCorretos(){
        Voluntario voluntario = new Voluntario();
        voluntario.setPassaporte("123456789");
        voluntario.setNomeCompleto("Fulaninho");
        voluntario.setIdade(50);
        voluntario.setTelefone("99999-9999");
        voluntario.setEmail("teste01@email.com");
        voluntario.setTipoSangue("A+");
        voluntario.setCidade(preparaPreCondicao1());
        voluntario.setSituacaoSaude(preparaPreCondicao2());

        voluntarioRepository.save(voluntario);

        Voluntario voluntarioBd = voluntarioRepository.findOneByPassaporte(voluntario.getPassaporte());

        Assertions.assertEquals(voluntarioBd.getPassaporte(), voluntario.getPassaporte());

    }

    @Test
    @DisplayName("Não Deve salvar com ")
    public void naoDeveSalvarComOss(){

    }


}
