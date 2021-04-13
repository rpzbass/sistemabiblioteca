package mjv.devschool.sistemalivaria.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mjv.devschool.sistemalivaria.model.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao,Long> {

	
}
