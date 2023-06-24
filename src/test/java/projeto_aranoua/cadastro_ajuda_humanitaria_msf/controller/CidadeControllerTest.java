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
public class CidadeControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void deveListarCidadeCadastradas() throws Exception{

        URI uri = new URI("/api/cidades");

        RequestBuilder request = MockMvcRequestBuilders.get(uri);

        ResultMatcher statusEsperado = MockMvcResultMatchers.status().is(200);

        //Conteúdo (Content)
        String jsonRetorno = "[{\"id\":1,\"nome\":\"Pernambuco\",\"ibge\":\"26\",\"pais\":{\"id\":1,\"nome\":\"Brasil\",\"sigla\":\"BRA\"}},{\"id\":2,\"nome\":\"Piaui\",\"ibge\":\"22\",\"pais\":{\"id\":1,\"nome\":\"Brasil\",\"sigla\":\"BRA\"}}]";
        ResultMatcher conteudoEsperado = MockMvcResultMatchers.content().json(jsonRetorno);

        mvc.perform(request).andExpect(statusEsperado).andExpect(conteudoEsperado);

    }

}
