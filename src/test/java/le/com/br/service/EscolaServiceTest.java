package le.com.br.service;

import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import le.com.br.dto.AlunoDto;

public class EscolaServiceTest {
	
	@Mock
	private GerarMatriculaService matriculaService;
	
	@Mock
	private GerarStatusService statusService;

	@InjectMocks
	private EscolaService escolaService;
	
	private String retorno;
	
	private String status;
	
	@Before
	public void inicializar() {
		MockitoAnnotations.initMocks(this);		
		this.escolaService = new EscolaService(matriculaService, statusService);
	}

	@Test
	public void deveriaGerarNumeroDeMatricula() {
		
 		AlunoDto aluno = new AlunoDto();
		retorno = "20";
		
		status = "suspenso";
		
		Mockito.when(this.matriculaService.gerarMatricula(anyString())).thenReturn(retorno);
		Mockito.when(this.statusService.gerarStatus()).thenReturn(status);
		aluno = this.escolaService.realizarMatricula();
		
		Assert.assertEquals("20", aluno.getMatricula() );
		
		
	}

}
