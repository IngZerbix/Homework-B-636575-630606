package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {
	private String luce;
	
	public StanzaBuia(String nome, String lanterna) {
		super(nome);
		this.luce = lanterna;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(this.luce)) {
			return super.getDescrizione();
		}
		else {
			return "qui c'è un buio pesto";
		}
	}
}
