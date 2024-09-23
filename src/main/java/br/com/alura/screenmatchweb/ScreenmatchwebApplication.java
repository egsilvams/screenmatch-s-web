package br.com.alura.screenmatchweb;

import br.com.alura.screenmatchweb.model.DadosSerie;
import br.com.alura.screenmatchweb.service.ConsumoApi;
import br.com.alura.screenmatchweb.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchwebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchwebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();
		String apikey = "580e5d27";
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey="+apikey);
		System.out.println(json);

		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
