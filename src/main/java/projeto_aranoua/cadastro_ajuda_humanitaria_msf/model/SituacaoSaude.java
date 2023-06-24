package projeto_aranoua.cadastro_ajuda_humanitaria_msf.model;

import org.springframework.dao.DataIntegrityViolationException;

import javax.persistence.*;

@Entity
public class SituacaoSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
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

    public void setSituacao(int situacao) {
        switch (situacao){
            case 1:
                this.situacao = "Ótimo";
                break;

            case 2:
                this.situacao = "Bom";
                break;

            case 3:
                this.situacao = "Ruim";
                break;

            default:
                throw new DataIntegrityViolationException("Valor inválido, consulte as opções.");
        }
    }
}
