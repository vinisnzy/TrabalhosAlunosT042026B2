package calculadora;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o primeiro valor: ");
		int n1 = scanner.nextInt();

		System.out.println("Digite o segundo valor: ");
		int n2 = scanner.nextInt();

		System.out.println("Digite a operação desejada (+, -, *, /):");
		String op = scanner.next();

		if (op.equals("+")) {
			System.out.println("Resultado: " + (somar(n1, n2)));
		} else if (op.equals("-")) {
			System.out.println("Resultado: " + (subtrair(n1, n2)));
		} else if (op.equals("*")) {
			System.out.println("Resultado: " + (multiplicar(n1, n2)));
		} else if (op.equals("/")) {
			if (n2 == 0) {
				System.out.println("Não é possível fazer uma divisão por 0");
			} else {
				System.out.println("Resultado: " + (dividir(n1, n2)));
			}
			
		} else {
			System.out.println("Operação inválida");
		}

		scanner.close();
	}
	
	public static double somar(double primeiroNumero, double segundoNumero) {
		return primeiroNumero + segundoNumero;
	}
	
	public static double subtrair(double primeiroNumero, double segundoNumero) {
		return primeiroNumero - segundoNumero;
	}
	
	public static double multiplicar(double primeiroNumero, double segundoNumero) {
		return primeiroNumero * segundoNumero;
	}

	public static double dividir(double primeiroNumero, double segundoNumero) {
		return primeiroNumero / segundoNumero;
	}
}
