package entities;

public class Ticket implements MethodsOfPayment {
	
	private int codigoDeBarras;
	private double valor;
	
	public Ticket () {
	}
	
	public Ticket (int cod, double valor) {
		this.codigoDeBarras = cod;
		this.valor = valor;
	}
	
	
	public int getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(int codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void realizarPagamento() {
		System.out.printf("\n\n\nO pagamento no valor de %.2f do boleto de código: %d foi efetuado com sucesso.\n\n\n", getValor(), getCodigoDeBarras());
	}
	
	public void gerarRecibo() {
		System.out.println("=============== RECIBO ===============");
		System.out.println("Código de barras: " + codigoDeBarras);
		System.out.println("Valor: R$ " + getValor());
		System.out.println("======================================");
		System.out.println("Situação: pagamento efetuado com sucesso.");
	}
}
