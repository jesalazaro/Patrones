import javax.swing.*;
import java.awt.*;

public class NonCaliforniaBuilder extends UIBuilder {

    private JLabel lblOrderAmount;

    private JTextField txtOrderAmount;

    public void addUIControls() {

        searchUI = new JPanel();


        lblOrderAmount = new JLabel("Order Amount:");
        txtOrderAmount = new JTextField(10);

        GridBagLayout gridbag = new GridBagLayout();
        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();


        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);

        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gridbag.setConstraints(lblOrderAmount, gbc);


        gbc.gridx = 1;
        gbc.gridy = 0;
        gridbag.setConstraints(txtOrderAmount, gbc);
    }



    public double[] getValues() {
        double[] inputValues = new double[1];
        inputValues[0] = Double.parseDouble(txtOrderAmount.getText());
        return (inputValues);
    }
}
