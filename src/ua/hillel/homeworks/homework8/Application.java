package ua.hillel.homeworks.homework8;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String[] typesOfChairs = { "chair", "armchair", "rocking chair", "stool", "wheelchair ", "deckchair",
                "bench", "chair", "stool", "sofa", "lounger", "car seat", "bench" };
        List<String> wordsList = Arrays.asList(typesOfChairs);

        countOccurrence(wordsList, "chair");

        int[] numbers = { 1, 2, 3, 4 };
        System.out.println(toList(numbers));

        List<Integer> listNoUnique = List.of(5, 6, 7, 8, 7, 8);
        System.out.println(findUnique(listNoUnique));

        calcOccurrence(wordsList);

        System.out.println(findOccurrence(wordsList).toString().replace("]", "\n]"));
    }

    private static void countOccurrence(List<String> wordsList, String someString) {
        int count = 0;

        for (String word : wordsList) {
            if (word.equals(someString)) {      // а contains то тут со строками не подходит, потому что вместо 2, выведет 6
                count++;
            }
        }
        System.out.println(count);
    }

    private static int countOccurrenceStream(List<String> wordsList, String someString) {
        return (int) wordsList.stream()
                .filter(s -> s.equals(someString))
                .count();
    }

    private static List<Integer> toList(int[] numbers) {
        List<Integer> numbersList = new ArrayList<>();

        for (int i : numbers) {
            numbersList.add(i);
        }
        return numbersList;
    }

    private static List<Integer> toListStream(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .toList();
    }

    private static List<Integer> findUnique(List<Integer> listNoUnique) {
        List<Integer> listUnique = new ArrayList<>();

        for (Integer i : listNoUnique) {
            if (!listUnique.contains(i)) {
                listUnique.add(i);
            }
        }
        return listUnique;
    }

    private static List<Integer> findUniqueStream(List<Integer> listNoUnique) {
        return listNoUnique.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static Set<String> toUniqueListString(List<String> ListNoUnique) {
        return new HashSet<>(ListNoUnique);
    }

    private static void calcOccurrence(List<String> wordsList) {
        Set<String> wordsListUnique = toUniqueListString(wordsList);

        for (String word : wordsListUnique) {
            System.out.println(word + ": " + countOccurrenceStream(wordsList, word));
        }
    }

    private static List<String> findOccurrence(List<String> wordsList) {
        Set<String> wordsListUnique = toUniqueListString(wordsList);
        List<String> wordsListResult = new ArrayList<>();

        for (String word : wordsListUnique) {
            String resultString = String.format("\n{name: \"%s\", occurrence: %d}", word, countOccurrenceStream(wordsList, word));
            wordsListResult.add(resultString);
        }
        return wordsListResult;
    }

    private static List<StructureList> findOccurrenceStructure(List<String> wordsList) {
        Set<String> wordsListUnique = toUniqueListString(wordsList);
        List<StructureList> wordsListResult = new ArrayList<>();

        for (String word : wordsListUnique) {
            wordsListResult.add(new StructureList(word, countOccurrenceStream(wordsList, word)));
        }
        return wordsListResult;
    }

    private record StructureList(String name, int occurrence) {
        @Override
        public String toString() {
            return String.format("\n{name: \"%s\", occurrence: %d}", name, occurrence);
        }
    }
}
