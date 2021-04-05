package mjv.devschool.sistemalivaria.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mjv.devschool.sistemalivaria.dto.LocacaoDto;
import mjv.devschool.sistemalivaria.model.Cadastro;
import mjv.devschool.sistemalivaria.model.Locacao;
import mjv.devschool.sistemalivaria.model.LocacaoStatus;
import mjv.devschool.sistemalivaria.repositorie.CadastroRepository;
import mjv.devschool.sistemalivaria.repositorie.LocacaoRepository;

@Service
public class LocacaoService  {

	@Autowired   //notação para injecao de classe que facilita a modularização e acoplamento no codigo
	CadastroRepository cadRepository;
	
	@Autowired
	LocacaoRepository locRepository;
	
	@Transactional
	public LocacaoDto  gerarLocacao(LocacaoDto locDto) {
	
		Locacao locacao = new Locacao(new Date(),LocacaoStatus.RESERVADO,0.0);
		
		Cadastro cad = cadRepository.getOne(locDto.getCadastroDto().getId());
		
		locacao.setCadastro(cad);
		
		locacao = locRepository.save(locacao);
			
		return new LocacaoDto(locacao);
		
	}
	
	
}
