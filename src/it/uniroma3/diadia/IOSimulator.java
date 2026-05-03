package it.uniroma3.diadia;

public class IOSimulator implements IO {
	private String[] input;
	private int indiceInput = 0;
	private String[] output;
	private int indiceOutput = 0;

	public IOSimulator(String[] array) {
		this.input = array;
		this.output = new String[input.length];
	}

	@Override
	public void mostraMessaggio(String messaggio) {
		output[indiceOutput++] = messaggio;
	}

	@Override
	public String leggiRiga() {
		return input[indiceInput++];
	}
	
	public String[] getOutput() {
		return this.output;
	}
}
