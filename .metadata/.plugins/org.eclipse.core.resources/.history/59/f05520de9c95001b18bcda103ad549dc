package mjv.devschool.sistemalivaria.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mjv.devschool.sistemalivaria.model.Locacao;
import mjv.devschool.sistemalivaria.model.LocacaoStatus;

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
	private LocacaoStatus status;
	
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
	
	public LocacaoDto(Long id,Date dataAgendamento,Date dataRetirada, Date finalizacao,Double valorTotal,LocacaoStatus status) {
		
		this.id = id;
		this.dataAgendamento = dataAgendamento;
		this.dataRetirada = dataRetirada;
		this.finalizacao = finalizacao;
		this.valorTotal = valorTotal;
		this.status = status;
	}
	
	public LocacaoDto(Locacao entidade) {
		
		this.id = entidade.getId();
		this.dataAgendamento = entidade.getDataAgendamento();
		this.dataRetirada = entidade.getDataRetirada();
		this.finalizacao = entidade.getFinalizacao();
		this.valorTotal = entidade.getValorTotal();
		this.status = entidade.getStatus();
		this.getCadastroDto().setId(entidade.getCadastro().getId());
		this.getCadastroDto().setLogin(entidade.getCadastro().getLogin());
		this.getCadastroDto().getEnderecoDto().setBairro(entidade.getCadastro().getEndereco().getBairro());
		
	}

	public LocacaoDto(Date dataAgendamento,LocacaoStatus status, Double valorTotal) {
		
		this.dataAgendamento = dataAgendamento;
		this.status = status;
		this.valorTotal = valorTotal;
		
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
