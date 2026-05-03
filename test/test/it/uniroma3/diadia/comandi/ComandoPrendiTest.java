package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {
	private ComandoPrendi comando;
	private Partita partita;
	
	@BeforeEach
	void setup() {
		IO io = new IOConsole();
		this.comando = new ComandoPrendi(io);
		this.partita = new Partita();
		Attrezzo caramella = new Attrezzo("caramella", 2);
		this.partita.getStanzaCorrente().addAttrezzo(caramella);
	}
	
	@Test 
	void testCaramellaNonInStanza() {
		this.comando.setParametro("caramella");
		this.comando.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("caramella"));
	}
	
	@Test
	void testCaramellaInBorsa() {
		this.comando.setParametro("caramella");
		this.comando.esegui(partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("caramella"));
	}
	
	@Test
	void testBorsaPiena() {
		int pesoMax = this.partita.getGiocatore().getBorsa().getPesoMax();
		Attrezzo sasso = new Attrezzo("sasso", pesoMax);
		this.partita.getGiocatore().getBorsa().addAttrezzo(sasso);
		this.comando.setParametro("caramella");
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("caramella"));
	}
	
	@Test
	void testAttrezzoNonInStanza() {
		this.comando.setParametro("pangocciolo");
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("pangocciolo"));
	}
	

}