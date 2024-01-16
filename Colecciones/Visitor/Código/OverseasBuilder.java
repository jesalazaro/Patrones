import javax.swing.*;
import java.awt.*;

public class OverseasBuilder extends UIBuilder {
    private JLabel lblOrderAmount;

    private JLabel lblAdditionalSH;

    private JTextField txtOrderAmount;

    private JTextField txtAdditionalSH;

    public void addUIControls() {

        searchUI = new JPanel();

        GridBagLayout gridbag = new GridBagLayout();
        lblOrderAmount = new JLabel("Order Amount:");
        txtOrderAmount = new JTextField(10);
        lblAdditionalSH =
                new JLabel("Additional S & H(Overseas and Brazilian Orders Only):");
        txtAdditionalSH = new JTextField(10);

        searchUI.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();



        searchUI.add(lblOrderAmount);
        searchUI.add(txtOrderAmount);
        searchUI.add(lblAdditionalSH);
        searchUI.add(txtAdditionalSH);


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
        gbc.gridy = 3;
        gridbag.setConstraints(lblAdditionalSH, gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 3;
        gridbag.setConstraints(txtAdditionalSH, gbc);

    }



    public double[] getValues() {
        double[] inputValues = new double[2];
        inputValues[0] = Double.parseDouble(txtOrderAmount.getText());
        inputValues[1] = Double.parseDouble(txtAdditionalSH.getText());
        return (inputValues);
    }

//    crear la coleccion de objectos y cada vez que lea de la interfaz grafica carga en la coleccion,, se crea el objeto orden y se carga sobre la coleccion, sobre visit se dvuelve double
}
