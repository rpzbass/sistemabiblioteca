package mjv.devschool.sistemalivaria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_locacao")
public class Locacao implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	private Date dataAgendamento;
	private Date dataRetirada;
	private Date finalizacao;
	private Double valorTotal;
	
	private LocacaoStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cadastro_id",referencedColumnName = "id")
	Cadastro cadastro = new Cadastro();
	
	
	
	
	/*@JoinTable(name = "tb_locacao_locacaoItem",
	joinColumns = @JoinColumn(name = "locacao_id" ),
	inverseJoinColumns = @JoinColumn(name = "locacaoItem_id"))*/
	
	/*@ManyToMany
	@JoinTable(name = "tb_locacao_locacaoItems",
		joinColumns = @JoinColumn(name = "locacao_id"), 
		inverseJoinColumns = @JoinColumn(name = "locacaoItems_id"))
	//@JoinColumn(name = "locacaoitem_id", referencedColumnName="id")
	*/
	@OneToMany
	@JoinColumn(name = "id")
	List<LocacaoItem> locacaoItem = new ArrayList<>();
 	
	


	public Locacao() {
		
	}
	
	
	public Locacao(Long id, Date dataAgendamento, Date dataRetirada, Date finalizacao, Double valorTotal , LocacaoStatus status ) {
	
		this.id = id;
		this.dataAgendamento = dataAgendamento;
		this.dataRetirada = dataRetirada;
		this.finalizacao = finalizacao;
		this.valorTotal = valorTotal;
		this.status = status;
	}
	
	public Locacao(Date dataAgendamento,LocacaoStatus status, Double valorTotal) {
		
		this.dataAgendamento = dataAgendamento;
		this.status = status;
		this.valorTotal = valorTotal;
		
		
	}
	
	
	public LocacaoStatus getStatus() {
		return status;
	}

	public void setStatus(LocacaoStatus status) {
		this.status = status;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public List<LocacaoItem> getLocacaoItem() {
		return locacaoItem;
	}

	public void setLocacaoItem(List<LocacaoItem> locacaoItem) {
		this.locacaoItem = locacaoItem;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataAgendamento() {
		
		return new Date();
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
		this.valorTotal = 0.0;
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	

	
}
