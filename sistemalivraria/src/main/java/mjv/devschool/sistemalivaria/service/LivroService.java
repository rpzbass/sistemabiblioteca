package mjv.devschool.sistemalivaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mjv.devschool.sistemalivaria.dto.LivroDto;
import mjv.devschool.sistemalivaria.model.Livro;
import mjv.devschool.sistemalivaria.repositorie.LivroRespository;

@Service
public class LivroService {

	@Autowired
	private LivroRespository livrorepository;

	
	/*
	public List<CadastroDto> findAll(){
		
		List<Cadastro> list = cadRepository.findAll();
		return list.stream().map(x -> new CadastroDto(x)).collect(Collectors.toList());
		
	}
    */
	@Transactional
	public LivroDto buscarLivroPorId(Long id) {

		Optional<Livro> livro = livrorepository.findById(id);
		Livro entidade = livro.orElseThrow();
		return new LivroDto(entidade);

	}
	
	
	@Transactional
	public LivroDto CadastrarLivro(LivroDto livrodto) {
		
		Livro livro = new Livro();
		cpDtoParaEntidade(livrodto,livro);        		
		livro = livrorepository.save(livro);
		return new LivroDto(livro);
		
	}
	
	
	
	private void cpDtoParaEntidade(LivroDto livrodto, Livro livro ) {
		
		livro.setIsbn(livrodto.getIsbn());
		
		livro.setTitulo(livrodto.getTitulo());
		livro.setExemplares(livrodto.getExemplares());
		livro.setReservados(livrodto.getReservados());
		livro.setValorDiaria(livrodto.getValorDiaria());
		
	
	}
	
	
	
	
	
	
}
