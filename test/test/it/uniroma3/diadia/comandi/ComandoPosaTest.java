package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	private ComandoPosa comando;
	private Partita partita;
	
	@BeforeEach
	void setup() {
		IO io = new IOConsole();
		this.comando = new ComandoPosa(io);
		this.partita = new Partita();
		Attrezzo matita = new Attrezzo("matita", 2);
		this.partita.getGiocatore().getBorsa().addAttrezzo(matita);
	}
	
	@Test 
	void testMatitaInStanza() {
		this.comando.setParametro("matita");
		this.comando.esegui(partita);
		assertTrue(this.partita.getStanzaCorrente().hasAttrezzo("matita"));
	}
	
	@Test
	void testMatitaNonInBorsa() {
		this.comando.setParametro("matita");
		this.comando.esegui(partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("matita"));
	}
	
	@Test
	void testStanzaPiena() {
		while (this.partita.getStanzaCorrente().getCapacita() > 0) {
			Attrezzo penna = new Attrezzo("penna", 3);
			this.partita.getStanzaCorrente().addAttrezzo(penna);
		}
		this.comando.setParametro("matita");
		this.comando.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("matita"));
	}
	
	@Test
	void testAttrezzoNonInBorsa() {
		this.comando.setParametro("gomma");
		this.comando.esegui(partita);
		assertFalse(this.partita.getStanzaCorrente().hasAttrezzo("gomma"));
	}
	

}
