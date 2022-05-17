import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class MyGUI extends JFrame {

    private JPanel MainPanel;
    private JTextField tFieldFirstPoly;
    private JTextField tFieldSecondPoly;
    private JTextField tFieldResult;
    private JButton buttonAdd;
    private JButton buttonSubtract;
    private JButton buttonMultiply;
    private JButton buttonDivide;
    private JButton buttonDerivative;
    private JButton buttonIntegration;


    public MyGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 548, 439);
        MainPanel = new JPanel();
        MainPanel.setBackground(new Color(65, 105, 225));
        MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(MainPanel);
        MainPanel.setLayout(null);

        JLabel labelFirstPoly = new JLabel("First polynomial");
        labelFirstPoly.setFont(new Font("Arial", Font.PLAIN, 18));
        labelFirstPoly.setBounds(10, 30, 150, 30);
        MainPanel.add(labelFirstPoly);

        tFieldFirstPoly = new JTextField();
        tFieldFirstPoly.setBackground(new Color(30, 144, 255));
        tFieldFirstPoly.setFont(new Font("Arial", Font.PLAIN, 18));
        tFieldFirstPoly.setBounds(175, 30, 325, 30);
        MainPanel.add(tFieldFirstPoly);
        tFieldFirstPoly.setColumns(10);

        JLabel labelSecondPoly = new JLabel("Second polynomial");
        labelSecondPoly.setFont(new Font("Arial", Font.PLAIN, 18));
        labelSecondPoly.setBounds(10, 75, 160, 30);
        MainPanel.add(labelSecondPoly);

        tFieldSecondPoly = new JTextField();
        tFieldSecondPoly.setBackground(new Color(30, 144, 255));
        tFieldSecondPoly.setFont(new Font("Arial", Font.PLAIN, 18));
        tFieldSecondPoly.setBounds(175, 75, 325, 30);
        MainPanel.add(tFieldSecondPoly);
        tFieldSecondPoly.setColumns(10);

        buttonAdd = new JButton("ADD");
        buttonAdd.setBackground(new Color(30, 144, 255));
        buttonAdd.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonAdd.setBounds(10, 175, 230, 25);
        MainPanel.add(buttonAdd);

        buttonSubtract = new JButton("Subtract");
        buttonSubtract.setBackground(new Color(30, 144, 255));
        buttonSubtract.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonSubtract.setBounds(270, 175, 230, 25);
        MainPanel.add(buttonSubtract);

        buttonMultiply = new JButton("Multiply");
        buttonMultiply.setBackground(new Color(30, 144, 255));
        buttonMultiply.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonMultiply.setBounds(10, 210, 230, 25);
        MainPanel.add(buttonMultiply);

        buttonDivide = new JButton("Divide");
        buttonDivide.setBackground(new Color(30, 144, 255));
        buttonDivide.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonDivide.setBounds(270, 210, 230, 25);
        MainPanel.add(buttonDivide);

        buttonDerivative = new JButton("Derivative");
        buttonDerivative.setBackground(new Color(30, 144, 255));
        buttonDerivative.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonDerivative.setBounds(10, 245, 230, 25);
        MainPanel.add(buttonDerivative);

        buttonIntegration = new JButton("Integration");
        buttonIntegration.setBackground(new Color(30, 144, 255));
        buttonIntegration.setFont(new Font("Arial", Font.PLAIN, 18));
        buttonIntegration.setBounds(270, 245, 230, 25);
        MainPanel.add(buttonIntegration);

        tFieldResult = new JTextField();
        tFieldResult.setBackground(new Color(30, 144, 255));
        tFieldResult.setEditable(false);
        tFieldResult.setFont(new Font("Arial", Font.PLAIN, 18));
        tFieldResult.setColumns(10);
        tFieldResult.setBounds(10, 110, 490, 45);
        MainPanel.add(tFieldResult);
        this.setVisible(true);
    }

    public void setAddActionListener(final ActionListener e){
        buttonAdd.addActionListener(e);
    }

    public void setSubActionListener(final ActionListener e){
        buttonSubtract.addActionListener(e);

    }

    public void setProdActionListener(final ActionListener e){
        buttonMultiply.addActionListener(e);
    }

    public void setDerivativeActionListener(final ActionListener e){
        buttonDerivative.addActionListener(e);

    }

    public void setIntegrationActionListener(final ActionListener e){
        buttonIntegration.addActionListener(e);

    }



    public String gettFieldFirstPoly() {
        return tFieldFirstPoly.getText();
    }

    public String gettFieldSecondPoly() {return tFieldSecondPoly.getText();}

    public void settFieldResult(String tFieldResult) {this.tFieldResult.setText(tFieldResult);}


}
