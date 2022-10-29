import java.util.HashMap;
import java.util.Scanner;

public class FrequencyVocabulary {

    public static void init(){
        System.out.println("Введите текст: ");

        Scanner scanner = new Scanner(System.in);
        String string = removePunctuations(scanner.nextLine());
        String[] words = string.split("\\s+");
        HashMap<String, Integer> wordToCount = new HashMap<>();

        for (String word : words)
        {
            if (!wordToCount.containsKey(word))
            {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        System.out.println("\nЧастотный словарь\n");
        for (String word : wordToCount.keySet())
            System.out.println(word + " " + wordToCount.get(word));
    }

    public static String removePunctuations(String source) {
        return source.replaceAll("\\p{Punct}", "");
    }

}
