
import javax.swing.JOptionPane;

public class ConversorMonedas {

    public static void convertCurrency() {
        String[] options = {
                "Soles a Dólares", "Dólares a Soles",
                "Soles a Euros", "Euros a Soles",
                "Soles a Libras Esterlinas", "Libras Esterlinas a Soles",
                "Soles a Yen Japonés", "Yen Japonés a Soles",
                "Soles a Won sul-coreano", "Won sul-coreano a Soles",
                "Atrás"
        };

        String selectedOption = showOptionDialog(
                "Elige la Moneda que Deseas Convertir:",
                "CONVERSOR DE MONEDAS ALURA",
                options
        );

        if (selectedOption == null || selectedOption.equals("Atrás")) {
            return;
        }

        double exchangeRate = getExchangeRate(selectedOption);

        String amountString = JOptionPane.showInputDialog("Ingrese monto de Soles:");
        double amount = Double.parseDouble(amountString);
        double result = amount * exchangeRate;
        String formattedResult = String.format("%.2f", result);
        JOptionPane.showMessageDialog(null, "Tienes " + formattedResult + " " + getToCurrency(selectedOption));
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

    private static double getExchangeRate(String selectedOption) {
        switch (selectedOption) {
            case "Soles a Dólares":
                return 0.28;
            case "Dólares a Soles":
                return 1 / 0.28;
            case "Soles a Euros":
                return 0.23;
            case "Euros a Soles":
                return 1 / 0.23;
            case "Soles a Libras Esterlinas":
                return 0.20;
            case "Libras Esterlinas a Soles":
                return 1 / 0.20;
            case "Soles a Yen Japonés":
                return 30.10;
            case "Yen Japonés a Soles":
                return 1 / 30.10;
            case "Soles a Won sul-coreano":
                return 318.70;
            case "Won sul-coreano a Soles":
                return 1 / 318.70;
            default:
                return 0;
        }
    }

    private static String getToCurrency(String selectedOption) {
        return selectedOption.substring(selectedOption.indexOf(" a ") + 3);
    }
}
