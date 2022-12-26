

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static Scanner sc = new Scanner(System.in);
    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
            "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
            "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
            "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
            "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon",
            "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal",
            "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
            "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
            "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
            "|   |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "    |\n" +
            "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            "+---+\n" +
                    "|   |\n" +
                    "O   |\n" +
                    "|   |\n" +
                    "    |\n" +
                    "    |\n" +
                    "=========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" + 
                    "     |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    " =========\n",

            " +---+\n" +
                    " |   |\n" +
                    " O   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    " =========\n"};

    public static void main(String[] args) throws IOException, InterruptedException {
        Random rand = new Random();
        int r = rand.nextInt(words.length);
        String choosen= words[r];
        char[] placeholders = new char[choosen.length()];
        for (int i = 0; i < placeholders.length; i++) {
            placeholders[i] = '_';
        }
        char[] missed = new char[6];
        int misses=0;
        while(misses<6){
            System.out.print(gallows[misses]);
            System.out.print("Word\t");
            printDashes(placeholders);
            System.out.println();
            System.out.print("Missed\t");
            printMissed(missed);
            System.out.println();
            System.out.print("Guesses\t\t");
            char c = sc.next().charAt(0);
            if(compare(choosen,c)){
                updateDashes(c,choosen,placeholders);
            } else {
                missed[misses]=c;
                misses++;
            }
            System.out.print("\033[2J");
            System.out.flush();

            if (Arrays.equals(choosen.toCharArray(),placeholders)){
                System.out.print(gallows[misses]);
                System.out.print("\nWord:   ");
                printDashes(placeholders);
                System.out.println("\nGOOD WORK!");
                break;
            }
        }

        if (misses == 6) {
            System.out.print(gallows[6]);
            System.out.println("\nRIP!");
            System.out.println("\nThe word was: '" + choosen + "'");
        }
        sc.close();

    }

    private static void updateDashes(char c, String choosen, char[] placeholders) {
        for (int i=0;i<choosen.length();i++){
            if (choosen.charAt(i)==c){
                placeholders[i]=c;
            }
        }
    }

    private static boolean compare(String choosen, char c) {

        for (int i = 0; i < choosen.length(); i++) {
            if (choosen.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    private static void printMissed(char[] missed) {
        for(int i =0;i<missed.length;i++){
            System.out.print(" "+missed[i]);
        }
    }

    private static void printDashes(char[] string) {
        for(int i =0;i<string.length;i++){
            System.out.print(" "+string[i]);
        }
    }
}
