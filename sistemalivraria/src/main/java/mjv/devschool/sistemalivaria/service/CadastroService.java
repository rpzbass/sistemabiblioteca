package mjv.devschool.sistemalivaria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mjv.devschool.sistemalivaria.dto.CadastroDto;
import mjv.devschool.sistemalivaria.dto.EnderecoDto;
import mjv.devschool.sistemalivaria.model.Cadastro;
import mjv.devschool.sistemalivaria.repositorie.CadastroRepository;

@Service
public class CadastroService {

	@Autowired
	private CadastroRepository cadRepository;

	
	
	public List<CadastroDto> findAll(){
		
		List<Cadastro> list = cadRepository.findAll();
		return list.stream().map(x -> new CadastroDto(x)).collect(Collectors.toList());
		
	}

	@Transactional
	public CadastroDto insert(CadastroDto dto) {
		
		Cadastro entidade = new Cadastro();
		cpDtoParaEntidade(dto,entidade);        		
		entidade = cadRepository.save(entidade);
		return new CadastroDto(entidade);
		
	}
	
	
	
	private void cpDtoParaEntidade(CadastroDto dto, Cadastro entidade ) {
		
		entidade.setNome(dto.getNome());
		entidade.setTelefone(dto.getTelefone());
		entidade.setEmail(dto.getEmail());
		entidade.setCpf(dto.getCpf());
		entidade.setLogin(dto.getLogin());
		entidade.setSenha(dto.getSenha());
		
		entidade.getEndereco().setCep(dto.getEnderecoDto().getCep());
		entidade.getEndereco().setLogradouro(dto.getEnderecoDto().getLogradouro());
		entidade.getEndereco().setBairro(dto.getEnderecoDto().getBairro());
		entidade.getEndereco().setLocalidade(dto.getEnderecoDto().getLocalidade());
		entidade.getEndereco().setUf(dto.getEnderecoDto().getUf());
		entidade.getEndereco().setIbge(dto.getEnderecoDto().getIbge());
	}
	
	
	
	
	
	
}
