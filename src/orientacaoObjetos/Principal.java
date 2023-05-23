package orientacaoObjetos;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		Banco banco = new Banco();
		Scanner leitor = new Scanner(System.in);
		
		System.out.println("Escolha uma opção ! \n");
		

		System.out.println("1. Cadastrar conta");
		System.out.println("2. Listar contas existentes ");
		System.out.println("3. Entrar em uma conta");
		System.out.println("4. Ver saldo geral");
		System.out.println("0. Sair \n");
		
		int opcao = leitor.nextInt();
		
		do {
			
			switch(opcao) {
			case 1:
				banco.cadastrarConta();
				break;
			case 2:
				banco.listarContas();
				break;
			case 3:
				banco.acessarConta();
				break;
			case 4:
				System.out.println("Saldo geral = " + Conta.getSaldoGeral());
				break;
			default:
				System.out.println("Opção inválida");
			}
			
			System.out.println("");
			System.out.println("1. Cadastrar conta");
			System.out.println("2. Listar contas existentes ");
			System.out.println("3. Entrar em uma conta");
			System.out.println("4. Ver saldo geral");
			System.out.println("0. Sair");
			
			opcao = leitor.nextInt(); 
			
		} while (opcao != 0);
		
		
		leitor.close();
	}

}
