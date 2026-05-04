package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IOSimulatorTest {
	private String[] input = {
			"vai sud",
			"prendi lanterna",
			"vai ovest",
			"posa lanterna",
			"vai ovest",
			"vai ovest",
			"prendi osso",
			"vai nord"
	};
	private String[] outputAtteso = {
			""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.",
			"Aula N10\n"
			+ "Uscite:  nord est ovest\n"
			+ "Attrezzi nella stanza: lanterna (3kg) ",
			"Aula N10\n"
			+ "Uscite:  nord est ovest\n"
			+ "Attrezzi nella stanza: ",
			"Laboratorio Campus\n"
			+ "Uscite:  est ovest\n"
			+ "Attrezzi nella stanza: ",
			"Laboratorio Campus\n"
			+ "Uscite:  est ovest\n"
			+ "Attrezzi nella stanza: lanterna (3kg) ",
			"Aula N11\n"
			+ "Uscite:  est ovest\n"
			+ "Attrezzi nella stanza: ",
			"Atrio\n"
			+ "Uscite:  nord est sud ovest\n"
			+ "Attrezzi nella stanza: osso (1kg) ",
			"Atrio\n"
			+ "Uscite:  nord est sud ovest\n"
			+ "Attrezzi nella stanza: ",
			"Biblioteca\n"
			+ "Uscite:  sud\n"
			+ "Attrezzi nella stanza: ",
			"Hai vinto!"	
	};

	@Test
	void test() {
		IOSimulator io = new IOSimulator(input);
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
		String[] output = io.getOutput();
		for (int i = 0; i < output.length; i++) {
			assertEquals(outputAtteso[i], output[i]);
		}
	}

}
