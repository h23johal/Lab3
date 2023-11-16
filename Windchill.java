import java.util.Random;
import java.util.Scanner;

public class Windchill {

    public static double calculateWindChill(double temperature, double windSpeed) {
        double speedInKmh = windSpeed * 3.6;
        return 13.12 + 0.6215 * temperature - 11.37 * Math.pow(speedInKmh, 0.16) + 0.3965 * temperature * Math.pow(speedInKmh, 0.16);
    }

    public static void printWindChillMessage(double wct) {
        if (wct > -25) {
            System.out.println("kallt");
        } else if (wct > -35) {
            System.out.println("Mycket kallt");
        } else if (wct > -60) {
            System.out.println("Risk för frostskada");
        } else {
            System.out.println("Stor risk för frostskada");
        }
    }

    public static void printMultiplicationTable() {
        Random random = new Random();
        int rows = random.nextInt(15) + 1;

        for (int i = 1; i <= rows; i++) {
            System.out.print("|" + i + "|\t");
            for (int j = 1; j <= 11; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Fyll i utetemperaturen i Celsius:");
        double temperature = input.nextDouble();

        System.out.println("Fyll i vindhastigheten i m/s:");
        double windSpeed = input.nextDouble();

        double windChill = calculateWindChill(temperature, windSpeed);
        System.out.printf("Wind chill temperaturen är: %.2f grader Celsius%n", windChill);

        // Skriv ut det specifika meddelandet baserat på WCT-värdet
        printWindChillMessage(windChill);

        // Skriv ut multiplikationstabellen
        printMultiplicationTable();

        input.close();
    }
}