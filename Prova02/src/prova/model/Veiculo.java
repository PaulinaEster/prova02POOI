package prova.model;

public class Veiculo {
	
	private int id;
	private String modelo;
	private String ano;
	private String numeroSerie;
	private String marca;
	private String cor;
	private String tipo;
	
	public Veiculo() {}

	public Veiculo(int id, String modelo, String ano, String numeroSerie, String marca, String cor, String tipo) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.ano = ano;
		this.numeroSerie = numeroSerie;
		this.marca = marca;
		this.cor = cor;
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	
	
}
