import javax.swing.*;

public class ClasePrincipal {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            JLabel titleLabel = new JLabel("Bienvenido al Conversor Alura");
            panel.add(titleLabel);

            String[] options = {
                    "Convertidor de Monedas", "Convertidor de Longitud", "Salir"
            };

            JComboBox<String> comboBox = new JComboBox<>(options);
            panel.add(comboBox);

            JButton convertButton = new JButton("Seleccionar");
            convertButton.addActionListener(e -> {
                String selectedOption = (String) comboBox.getSelectedItem();
                if (selectedOption == null || selectedOption.equals("Salir")) {
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar este Conversor!");
                    System.exit(0);
                } else if (selectedOption.equals("Convertidor de Monedas")) {
                    ConversorMonedas.convertCurrency();
                } else if (selectedOption.equals("Convertidor de Longitud")) {
                    ConvertorLongitud.convertLength();
                }
            });
            panel.add(convertButton);

            JFrame frame = new JFrame("Conversor Alura");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        });
    }
}


