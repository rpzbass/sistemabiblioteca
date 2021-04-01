package mjv.devschool.sistemalivaria.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_livro")
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
	private String isbn;
	private Double valorDiaria;
	private Integer exemplares;
	private Integer reservados;
	
	
	public Livro() {
		
		
	}
	
	public Livro(Long id, String isbn, Double valorDiaria, Integer exemplares, Integer reservados) {
		
		this.id = id;
		this.isbn = isbn;
		this.valorDiaria = valorDiaria;
		this.exemplares = exemplares;
		this.reservados = reservados;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
	
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Integer getExemplares() {
		return exemplares;
	}

	public void setExemplares(Integer exemplares) {
		this.exemplares = exemplares;
	}

	public Integer getReservados() {
		return reservados;
	}

	public void setReservados(Integer reservados) {
		this.reservados = reservados;
	}
	
	
	
	
	


}
