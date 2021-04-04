package mjv.devschool.sistemalivaria.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mjv.devschool.sistemalivaria.model.Locacao;

public class LocacaoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Date dataAgendamento;
	private Date dataRetirada;
	private Date finalizacao;
	private Double valorTotal;
	
	CadastroDto cadastroDto = new CadastroDto();
	
	
	public CadastroDto getCadastroDto() {
		return cadastroDto;
	}

	public void setCadastroDto(CadastroDto cadastroDto) {
		this.cadastroDto = cadastroDto;
	}

	List<LocacaoItemDto> locacaoitemsdto = new ArrayList<LocacaoItemDto>();
	
	
	public List<LocacaoItemDto> getLocacaoitemsdto() {
		return locacaoitemsdto;
	}

	public void setLocacaoitemsdto(List<LocacaoItemDto> locacaoitemsdto) {
		this.locacaoitemsdto = locacaoitemsdto;
	}

	public LocacaoDto() {
		
		
	}
	
	public LocacaoDto(Long id,Date dataAgendamento,Date dataRetirada, Date finalizacao,Double valorTotal) {
		
		this.id = id;
		this.dataAgendamento = dataAgendamento;
		this.dataRetirada = dataRetirada;
		this.finalizacao = finalizacao;
		this.valorTotal = valorTotal;
		
	}
	
	public LocacaoDto(Locacao entidade) {
		
		this.id = entidade.getId();
		this.dataAgendamento = entidade.getDataAgendamento();
		this.dataRetirada = entidade.getDataRetirada();
		this.finalizacao = entidade.getFinalizacao();
		this.valorTotal = entidade.getValorTotal();
		
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Date getFinalizacao() {
		return finalizacao;
	}

	public void setFinalizacao(Date finalizacao) {
		this.finalizacao = finalizacao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
		
		
}
