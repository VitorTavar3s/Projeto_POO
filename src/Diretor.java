public class Diretor extends Pessoa {
    private String area;

    public Diretor(String nome, String area) {
        this.nome = nome;
        this.area = area;
    }
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}