package br.com.cauesobral.screenmatch.desafios;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DesafiosStreams {
    public static void main(String[] args) {
        //Ex 1 - filtrar apenas pares
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
        //Ex 2 - deixar todas as palavras em maiúsculas
        List<String> palavras = Arrays.asList("Caue", "Joao", "Adriano", "Caue", "Bruno", "Eder", "Gabriel");
        palavras.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println); //a abreviacao soutc sempre vai imprimri esse sout com :: do forEach
        //Ex 3 - Pegar as impares, multiplicar tds por 2 e dps imprimir
        numeros.stream()
                .filter(n -> n % 2 != 0)
                //lembrar q map é pra alterar os valores do array individualente
                .map(n -> n * 2)
                .forEach(System.out::println);

        //Ex 4 - remover elementos repetidos
        List<String> unicas = palavras.stream()
                .distinct() //remove elementos duplicados da stream
                .collect(Collectors.toList()); //metodo collect serve para transformar os dados do fluxo da
        //stream em algo, nesse caso, toList() porque quero que vire uma lista
        System.out.println(unicas);

        //Ex 5 - filtrando e ordenando primos
        List<List<Integer>> listaDeNumeros = Arrays.asList(
                Arrays.asList(1, 2, 3, 4),
                Arrays.asList(5, 6, 7, 8),
                Arrays.asList(9, 10, 11, 12)
        );
        List<Integer> primosOrdenados = listaDeNumeros.stream()
                .flatMap(List::stream) //transforma sublistas em uma única stream
                .filter(DesafiosLambda::ehPrimo) //só repeti a funcao do DesafiosLambda.java
                .sorted() //coloca o fluxo de dados em ordem
                //.forEach(System.out::println); Poderia usar isso para imprimir todos os elementos
                .collect(Collectors.toList());
        System.out.println(primosOrdenados);

        //Ex 6 - Filtrar adultos e ordenar alfabéticamente
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Alice", 22),
                new Pessoa("Bob", 17),
                new Pessoa("Charlie", 19)
        );
        pessoas.stream()
                .filter(n -> n.getIdade() >= 18)
                .map(Pessoa::getNome)
                .sorted()
                .forEach(System.out::println);
        //Ex 7 - Ordenar por preço e somente eletrônicos
        List<Produto> produtos = Arrays.asList(
                new Produto("Smartphone", 800.0, "Eletrônicos"),
                new Produto("Notebook", 1500.0, "Eletrônicos"),
                new Produto("Teclado", 200.0, "Eletrônicos"),
                new Produto("Cadeira", 300.0, "Móveis"),
                new Produto("Monitor", 900.0, "Eletrônicos"),
                new Produto("Mesa", 700.0, "Móveis")
        );
        List<Produto> eletronicos = produtos.stream()
                .filter(n -> n.getPreco() < 1000) //filter sempre vai comparar como um boleano, entao n dá
                // pra usar filter pra pegar os n da categoria eletrônicos
                .filter(n -> n.getCategoria().equals("Eletrônicos"))
                .sorted((p1,p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                //Tenho que gravar essa sintaxe do sorted
                .collect(Collectors.toList());
        System.out.println(eletronicos);

        //Ex 8 - 3 mais baratos do exercício enterior
        List<Produto> eletronicosBaratos = produtos.stream()
                .filter(n -> n.getPreco() < 1000) //filter sempre vai comparar como um boleano, entao n dá
                // pra usar filter pra pegar os n da categoria eletrônicos
                .filter(n -> n.getCategoria().equals("Eletrônicos"))
                .sorted((p1,p2) -> Double.compare(p1.getPreco(), p2.getPreco()))
                //Tenho que gravar essa sintaxe do sorted
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(eletronicosBaratos);

    }
}
