import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by dennispark on 1/5/15.
 */

public class Problem7 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> fileIn = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int n = Integer.parseInt(br.readLine());
        String[][] bombPositions = new String[n][n];
        String[][] touchedPositions = new String[n][n];
        String[][] filledPositions = new String[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] splittedLine = line.split("");
            for (int j = 0; j < n; j++) {
                bombPositions[i][j] = splittedLine[j];
            }
        }
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            String[] splittedLine = line.split("");
            for (int j = 0; j < n; j++) {
                touchedPositions[i][j] = splittedLine[j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (touchedPositions[i][j].equals("x")) {
                    int count = 0;
                    if (i > 0) {
                        if (j > 0) {
                            if (bombPositions[i - 1][j - 1].equals("*")) {
                                count++;
                            }
                            if (bombPositions[i - 1][j].equals("*")) {
                                count++;
                            }
                            if (j < n - 1) {
                                if (bombPositions[i - 1][j + 1].equals("*")) {
                                    count++;
                                }
                            }
                        }
                    }
                    if (j > 0) {
                        if (bombPositions[i][j - 1].equals("*")) {
                            count++;
                        }
                    }
                    if (j < n - 1) {
                        if (bombPositions[i][j + 1].equals("*")) {
                            count++;
                        }
                    }
                    if (i < n - 1) {
                        if (j > 0) {
                            if (bombPositions[i + 1][j - 1].equals("*")) {
                                count++;
                            }
                        }
                        if (bombPositions[i + 1][j].equals("*")) {
                            count++;
                        }
                        if (j < n) {
                            if (bombPositions[i + 1][j + 1].equals("*")) {
                                count++;
                            }
                        }

                    }

                    filledPositions[i][j] = Integer.toString(count);
                } else {
                    filledPositions[i][j] = ".";
                }
            }
        }
        for (int i = 0; i < n; i++) {
            String[] lineArray = filledPositions[i];
            String line = String.join("", lineArray);
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }
}
