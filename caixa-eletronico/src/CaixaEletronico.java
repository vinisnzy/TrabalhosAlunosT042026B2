import java.util.Locale;
import java.util.Scanner;

public class CaixaEletronico {
	static double saldo = 0.0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean caixaLigado = false;
		int senhaCaixa = 1234;
		
		for (int i = 1; i <= 3; i++) {
			System.out.print("Digite sua senha (4 Dígitos): ");
			int senha = sc.nextInt();
			if (senha == senhaCaixa) {
				i = 4; // Sai do for
				caixaLigado = true;
				System.out.println("Caixa liberado\n");
			} else {
				System.out.println("Senha inválida, tentativa " + i + " de 3\n");
				if (i == 3) {
					System.out.println("Acabaram suas tentativas: Caixa bloqueado");
				}
			}
		}
		
		while (caixaLigado) {
			System.out.println("1. Consultar saldo");
			System.out.println("2. Depositar dinheiro");
			System.out.println("3. Sacar dinheiro");
			System.out.println("4. Sair");
			System.out.print("Escolha a operação desejada: ");
			int operacao = sc.nextInt();
			if (operacao==1) {
				consultarSaldo();
			}
			else if (operacao==2) {
				System.out.print("Digite o valor que deseja depositar: ");
				double valor = sc.nextDouble();
				depositarDinheiro(valor);
			}
			else if (operacao==3) {
				System.out.print("Digite o valor que deseja sacar: ");
				double valor = sc.nextDouble();
				sacarDinheiro(valor);
			}
			else if (operacao==4) {
				System.out.println("Sessão encerrada...");
				caixaLigado = false;
			} else {
				System.out.println("Erro! Digite um valor de 1 a 4\n");
			}
		}
		
		sc.close();
	}
	
	public static void consultarSaldo() {
		System.out.printf(Locale.of("pt", "BR"), "O saldo na conta é R$ %.2f%n", saldo);
	}
	
	public static void depositarDinheiro(double valor) {
		if (valor<=0) {
			System.out.println("Valor inválido\n");
		}
		else {
			saldo+=valor;
			System.out.println("Valor depositado\n");
		}
	}
	
	public static void sacarDinheiro(double valor) {
		if (valor<=0) {
			System.out.println("Valor inválido\n");
		}
		else if (valor>saldo) {
			System.out.println("Saldo insuficiente\n");
		}
		else if (valor<=500) {
			System.out.println("Limite de saque diário atingido. Seu limite atual é de R$ 500,00");
		}
		else {
			saldo-=valor;
			System.out.println("Valor sacado\n");
		}
	}
}