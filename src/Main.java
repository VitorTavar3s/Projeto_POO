import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
        static Scanner scanner = new Scanner(System.in);
        static List<Filme> filmes = new ArrayList<>();
        static List<Ator> atores = new ArrayList<>();
        static List<Diretor> diretores = new ArrayList<>();
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
            System.out.println("5 - Buscar Diretor");
            System.out.println("6 - Buscar Ator");
            System.out.println("7 - Sair");
            System.out.println();
            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> cadastrarFilme();
                case 2 -> cadastrarDiretor();
                case 3 -> cadastrarAtor();
                case 4 -> buscarFilme();
                case 5 -> buscarDiretor();
                case 6 -> buscarAtor();
                case 7 -> System.out.println("Saindo...");
                default -> System.out.println("Digite uma opção válida!");
            }
        } while (opcao != 7);


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
        System.out.println("Filme cadastrado com sucesso");
    }

    public static void cadastrarDiretor() {
        scanner.nextLine();
        //Lista dos filmes com Id
        //
        do {
            System.out.println("Informe o nome do Diretor:");
            String nomeDiretor = scanner.nextLine();
            System.out.println("Informe a área do Diretor:");
            String area = scanner.nextLine();

            do {
                System.out.println("Deseja cadastrar esse diretor a um filme? (S/N)");
                String cadastarDiretorNoFilme = scanner.nextLine();
                if (!cadastarDiretorNoFilme.equalsIgnoreCase("S")) {
                    break;
                }

                boolean filmeEncontrado;
                do {
                    filmeEncontrado = false;
                    System.out.println("Digite o nome do filme que o diretor coordenou:");
                    String nomeFilme = scanner.nextLine();

                    for (Filme filme : filmes) {
                        if (nomeFilme.equals(filme.getNome())) {
                            Diretor diretor = new Diretor(nomeDiretor, area);
                            diretores.addAll(filme.getDiretores());
                            diretores.add(diretor);
                            filme.setDiretores(diretores);
                            filmeEncontrado = true;
                            System.out.println("Diretor cadastrado com sucesso!");
                            break;
                        }
                    }

                    if (!filmeEncontrado) {
                        System.out.println("Filme não encontrado! Deseja tentar outro filme? (S/N):");
                        String resposta = scanner.next();
                        if (!resposta.equalsIgnoreCase("S")) {
                            break;
                        }
                        scanner.nextLine();
                    }
                } while (!filmeEncontrado);
            } while (true);

            System.out.println("Deseja adicionar outro diretor? (S/N):");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("S")) {
                break;
            }
            scanner.nextLine();
        } while (true);
    }    
    

    public static void cadastrarAtor(){
            scanner.nextLine();
        do{
            System.out.println("Informe o nome do Ator:");
            String nomeAtor = scanner.nextLine();
            System.out.println("Informe o CPF do Ator:");
            String cpf = scanner.nextLine();


            do {
                System.out.println("Deseja cadastrar esse ator a um filme? (S/N)");
                String cadastrarAtorNoFilme = scanner.nextLine();
                if (!cadastrarAtorNoFilme.equalsIgnoreCase("S")) {
                    break;
                }

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
            } while (true);


            System.out.println("Deseja adicionar outro ator? (S/N):");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("S")){
                break;
            }
            scanner.nextLine();
        }while (true);
    }

    public static void buscarFilme(){
        scanner.nextLine(); 

        System.out.println("Digite o nome do filme que deseja buscar:");
        String nomeFilmeBusca = scanner.nextLine();

        boolean filmeEncontrado = false;

        for (Filme filme : filmes) {
            if (nomeFilmeBusca.equalsIgnoreCase(filme.getNome())) {
                filmeEncontrado = true;
                System.out.println("Filme encontrado:");
                System.out.println("Nome: " + filme.getNome());
                System.out.println("Descrição: " + filme.getDescricao());
                System.out.println("Data de lançamento: " + filme.getData_lancamento());
                System.out.println("Orçamento: " + filme.getOrcamento());
                System.out.println("Atores:");
                for (Ator ator : filme.getAtores()) {
                    System.out.println("- " + ator.nome);
                }
                System.out.println("Diretores:");
                for (Diretor diretor : filme.getDiretores()) {
                    System.out.println("- " + diretor.getNome());
                }
                break;
            }
        }

        if (!filmeEncontrado) {
            System.out.println("Filme não encontrado.");
        }
    }

    public static void buscarDiretor() {
        if (diretores.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
            return;
        }

        System.out.println("Escolha uma opção:");
        System.out.println("1 -> Buscar diretor específico");
        System.out.println("2 -> Exibir todos os diretores cadastrados");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do diretor que deseja buscar:");
                String nomeDiretor = scanner.nextLine();
                buscarDiretorEspecifico(nomeDiretor);
                break;
            case 2:
                exibirTodosOsDiretores();
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static void buscarDiretorEspecifico(String nomeDiretor) {
        boolean diretorEncontrado = false;
        for (Diretor diretor : diretores) {
            if (diretor.getNome().equalsIgnoreCase(nomeDiretor)) {
                diretorEncontrado = true;
                System.out.println("Diretor encontrado:");
                System.out.println("Nome: " + diretor.getNome());
                System.out.println("Área: " + diretor.getArea());
                break;
            }
        }
        if (!diretorEncontrado) {
            System.out.println("Diretor não encontrado.");
        }
    }

    private static void exibirTodosOsDiretores() {
        System.out.println("Diretores cadastrados:");
        for (Diretor diretor : diretores) {
            System.out.println("Nome: " + diretor.getNome());
            System.out.println("Área: " + diretor.getArea());
            System.out.println();
        }
    }
    public static void buscarAtor(){}
}