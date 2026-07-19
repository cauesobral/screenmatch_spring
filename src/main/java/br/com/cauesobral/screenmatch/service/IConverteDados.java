package br.com.cauesobral.screenmatch.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
    //Recebe uma string json, depois tenta converter esse json na classe
    //indicada, esse <T> t é a sintaxe Genericos, representa tipo genérico, significa que o tipo
    //da classe será definida quando a classe for utilizada
}
