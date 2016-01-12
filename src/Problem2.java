import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by dennispark on 1/11/16.
 */
public class Problem2 {
    public static void main(String[] args) throws Exception {
        ArrayList<String> fileIn = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            fileIn.add(line);
        }
        int caseNum = Integer.parseInt(fileIn.get(0));
        fileIn.remove(0);
        for (int i = 0; i < caseNum; i++) {
            int pointNum = Integer.parseInt(fileIn.get(0));
            fileIn.remove(0);
            ArrayList<Double> distances = new ArrayList();
            for (int j = 0; j < pointNum; j++) {
                for (int k = j + 1; k < pointNum; k++) {
                    String[] coord1 = fileIn.get(j).split(" ");
                    String[] coord2 = fileIn.get(k).split(" ");
                    distances.add(getDistances(Double.parseDouble(coord1[0]),
                            Double.parseDouble(coord1[1]),
                            Double.parseDouble(coord2[0]),
                            Double.parseDouble(coord2[1])
                    ));
                }
            }
            double largestDistance = distances.get(0);
            for (int j = 1; j < distances.size(); j++) {
                if (distances.get(j) > largestDistance) {
                    largestDistance = distances.get(j);
                }
            }
            double squareArea = Math.pow(largestDistance * Math.sqrt(2) / 2, 2);
            bw.write(formatArea(squareArea));
            bw.newLine();

            for (int j = 0; j < pointNum; j++) {
                fileIn.remove(0);
            }
        }
        bw.close();
    }

    public static double getDistances(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static String formatArea(double area) {
        DecimalFormat twoDForm = new DecimalFormat("#.00");
        return twoDForm.format(area);
    }
}
