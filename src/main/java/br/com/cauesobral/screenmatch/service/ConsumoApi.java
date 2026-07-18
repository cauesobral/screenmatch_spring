package br.com.cauesobral.screenmatch.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obterDados (String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            //IOException significa não encontrado
            //Interrupted é quando a busca é interrompida
            //Não lembro se o Java 8 tem o multi-catch, mas vou usar aqui por enquanto
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}
