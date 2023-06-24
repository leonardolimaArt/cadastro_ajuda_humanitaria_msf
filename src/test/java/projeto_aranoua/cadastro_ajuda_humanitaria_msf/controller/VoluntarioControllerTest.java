package projeto_aranoua.cadastro_ajuda_humanitaria_msf.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

@SpringBootTest
@AutoConfigureMockMvc
public class VoluntarioControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void deveListarVoluntariosCadastrados() throws Exception{

        URI uri = new URI("/api/voluntarios");

        RequestBuilder request = MockMvcRequestBuilders.get(uri);

        ResultMatcher statusEsperado = MockMvcResultMatchers.status().is(200);

        //Conteúdo (Content)
        String jsonRetorno = "[{\"id\":1,\"passaporte\":\"FS245798\",\"nomeCompleto\":\"Nome 01\",\"idade\":23,\"telefone\":\"92 9 9999-9999\",\"email\":\"email@email.com\",\"tipoSangue\":\"O-\",\"situacaoSaude\":{\"id\":1,\"situacao\":\"1\"},\"cidade\":{\"id\":1,\"nome\":\"Pernambuco\",\"ibge\":\"26\",\"pais\":{\"id\":1,\"nome\":\"Brasil\",\"sigla\":\"BRA\"}}}]";
        ResultMatcher conteudoEsperado = MockMvcResultMatchers.content().json(jsonRetorno);

        mvc.perform(request).andExpect(statusEsperado).andExpect(conteudoEsperado);

    }

}
