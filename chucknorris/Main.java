package chucknorris;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static String getBinary(char c) {
        return String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0');
    }

    public static String getBinariesEncoded(char[] inputArr) {
        String strArrBinaries = "";
        for (int i =0; i < inputArr.length; i++) {
            strArrBinaries += getBinary(inputArr[i]);
        }
        return strArrBinaries;
    }

    public static String makeGroup(char bit, int count) {
        String firstPart = (bit == '1') ? "0" : "00";
        String secondPart = "0".repeat(count);

        return firstPart + " " + secondPart;
    }

    public static String[] getBlocks(String encodedString) {
        String[] blocks = encodedString.split(" ");
        return blocks;
    }

    public static String getBinariesDecoded(String[] blocks) {
        String binary = "";

        if (blocks.length %  2 != 0) {
            return binary;
        }

        for (int i = 0; i < blocks.length; i += 2) {
            String zeroOrOne = blocks[i];
            String bit = (zeroOrOne.equals("0")) ? "1" : "0";
            if (!zeroOrOne.equals("0") && !zeroOrOne.equals(("00"))) {
                return "";
            }

            String howManyBits = blocks[i + 1];
            if (!howManyBits.matches("0+")) {
                return "";
            }

            binary += bit.repeat(howManyBits.length());
        }
        return binary;
    }

    public static String getDecodedString(String binaries) {
        String decodedString = "";

        if (binaries == null || binaries.length() % 7 != 0) {
            return decodedString;
        }


        for (int i = 0; i <= binaries.length() - 7; i+=7) {
            String subString = binaries.substring(i, i+7);
            try {
                int theChar = Integer.parseInt(subString, 2);
                decodedString += (char)theChar;
            } catch(NumberFormatException e) {
                return "";
            }

        }
        return decodedString;
    }

    public static String chuckNorrisEncryption(String binaryArr) {
        String strChuckEncrypt = "";
        char currentBit = binaryArr.charAt(0);
        int count = 1;

        for (int i = 1; i < binaryArr.length(); i++) {
            if (binaryArr.charAt(i) == currentBit) {
                count++;
            } else {
                strChuckEncrypt += makeGroup(currentBit, count) + " ";
                currentBit = binaryArr.charAt(i);
                count = 1;
            }
        }

        strChuckEncrypt += makeGroup(currentBit, count);
        return strChuckEncrypt;
    }

    public static void startEncoder() {
        System.out.println("Input string:");

        String input = scanner.nextLine();

        char[] inputArr = input.toCharArray();
        String arrBinary = getBinariesEncoded(inputArr);

        System.out.println("Encoded string:");
        System.out.println(chuckNorrisEncryption(arrBinary));
    }

    public static void startDecoder() {
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();

        if (!input.matches("^[0 ]+$")) {
            System.out.println("Encoded string is not valid.");
            return;
        }
        String[] blocks = getBlocks(input);

        if (blocks.length % 2 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }

        String binaryStrArr = getBinariesDecoded(blocks);
        String decryptedStr = getDecodedString(binaryStrArr);

        if (!decryptedStr.isEmpty()) {
            System.out.println("Decoded string:");
            System.out.println(decryptedStr);
        } else {
            System.out.println("Encoded string is not valid.");
        }

    }

    public static void runProgram() {
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = scanner.nextLine();
            switch(operation) {
                case "encode":
                    startEncoder();
                    break;
                case "decode":
                    startDecoder();
                    break;
                case "exit":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("There is no '" + operation + "' operation");
            }
        }
    }

    public static void main(String[] args) {
        /*TASK 1*
        for (int i = 0; i< inputArr.length; i++) {
            str += inputArr[i] + " ";
        }
        System.out.println(str);
         */

         /*TASK 2*
        for (char c : inputArr) {
            String binary = String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0');
            str += c + " = " + binary + "\n";
        }
        */

        /*TASK 3*
        startEncoder();
        */

        /*TASK 4
        startDecoder();
        */

        /*TASK 5
        */
        runProgram();

    }
}