package mjv.devschool.sistemalivaria.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mjv.devschool.sistemalivaria.model.Livro;

@Repository
public interface LivroRespository extends JpaRepository<Livro,Long> {

	
	
	
}
