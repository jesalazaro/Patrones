import java.util.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;
import java.util.HashMap;
import java.util.Map;


public class OrderManager extends JFrame {
  private JPanel pSearchCriteria;
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String CREATE_ORDER = "Create Order";
  public static final String EXIT = "Exit";
  public static final String CA_ORDER = "California Order";
  public static final String NON_CA_ORDER =
    "Non-California Order";

  public static final String OVERSEAS_ORDER = "Overseas Order";

  public static final String BRAZILIAN_ORDER = "Brazilian Order";
  private JComboBox cmbOrderType;
  private JLabel lblOrderType;
  private JLabel lblTotal, lblTotalValue;

  public  static Map<String, Object> myHashMap = new HashMap<>();
  private OrderVisitor objVisitor;

  public OrderManager() {
    super("Visitor Pattern - Example");

    //Create the visitor instance
    objVisitor = new OrderVisitor();

    cmbOrderType = new JComboBox();
    cmbOrderType.addItem(OrderManager.CA_ORDER);
    cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
    cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);
    cmbOrderType.addItem(OrderManager.BRAZILIAN_ORDER);



    lblOrderType = new JLabel("Order Type:");


    lblTotal = new JLabel("Result:");
    lblTotalValue =
      new JLabel("Click Create or GetTotal Button");

    pSearchCriteria = new JPanel();
    //Create the open button
    JButton getTotalButton =
      new JButton(OrderManager.GET_TOTAL);
    getTotalButton.setMnemonic(KeyEvent.VK_G);
    JButton createOrderButton =
      new JButton(OrderManager.CREATE_ORDER);
    getTotalButton.setMnemonic(KeyEvent.VK_C);
    JButton exitButton = new JButton(OrderManager.EXIT);
    exitButton.setMnemonic(KeyEvent.VK_X);
    ButtonHandler objButtonHandler = new ButtonHandler(this);



    getTotalButton.addActionListener(objButtonHandler);
    createOrderButton.addActionListener(objButtonHandler);
    exitButton.addActionListener(new ButtonHandler());
    cmbOrderType.addActionListener(objButtonHandler);

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    JPanel panel = new JPanel();
    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();
    panel.add(getTotalButton);
    panel.add(createOrderButton);
    panel.add(exitButton);
    gbc2.anchor = GridBagConstraints.EAST;
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(createOrderButton, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(getTotalButton, gbc2);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    gridbag2.setConstraints(exitButton, gbc2);

    //****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();



    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    buttonPanel.add(pSearchCriteria);
    buttonPanel.add(lblTotal);
    buttonPanel.add(lblTotalValue);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderType, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(cmbOrderType, gbc);

    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(pSearchCriteria, gbc);






    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotal, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotalValue, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;

    //****************************************************

    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();

    contentPane.add(buttonPanel, BorderLayout.NORTH);
    contentPane.add(panel, BorderLayout.CENTER);
    try {

      SwingUtilities.updateComponentTreeUI(
        OrderManager.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }

  public void displayNewUI(JPanel panel) {
    pSearchCriteria.removeAll();
    pSearchCriteria.add(panel);
    pSearchCriteria.validate();
    validate();
  }

  public JComboBox getSearchTypeCtrl(){
    return cmbOrderType;
  }

  public static void main(String[] args) {
    JFrame frame = new OrderManager();

    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }
                           );

    //frame.pack();
    frame.setSize(500, 400);
    frame.setVisible(true);
  }

  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }
  public OrderVisitor getOrderVisitor() {
    return objVisitor;
  }
  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }


} // End of class OrderManager

class ButtonHandler implements ActionListener {

  OrderManager objOrderManager;

  UIBuilder builder;



  public void actionPerformed(ActionEvent e) {

    String totalResult = null;


    if (e.getActionCommand().equals(OrderManager.EXIT)) {
      System.exit(1);
    }

    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)) {


      String orderType = objOrderManager.getOrderType();


//      OrderManager.myHashMap.put("key1", new orderType("value1"));

      double[] values = builder.getValues();  //get input values
      double dblOrderAmount = 0.0;
      double dblTax = 0.0;
      double dblSH = 0.0;

      if(orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
        dblOrderAmount = values[0];
        dblTax = values[1];
      } else if(orderType.equalsIgnoreCase(OrderManager.NON_CA_ORDER)) {
        dblOrderAmount = values[0];
      } else if (orderType.equalsIgnoreCase(OrderManager.OVERSEAS_ORDER)){
        dblOrderAmount = values[0];
        dblSH =  values[1];
      } else if (orderType.equalsIgnoreCase(OrderManager.BRAZILIAN_ORDER)){
        dblOrderAmount = values[0];
        dblSH =  values[1];
      }

      //Create the order
      Order order = createOrder(orderType, dblOrderAmount,
              dblTax, dblSH);

      //Get the Visitor
      OrderVisitor visitor =
              objOrderManager.getOrderVisitor();

      System.out.println(visitor);
      // accept the visitor instance
      order.accept(visitor);

      objOrderManager.setTotalValue(
              " Order Created Successfully");
    }

    if (e.getSource() == objOrderManager.getSearchTypeCtrl()) {
      String selection = objOrderManager.getOrderType();
      if (selection.equals("") == false) {
        BuilderFactory factory = new BuilderFactory();
        builder = factory.getUIBuilder(selection);
        UIDirector director = new UIDirector(builder);
        director.build();
        JPanel UIObj = builder.getSearchUI();
        objOrderManager.displayNewUI(UIObj);

      }
    }






    if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
      //Get the Visitor
      OrderVisitor visitor =
              objOrderManager.getOrderVisitor();
      totalResult = new Double(
              visitor.getOrderTotal()).toString();
      totalResult = " Orders Total = " + totalResult;
      objOrderManager.setTotalValue(totalResult);
    }
  }

  public Order createOrder(String orderType,
      double orderAmount, double tax, double SH) {

    if (orderType.equalsIgnoreCase(OrderManager.CA_ORDER)) {
      return new CaliforniaOrder(orderAmount, tax);
    }
    if (orderType.equalsIgnoreCase(
      OrderManager.NON_CA_ORDER)) {
      return new NonCaliforniaOrder(orderAmount);

    }
    if (orderType.equalsIgnoreCase(
          OrderManager.OVERSEAS_ORDER)) {
      return new OverseasOrder(orderAmount, SH);
    }
    if (orderType.equalsIgnoreCase(
            OrderManager.BRAZILIAN_ORDER)) {
      return new BrazilianOrder(orderAmount, SH);
    }
    return null;
  }

  public ButtonHandler() {
  }
  public ButtonHandler(OrderManager inObjOrderManager) {
    objOrderManager = inObjOrderManager;
  }

} // End of class ButtonHandler

class BuilderFactory {
  public UIBuilder getUIBuilder(String str) {

    UIBuilder builder = null;

      switch (str) {
          case OrderManager.NON_CA_ORDER:
              builder = new NonCaliforniaBuilder();
              break;
          case OrderManager.CA_ORDER:
              builder = new CaliforniaBuilder();
              break;
          case OrderManager.OVERSEAS_ORDER:
              builder = new OverseasBuilder();
              break;
          case OrderManager.BRAZILIAN_ORDER:
              builder = new BrazilianBuilder();
              break;
      }
    return builder;
  }
}
