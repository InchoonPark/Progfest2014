import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by dennispark on 12/12/15.
 */
public class Problem6 {
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
            String[] fileLineWords = fileLine.split(",");
            if (fileLineWords[0].equals("no") || fileLineWords[1].equals("COBOL")) {
                bw.write(addPrices(fileLineWords[2]));
                bw.newLine();
            } else {
                bw.write(addDiscountPrices(fileLineWords[2]));
                bw.newLine();
            }
        }
        bw.close();
    }

    public static String addPrices(String pricesString) {
        String[] prices = pricesString.split(" ");
        double price = 0;
        for (int i = 0; i < prices.length; i++) {
            price += Double.parseDouble(prices[i]);
        }
        return formatPrice(price) + "," + formatPrice(price);
    }

    public static String addDiscountPrices(String pricesString) {
        String[] prices = pricesString.split(" ");
        double price = 0;
        double discountedPrice;
        for (int i = 0; i < prices.length; i++) {
            price += Double.parseDouble(prices[i]);
        }
        if (prices.length >= 5) {
            discountedPrice = price * 0.85 * 0.9 * 0.9;
        } else if (prices.length >= 2) {
            discountedPrice = price * 0.85 * 0.9;
        } else {
            discountedPrice = price * 0.9;
        }
        return formatPrice(price) + "," + formatPrice(discountedPrice);
    }

    public static String formatPrice(double price) {
        DecimalFormat twoDForm = new DecimalFormat("#.00");
        String formattedPrice = twoDForm.format(price);
        return formattedPrice;
    }
}