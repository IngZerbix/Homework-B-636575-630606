package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

class FabbricaComandiTest {
	private Comando comandoVai;
	private Comando comandoPrendi;
	private Comando comandoPosa;
	private Comando comandoAiuto;
	private Comando comandoFine;
	private Comando comandoGuarda;
	

	@BeforeEach
	void setUp() {
		IO io = new IOConsole();
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica(io);
		this.comandoVai = fabbrica.costruisciComando("vai nord");
		this.comandoPrendi = fabbrica.costruisciComando("prendi mela");
		this.comandoPosa = fabbrica.costruisciComando("posa banana");
		this.comandoAiuto = fabbrica.costruisciComando("aiuto");		
		this.comandoFine = fabbrica.costruisciComando("fine");
		this.comandoGuarda = fabbrica.costruisciComando("guarda");
	}
	
	@Test
	void testVaiNome() {
		assertEquals(this.comandoVai.getNome(),"vai");
	}
	
	@Test
	void testVaiParametro() {
		assertEquals(this.comandoVai.getParamentro(),"nord");
	}
	
	@Test
	void testPrendiNome() {
		assertEquals(this.comandoPrendi.getNome(),"prendi");
	}
	
	@Test
	void testPrendiParametro() {
		assertEquals(this.comandoPrendi.getParamentro(),"mela");
	}
	
	@Test
	void testPosaNome() {
		assertEquals(this.comandoPosa.getNome(),"posa");
	}
	
	@Test
	void testPosaParametro() {
		assertEquals(this.comandoPosa.getParamentro(),"banana");
	}
	
	@Test
	void testAiutoNome() {
		assertEquals(this.comandoAiuto.getNome(),"aiuto");
	}
	
	@Test
	void testAiutoParametro() {
		assertNull(this.comandoAiuto.getParamentro());
	}
	
	@Test
	void testFineNome() {
		assertEquals(this.comandoFine.getNome(),"fine");
	}
	
	@Test
	void testFineParametro() {
		assertNull(this.comandoFine.getParamentro());
	}
	
	@Test
	void testGuardaNome() {
		assertEquals(this.comandoGuarda.getNome(),"guarda");
	}
	
	@Test
	void testGuardaParametro() {
		assertNull(this.comandoGuarda.getParamentro());
	}
	
	
	
	
	
	

}
