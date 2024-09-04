package app.servicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculosService;

@SpringBootTest // Contexto do Spring nos testes
public class CalculosServiceTest {

	@Autowired
	private CalculosService calculosService;

	// Testes para a função somar

	@Test
	@DisplayName("Teste unitário - cenário de soma = 10")
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(4);
		lista.add(2);

		int soma = calculosService.somar(lista);

		Assertions.assertEquals(10, soma);
	}

	@Test
	@DisplayName("Teste unitário - cenário de soma com lista vazia = 0")
	void cenario02() {
		List<Integer> lista = new ArrayList<>();

		int soma = calculosService.somar(lista);

		Assertions.assertEquals(0, soma);
	}

	@Test
	@DisplayName("Teste unitário - cenário de erro ao somar lista com valor null")
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(4);
		lista.add(null);  // Adicionando um valor null

		Assertions.assertThrows(NullPointerException.class, () -> {
			calculosService.somar(lista);
		});
	}

	// Testes para a função media

	@Test
	@DisplayName("Teste unitário - cálculo da média = 3.0")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(3);
		lista.add(3);

		double media = calculosService.media(lista);

		Assertions.assertEquals(3.0, media);
	}

	@Test
	@DisplayName("Teste unitário - cálculo da média com lista vazia lança exceção")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();

		Assertions.assertThrows(ArithmeticException.class, () -> {
			calculosService.media(lista);
		});
	}

	@Test
	@DisplayName("Teste unitário - cálculo da média com lista contendo null")
	void cenario06() {
		List<Integer> lista = new ArrayList<>();
		lista.add(4);
		lista.add(null);
		lista.add(6);

		Assertions.assertThrows(NullPointerException.class, () -> {
			calculosService.media(lista);
		});
	}
}
