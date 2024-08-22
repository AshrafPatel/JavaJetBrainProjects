package bullscows;
import java.util.*;


class Grade {
    int bulls;
    int cows;

    Grade(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }
}

class Game {
    int turn = 1;
    int range = 0;
    List<Character> secretList = new ArrayList<>(List.of('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u',
            'v',  'w',  'x', 'y', 'z'));
    static Scanner scanner = new Scanner(System.in);
    static String secretCode;

    private static String getSecretLength() {
        System.out.println("Please, enter the secret code's length:");
        String input = scanner.nextLine();
        if (input.matches(".*[a-zA-Z\\W_]+.*")) {
            input = "Error: " + "\"" + input + "\"" + " isn't a valid number.";
        }
        return input;
    }

    private static String getSecretRange() {
        System.out.println("Input the number of possible symbols in the code:");
        String input = scanner.nextLine();
        if (input.matches(".*[a-zA-Z\\W_]+.*")) {
            input = "Error: " + "\"" + input + "\"" + " isn't a valid number.";
        }
        return input;
    }

    private static String getStars() {
        String stars = "";
        for (int i = 0; i < secretCode.length(); i++) {
            stars += "*";
        }
        return stars;
    }

    private String createSecretCode(int length) {
        assert length > 0 && length <= 36;
        String secret = "";

        List<Character> randomList = secretList.subList(0, length);
        Collections.shuffle(randomList);
        for (int i=0; i < length; i++) {
            secret += randomList.get(i);
        }

        secretCode = secret.toString();
        return secret.toString();
    }

    private String getSymbols() {
        String symbolRRange = "";
        if (range == 1) {
            symbolRRange += "(0).";
        } else if (range <= 10) {
            symbolRRange += "(0-" + secretList.get(range-1) + ").";
        } else if (range == 11) {
            symbolRRange += "(0-9, a).";
        } else if (range >= 12 && range <= 36) {
            symbolRRange += "(0-9, a-" + secretList.get(range-1) + ").";
        }
        return symbolRRange;
    }

    private static String getGuess() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private Grade getGrade(String guess) {
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == secretCode.charAt(i)) {
                bulls += 1;
            } else if (secretCode.indexOf(guess.charAt(i)) != -1) {
                cows += 1;
            }
        }

        return new Grade(bulls, cows);
    }

    private void printGrade(Grade grade) {
        String gradeString;

        if (grade.bulls != 0 && grade.cows != 0) {
            gradeString = String.format("%d bull(s) and %d cow(s)", grade.bulls, grade.cows);
        } else if (grade.bulls != 0) {
            gradeString = String.format("%d bull(s)", grade.bulls);
        } else if (grade.cows != 0) {
            gradeString = String.format("%d cow(s)", grade.cows);
        } else {
            gradeString = "None";
        }

        System.out.printf("Grade: %s", gradeString);
        System.out.println();
    }

    void play() {
        String guess;
        String secretLengthStr = getSecretLength();
        if (secretLengthStr.contains("Error")) {
            System.out.println(secretLengthStr);
            return;
        }

        String secretRangeStr = getSecretRange();

        if (secretRangeStr.contains("Error")) {
            System.out.println(secretRangeStr);
            return;
        }

        int length = Integer.parseInt(secretLengthStr);
        range = Integer.parseInt(secretRangeStr);

        if (length > 36) {
            System.out.println("Error: secret length cannot be greater than 36");
            //length = getSecretLength();
            return;
        }

        if (length < 1) {
            System.out.println("Error: secret length cannot be less than 1");
            return;
        }

        if (range > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            //range = getSecretRange();
            return;
        }

        if (length > range) {
            System.out.println("Error: it's not possible to generate a code with a length of " + length + " with " + range + " unique symbols.");
            return;
        }

        secretCode = createSecretCode(length);

        System.out.println("The secret is prepared: " + getStars() + getSymbols());
        System.out.println("Okay, let's start a game!");

        do {
            System.out.printf("Turn %d:\n", turn);
            guess = getGuess();
            Grade grade = getGrade(guess);
            printGrade(grade);
            turn += 1;
        } while (!guess.equals(secretCode));

        System.out.println("Congratulations! You guessed the secret code.");
    }
}

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}