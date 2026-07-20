package br.com.cauesobral.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true) //Ele vai pegar só os dados do DadosSerie
public record DadosSerie(@JsonAlias ("Title") String titulo,
                         @JsonAlias ("totalSeasons") Integer temporadas,
                         @JsonAlias ("imdbRating") String avaliacao) {
    public int totalTemporadas() {
        return temporadas;
    }
    //JsonAlias serve só para leitura de arquivos JSON
    //JsonProperty serve tanto para serialização quando desserialização de arquivos JSON
}
