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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField username;
    private JTextField phone;
    private JTextField email;
    private JTextField address;
    private JTextField dateofbirth;
    private JTextField insurance;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    /**
	 * @author ARLANDE  With certified Copyright.
	 */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }



    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(".                                                                           REGISTRATION PAGE FOR USER                          (ONLINE PREGNANCY TEST  SYSTEM )                 .");
        setBounds(180, 50, 1014, 597);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setBackground(Color.pink);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("REGISTER AS NEW USER");
        lblNewUserRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 35));
        lblNewUserRegister.setForeground(new Color(139, 0, 0)); 
        lblNewUserRegister.setBounds(362, 40, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Username");
        lblName.setFont(new Font("Georgia", Font.PLAIN, 17));
        lblName.setBounds(58, 140, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Phone Number");
        lblNewLabel.setFont(new Font("Georgia", Font.PLAIN, 17));
        lblNewLabel.setBounds(58, 230, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Georgia", Font.PLAIN, 17));
        lblEmailAddress.setBounds(58, 310, 124, 36);
        contentPane.add(lblEmailAddress);
        
        JLabel lblNewLabeldob = new JLabel("Date of Birth");
        lblNewLabeldob.setFont(new Font("Georgia", Font.PLAIN, 17));
        lblNewLabeldob.setBounds(58, 380, 110, 29);
        contentPane.add(lblNewLabeldob);

        username = new JTextField();
        username.setFont(new Font("Bookman Old Style", Font.PLAIN, 17));
        username.setBounds(214, 140, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        phone = new JTextField();
        phone.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
        phone.setBounds(214, 220, 228, 50);
        contentPane.add(phone);
        phone.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
        email.setBounds(214, 310, 228, 50);
        contentPane.add(email);
        email.setColumns(10);
        
        dateofbirth = new JTextField();
        dateofbirth.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
        dateofbirth.setBounds(214, 380, 228, 50);
        contentPane.add(dateofbirth);
        dateofbirth.setColumns(10);


        JLabel lbladdress = new JLabel("Addres");
        lbladdress.setFont(new Font("Georgia", Font.PLAIN, 17));
        lbladdress.setBounds(542, 140, 99, 29);
        contentPane.add(lbladdress);
        

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("TGeorgia", Font.PLAIN, 17));
        lblPassword.setBounds(542, 220, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblinsurance = new JLabel("Insurance");
        lblinsurance.setFont(new Font("Georgia", Font.PLAIN, 17));
        lblinsurance.setBounds(542, 310, 139, 26);
        contentPane.add(lblinsurance);
        
        address = new JTextField();
        address.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
        address.setBounds(707, 140, 228, 50);
        contentPane.add(address);
        address.setColumns(10);


        insurance = new JTextField();
        insurance.setFont(new Font("Bookman Old StyleTahoma", Font.PLAIN, 13));
        insurance.setBounds(707, 310, 228, 50);
        contentPane.add(insurance);
        insurance.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
        passwordField.setBounds(707, 220, 228, 50);
        contentPane.add(passwordField);
        
        username.setBackground(Color.LIGHT_GRAY);
        phone.setBackground(Color.LIGHT_GRAY);
        email.setBackground(Color.LIGHT_GRAY);
        address.setBackground(Color.LIGHT_GRAY);
        dateofbirth.setBackground(Color.LIGHT_GRAY);
        insurance.setBackground(Color.LIGHT_GRAY);
        passwordField.setBackground(Color.LIGHT_GRAY);



        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Username = username.getText();
                String Phone = phone.getText();
                String emailId = email.getText();
                String Address = address.getText();
                String dateOfBirth = dateofbirth.getText();
                String password = passwordField.getText();
                String Insurance = insurance.getText();
                

                String msg = "" + Username;
                msg += " \n";
              

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

                    String query = "INSERT INTO user (Username, Email,Password, Phone, DateOfBirth,  Address, Insurance) " +
                            "VALUES ('" + Username + "','" + emailId + "','" + password + "','" + Phone + "','" + dateOfBirth + "','" + Address + "','" + Insurance + "')";
 

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
                    } else {
                        JOptionPane.showMessageDialog(btnNewButton,
                            "Welcome, " + msg + "Your account is sucessfully created");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Algerian", Font.PLAIN, 22));
        btnNewButton.setBounds(430, 460, 180, 62);
        btnNewButton.setBackground(new Color(139, 0, 0));
        btnNewButton.setForeground(Color.WHITE); 
        contentPane.add(btnNewButton);
        

        JLabel copyrightLabel = new JLabel("\u00a9 2024 MUSEMAKWELI ROSSA BELYSE ARLANDE  - (ONLINE PREGNANCY TEST System) . All rights reserved.");
        copyrightLabel.setForeground(Color.GRAY);
        copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        copyrightLabel.setBounds(10, 530, 974, 20); 
        contentPane.add(copyrightLabel);
    }
}
