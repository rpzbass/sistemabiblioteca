package mjv.devschool.sistemalivaria.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import mjv.devschool.sistemalivaria.dto.CadastroDto;
import mjv.devschool.sistemalivaria.model.Cadastro;
import mjv.devschool.sistemalivaria.model.Endereco;
import mjv.devschool.sistemalivaria.repositorie.CadastroRepository;
import mjv.devschool.sistemalivaria.service.exceptions.AccessComunicationError;
import mjv.devschool.sistemalivaria.service.exceptions.DatabaseException;

@Service
public class CadastroService {

	@Autowired
	private CadastroRepository cadRepository;

	// @Autowired
	// private ViaCEPClient viaCepClient;

	public List<CadastroDto> findAll() {

		List<Cadastro> list = cadRepository.findAll();
		return list.stream().map(x -> new CadastroDto(x)).collect(Collectors.toList());

	}

	@Transactional
	public CadastroDto insert(CadastroDto dto) {
		try {
			Cadastro entidade = new Cadastro();
			cpDtoParaEntidade(dto, entidade);
			entidade = cadRepository.save(entidade);
			return new CadastroDto(entidade);
		} catch (DataIntegrityViolationException e) {
		
			throw new DatabaseException("CPF OU EMAIL OU LOGIN JÁ CADASTRADO");
		
		} catch (EntityNotFoundException e) {

			throw new EntityNotFoundException("Cadastro não encontrado");
		}

	}

	private void cpDtoParaEntidade(CadastroDto dto, Cadastro entidade) {

		entidade.setNome(dto.getNome());
		entidade.setTelefone(dto.getTelefone());
		entidade.setEmail(dto.getEmail());
		entidade.setCpf(dto.getCpf());
		entidade.setLogin(dto.getLogin());
		entidade.setSenha(dto.getSenha());
		try {
		RestTemplate template = new RestTemplate();
		entidade.setEndereco(template.getForObject("https://viacep.com.br/ws/{cep}/json", Endereco.class,
				dto.getEnderecoDto().getCep()));
		}catch(ResourceAccessException e) {
			
			throw new AccessComunicationError("Erro de comunicacao ao buscar endereço via cep");
		
		}
		
		
	}

}
