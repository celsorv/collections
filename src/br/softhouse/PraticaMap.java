package br.softhouse;

import java.util.*;

public class PraticaMap {

    public static void test() {

        System.out.println("\nCriar um dicionário contendo os modelos e seus respectivos consumos:");
        Map<String, Double> carrosPopulares = new HashMap<>() {{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.5);
            put("Kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("\nMudar o consumo do Gol para 15,2 Km/l:");
        carrosPopulares.put("Gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("\nTucson está no dicionário: " + carrosPopulares.containsKey("Tucson"));

        System.out.println("\nQual o consumo do Uno: " + carrosPopulares.get("Uno"));

        //Hashset não garante a ordem de inserção dos elementos
        //System.out.println("Exiba o terceiro modelo adicionado");

        System.out.println("\nExiba os modelos:");
        Set<String> modelos = carrosPopulares.keySet();
        System.out.println(modelos);
        //carrosPopulares.keySet().forEach(System.out::println);

        System.out.println("\nExiba o consumo dos carros:");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);
        //carrosPopulares.values().forEach(System.out::println);

        for (int i = 0; i < 2; i++) {

            Double consumo;

            if (i == 0) {
                System.out.println("\nCarro de menor consumo: ");
                consumo = Collections.max(carrosPopulares.values());
            } else {
                System.out.println("\nCarro de maior consumo: ");
                consumo = Collections.min(carrosPopulares.values());
            }

            /*
            Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
            String modelo = "";
            for (Map.Entry<String, Double> entry: entries) {
                if (entry.getValue().equals(consumo))
                    modelo = entry.getKey();
            }
            */

            String modelo = carrosPopulares.entrySet().stream()
                    .filter(e -> e.getValue().equals(consumo))
                    .findFirst()
                    .map(Map.Entry::getKey)
                    .orElse("");

            System.out.println("  --->> " + modelo + ", faz " + consumo + " Km/l");

        }

        System.out.println("\nA soma dos consumos é:");

        /*
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        */

        Double soma = carrosPopulares.values().stream().reduce(0d, Double::sum);
        System.out.println("  --->> " + soma);

        System.out.println("A média de consumo dos carros do dicionário é:");
        System.out.println("  --->> " + (soma / carrosPopulares.size()));

        System.out.println("\nRemover os modelos com consumo igual a 15,6 Km/l");
        System.out.println(carrosPopulares);
        carrosPopulares.values().removeIf(e -> e == 15.6);
        System.out.println(carrosPopulares);

        System.out.println("\nMostrar os carros na ordem em que foram informados:");
        Map<String, Double> carrosPopularesLinkedHashMap = new LinkedHashMap<>() {{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.5);
            put("Kwid", 15.6);
        }};
        System.out.println(carrosPopularesLinkedHashMap);

        System.out.println("\nMostrar os carros ordenado pelo modelo (key order):");
        Map<String, Double> carrosPopularesTreeMap = new TreeMap<>() {{
            put("Gol", 14.4);
            put("Uno", 15.6);
            put("Mobi", 16.1);
            put("Hb20", 14.5);
            put("Kwid", 15.6);
        }};
        System.out.println(carrosPopularesTreeMap);

        System.out.println("\nRemover os carros do dicionário:");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);

        System.out.println("\nO dicionário de carros está vazio: " + carrosPopulares.isEmpty());

    }


}
