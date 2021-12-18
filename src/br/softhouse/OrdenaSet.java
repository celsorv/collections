package br.softhouse;

import br.softhouse.model.Serie;

import java.util.*;

public class OrdenaSet {

    public static void test() {

        // formato de inicialização de chave dupla: considerado um anti-padrão
        Set<Serie> minhasSeries = new HashSet<>() {
            {
                add(new Serie("got","fantasia", 60));
                add(new Serie("dark","drama", 60));
                add(new Serie("that '70s show","comédia", 25));
            }
        };

        System.out.println("\n---\tOrdem Aleatória\t---");
        minhasSeries.forEach(System.out::println);

        Set<Serie> minhasSeriesLinkedHashSet = new LinkedHashSet<>() {
            {
                add(new Serie("got","fantasia", 60));
                add(new Serie("dark","drama", 60));
                add(new Serie("that '70s show","comédia", 25));
            }
        };
        System.out.println("\n---\tOrdem de Inserção\t---");
        minhasSeriesLinkedHashSet.forEach(System.out::println);

        System.out.println("\n---\tOrdem Natural (TempoEpisodio)\t---");
        Set<Serie> minhasSeriesTreeSet = new TreeSet<>(minhasSeries);
        minhasSeriesTreeSet.forEach(System.out::println);

        System.out.println("\n---\tOrdem Nome/Gênero/TempoEpisodio\t---");
        Set<Serie> minhasSeriesTreeSet2 = new TreeSet<>(
                Comparator.comparing(Serie::getNome)
                        .thenComparing(Serie::getGenero)
                        .thenComparing(Serie::getTempoEpisodio)
        );
        minhasSeriesTreeSet2.addAll(minhasSeries);
        minhasSeriesTreeSet2.forEach(System.out::println);

    }


}
