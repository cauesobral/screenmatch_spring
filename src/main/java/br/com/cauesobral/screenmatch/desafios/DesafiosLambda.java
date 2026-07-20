package br.com.cauesobral.screenmatch.desafios;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

//Ex 1 & 7
@FunctionalInterface
interface Operacao {
    int operacao (int a, int b);
}

//Ex 2
@FunctionalInterface
interface Inteiro {
    //O tipo do metodo precisa ser o retorno do lambda
    boolean numero (int numero);
}

//Ex 3
@FunctionalInterface
interface TransformadorTexto {
    String transformar (String texto);
}
//Ex 4
@FunctionalInterface
interface Palindromo {
    boolean verificar (String s);
}

//Ex 5 & 6
@FunctionalInterface
interface OperacaoLista {
    List<Integer> executar (List<Integer> numeros);
}
//O 6 saiu de primeira heinn (também a sintaxe é bem parecida com o 5)

public class DesafiosLambda {
    public static void main(String[] args) {
        Operacao resultadoMultiplicacao = (a, b) -> a * b;
        System.out.println(resultadoMultiplicacao.operacao(5,2));

        Inteiro ehPrimo = (numero) -> {
            if (numero <= 1) return false;
            if (numero == 2) return false;
            if (numero % 2 == 0) return false;

            for (int i = 3; i * i <= numero; i += 2) {
                if (numero % i == 0) return false;
            }
            return true;
        };
        System.out.println(ehPrimo.numero(3));
        System.out.println(ehPrimo.numero(9));
        TransformadorTexto textoAumentado = texto -> texto.toUpperCase();
        System.out.println(textoAumentado.transformar("caue"));

        Palindromo verificacao = s -> s.equals(new StringBuilder(s).reverse().toString());
        System.out.println(verificacao.verificar("arara"));
        System.out.println(verificacao.verificar("atoleiro"));

//        Replace all é uma função que altera a lista e retorna void, então o tipo do metodo da interface
//        precisa ser void necessariamente

        OperacaoLista triplicacao = numeros -> {
            numeros.replaceAll(n -> n * 3);
            return numeros;
        };
        System.out.println(triplicacao.executar(new ArrayList<>(List.of(1,2,3,4))));

        OperacaoLista sortear = numeros -> {
            sort(numeros);
            return numeros;
        };
        System.out.println(sortear.executar(new ArrayList<>(List.of(4,1,7,3,8,4,6,2))));

        Operacao divisao = (a,b) -> {
            if (b == 0) {
                throw new ArithmeticException ("O divisor não pode ser zero.");
            }
            return a / b;
        };
        System.out.println("Resultado: "+ divisao.operacao(10,2));
        System.out.println("Resultado: "+ divisao.operacao(10,0));
    }
}
