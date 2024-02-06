import java.util.List;

public class Filme {

    private String nome,descricao,data_lancamento;
    private Double orcamento;
    private List<Ator> atores;

    Filme(String nome,String descricao,String data_lancamento,Double orcamento){
        this.nome = nome;
        this.descricao = descricao;
        this.data_lancamento = data_lancamento;
        this.orcamento =  orcamento;
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
}
