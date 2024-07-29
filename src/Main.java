import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> listOfIncorrectLetters = new TreeSet<>(); //список неправильных букв
        TreeSet<Character> listOfCorrectLetters = new TreeSet<>(); //список правильных букв
        int count = 0; //счётчик ошибок

        Scanner scanner = new Scanner(System.in);
        getMenu();
        int commandNumber = Integer.parseInt(scanner.next());

        if (commandNumber == 1) {
            RandomWord randomWord = new RandomWord();

            String[] symbols = new String[randomWord.getRandomWord().length()];
            Arrays.fill(symbols, "_");
            System.out.println(Arrays.toString(symbols));

            do {
                System.out.println("Введите букву:");

                //проверка на число
                if (scanner.hasNextInt()){
                    System.out.println("Введено число");
                    scanner.next();
                    continue;
                }
                String letter = scanner.next();

                //проверка на кол-во введённых символов
                if (letter.length() > 1){
                    System.out.println("Введено больше одного символа");
                    continue;
                }

                //проверка на повторно введённую букву
                if ((listOfIncorrectLetters.contains(letter)) || (listOfCorrectLetters.contains(letter.charAt(0)))) {
                    System.out.println("Эту букву уже вводили");
                    continue;
                }

                //проверка на верхний регистр
                if (letter.equals(letter.toUpperCase())){
                    System.out.println("Букву необходимо вводить в нижнем регистре");
                    continue;
                }

                if (randomWord.getRandomWord().contains(letter)){
                    //проверить сколько раз встречается
                    String string = randomWord.getRandomWord();
                    char l = letter.charAt(0);
                    for (int i = 0; i < string.length(); i++) {
                        if (string.charAt(i) == l){
                            symbols[i] = letter;
                        }
                    }
                    listOfCorrectLetters.add(l);
                    System.out.println("Слово: " + Arrays.toString(symbols));
                    System.out.println("Ошибки: " + count + " шт. " + listOfIncorrectLetters);
                    printHangmanStatus(count);
                } else {
                    System.out.println("Такой буквы нет\n");
                    listOfIncorrectLetters.add(letter);
                    count++;
                    System.out.println("Слово: " + Arrays.toString(symbols));
                    System.out.println("Ошибки: " + count + " шт. " + listOfIncorrectLetters);
                    printHangmanStatus(count);
                }
                if (listOfCorrectLetters.equals(randomWord.getListOfCorrectLetters())){
                    System.out.println("\nСлово: " + Arrays.toString(symbols));
                    System.out.println("Вы отгадали слово");
                    break;
                }
            } while (count < 6); //проверяет кол-во ошибок и кол-во отгаданных букв
            if (count == 6){
                System.out.println("Вы проиграли");
            }
        } else if (commandNumber == 2) {
            System.out.println("The End");
            scanner.close();
        } else {
            System.out.println("Неверно введена команда");
            scanner.close();
        }
    }

    public static void getMenu(){
        System.out.println("\n--Menu--");
        System.out.println("1 - Play");
        System.out.println("2 - Exit");
    }

    private static void printHangmanStatus(int count){
        for (String gallowsStatus : HangmanStatus.getHangmanStatus(count)) {
            System.out.println(gallowsStatus);
        }
    }
}