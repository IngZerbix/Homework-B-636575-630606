package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoVai;

class StanzaBloccataTest {
	private StanzaBloccata cella;
	private Partita partita;
	private ComandoVai comando;

	@BeforeEach
	void setUp() {
		this.cella = new StanzaBloccata("cella", "chiave", "nord");
		Stanza corridoio = new Stanza("corridoio");
		Stanza bagno = new Stanza("bagno");
		this.cella.impostaStanzaAdiacente("nord", corridoio);
		this.cella.impostaStanzaAdiacente("est", bagno);
		this.partita = new Partita();
		this.partita.setStanzaCorrente(cella);
		IO io = new IOConsole();
		this.comando = new ComandoVai(io);
	}
	
	@Test
	void testDirezioneBloccataSenzaChiave() {
		this.comando.setParametro("nord");
		this.comando.esegui(this.partita);
		assertEquals(this.partita.getStanzaCorrente(), cella);
	}
	
	@Test
	void testDirezioneNonBloccataSenzaChiave() {
		this.comando.setParametro("est");
		this.comando.esegui(this.partita);
		assertEquals(this.partita.getStanzaCorrente(), this.cella.getStanzaAdiacente("est"));
	}
	
	@Test
	void testDirezioneBloccataConChiave() {
		Attrezzo chiave = new Attrezzo("chiave", 5);
		this.cella.addAttrezzo(chiave);
		this.comando.setParametro("nord");
		this.comando.esegui(this.partita);
		assertEquals(this.partita.getStanzaCorrente(), this.cella.getStanzaAdiacente("nord"));
	}

}
