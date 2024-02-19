package Online_Pregnancy_Test_System;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class ResultsForm extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField userID;
    private JTextField testDate;
    private JComboBox<String> resultComboBox;

   
    private JButton btnNewButton;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ResultsForm frame = new ResultsForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public ResultsForm() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(180, 50, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(Color.pink);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewAmbulanceRegister = new JLabel("RESULTS FORM");
        lblNewAmbulanceRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 40));
        lblNewAmbulanceRegister.setForeground(new Color(139, 0, 0)); 
        lblNewAmbulanceRegister.setBounds(362, 35, 325, 50);
        contentPane.add(lblNewAmbulanceRegister);

        JLabel lblUserID = new JLabel("User ID");
        lblUserID.setFont(new Font("Georgia", Font.BOLD, 18));
        lblUserID.setBounds(58, 151, 99, 43);
        contentPane.add(lblUserID);

        JLabel lblTestDate = new JLabel("TestDate");
        lblTestDate.setFont(new Font("Georgia", Font.BOLD, 18));
        lblTestDate.setBounds(58, 320, 110, 29);
        contentPane.add(lblTestDate);

        JLabel lblResult = new JLabel("Result");
        lblResult.setFont(new Font("Georgia", Font.BOLD, 18));
        lblResult.setBounds(542, 151, 124, 36);
        contentPane.add(lblResult);
        
       

        userID = new JTextField();
        userID.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        userID.setBounds(214, 151, 228, 50);
        contentPane.add(userID);
        userID.setColumns(10);

        testDate = new JTextField();
        testDate.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        testDate.setBounds(214, 320, 228, 50);
        contentPane.add(testDate);
        testDate.setColumns(10);

        resultComboBox = new JComboBox<>(new String[]{"Negative", "Positive", "Physical Consultation"});
        resultComboBox.setFont(new Font("Goudy Old Style", Font.PLAIN, 18));
        resultComboBox.setBounds(707, 151, 228, 50);
        contentPane.add(resultComboBox);
        
        

              
        
        userID.setBackground(Color.LIGHT_GRAY);
        testDate.setBackground(Color.LIGHT_GRAY);
        resultComboBox.setBackground(Color.LIGHT_GRAY);
        
        


        btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String UserID = userID.getText();
                String TestDate = testDate.getText();
                Object Result = resultComboBox.getSelectedItem();
                String msg = "" + UserID;
                msg += " 2024";
              

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

                    String query = "INSERT INTO tests (UserID, TestDate, Result) " +
                            "VALUES ('" + UserID + "','" + TestDate + "','" + Result + "')";

                    
                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "An Error occured during submission");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "A Result " + msg + " was Successfully submitted");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        btnNewButton.setBounds(480, 430, 180, 62);
        btnNewButton.setBackground(new Color(139, 0, 0));
        btnNewButton.setForeground(Color.WHITE); 
        contentPane.add(btnNewButton);

    
        JLabel copyrightLabel = new JLabel("\u00a9 2024 MUSEMAKWELI ROSSA BELYSE ARLANDE  - (ONLINE PREGNANCY TEST System) . . All rights reserved.");
        copyrightLabel.setForeground(Color.GRAY);
        copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        copyrightLabel.setBounds(10, 540, 974, 20); 
        contentPane.add(copyrightLabel);
    }
}

