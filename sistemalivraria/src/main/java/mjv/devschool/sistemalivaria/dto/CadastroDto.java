package mjv.devschool.sistemalivaria.dto;

import java.io.Serializable;

import mjv.devschool.sistemalivaria.model.Cadastro;

public class CadastroDto implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String login;
	private String senha;
	
	EnderecoDto enderecDto;
	

	public CadastroDto() {
		
	}
	
	public CadastroDto(Long id, String nome,String cpf,String telefone,String login,String senha) {
		
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.login = login;
		this.senha = senha;
		
	}
	
	public CadastroDto(Cadastro entidade) {
		
		this.id = entidade.getId();
		this.nome = entidade.getNome();
		this.cpf = entidade.getCpf();
		this.telefone = entidade.getTelefone();
		this.login = entidade.getLogin();
		this.senha = entidade.getSenha();
		
	}
	
	
	

	public EnderecoDto getEnderecDto() {
		return enderecDto;
	}

	public void setEnderecDto(EnderecoDto enderecDto) {
		this.enderecDto = enderecDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
	
	
	
	
	
}
