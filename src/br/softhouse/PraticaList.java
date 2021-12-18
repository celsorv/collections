package br.softhouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PraticaList {

    public static void test() {

        List<Double> notas = new ArrayList<>();
        notas.add(10d);
        notas.add(5d);
        notas.add(6d);
        notas.add(4d);
        notas.add(7d);

        List<Double> notasLinkedList = new LinkedList<>(notas);

        System.out.println("\nPosição da nota 5: " + notas.indexOf(5d));  // 1

        System.out.println("\nIncluir nota 8 na posição 2:");
        notas.add(2, 8d);
        System.out.println(notas);  // [10.0, 5.0, 8.0, 6.0, 4.0, 7.0]

        System.out.println("\nSubstituir a nota 5 por 6.5:");
        notas.set(1, 6.5d);
        System.out.println(notas);  // [10.0, 6.5, 8.0, 6.0, 4.0, 7.0]

        System.out.println("\n2a. nota adicionada: " + notas.get(1)); // 6.5

        System.out.println("\nMenor nota: " + Collections.min(notas));    // 4.0

        System.out.println("\nMaior nota: " + Collections.max(notas));    // 10.0

/*
        final Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
*/
        Double soma = notas.stream().reduce(0d, Double::sum);
        System.out.println("\nSoma das notas: " + soma);  // 41.5

        System.out.println("\nMédia das notas: " + soma / notas.size());  // 6.91666...

        System.out.println("\nRemover a nota 10:");
        notas.remove(10d);
        System.out.println(notas);  // [6.5, 8.0, 6.0, 4.0, 7.0]

        System.out.println("\nRemover a nota na posição 0:");
        notas.remove(0);
        System.out.println(notas);  // [8.0, 6.0, 4.0, 7.0]

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


        System.out.println("\nApagar toda a lista:");
        notas.clear();
        System.out.println(notas);

        System.out.println("\nConfira se a lista está vazia: " + notas.isEmpty());

        System.out.println("\nUsando LinkedList:");
        System.out.println("  --->> " + notasLinkedList);

        System.out.println("\n1a. nota sem remover: " + notasLinkedList.get(0));

        System.out.println("\n1a. nota removendo-a: " + notasLinkedList.remove(0));
        System.out.println("  --->> " + notasLinkedList);

    }

}
