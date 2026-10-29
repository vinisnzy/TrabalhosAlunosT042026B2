import java.util.ArrayList;
import java.util.Scanner;

import objetos.Jogo;

public class Principal {
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Jogo> jogos = new ArrayList<Jogo>();
	static int contaId = 1;

	public static void main(String[] args) {
		mostrarMenu();
	}

	private static void mostrarMenu() {
		int escolha;
		do {
			System.out.println("\n========== SISTEMA DE GERENCIAMENTO ==========");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Listar todos");
			System.out.println("3 - Buscar por ID");
			System.out.println("4 - Atualizar");
			System.out.println("5 - Excluir");
			System.out.println("0 - Sair");
			System.out.print("\nOpção: ");
			escolha = sc.nextInt();
			sc.nextLine();
			validarEscolha(escolha);
		} while (escolha != 0);
	}

	private static void validarEscolha(int escolha) {
		switch (escolha) {
		    case 1: {
		    	cadastrarJogo();
		    	break;
		    }
		    case 2: {
		    	listarJogos();
		    	break;
		    }
		    case 3: {
		    	buscarJogoPorIdEMostrar();
		    	break;
		    }
		    case 4: {
		    	atualizarJogo();
		    	break;
		    }
		    case 5: {
		    	excluirJogo();
		    	break;
		    }
			case 0: {
				System.out.println("Obrigado por utilizar o sistema!");
				break;
			}		
		}
	}

	private static void excluirJogo() {
		Jogo jogo = buscarJogoPorId();
		if (jogo != null) {
			jogos.remove(jogo);
			System.out.println("Jogo excluido com sucesso!");
		}
	}

	private static void atualizarJogo() {
		Jogo jogo = buscarJogoPorId();
		if (jogo != null) {
			System.out.print("Informe o novo nome do jogo: ");
			jogo.setNome(sc.nextLine());
			System.out.print("Informe o novo gênero do jogo: ");
			jogo.setGenero(sc.nextLine());
			System.out.println("Jogo atualizado com sucesso!");
		}
	}
	
	private static void buscarJogoPorIdEMostrar() {
		Jogo jogo = buscarJogoPorId();
		if (jogo != null) {
			jogo.printar();
		}
	}

	private static Jogo buscarJogoPorId() {
		System.out.print("\nInforme o ID do jogo: ");
		int id = sc.nextInt();
		sc.nextLine();
		for (Jogo jogo : jogos) {
			if (jogo.getId() == id) {
				return jogo;
			}
		}
		System.out.printf("Jogo não encontrado com o ID: %d\n", id);
		return null;
	}

	private static void listarJogos() {
		if (jogos.isEmpty()) {
			System.out.println("\nNenhum jogo cadastrado!");
		} else {
			System.out.println("\nLista de todos os jogos:");
			for (Jogo jogo : jogos) {
				jogo.printar();
			}
		}
	}
	private static void cadastrarJogo() {
		Jogo jogo = new Jogo();
		jogo.setId(contaId++);
		System.out.print("\nInforme o nome do jogo: ");
		jogo.setNome(sc.nextLine());
		System.out.print("Informe o gênero do jogo: ");
		jogo.setGenero(sc.nextLine());
		jogos.add(jogo);
		System.out.println("Jogo cadastrado com sucesso!\n");
	}
}
