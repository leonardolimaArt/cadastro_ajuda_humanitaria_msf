package projeto_aranoua.cadastro_ajuda_humanitaria_msf.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
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
    /*
    RN-01: O voluntário deve ter os seguintes dados cadastrados (todos obrigatórios): Passaporte, Nome
    Completo, Idade, Telefone, E-mail e Tipo Sanguíneo.
    RN-02: Um voluntário não pode ser cadastrado se já tiver um passaporte com o mesmo número no sistema.
    RN-03: O voluntário deve ter de 18 a 55 anos de idade;
    RN-04: O voluntário deve estar associado a uma cidade de um determinado país.
    RN-05: O voluntário deve ter sua situação de saúde declarada (Opções: Ruim, Bom, Ótimo).
    */
    @Test
    @DisplayName("Deve salvar com os dados corretos")
    public void deveSalvarComOsDadosCorretos(){
        Cidade cidade = preparaPreCondicao1();
        SituacaoSaude situacaoSaude = preparaPreCondicao2();

        Voluntario voluntario = new Voluntario();
        voluntario.setPassaporte("123456789");
        voluntario.setNomeCompleto("Fulaninho");
        voluntario.setIdade(50);
        voluntario.setTelefone("99999-9999");
        voluntario.setEmail("teste01@email.com");
        voluntario.setTipoSangue("A+");
        voluntario.setCidade(cidade);
        voluntario.setSituacaoSaude(situacaoSaude);

        voluntarioRepository.save(voluntario);

        Voluntario voluntarioBd = voluntarioRepository.findOneByPassaporte(voluntario.getPassaporte());

        Assertions.assertEquals(voluntarioBd.getPassaporte(), voluntario.getPassaporte());

    }
    //RN-02: Um voluntário não pode ser cadastrado se já tiver um passaporte com o mesmo número no sistema.
    @Test
    @DisplayName("Não Deve salvar com passaporte duplicado")
    public void naoDeveSalvarComOsMesmoDadosDoPassaporte(){
        Cidade cidade = preparaPreCondicao1();
        SituacaoSaude situacaoSaude = preparaPreCondicao2();

        Voluntario voluntario = new Voluntario();
        voluntario.setPassaporte("123456789");
        voluntario.setNomeCompleto("Fulaninho");
        voluntario.setIdade(50);
        voluntario.setTelefone("99999-9999");
        voluntario.setEmail("teste01@email.com");
        voluntario.setTipoSangue("A+");
        voluntario.setCidade(cidade);
        voluntario.setSituacaoSaude(situacaoSaude);
        voluntarioRepository.save(voluntario);

        Voluntario voluntario01 = new Voluntario();
        voluntario01.setPassaporte("123456789");
        voluntario01.setNomeCompleto("Fulaninho");
        voluntario01.setIdade(50);
        voluntario01.setTelefone("99999-9999");
        voluntario01.setEmail("teste01@email.com");
        voluntario01.setTipoSangue("A+");
        voluntario.setCidade(cidade);
        voluntario.setSituacaoSaude(situacaoSaude);

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> voluntarioRepository.save(voluntario01));

    }
    //Teste regra de negócio da classe model - RN-03: O voluntário deve ter de 18 a 55 anos de idade;
    @Test
    @DisplayName("Não deve salvar idade fora do intervalo")
    public void naoDeveSetIdadeForaDoIntervalo(){
        Voluntario voluntario = new Voluntario();
        voluntario.setPassaporte("123456789");
        voluntario.setNomeCompleto("Fulaninho");

        voluntario.setTelefone("99999-9999");
        voluntario.setEmail("teste01@email.com");
        voluntario.setTipoSangue("A+");
        voluntario.setCidade(preparaPreCondicao1());

        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {voluntario.setIdade(90); voluntarioRepository.save(voluntario);});
    }
}
