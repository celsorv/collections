package br.softhouse;

import java.util.*;

public class PraticaSet {

    public static void test() {

        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        // Não tem como exibir um elemento pela sua posição

        // Não há como incluir um elemento em umna posição específica

        // Não há como substituir o conteúdo de uma posição por outro

        System.out.println("\nA nota 5.0 pertence ao conjunto: " + notas.contains(5d));

        // Exibir a terceira nota adicionada
        // No hashset a ordem de inclusão não é garantida

        System.out.println("\nA menor nota é: " + Collections.min(notas));

        System.out.println("\nA maior nota é: " + Collections.max(notas));

        /*
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("\nA soma das notas é: " + soma);
        */

        Double soma = notas.stream().reduce(0d, Double::sum);
        System.out.println("\nSoma das notas: " + soma);

        System.out.println("\nMédia das notas: " + soma / notas.size());
        System.out.println("\nRemover a nota 10:");

        System.out.println("\nRemover a nota 0:");
        notas.remove(0d);
        System.out.println(notas);

        // Não tem como remover o elemento passando sua posição

        System.out.println("\nRemover as notas menores que 7:");

        /*
        final Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        */

        notas.removeIf(elemento -> elemento < 7);
        System.out.println("  -->> " + notas);

        System.out.println("Exibir as notas na ordem em que foram inseridas:");

        // Hashset não garante a ordem de inserção, LinkedHashSet sim
        Set<Double> notasLinkedHashSet = new LinkedHashSet<>() {{
            add(7d);
            add(8.5);
            add(9.3);
            add(5d);
            add(7d); // duplicidade não é inserida
            add(0d);
            add(3.6);
        }};
        System.out.println(notasLinkedHashSet);

        System.out.println("Exibir as notas na ordem crescente");
        // TreeSet armazena o conjunto de forma ordenada
        Set<Double> notasTreeSet = new TreeSet<>(notasLinkedHashSet);
        System.out.println(notasTreeSet);

        System.out.println("\nApagar todo o conjunto:");
        notas.clear();
        System.out.println(notas);


        System.out.println("\nConfira se o conjunto está vazio: " + notas.isEmpty());

        System.out.println("\nConfira se notasLinkedHashSet está vazio: " + notasLinkedHashSet.isEmpty());

    }

}
