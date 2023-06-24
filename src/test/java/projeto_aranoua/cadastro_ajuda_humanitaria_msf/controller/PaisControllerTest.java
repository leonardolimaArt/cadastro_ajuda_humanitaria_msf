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
public class PaisControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void deveListarPaisesCadastrados() throws Exception{

        URI uri = new URI("/api/paises");

        RequestBuilder request = MockMvcRequestBuilders.get(uri);

        ResultMatcher statusEsperado = MockMvcResultMatchers.status().is(200);

        //Conteúdo (Content)
        String jsonRetorno = "[{\"id\":1,\"nome\":\"Brasil\",\"sigla\":\"BRA\"}]";
        ResultMatcher conteudoEsperado = MockMvcResultMatchers.content().json(jsonRetorno);

        mvc.perform(request).andExpect(statusEsperado).andExpect(conteudoEsperado);

    }


}

