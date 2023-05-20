package entities;

public class ControleRemoto {
	
	private Televisao tv;
	
	public ControleRemoto() {
	}
	
	public ControleRemoto(Televisao tv) {
		this.tv = tv;
	}
	
	public void aumentarVolume() {
		tv.aumentarVolume();
	}
	
	public void diminuirVolume() {
		tv.diminuirVolume();
	}
	
	public void aumentarCanal() {
		tv.aumentarCanal();
	}
	
	public void diminuirCanal() {
		tv.diminuirCanal();
	}
	
	public void trocarCanal(int novoCanal) {
		if (novoCanal >= 1)
			tv.setCanal(novoCanal);
		else
			System.out.println("\nCanal inválido.");
	}
	
	public int consultarVolume() {
		return tv.getVolume();
	}
	
	public int consultarCanal() {
		return tv.getCanal();
	}
	
	public String consultarInformacoes() {
		return "A televisão está no canal "
				+ tv.getCanal() 
				+ " e com o volume de " 
				+ tv.getVolume() 
				+ ".";
	}
}