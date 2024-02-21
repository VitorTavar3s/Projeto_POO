import java.util.ArrayList;
import java.util.List;

public class Filme {

    private static long ultimoId = 0;

    private Long id;
    private String nome, descricao, dataLancamento;
    private Double orcamento;
    private List<Ator> atores = new ArrayList<>();
    private List<Diretor> diretores = new ArrayList<>();

    Filme(String nome, String descricao, String dataLancamento, Double orcamento){
        this.id = gerarNovoId();
        this.nome = nome;
        this.descricao = descricao;
        this.dataLancamento = dataLancamento;
        this.orcamento =  orcamento;
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

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDataLancamento() {
        return dataLancamento;
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

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataLancamento='" + dataLancamento + '\'' +
                ", orcamento=" + orcamento +
                ", atores=" + atores +
                ", diretores=" + diretores +
                '}';
    }

    public static synchronized long gerarNovoId() {
        return ++ultimoId;
    }

}
