import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {

        static Scanner scanner = new Scanner(System.in);

        static List<Filme> filmes = new ArrayList<>();

        static List<Ator> atores = new ArrayList<>();

        static List<Diretor> diretores = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do{
            System.out.println(">>>> Menu <<<<");
            System.out.println("1 - Cadastros");
            System.out.println("2 - Buscas");
            System.out.println("3 - Sair");
            System.out.println();
            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> cadastros();
                case 2 -> buscas();
                case 3 -> System.out.println("Saindo...");
                default -> System.out.println("Opção " + opcao + " é inválida, Escolha 1, 2, ou 3!");
            }
        } while (opcao != 3);
    }

    public static void cadastros(){
        int opcao;
        do{
            System.out.println(">>>> Cadastros <<<<");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Ator");
            System.out.println("3 - Cadastrar Diretor");
            System.out.println("4 - Voltar Para Menu Principal");
            System.out.println("Digite a sua opção: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> cadastrarFilme();
                case 2 -> cadastrarAtor();
                case 3 -> cadastrarDiretor();
                case 4 -> System.out.println("Voltando para o menu principal!");
                default -> System.out.println("Opção " + opcao + " é inválida, Escolha 1, 2, 3 ou 4!");
            }
        } while (opcao != 4);
    }

    public static void buscas(){
        int opcao;
        do{
            System.out.println(">>>> Buscas <<<<");
            System.out.println("1 - Buscar Filme");
            System.out.println("2 - Buscar Ator");
            System.out.println("3 - Buscar Diretor");
            System.out.println("4 - Voltar Para Menu Principal");
            System.out.println("Digite a sua opção: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1 -> buscarFilme();
                case 2 -> buscarAtor();
                case 3 -> buscarDiretor();
                case 4 -> System.out.println("Voltando para o menu principal!");
                default -> System.out.println("Opção " + opcao + " é inválida, Escolha 1, 2, 3 ou 4!");
            }
        } while (opcao != 4);
    }


    public static void cadastrarFilme(){
        scanner.nextLine();
        boolean adicionarOutro = true;
        do {
            System.out.println("Digite o nome do filme:");
            String nome = scanner.nextLine();
            System.out.println("Digite a descrição do filme:");
            String descricao = scanner.nextLine();
            System.out.println("Digite a data de lançamento do filme:");
            String data = scanner.nextLine();
            System.out.println("Digite o orçamento do filme:");
            Double orcamento = scanner.nextDouble();
            scanner.nextLine();


            Filme filme = new Filme(nome, descricao, data, orcamento);
            filmes.add(filme);
            filme.setAtores(atores);
            System.out.println("Filme cadastrado com sucesso");

            String resposta;
            do {
                System.out.println("Deseja adicionar outro filme? (S/N):");
                resposta = scanner.next();

                if (!Objects.equals(resposta, "s") && !Objects.equals(resposta, "n")) {
                    System.out.println("Opção incorreta, digite 'S' para SIM e 'N' para NÃO!");
                }
            } while (!Objects.equals(resposta, "s") && !Objects.equals(resposta, "n"));

            if (resposta.equalsIgnoreCase("n")) {
                adicionarOutro = false;
            }

            scanner.nextLine();
        }
        while (adicionarOutro);

    }

    public static void cadastrarAtor(){
        scanner.nextLine();
        boolean adicionarOutro = true;

        do{
            System.out.println("Informe o nome do Ator:");
            String nomeAtor = scanner.nextLine();

            boolean existeCpf = false;
            String cpf;
            do {
                System.out.println("Informe o CPF do Ator:");
                cpf = scanner.nextLine();

                for (Ator ator : atores) {
                    if (ator.getCpf().equals(cpf)) {
                        existeCpf = true;
                        System.out.println("O cpf " + cpf  + " " + " já existe. Por favor, digite outro cpf!");
                    }else {
                        existeCpf = false;
                    }
                }
            }while (existeCpf);

            boolean filmeEncontrado = false;
            do {

                for (Filme filme : filmes){
                    System.out.println("id " + filme.getId() + "| "  + filme.getNome());
                }

                System.out.println("Digite o id do filme onde o ator se apresenta:");
                Long idFilme = scanner.nextLong();

                for (Filme filme : filmes) {
                    if (idFilme.equals(filme.getId())) {
                        Ator ator = new Ator(nomeAtor, cpf);
                        atores.add(ator);
                        filmeEncontrado = true;
                        System.out.println("Ator cadastrado com sucesso!");
                        break;
                    }
                }

                if (!filmeEncontrado) {
                    System.out.println("Filme com id " + idFilme + " não encontrado! Por favor, informe um id valido:");
                }
            }while (!filmeEncontrado);

            String resposta;
            do {
                System.out.println("Deseja adicionar outro ator? (S/N):");
                scanner.nextLine();
                resposta = scanner.next();

                if (!Objects.equals(resposta, "s") && !Objects.equals(resposta, "n")) {
                    System.out.println("Opção incorreta, digite 'S' para SIM e 'N' para NÃO!");
                }
            }while (!Objects.equals(resposta, "s") && !Objects.equals(resposta, "n"));

            if (resposta.equalsIgnoreCase("n")) {
                adicionarOutro = false;
            }

            scanner.nextLine();

        }while (adicionarOutro);
    }

    public static void cadastrarDiretor() {
        scanner.nextLine();
        boolean adicionarOutro = true;

        do {
            System.out.println("Informe o nome do Diretor:");
            String nomeDiretor = scanner.nextLine();
            System.out.println("Informe a área do Diretor:");
            String area = scanner.nextLine();

            boolean filmeEncontrado;
            do {
                filmeEncontrado = false;
                for (Filme filme : filmes){
                    System.out.println("id " + filme.getId() + "| "  + filme.getNome());
                }
                System.out.println("Digite o id do filme que o diretor coordenou:");
                Long idFilme = scanner.nextLong();

                for (Filme filme : filmes) {
                    if (idFilme.equals(filme.getId())) {
                        Diretor diretor = new Diretor(nomeDiretor, area);
                        diretores.addAll(filme.getDiretores());
                        diretores.add(diretor);
                        filme.setDiretores(diretores);
                        filmeEncontrado = true;
                        System.out.println("Diretor cadastrado com sucesso!");
                        break;
                    }

                    if (!filmeEncontrado) {
                        System.out.println("Filme com id " + idFilme + " não encontrado! Por favor, informe um id valido:");
                    }
                }

            }while (!filmeEncontrado);

            String resposta;
            do {
                System.out.println("Deseja adicionar outro Diretor? (S/N):");
                resposta = scanner.next();

                if (!Objects.equals(resposta, "s") && !Objects.equals(resposta, "n")) {
                    System.out.println("Opção incorreta, digite 'S' para SIM e 'N' para NÃO!");
                }
            }while (!Objects.equals(resposta, "s") && !Objects.equals(resposta, "n"));

            if (resposta.equalsIgnoreCase("n")) {
                adicionarOutro = false;
            }

        }while (adicionarOutro);
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