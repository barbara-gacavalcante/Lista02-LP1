package entities;

public class Televisao {
	protected int volume = 0;
	protected int canal = 1;
	
	public Televisao() {
	}
	
	public Televisao (int volume, int canal) {
		this.volume = volume;
		this.canal = canal;
	}
		
	public int getVolume() {
		return volume;
	}

	public int getCanal() {
		return canal;
	}

	public void setCanal(int canal) {
		this.canal = canal;
	}

	public void aumentarVolume() {
		volume++;
	}
	
	public void aumentarCanal() {
		canal++;
	}
	
	public void diminuirVolume() {
		if (volume > 0) {
			volume--;
		}
	}
	
	public void diminuirCanal() {
		if (canal >  1) {
			canal--;
		}
	}
	
}
