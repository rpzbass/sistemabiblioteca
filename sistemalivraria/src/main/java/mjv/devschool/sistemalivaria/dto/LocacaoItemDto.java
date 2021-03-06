package mjv.devschool.sistemalivaria.dto;

import java.io.Serializable;
import java.util.Date;

import mjv.devschool.sistemalivaria.model.Livro;
import mjv.devschool.sistemalivaria.model.LocacaoItem;

public class LocacaoItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Date dataPrevisaoEntrega;
	private Date dataEntrega;
	private Long diarias;
	private Double valorDiaria;
	private Double valorLocacao;
	
	
	public LivroDto getLivroDto() {
		return livroDto;
	}

	public void setLivroDto(LivroDto livroDto) {
		this.livroDto = livroDto;
	}

	LivroDto livroDto = new LivroDto();
	
	public LocacaoItemDto() {
		
	}
	
	public LocacaoItemDto(Long id, Date dataPrevisaoEntrega,Date dataEntrega,Long diarias, Double valorDiaria,Double valorLocacao) {
		
		this.id = id;
		this.dataPrevisaoEntrega = dataPrevisaoEntrega;
		this.dataEntrega = dataEntrega;
		this.diarias = diarias;
		this.valorDiaria = valorDiaria;
		this.valorLocacao = valorLocacao;
		
	}
	public LocacaoItemDto(LocacaoItem entidade) {
		
		this.id = entidade.getId();
		this.dataPrevisaoEntrega = entidade.getDataPrevisaoEntrega();
		this.dataEntrega = entidade.getDataEntrega();
		this.diarias =  entidade.getDiarias();
		this.valorDiaria = entidade.getValorDiaria();
		this.valorLocacao = entidade.getValorLocacao();
		
		
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataPrevisaoEntrega() {
		return dataPrevisaoEntrega;
	}

	public void setDataPrevisaoEntrega(Date dataPrevisaoEntrega) {
		this.dataPrevisaoEntrega = dataPrevisaoEntrega;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Long getDiarias() {
		return diarias;
	}

	public void setDiarias(Long diarias) {
		this.diarias = diarias;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(Double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}
	
	
	
	
	
}
