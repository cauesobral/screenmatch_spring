package br.com.cauesobral.screenmatch.desafios;

import java.util.*;
import java.util.stream.Collectors;

//A parte mais difícil de aprender stream é decorar todos os métodos dessa biblioteca,
//mas acredito que com o uso frequente dos métodos acabo aprendendo por osmose as mais relevantes

public class DesafiosStreamParteDois {
    public static void main(String[] args) {

        //Ex 1 - só retornar o maior
        List<Integer> numeros = Arrays.asList(10, 20, 30, 40, 50);
        Integer maior = numeros.stream()
                .max(Comparator.naturalOrder()) //.max(Comparator.naturalOrder() pega o maior
                .orElse(0); //Se não encontrar o maior é zero
        System.out.println(maior);

        //Ex 2 - agrupar pelo numero de letras de cada palavra
        List<String> palavras = Arrays.asList("java", "stream", "lambda", "code");
        Map<Integer, List<String>> agrupadas = palavras.stream() //Declaração de um map com Integer de chave e
                // List<String> de valor
                .collect(Collectors.groupingBy(String::length));
        System.out.println(agrupadas);

        //Ex 3 - concatenar separado por virgulas
        List<String> nomes = Arrays.asList("Alice", "Bob", "Charlie");
        String listaConcatenada = nomes.stream()
                .collect(Collectors.joining(","));
        System.out.println(listaConcatenada);

        //Ex 4 - Dada a lista de números inteiros abaixo, calcule a soma dos quadrados
        // dos números pares.
        List<Integer> numeros2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer resultado = numeros2.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(resultado);

        //Ex 5
        List<Integer> pares = numeros2.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        List<Integer> impares = numeros2.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        System.out.println(pares);
        System.out.println(impares);

        //Ex 6 - Literalmente o mesmo exercício de parte 1, acho que repetiram pra usar de base pro exercício
        // sete
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

        //Ex 7 - Dada a lista de produtos acima, conte quantos produtos há em cada
        // categoria e armazene em um Map<String, Long>.
        Map<String, Long> mapProdutos = produtos.stream()
                .collect(Collectors.groupingBy
                        (Produto::getCategoria, Collectors.counting()));
        System.out.println(mapProdutos);

        //Ex 8 - pegar o mais caro de cada categoria
        Map<String, Optional<Produto>> maisCaroPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.maxBy(Comparator.comparingDouble(Produto::getPreco))));
        System.out.println(maisCaroPorCategoria);

        //Ex 9 - soma dos valores de cada categoria
        Map<String, Double> somaPrecoPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria,
                        Collectors.summingDouble(Produto::getPreco)));

        System.out.println(somaPrecoPorCategoria);
    }
}
