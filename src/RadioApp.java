import java.util.Scanner;

public class RadioApp {

    public static void main(String[] args) {
        CarRadio carRadio = new CarRadio();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nRadio Menu:");
            System.out.println("1. Prende el radio");
            System.out.println("2. Cambia de AM a FM a AM");
            System.out.println("3. Avanzar en el dial de las emisoras");
            System.out.println("4. Permite guardar una emisora en uno de los 12 botones");
            System.out.println("5. Permite seleccionar la emisora puesta en un botón");
            System.out.println("6. Apagar el radio");
            System.out.println("0. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    carRadio.tooglePowerOffOn();
                    System.out.println("Radio " + (carRadio.getState() ? "encendido" : "apagado"));
                    break;
                case 2:
                    carRadio.toogleAMFM();
                    System.out.println("Modo cambiado a " + (carRadio.getStateAMFM() ? "AM" : "FM"));
                    break;
                case 3:
                    carRadio.nextFrequency();
                    System.out.println("Frecuencia actual: " + carRadio.getCurrentFrequency());
                    break;
                case 4:
                    System.out.println("Ingrese el número de botón (1-12) para guardar la emisora:");
                    int buttonToSave = scanner.nextInt();
                    carRadio.setFavFrequency(buttonToSave);
                    System.out.println("Emisora guardada en el botón " + buttonToSave);
                    break;
                case 5:
                    System.out.println("Ingrese el número de botón (1-12) para seleccionar la emisora:");
                    int buttonToSelect = scanner.nextInt();
                    float selectedFrequency = carRadio.getFavFrequency(buttonToSelect);
                    System.out.println(
                            "Emisora seleccionada desde el botón " + buttonToSelect + ": " + selectedFrequency);
                    break;
                case 6:
                    carRadio.tooglePowerOffOn();
                    System.out.println("Radio apagado");
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
