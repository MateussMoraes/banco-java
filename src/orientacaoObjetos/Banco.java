package orientacaoObjetos;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Banco {

	ArrayList<Conta> contas = new ArrayList<Conta>();

	Scanner leitor = new Scanner(System.in);

	public void cadastrarConta() {
		System.out.println("Digite o nome da conta: ");

		String nomeConta = leitor.next();

		Conta novaConta = new Conta(nomeConta);

		contas.add(novaConta);

		System.out.println("Conta criada com sucesso");
	}

	public void listarContas() {
		for (int i = 0; i < contas.size(); i++) {
			System.out.println(contas.get(i).getNumero() + ". Conta => " + contas.get(i).getNome() + " ||  Saldo => " + contas.get(i).getSaldo());
		}
	}

	public Conta findConta(int numeroConta) {
		for (Conta c : contas) {
			if (c.getNumero() == numeroConta) {
				return c;
			}
		}
		return null;
	}

	public void sacar(Conta contaAtual) {
		System.out.println("Saldo atual: " + contaAtual.getSaldo());

		System.out.println("Quantos você deseja sacar ?");

		float valor = leitor.nextFloat();

		boolean saque = contaAtual.saque(valor);

		if (saque) {
			System.out.println(valor + " sacado com sucesso");
		} else {
			System.out.println("Saldo insuficiente !");
		}
	}
	
	public void saqueCemReais(Conta contaAtual) {
		System.out.println("Saldo atual: " + contaAtual.getSaldo());
		
		boolean saque = contaAtual.saque();
		
		if (saque) {
			System.out.println("Cem reais sacado com sucesso");
		} else {
			System.out.println("Saldo insuficiente !");
		} 

	}

	public void depositar(Conta contaAtual) {
		System.out.println("Saldo atual: " + contaAtual.getSaldo());

		System.out.println("Digite o valor do depósito: ");

		float valor = leitor.nextFloat();

		contaAtual.deposito(valor);

		System.out.println("Depósito realizado com sucesso");
		System.out.println("Saldo atual: " + contaAtual.getSaldo());
	}

	public void transferir(Conta contaAtual) {
		System.out.println("Saldo atual: " + contaAtual.getSaldo());

		System.out.println("Escolha a conta para transferir");

		listarContas();

		int contaNumero = leitor.nextInt();

		Conta contaEscolhida = findConta(contaNumero);

		if (contaEscolhida != null) {
			System.out.println("Digite o valor da transferência:");

			float valor = leitor.nextFloat();
			
			

			boolean transferencia = contaAtual.transferencia(valor, contaEscolhida);
			
			if (transferencia) {
				System.out.println("Transferência realizada com sucesso");
				System.out.println("Saldo atual: " + contaAtual.getSaldo());				
			} else {
				System.out.println("Saldo insuficiente !");
			}

		} else {
			System.out.println("Conta não encontrada !");
		}

	}

	public void acessarConta() {

		if (contas.size() > 0) {

			System.out.println("Escolha a conta: ");
			listarContas();

			int numeroConta = leitor.nextInt();

			Conta contaAcessada = findConta(numeroConta);

			System.out.println("Conta acessada com sucesso !");
			System.out.println("Nome -> " + contaAcessada.getNome());
			System.out.println("Número -> " + contaAcessada.getNumero());
			System.out.println("Saldo da conta -> " + contaAcessada.getSaldo());

			System.out.println("Escolha uma operação");

			System.out.println("");
			System.out.println("1. Saque com valor");
			System.out.println("2. Transferir ");
			System.out.println("3. Depositar");
			System.out.println("4. Saque de 100 (cem) reais");
			System.out.println("0. Sair");

			int operacao = leitor.nextInt();

			do {
				switch (operacao) {
				case 1:
					sacar(contaAcessada);
					break;
				case 2:
					transferir(contaAcessada);
					break;
				case 3:
					depositar(contaAcessada);
					break;
				case 4:
					
					
				default:
					System.out.println("Opção inválida");
				}
				
				System.out.println("");
				System.out.println("1. Sacar");
				System.out.println("2. Transferir ");
				System.out.println("3. Depositar");
				System.out.println("0. Sair");

				operacao = leitor.nextInt();

			} while (operacao != 0);
		} else {
			System.out.println("Não tem nenhuma conta !");
		}

	}

}
