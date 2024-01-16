import javax.swing.*;
import java.awt.*;

public class CaliforniaBuilder extends UIBuilder {

    private JLabel lblOrderAmount;
    private JLabel lblAdditionalTax;

    private JTextField txtOrderAmount;

    private JTextField txtAdditionalTax;

    public void addUIControls() {

        searchUI = new JPanel();

        GridBagLayout gridbag = new GridBagLayout();
        lblOrderAmount = new JLabel("Order Amount:");
        txtOrderAmount = new JTextField(10);
        lblAdditionalTax =
                new JLabel("Additional Tax(CA Orders Only):");

        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();
        txtAdditionalTax = new JTextField(10);


        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);
        searchUI.add(lblAdditionalTax);
        searchUI.add(txtAdditionalTax);

        gbc.insets.top = 5;
        gbc.insets.bottom = 5;


        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gridbag.setConstraints(lblOrderAmount, gbc);


        gbc.gridx = 1;
        gbc.gridy = 1;
        gridbag.setConstraints(txtOrderAmount, gbc);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gridbag.setConstraints(lblAdditionalTax, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gridbag.setConstraints(txtAdditionalTax, gbc);



    }



    public double[] getValues() {
        double[] inputValues = new double[2];
        inputValues[0] = Double.parseDouble(txtOrderAmount.getText());
        inputValues[1] = Double.parseDouble(txtAdditionalTax.getText());
        return (inputValues);
    }
}
