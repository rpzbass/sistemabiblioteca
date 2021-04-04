package mjv.devschool.sistemalivaria.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import mjv.devschool.sistemalivaria.model.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao,Long> {

	
}
