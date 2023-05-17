package entities;

public class BankTransfer implements MethodsOfPayment {
	
	private int contaOrigem;
	private int contaDestino;
	private double valor;
	private double saldo;
	
	public BankTransfer() {
	}
	
	
	public BankTransfer(int contaOrigem, int contaDestino, double valor, double saldo) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valor = valor;
		this.saldo = saldo;
	}


	public int getContaOrigem() {
		return contaOrigem;
	}


	public void setContaOrigem(int contaOrigem) {
		this.contaOrigem = contaOrigem;
	}


	public int getContaDestino() {
		return contaDestino;
	}


	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public double getSaldo() {
		return saldo;
	}

	public boolean verificarSaldo(double valor, double saldo) {
		if (valor <= saldo) {
			return true;
		}
		return false;
	}

	public double saldoFinal(double valor, double saldo) {
		return saldo - valor;
	}

	public void realizarPagamento() {
		System.out.printf("\n\n\nO pagamento no valor de %.2f via transferência bancária da conta de número: %d para a conta: %d foi efetuado com sucesso.\n\n\n", getValor(), getContaOrigem(), getContaDestino());
	}
	
	public void gerarRecibo() {
		System.out.println("=============== RECIBO ===============");
		System.out.println("Conta de origem: " + contaOrigem);
		System.out.println("Conta de destino: " + contaDestino);
		System.out.println("Valor: R$ " + getValor());
		System.out.println("Saldo final da conta: R$ " + saldoFinal(valor, saldo));
		System.out.println("======================================");
		System.out.println("Situação: pagamento efetuado com sucesso.");		
	}
}
