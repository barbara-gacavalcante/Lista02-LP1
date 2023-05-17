package entities;

public class CreditCard implements MethodsOfPayment {
	
	private int numero;
	private String titular;
	private int cvv;
	private double limite;
	private double valor;
	
	public CreditCard () {
	}
	
	public CreditCard(int numero, String titular, int cvv, double limite, double valor) {
		this.numero = numero;
		this.titular = titular;
		this.cvv = cvv;
		this.limite = limite;
		this.valor = valor;
	}


	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public boolean verificarLimite(double limite, double valor) {
		if (limite >= valor) {
			return true;
		}
		return false;
	}

	public void realizarPagamento() {
		System.out.printf("\n\n\nO pagamento no valor de %.2f no cartão de %s foi efetuado com sucesso.\n\n\n", getValor(), titular);
	}
	
	public void gerarRecibo() {
		System.out.println("=============== RECIBO ===============");
		System.out.println("Nome do titular: " + titular);
		System.out.println("Nº do cartão: " + numero);
		System.out.println("CVV: " + cvv);
		System.out.println("Valor: R$ " + getValor());
		System.out.println("======================================");
		System.out.println("Situação: pagamento efetuado com sucesso.");
	}
}
