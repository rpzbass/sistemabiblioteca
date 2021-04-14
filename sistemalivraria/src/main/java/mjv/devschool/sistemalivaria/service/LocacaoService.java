package mjv.devschool.sistemalivaria.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mjv.devschool.sistemalivaria.dto.LocacaoDto;
import mjv.devschool.sistemalivaria.dto.LocacaoItemDto;
import mjv.devschool.sistemalivaria.model.Cadastro;
import mjv.devschool.sistemalivaria.model.Livro;
import mjv.devschool.sistemalivaria.model.Locacao;
import mjv.devschool.sistemalivaria.model.LocacaoItem;
import mjv.devschool.sistemalivaria.model.LocacaoStatus;
import mjv.devschool.sistemalivaria.repositorie.CadastroRepository;
import mjv.devschool.sistemalivaria.repositorie.LivroRespository;
import mjv.devschool.sistemalivaria.repositorie.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired // notação para injecao de classe que facilita a modularização e acoplamento no
				// codigo
	CadastroRepository cadRepository;

	@Autowired
	LivroRespository livroRepository;

	@Autowired
	LocacaoRepository locRepository;

	@Transactional
	public LocacaoDto gerarLocacao(LocacaoDto locDto) {

		Cadastro cad = cadRepository.getOne(locDto.getCadastroDto().getId());
		Locacao locacao = new Locacao(new Date(), LocacaoStatus.RESERVADO, 0.0);

		locacao.setCadastro(cad);

		for (LocacaoItemDto linha : locDto.getLocacaoitemsdto()) {

			Livro livro = livroRepository.getOne(linha.getLivroDto().getId());
			LocacaoItem item = new LocacaoItem();

			item.setLivro(livro);
			item.setDataPrevisaoEntrega(linha.getDataPrevisaoEntrega());
			locacao.setDataRetirada(locDto.getDataRetirada());
			item.setValorDiaria(livro.getValorDiaria());
			item.setDiarias(calcDiarias(locDto.getDataRetirada(),item.getDataPrevisaoEntrega()));
			item.setValorLocacao(item.getDiarias() * item.getValorDiaria());
			locacao.setValorTotal(item.getValorLocacao());
			locacao.getLocacaoItem().add(item);
			livro.incrementarReservado();
			
			
		}

		
		locacao = locRepository.save(locacao);

		return new LocacaoDto(locacao);

	}

	public long calcDiarias(Date dataRetirada, Date dataPrevisaoEntrega) {

		long diff =  dataPrevisaoEntrega.getTime() - dataRetirada.getTime();

		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}
	
	

}
