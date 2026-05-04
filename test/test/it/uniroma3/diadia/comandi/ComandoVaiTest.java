package it.uniroma3.diadia.comandi;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	
	private ComandoVai comando;
	private Partita partita;

	@BeforeEach
	void setUp() {
		IO io = new IOConsole();
		this.comando = new ComandoVai(io);
		this.partita = new Partita();
	}
	
	@Test
	void testNoDirezione() {
		Stanza stanzaIniziale = partita.getStanzaCorrente();
		comando.setParametro(null);
		comando.esegui(partita);
		assertEquals(partita.getStanzaCorrente(),stanzaIniziale);
	}
	
	@Test
	void testDirezioneNord() {
		Stanza stanzaNord = partita.getStanzaCorrente().getStanzaAdiacente("nord");
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(partita.getStanzaCorrente(),stanzaNord);
	}
	
	@Test 
	void testNoStanzaAdiacente(){
		Stanza stanzaIniziale = partita.getStanzaCorrente();
		partita.getStanzaCorrente().impostaStanzaAdiacente("nord", null);
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(partita.getStanzaCorrente(), stanzaIniziale);	
	}

}
