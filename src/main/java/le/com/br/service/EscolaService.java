package le.com.br.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import le.com.br.dto.AlunoDto;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EscolaService {
	
	private GerarMatriculaService matricula;
	
	private GerarStatusService status;
	
	@Autowired
	public EscolaService(GerarMatriculaService gerar, GerarStatusService status) {
		this.matricula = gerar;
		this.status = status;
	}
	
	public AlunoDto realizarMatricula() {
	
		AlunoDto aluno = new AlunoDto();
		aluno.setNome("Bruno");
		aluno.setDocumento("0123");
		
		String resultMatricula = matricula.gerarMatricula(aluno.getNome());
		String resultStatus = status.gerarStatus();
		
		aluno.setMatricula(resultMatricula);
		aluno.setStatus(resultStatus);
		
		log.info("realizada a matricula - aluno: {}, nº: {}, status: {}", aluno.getNome(), aluno.getMatricula(), aluno.getStatus());
		return aluno;
	}
	
	public void atualizarMatricula() {
		
		log.info("atualizada a matricula");
	}
	
}