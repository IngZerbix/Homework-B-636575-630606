package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia stanza;

	@BeforeEach
	void setup() {
		this.stanza = new StanzaBuia("cantina","lampadina");
	}
	
	@Test
	void testSenzaLampadina() {
		assertEquals(this.stanza.getDescrizione(),"qui c'è un buio pesto");
	}
	
	@Test
	void testConLampadina() {
		Attrezzo lampadina = new Attrezzo("lampadina", 3);
		this.stanza.addAttrezzo(lampadina);
		assertEquals(this.stanza.getDescrizione(),"cantina\nUscite: \nAttrezzi nella stanza: lampadina (3kg) ");
	}
	

}
