package projeto_aranoua.cadastro_ajuda_humanitaria_msf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SituacaoSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String situacao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
}
