package br.com.cauesobral.screenmatch;

import br.com.cauesobral.screenmatch.model.DadosEpisodio;
import br.com.cauesobral.screenmatch.model.DadosSerie;
import br.com.cauesobral.screenmatch.service.ConsumoApi;
import br.com.cauesobral.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var apikey = "ee6c8d00";
		var scanner = new Scanner(System.in);
		System.out.println("Digite o titulo que você quer pesquisar: ");
		var titulo = scanner.nextLine();

		var endereco = "http://www.omdbapi.com/?t="+titulo+"&apikey="+apikey+"&";

		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados(endereco);
		System.out.println(json);

		var conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		json = consumoApi.obterDados(endereco);
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);
	}
}
