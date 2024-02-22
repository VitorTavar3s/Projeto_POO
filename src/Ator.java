public class Ator extends Pessoa{

    private String cpf;

    public Ator(String nome,String cpf){
        this.id = gerarNovoId();
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}