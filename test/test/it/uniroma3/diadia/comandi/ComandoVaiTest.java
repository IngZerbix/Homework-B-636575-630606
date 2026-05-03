package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {

	@Test
	void testNoDirezione() {
		IO io = new IOConsole();
		ComandoVai comando = new ComandoVai(io);
		Partita partita = new Partita();
		Stanza stanzaIniziale = partita.getStanzaCorrente();
		comando.setParametro(null);
		comando.esegui(partita);
		assertEquals(partita.getStanzaCorrente(),stanzaIniziale);
	}
	
	@Test
	void testDirezioneNord() {
		IO io = new IOConsole();
		ComandoVai comando = new ComandoVai(io);
		Partita partita = new Partita();
		Stanza stanzaNord = partita.getStanzaCorrente().getStanzaAdiacente("nord");
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(partita.getStanzaCorrente(),stanzaNord);
	}
	
	@Test 
	void testNoStanzaAdiacente(){
		IO io = new IOConsole();
		ComandoVai comando = new ComandoVai(io);
		Partita partita = new Partita();
		Stanza stanzaIniziale = partita.getStanzaCorrente();
		partita.getStanzaCorrente().impostaStanzaAdiacente("nord", null);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(partita.getStanzaCorrente(), stanzaIniziale);	
	}

}
