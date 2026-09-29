package br.edu.principal;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int capacidade = 5;
        String[] nomes = new String[capacidade];
        String[] celulares = new String[capacidade];
        String[] emails = new String[capacidade];
        int quantidade = 0;
        Scanner sc = new Scanner(System.in);
        int opcao;
        boolean continuar = true;

        System.out.println("==========================");
        System.out.println("    AGENDA DE CONTATOS");
        System.out.println("        V.0.1.0");
        System.out.println("==========================");
        System.out.println("Bem-vindo!");

        while (continuar) {
            System.out.println();
            System.out.println("1-Adicionar contato");
            System.out.println("2-Listar contatos");
            System.out.println("3-Procurar contato");
            System.out.println("4-Excluir contato");
            System.out.println("5-Sair");
            System.out.println();
            System.out.print("Escolha uma opção:");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- ADICIONAR CONTATO ---");
                    if (quantidade == capacidade) {
                        System.out.println("Agenda cheia!");
                    } else {
                        System.out.print("Nome:");
                        nomes[quantidade] = sc.nextLine();
                        System.out.print("Celular:");
                        celulares[quantidade] = sc.nextLine();
                        System.out.print("E-mail:");
                        emails[quantidade] = sc.nextLine();
                        quantidade++;
                        System.out.println("Contato salvo com sucesso!");
                    }
                    break;
                case 2:
                    System.out.println("\n--- LISTAR CONTATOS ---");
                    if (quantidade == 0) {
                        System.out.println("Nenhum contato encontrado!");
                    } else {
                        for (int i = 0; i < quantidade; i++) {
                            System.out.println("\nContato " + (i + 1));
                            System.out.println("Nome:" + nomes[i]);
                            System.out.println("Celular:" + celulares[i]);
                            System.out.println("E-mail:" + emails[i]);
                        }
                    }
                    break;
                case 3:
                    System.out.println("\n--- PROCURAR CONTATO ---");
                    System.out.print("Digite o nome que deseja procurar:");
                    String nomeBusca = sc.nextLine();
                    boolean encontrado = false;
                    for (int i = 0; i < quantidade; i++) {
                        if (nomes[i].equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Contato encontrado!");
                            System.out.println("Nome:" + nomes[i]);
                            System.out.println("Celular:" + celulares[i]);
                            System.out.println("E-mail:" + emails[i]);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("\n--- EXCLUIR CONTATO ---");
                    if (quantidade == 0) {
                        System.out.println("Nenhum contato cadastrado.");
                    } else {
                        System.out.print("Digite o nome do contato que deseja excluir:");
                        String nomeExcluir = sc.nextLine();
                        int indiceExcluir = -1;
                        for (int i = 0; i < quantidade; i++) {
                            if (nomes[i].equalsIgnoreCase(nomeExcluir)) {
                                indiceExcluir = i;
                            }
                        }
                        if (indiceExcluir == -1) {
                            System.out.println("Contato não encontrado.");
                        } else {
                            for (int i = indiceExcluir; i < quantidade - 1; i++) {
                                nomes[i] = nomes[i + 1];
                                celulares[i] = celulares[i + 1];
                                emails[i] = emails[i + 1];
                            }
                            nomes[quantidade - 1] = null;
                            celulares[quantidade - 1] = null;
                            emails[quantidade - 1] = null;
                            quantidade--;
                            System.out.println("Contato excluído com sucesso!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}