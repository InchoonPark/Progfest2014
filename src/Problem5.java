import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by dennispark on 12/4/15.
 */
public class Problem5 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> fileIn = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fileIn.add(line);
        }
        for (int i = 1; i < fileIn.size(); i++) {
            String fileLine = fileIn.get(i);
            String[] fileLineWords = fileLine.split(" ");
            String[] newFileLineWords = new String[fileLineWords.length];
            String firstChar = fileLineWords[0].substring(0, 1);
            fileLineWords[0] = fileLineWords[0].substring(1);
            if (firstChar.equals("@")) {
                for (int j = 0; j < fileLineWords.length; j++) {
                    String encryptedWord = encryptWord(reverseWord(fileLineWords[j]));
                    newFileLineWords[j] = encryptedWord;
                }
            } else {
                for (int j = 0; j < fileLineWords.length; j++) {
                    String decryptedWord = decryptWord(reverseWord(fileLineWords[j]));
                    newFileLineWords[j] = decryptedWord;
                }
            }
            String newFileLine = String.join(" ", newFileLineWords);
            bw.write(newFileLine);
            bw.newLine();
        }
        bw.close();
    }

    public static String decryptWord(String str) {
        char[] wordChars = str.toCharArray();
        String decryptedWord = "";
        for (int i = 0; i < wordChars.length; i++) {
            int asciiValue = (int) wordChars[i];
            if (asciiValue > 65 && asciiValue < 91) {
                asciiValue--;
            } else if (asciiValue == 65) {
                asciiValue = 90;
            } else if (asciiValue > 97 && asciiValue < 123) {
                asciiValue--;
            } else if (asciiValue == 97) {
                asciiValue = 122;
            }
            char newChar = (char) asciiValue;
            decryptedWord += String.valueOf(newChar);
        }
        return decryptedWord;
    }

    public static String encryptWord(String str) {
        char[] wordChars = str.toCharArray();
        String encryptedWord = "";
        for (int i = 0; i < wordChars.length; i++) {
            int asciiValue = (int) wordChars[i];
            if (asciiValue > 64 && asciiValue < 90) {
                asciiValue++;
            } else if (asciiValue == 90) {
                asciiValue = 65;
            } else if (asciiValue > 96 && asciiValue < 122) {
                asciiValue++;
            } else if (asciiValue == 122) {
                asciiValue = 97;
            }
            char newChar = (char) asciiValue;
            encryptedWord += String.valueOf(newChar);
        }
        return encryptedWord;
    }

    public static String reverseWord(String str) {
        String reversedWord = "";
        for (int i = str.length(); i > 0; i--) {
            reversedWord += str.substring(i - 1, i);
        }
        return reversedWord;
    }
}