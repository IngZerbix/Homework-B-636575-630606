package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {
	private String direzioneBloccata;
	private String chiave;

	public StanzaBloccata(String nome, String chiave, String direzioneBloccata) {
		super(nome);
		this.chiave = chiave;
		this.direzioneBloccata = direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione.equals(direzioneBloccata)) {
			if(this.hasAttrezzo(chiave)) {
				return super.getStanzaAdiacente(direzione);
			} else
				return this;
		} else 
			return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String messaggio = super.getDescrizione();
		if(this.hasAttrezzo(chiave)) {
			return messaggio;
		} else
			return messaggio + "\nLa direzione " + this.direzioneBloccata + 
			" è bloccata senza " + this.chiave;
	}

}
