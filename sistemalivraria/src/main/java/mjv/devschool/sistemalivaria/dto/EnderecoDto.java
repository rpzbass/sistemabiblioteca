package mjv.devschool.sistemalivaria.dto;

import java.io.Serializable;

public class EnderecoDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	
	private String cep;
	private String logradouro;
	private String bairro;
	private String localidade;
	private String uf;
	private Integer ibge;
	
	
	
	public EnderecoDto() {
		
	}
	
	public EnderecoDto(Long id, String cep, String logradouro, String bairro, String localidade, String uf,String ibge) {
		
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getIbge() {
		return ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}
	
	
}