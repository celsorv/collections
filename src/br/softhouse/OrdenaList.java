package br.softhouse;

import br.softhouse.comparator.ComparatorIdade;
import br.softhouse.model.Gato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaList {

    public static void test() {

        // formato de inicialização de chave dupla: considerado um anti-padrão
        List<Gato> meusGatos = new ArrayList<>() {
            {
                add(new Gato("Jon", 18, "preto"));
                add(new Gato("Simba", 6, "branco"));
                add(new Gato("Jon", 12, "cinza"));
            }
        };

        System.out.println("\n---\tOrdem de Inserção\t---");
        System.out.println(meusGatos);

        System.out.println("\n---\tOrdem Natural (Nome)\t---");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        System.out.println("\n---\tOrdem Idade\t---");
        //Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("\n---\tOrdem Aleatória\t---");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("\n---\tOrdem Cor\t---");
        //meusGatos.sort((g1, g2) -> g1.getCor().compareToIgnoreCase(g2.getCor()));
        meusGatos.sort(Comparator.comparing(Gato::getCor));
        System.out.println(meusGatos);

        System.out.println("\n---\tOrdem Nome/Cor/Idade\t---");
        meusGatos.sort(Comparator.comparing(Gato::getNome)
                .thenComparing(Gato::getCor)
                .thenComparing(Gato::getIdade));
        System.out.println(meusGatos);

        List<String> numeros = List.of("1", "2", "5", "3");

    }

}
