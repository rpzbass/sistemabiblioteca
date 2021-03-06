package mjv.devschool.sistemalivaria.service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import mjv.devschool.sistemalivaria.service.exceptions.EntityNotFoundExceptio;

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

		try {

			Cadastro cad = cadRepository.getOne(locDto.getCadastroDto().getId());
			Locacao locacao = new Locacao(new Date(), LocacaoStatus.RESERVADO, 0.0);
			locacao.setCadastro(cad);

			for (LocacaoItemDto linha : locDto.getLocacaoitemsdto()) {

				Livro livro = buscarLivroDisponivel(linha.getLivroDto().getId());
				try {
					if (!livro.getId().equals(null)) {

						LocacaoItem item = new LocacaoItem();
						item.setLivro(livro);
						item.setDataPrevisaoEntrega(linha.getDataPrevisaoEntrega());
						locacao.setDataRetirada(locDto.getDataRetirada());
						item.setValorDiaria(livro.getValorDiaria());
						item.setDiarias(calcDiarias(locDto.getDataRetirada(), item.getDataPrevisaoEntrega()));
						item.setValorLocacao(item.getDiarias() * item.getValorDiaria());
						locacao.setValorTotal(calcValorTotal(item.getValorLocacao()));
						locacao.getLocacaoItem().add(item);
						livro.incrementarReservado();
						locacao.setStatus(devolverLivro(locDto.getFinalizacao()));
						locacao.setFinalizacao(locDto.getFinalizacao());
					}
				} catch (NullPointerException e) {
					throw new EntityNotFoundExceptio("Exemplares esgotados");
				}
			}

			locacao = locRepository.save(locacao);

			return new LocacaoDto(locacao);

		} catch (EntityNotFoundException e) {

			throw new EntityNotFoundExceptio("Entidade não encontrada");

		} catch (DataIntegrityViolationException e) {

			throw new EntityNotFoundExceptio("Cadastro não encontrado");

		}

	}

	protected Livro buscarLivroDisponivel(Long id) {

		Livro livro = livroRepository.getOne(id);

		return (!livro.getExemplares().equals(0)) ? livro : null;

	}

	protected long calcDiarias(Date dataRetirada, Date dataPrevisaoEntrega) {

		long diff = dataPrevisaoEntrega.getTime() - dataRetirada.getTime();

		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	protected Double calcValorTotal(Double valorTotal) {

		return valorTotal += valorTotal;
	}

	protected LocacaoStatus devolverLivro(Date data) {

		return (!data.equals(null)) ? LocacaoStatus.DISPONIVEL : LocacaoStatus.RESERVADO;

	}

}
