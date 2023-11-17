//Importdeklarerar paketet Random så jag kan hämta slumpmässiga tal
import java.util.Random;
//Importdeklarerar paketet Scanner så jag kan göra input instanser
import java.util.Scanner;

public class Windchill {

    public static double calculateWindChill(double temperature, double windSpeed) {
        //Omvandlar meter per sekund till kilometer per timme.
        double speedInKmh = windSpeed * 3.6;
        //Räknar ut Windchill med hjälp av algoritmen och returnerar resultatet.
        return 13.12 + 0.6215 * temperature - 11.37 * Math.pow(speedInKmh, 0.16) + 0.3965 * temperature * Math.pow(speedInKmh, 0.16);
    }
    //för en metod för att hämta utskriften felInput.
    public static void felInput() {
        System.out.println("Fel input");
    }
    //Gör en metod för att returnera varningar vid olika windchill temperaturer.
    public static void printWindChillMessage(double wct) {
        //Om över 100°c. printa du är antagligen död.
        if (wct > 100) {
            System.out.println("du är antagligen död");
        }
        //Om över 25°c. printa plocka fram badbyxorna.
        else if (wct > 25) {
            System.out.println("plocka fram badbyxorna");
        }
        //Om över 0°c. printa behagligt.
        else if (wct > 0) {
            System.out.println("behagligt");
        }
        //Om över -25°c. printa Mycket kallt.
        else if (wct > -25) {
            System.out.println("kallt");
            //Om över -35°c. printa Mycket kallt.
        } else if (wct > -35) {
            System.out.println("Mycket kallt");
            //Om över -60°c. printa Risk för frostskada.
        } else if (wct > -60) {
            System.out.println("Risk för frostskada");
            //Om under -60°c. printa: Stor risk för frostskada.
        } else {
            System.out.println("Stor risk för frostskada");
        }

    }

   public static void printMultiplicationTable() {
        //initiera randomvärde
        Random random = new Random();
        //printa ut 1-11 i toppen av tabellen
       for (int r = 1; r <= 11; r++) {
           System.out.print("\t"+r+"\t");
       }
       //ny rad
       System.out.println();
       //printa ut linje för att separera headern med tabellen
       for (int l = 1; l <= 11; l++) {
           System.out.print("--------");
       }
       //ny rad
       System.out.println();
       //Hämtar ett slumpmässigt värde 1-15 (0 till 14+1).
       //Detta värde representerar antalet rader
        int rows = random.nextInt(15) + 1;
       //för varje rad, printa radens multiplikationstabell.
        for (int i = 1; i <= rows; i++) {
            // Skriver ut radnumret följt av en vertikal linje och en tab,
            // vilket fungerar som radens rubrik i tabellen.
            System.out.print(i + "|\t");
            for (int j = 1; j <= 11; j++) {
                System.out.print(i * j + "\t\t");
            }
            //ny rad efter varje varv
            System.out.println();
        }
    }
        //main metoden, nu kör vi!
    public static void main(String[] args) {
        //initiera bool för att avgöra om programmet körs
        boolean running = true;
        //input
        Scanner input = new Scanner(System.in);
        //programmet körs
        System.out.println("\nVälkommen till labb 3 uppgift A och B!\nVi har valt att kombinera dessa uppgifter med hjälp av en meny");
        while (running) {
            //utskrift av menyval
            System.out.println("\n-----------------------------------------------------------------\nVad vill du göra?\nBeräkna windchill temperatur[1]\nSkriva ut multiplikationstabellen[2]\nAvsluta[3]");
            //Starta meny
            switch(input.next()) {
                //om användaren matar in "1"
                case "1":
                    //initiera variabler för temperatur och vindhastighet
                    double temperature = 0;
                    double windSpeed = 0;
                    //initiera bool för att avgöra om användaren väljer temperatur
                    //detta är i felhanteringssyfte, om användaren ej matar in ett doublevärde börjar loopen om
                    boolean choosingTemp = true;
                    while (choosingTemp) {

                        System.out.println("Fyll i utetemperaturen i Celsius:");
                        //om användarens input är ett doublevärde
                        if (input.hasNextDouble()) {
                            temperature = input.nextDouble();
                            //stäng loopen
                            choosingTemp = false;
                        //om användaren matar in något annat än ett doublevärde
                        } else {
                            //mata ut felmeddelande
                            felInput();
                            //input är nästa inmatning
                            input.next();
                            //loopen börjar om och användaren får mata in igen.
                        }
                    }
                    //liknande kod för inmatning av vindhastighet
                    boolean choosingWS = true;
                    while (choosingWS) {
                        System.out.println("Fyll i vindhastigheten i m/s:");
                        if (input.hasNextDouble()) {
                            windSpeed = input.nextDouble();
                            choosingWS = false;
                        } else {
                            felInput();
                            input.next();
                        }

                    }
                    //initiera double med värdet av uträkningen av kalkylationsmetoden
                    double windChill = calculateWindChill(temperature, windSpeed);
                    System.out.printf("Wind chill temperaturen är: %.2f grader Celsius%n", windChill);

                    // kalla på metod för att skriva ut det specifika meddelandet baserat på WCT-värdet
                    printWindChillMessage(windChill);
                    break;

                case "2":
                    // kalla på metod för utskrift av multiplikationstabellen
                    printMultiplicationTable();
                    break;

                case "3":
                    //running boolen omställs till false, därför bryts loopen och programmet avslutas
                    running = false;
                    break;
                default:
                    //printa ut felmeddelande
                    felInput();
                    break;
            }
        }
        //programmet avslutas och input stängs
        System.out.println("Avslutar...");
        input.close();
    }
}