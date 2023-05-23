package orientacaoObjetos;

public class Conta {
	private String nome;
	private int numero;
	private float saldo;
	private static int numeroGeral = 0;
	private static float saldoGeral;

	public Conta(String nome) {
		this.nome = nome;
		this.saldo = (float) 0.00;
		numeroGeral++;
		this.numero = numeroGeral;
	}

	public boolean saque(float valor) {
		if (valor > saldo + 0.02 || valor < 1) {
			return false;
		}
		this.saldo = this.saldo - valor;
		this.saldo = this.saldo - (float) 0.02;
		return true;
	}

	public boolean saque() {
		if (this.saldo < 100) {
			return false;
		}
		
		this.saldo = this.saldo - 100;
		this.saldo = this.saldo - (float) 0.02;
		return true;
	}

	public boolean transferencia(float valor, Conta conta) {
		if (valor > this.saldo || valor < 1) {
			return false;
		}
		this.saldo = this.saldo - valor;
		conta.saldo = conta.saldo + valor;
		return true;
	}

	public void deposito(float valor) {
		this.saldo = this.saldo + valor;
	}

	public String getNome() {
		return nome;
	}

	public static float getSaldoGeral() {
		return saldoGeral;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}
