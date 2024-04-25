package Trabalho_Javaa;

import Trabalho_Javaa.entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Grupo: Áquila Morais, Ketly Wine, Isaque Severino, José Miguel
public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        int i; int verif = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato de data

        System.out.println("Bem-vindo ao sistema de gerenciamento de campeonatos de handball!");

        Campeonato campeonato = new Campeonato(2023,"Copa Brasil de Handeboll");
        System.out.printf("\n ----- %s ----- \n\t\t\t\t%d", campeonato.getNome(), campeonato.getAno());

        boolean test = true;
        while (test){
            System.out.println("\n\nOpções do campeonato: ");
            System.out.println("1. Adicionar time");
            System.out.println("2. Adicionar partida");
            System.out.println("3. Listar partidas ocorridas e não ocorridas");
            System.out.println("4. Listar tabela do campeonato (sem ordenação)");
            System.out.println("5. Listar tabela do campeonato (com ordenação)");
            System.out.println("6. Mostrar informações adicionais dos times");
            System.out.println("7. Sair");
            System.out.print("OPÇÃO: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Para consumir a quebra de linha após o número.

            switch (opcao) {
                case 1:
                    int n = 0; int s = 0;
                    // Adiciona o time

                    System.out.print("\nDigite o nome do time: ");
                    String nomeTime = scanner.nextLine();
                    System.out.print("Digite o nome do estádio: ");
                    String nomeEstadio = scanner.nextLine();
                    System.out.print("Preencha as informações do endereço do estádio\nDigite o nome do logradouro: ");
                    String logradouro = scanner.nextLine();
                    System.out.print("Digite o complemento: ");
                    String complemento = scanner.nextLine();
                    System.out.print("Digite o bairro: ");
                    String bairro = scanner.nextLine();

                    Endereco endereco = new Endereco(logradouro, complemento, bairro);

                    Estadio estadio = new Estadio(nomeEstadio, endereco);
                    Time time = new Time(nomeTime, estadio);
                    campeonato.addTime(time);

                    System.out.printf("\nInforme quantos jogadores seram alocados para o time %s (Mínimo 2): ",time.getNome());
                    int y = scanner.nextInt(); scanner.nextLine();
                    while (y < 2) {
                        System.out.print("Informe um número maior ou igual a 2:");
                        y = scanner.nextInt(); scanner.nextLine();
                    }
                    System.out.println("OBS: Cadastre logo o capitão.");
                    for (int j=0; j < y; j++){
                        System.out.print("\nDigite o nome do jogador: ");
                        String nomeJogador = scanner.nextLine();
                        System.out.print("Digite o gênero do jogador(m/f): ");
                        String genero = scanner.nextLine();

                        System.out.println("Os demais dados foram adicionados automaticamente.");

                        System.out.println("Transformar este jogador em capitão? (s/n): ");
                        char cap = scanner.next().charAt(0);
                        scanner.nextLine();
                        //quero melhorar essa chuva de if e else, tá feio. (pelo menos funciona)
                        if(cap == 's'){
                            s++;
                            if(s==2||time.TemCapitao()){
                                System.out.println("Um jogador já foi selecionado como capitão.");
                                System.out.println("Este não vai ser capitão.");
                                Jogador jogador = new Jogador(nomeJogador, genero, false);
                                time.addJogador(jogador);
                                System.out.println("Jogador adicionado.");
                                break;

                            } else {
                                Jogador jogador = new Jogador(nomeJogador,genero, true);
                                time.addJogador(jogador);
                                System.out.println("Jogador adicionado.");
                            }
                        } else if(cap == 'n') {
                            n++;
                            if (n >= y) {
                                if(time.TemCapitao()){
                                    Jogador jogador = new Jogador(nomeJogador, genero, false);
                                    time.addJogador(jogador);
                                    System.out.println("Jogador adicionado.");
                                    break;
                                } else{
                                    System.out.println("Pelo menos um jogador tem que ser capitão, jogadores não foram adicionados, tente de novo.");
                                    time.removeTodos();
                                    break;
                                }
                            } else {
                                Jogador jogador = new Jogador(nomeJogador, genero, false);
                                time.addJogador(jogador);
                                System.out.println("Jogador adicionado.");
                            }
                        }
                        time.definirCapitao();
                        //até aqui.

                    }
                    verif++;
                    break;
                case 2:
                    //Adicionar partidas

                    if(verif<3){
                        System.out.println("Ao menos cadastre, no mínimo, 3 times primeiro.");
                        break;
                    } else{
                        System.out.print("\nCadastre a partida!");

                        System.out.print("\nDigite a data da partida (no formato dd/MM/yyyy): ");
                        LocalDate data = LocalDate.parse(scanner.next(), formatter);

                        System.out.println("Selecione o time mandante:");
                        for (int j = 0; j < campeonato.getTimes().size(); j++) {
                            System.out.println((j + 1) + ". " + campeonato.getTimes().get(j).getNome());
                        }
                        int indiceMandante = scanner.nextInt() - 1;
                        Time timeMandante = campeonato.getTimes().get(indiceMandante);

                        // Criar uma cópia temporária da lista de times para a seleção dos visitantes
                        List<Time> timesParaSelecao = new ArrayList<>(campeonato.getTimes());
                        timesParaSelecao.remove(timeMandante);

                        System.out.println("Selecione o time visitante:");
                        for (int j = 0; j < timesParaSelecao.size(); j++) {
                            System.out.println((j + 1) + ". " + timesParaSelecao.get(j).getNome());
                        }
                        int indiceVisitante = scanner.nextInt() - 1;
                        Time timeVisitante = timesParaSelecao.get(indiceVisitante);

                        Partida partida = new Partida(timeMandante, timeVisitante, data);

                        if(partida.partidaOcorreu()) {
                            Random random = new Random();
                            int pontuacaoMandante = random.nextInt(50); // Gera um número aleatório de 0 a 50
                            int pontuacaoVisitante = random.nextInt(50);

                            System.out.println("Pontuação do time mandante: " + pontuacaoMandante);
                            System.out.println("Pontuação do time visitante: " + pontuacaoVisitante);

                            partida.setPontuacaoMandante(pontuacaoMandante);
                            partida.setPotuacaoVisitante(pontuacaoVisitante);

                            // Gerando gols aleatórios para os times
                            int gol1 = random.nextInt(10); // Gera um número aleatório de 0 a 10
                            int gol2 = random.nextInt(10);

                            System.out.println("Gols do time mandante: " + gol1);
                            System.out.println("Gols do time visitante: " + gol2);

                            // Atualizando saldo de gols para cada time
                            partida.getMandante().setGols(gol1 - gol2);
                            partida.getVisitante().setGols(gol2 - gol1);

                            if(pontuacaoMandante > pontuacaoVisitante){
                                timeMandante.setPartVencida(1);
                                timeVisitante.setPartDerrota(1);
                            } else if (pontuacaoVisitante > pontuacaoMandante) {
                                timeMandante.setPartDerrota(1);
                                timeVisitante.setPartVencida(1);
                            }
                        }

                        campeonato.addPartida(partida);
                    }
                    break;

                case 3:
                    // Lista de partidas ocorridas e não ocorridas
                    if(!campeonato.getPartidas().isEmpty()) {
                        System.out.println("***** Partidas que ocorreram *****");
                        for (Partida part : campeonato.getPartidas()) {
                            if (part.partidaOcorreu()) {
                                System.out.println(part);
                            }
                        }


                        System.out.println("***** Partidas que não ocorreram *****");
                        for (Partida part : campeonato.getPartidas()) {
                            if (!part.partidaOcorreu()) {
                                System.out.printf("\n\n-- Partida --" +
                                        "\nData -> %s" +
                                        "\nMandante -> %s" +
                                        "\nVisitante -> %s", part.getData(), part.getMandante().getNome(), part.getVisitante().getNome());
                            }
                        }
                    } else
                        System.out.println("O Campeonato não adicionou os times e/ou não realizou as partidas");

                    break;

                case 4:
                    // Listar times do campeonato sem ordenação

                    if (!campeonato.getTimes().isEmpty() && !campeonato.getPartidas().isEmpty()){
                        System.out.printf("\n-- Campeonato %s --\n", campeonato.getNome());
                        System.out.println("Nome do time   | Saldo de Vitórias | Saldo de gols");
                        for (Time t : campeonato.getTimes()) {
                            System.out.printf("%-16s | %-16d | %-16d\n", t.getNome(),t.saldoVitoria(), t.getGols());
                        }
                    } else
                        System.out.println("O Campeonato não adicionou os times e/ou não realizou as partidas");

                    break;

                case 5:
                    // Mostra tabela do campeonato com ordenação

                    if (!campeonato.getTimes().isEmpty() && !campeonato.getPartidas().isEmpty()){
                        System.out.printf("\n-- Campeonato %s --\n", campeonato.getNome());
                        System.out.println("Nome do time   | Saldo de Vitórias | Saldo de gols");

                        List<Time> times = campeonato.getTimes();

                        // Ordena a lista de times por saldo de vitórias e saldo de gols
                        times.sort((Time t1, Time t2) -> {
                            int compare = Integer.compare(t2.saldoVitoria(), t1.saldoVitoria());
                            if (compare == 0) {
                                compare = Integer.compare(t2.getGols(), t1.getGols());
                            }
                            return compare;
                        });

                        for (Time t : campeonato.getTimes()) {
                            System.out.printf("%-16s | %-16d | %-16d\n", t.getNome(),t.saldoVitoria(), t.getGols());
                        }
                    } else {
                        System.out.println("O Campeonato não adicionou os times e/ou não realizou as partidas");
                    }
                    break;
                case 6:
                    for(Time t : campeonato.getTimes()){
                        System.out.println(t);
                    }
                    break;
                case 7:
                    System.out.println("Saindo... Obrigado.");
                    test = false;
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }

        }
    }


}
