package br.com.cauesobral.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe); //Parece com
        } catch (JsonProcessingException e) {
            //Erro de processamento de JSON
            throw new RuntimeException(e);
        }
        //um fromJSON do Gson
    }
}
