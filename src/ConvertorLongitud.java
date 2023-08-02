
import javax.swing.JOptionPane;

public class ConvertorLongitud {

    public static void convertLength() {
        String[] options = {
                "Kilómetros a Metros", "Metros a Centímetros",
                "Metros a Kilómetros", "Centímetros a Metros",
                "Atrás"
        };

        String selectedOption = showOptionDialog(
                "Elige la Unidad de Longitud que Deseas Convertir:",
                "CONVERSOR DE LONGITUD ALURA",
                options
        );

        if (selectedOption == null || selectedOption.equals("Atrás")) {
            return;
        }

        double conversionFactor = getConversionFactor(selectedOption);

        String lengthString = JOptionPane.showInputDialog("Ingrese la longitud en " + getFromUnit(selectedOption));
        double length = Double.parseDouble(lengthString);
        double result = length * conversionFactor;
        String formattedResult = String.format("%.2f", result);
        JOptionPane.showMessageDialog(null, "La longitud es " + formattedResult + " " + getToUnit(selectedOption));
    }

    private static String showOptionDialog(String message, String title, String[] options) {
        return (String) JOptionPane.showInputDialog(
                null,
                message,
                title,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );
    }

    private static double getConversionFactor(String selectedOption) {
        switch (selectedOption) {
            case "Kilómetros a Metros":
                return 1000;
            case "Metros a Kilómetros":
                return 0.001;
            case "Metros a Centímetros":
                return 100;
            case "Centímetros a Metros":
                return 0.01;
            default:
                return 0;
        }
    }

    private static String getFromUnit(String selectedOption) {
        return selectedOption.substring(0, selectedOption.indexOf(" a "));
    }

    private static String getToUnit(String selectedOption) {
        return selectedOption.substring(selectedOption.indexOf(" a ") + 3);
    }
}

