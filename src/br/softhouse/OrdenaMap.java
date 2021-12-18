package br.softhouse;

import br.softhouse.model.Livro;

import java.util.*;

public class OrdenaMap {

    public static void test() {

        // formato de inicialização de chave dupla: considerado um anti-padrão
        Map<String, Livro> meusLivros = new HashMap<>() {
            {
                put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
                put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
                put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
            }
        };

        System.out.println("\n---\tOrdem Aleatória\t---");
        meusLivros.forEach((k, v) -> System.out.println(k + ": " + v.getNome() + " (" + v.getPaginas() + " págs)"));

        System.out.println("\n---\tOrdem de Inserção\t---");
        Map<String, Livro> meusLivrosLinkedHashMap = new LinkedHashMap<>() {
            {
                put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
                put("Duhigg, Charles", new Livro("O Poder do Hábito", 408));
                put("Harari, Yuval Noah", new Livro("21 Lições Para o Século 21", 432));
            }
        };
        meusLivrosLinkedHashMap.forEach((k, v) -> System.out.println(k + ": " + v.getNome() + " (" + v.getPaginas() + " págs)"));

        System.out.println("\n---\tOrdem alfabética de autores\t---");
        Map<String, Livro> meusLivrosTreeMap = new TreeMap<>(meusLivros);
        meusLivrosTreeMap.forEach((k, v) -> System.out.println(k + ": " + v.getNome() + " (" + v.getPaginas() + " págs)"));


        System.out.println("\n---\tOrdem alfabética de nomes dos livros\t---");

        /*
        Map<String, Livro> livrosPorNome = meusLivros.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Livro::getNome)))
                .collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new)
                );
        livrosPorNome.forEach((k, v) -> System.out.println(k + ": " + v.getNome() + " (" + v.getPaginas() + " págs)"));
*/

        Set<Map.Entry<String, Livro>> livrosPorNome = new TreeSet<>(
                Map.Entry.comparingByValue(Comparator.comparing(Livro::getNome, String.CASE_INSENSITIVE_ORDER))
        );
        livrosPorNome.addAll(meusLivros.entrySet());
        livrosPorNome.forEach((e) -> System.out.println(
                e.getKey() + ": " + e.getValue().getNome() + " (" + e.getValue().getPaginas() + " págs)"
        ));

    }

}

