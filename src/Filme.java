import java.util.ArrayList;
import java.util.List;

public class Filme {

    private static long ultimoId = 0;

    private Long id;
    private String nome,descricao,data_lancamento;
    private Double orcamento;
    private List<Ator> atores;
    private List<Diretor> diretores;

    Filme(String nome,String descricao,String data_lancamento,Double orcamento){
        this.id = gerarNovoId();
        this.nome = nome;
        this.descricao = descricao;
        this.data_lancamento = data_lancamento;
        this.orcamento =  orcamento;
        this.diretores = new ArrayList<>();
        this.atores = new ArrayList<>();
    }


    public Long getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setOrcamento(Double orcamento) {
        this.orcamento = orcamento;
    }

    public Double getOrcamento() {
        return orcamento;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public List<Ator> getAtores() {
        return atores;
    }
    
    public List<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<Diretor> diretores) {
        this.diretores = diretores;
    }

    public static synchronized long gerarNovoId() {
        return ++ultimoId;
    }

}
