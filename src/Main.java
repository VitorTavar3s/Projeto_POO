import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
        static Scanner scanner = new Scanner(System.in);
        static List<Filme> filmes = new ArrayList<>();
        static List<Ator> atores = new ArrayList<>();
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //Filme filme = new Filme();

        int opcao;

        do{
            System.out.println(">>>> Menu <<<<");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Diretor");
            System.out.println("3 - Cadastrar Ator");
            System.out.println("4 - Buscar Filme");
            System.out.println("5 - Sair");
            System.out.println();
            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> cadastrarFilme();
                case 2 -> cadastrarDiretor();
                case 3 -> cadastrarAtor();
                case 4 -> buscarFilme();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Digite uma opção válida!");
            }
        } while (opcao != 5);


    }

    public static void cadastrarFilme(){
        //List<Ator> atores = new ArrayList<>();
        //List<Filme> filmes = new ArrayList<>();

        scanner.nextLine();
        System.out.println("Digite o nome do filme:");
        String nome = scanner.nextLine();
        System.out.println("Digite a descrição do filme:");
        String descricao = scanner.nextLine();
        System.out.println("Digite a data de lançamento do filme:");
        String data = scanner.nextLine();
        System.out.println("Digite o orçamento do filme:");
        Double orcamento = scanner.nextDouble();
        scanner.nextLine();


        Filme filme = new Filme(nome,descricao,data,orcamento);
        filmes.add(filme);
        filme.setAtores(atores);
    }

    public static void cadastrarDiretor() { 
        System.out.println("Cadastro de Diretor");
        System.out.print("Nome: ");
        String nome = scanner.nextLine(); 
        nome = scanner.nextLine();
        System.out.print("Área: ");
        String area = scanner.nextLine();
    
        Diretor diretor = new Diretor(nome, area);
    
        System.out.println("Diretor cadastrado com sucesso:");
        System.out.println("Nome: " + diretor.getNome());
        System.out.println("Área: " + diretor.getArea());
    }

    public static void cadastrarAtor(){
            scanner.nextLine();
        do{
            System.out.println("Informe o nome do Ator:");
            String nomeAtor = scanner.nextLine();
            System.out.println("Informe o CPF do Ator:");
            String cpf = scanner.nextLine();
            //Poderia mostrar os filmes cadastrados.
            System.out.println("Digite o nome do filme onde o ator se apresenta:");
            String nomeFilme = scanner.nextLine();

            boolean filmeEncontrado = false;

            for(Filme filme : filmes){
                if(nomeFilme.equals(filme.getNome())){
                    Ator ator = new Ator(nomeAtor,cpf);
                    atores.add(ator);
                    filmeEncontrado = true;
                    System.out.println("Ator cadastrado com sucesso!");
                    break;
                }
            }

            if (!filmeEncontrado) {
                System.out.println("Filme não encontrado! Deseja tentar outro filme? (S/N):");
                String resposta = scanner.next();
                if (!resposta.equalsIgnoreCase("S")) {
                    break;
                }
            }


            System.out.println("Deseja adicionar outro ator? (S/N):");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("S")){
                break;
            }
            scanner.nextLine();
        }while (true);
    }

    public static void buscarFilme(){

    }
}