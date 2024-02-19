package Online_Pregnancy_Test_System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;




public class UserHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserHome frame = new UserHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    

    public UserHome(String userSes) {
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 setTitle("...                                                                           HOME PAGE FOR USER                          (AMBULANCE  BOOKING  SYSTEM )                 ...");
    	 setBounds(180, 50, 1014, 597);
         setResizable(true);
         contentPane = new JPanel();
         contentPane.setBackground(Color.pink);
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);
         
         JLabel copyrightLabel = new JLabel("\u00a9 2024 MUSEMAKWELI ROSSA BELYSE ARLANDE  - (ONLINE PREGNANCY TEST System) . All rights reserved.");
         copyrightLabel.setForeground(Color.GRAY);
         copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
         copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
         copyrightLabel.setBounds(10, 530, 974, 20); 
         contentPane.add(copyrightLabel);
         
         
         
         JLabel lblNewUserRegister = new JLabel(" USER DASHBOARD");
         lblNewUserRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 50));
         lblNewUserRegister.setForeground(new Color(139, 0, 0)); 
         lblNewUserRegister.setBounds(362, 18, 350, 80);
         contentPane.add(lblNewUserRegister);
         
         
         JButton btnViewDetails = new JButton("My Profile");
         btnViewDetails.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 try {
                     
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

                     
                     String query = "SELECT * FROM user WHERE email = ?";
                     PreparedStatement statement = connection.prepareStatement(query);
                     statement.setString(1, userSes);

                   
                     ResultSet resultSet = statement.executeQuery();

                     
                     StringBuilder userData = new StringBuilder();
                     while (resultSet.next()) {
                         userData.append("UserID: ").append(resultSet.getInt("UserID")).append("\n");
                         userData.append("Name: ").append(resultSet.getString("Username")).append("\n");
                         userData.append("Email: ").append(resultSet.getString("Email")).append("\n");
                         userData.append("Address: ").append(resultSet.getString("Address")).append("\n");
                         userData.append("DOB: ").append(resultSet.getString("DateOfBirth")).append("\n");
                         userData.append("Phone: ").append(resultSet.getString("Phone")).append("\n");
                         userData.append("Insurace: ").append(resultSet.getString("Insurance")).append("\n");
                         userData.append("Password: ").append(resultSet.getString("Password")).append("\n");
                         
                     }

                     
                     JOptionPane.showMessageDialog(UserHome.this, userData.toString(), "User Details", JOptionPane.INFORMATION_MESSAGE);

                    
                     resultSet.close();
                     statement.close();
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(UserHome.this, "Error retrieving user data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
             }
         });
         btnViewDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnViewDetails.setBounds(214, 300, 228, 50);
         btnViewDetails.setBackground(new Color(139, 0, 0));
         btnViewDetails.setForeground(Color.WHITE ); 
         contentPane.add(btnViewDetails);
         

         JButton btnUpdateData = new JButton("Update Data");
         btnUpdateData.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 UserUpdateDataForm updateForm = new UserUpdateDataForm(userSes);
                 updateForm.setVisible(true);
             }
         });
         btnUpdateData.setFont(new Font("Tahoma", Font.PLAIN, 16));
         btnUpdateData.setBounds(707, 224, 228, 50);
         btnUpdateData.setBackground(new Color(139, 0, 0));
         btnUpdateData.setForeground(Color.WHITE ); 
         contentPane.add(btnUpdateData);
         
        

         JButton btnNewButton = new JButton("Logout");
         btnNewButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                 if (a == JOptionPane.YES_OPTION) {
                     dispose();
                     UserLogin obj = new UserLogin();
                     obj.setTitle("User-Login");
                     obj.setVisible(true);
                 }
             }
         });
         btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnNewButton.setBounds(454, 400, 228, 50);
         btnNewButton.setBackground(new Color(139, 0, 0));
         btnNewButton.setForeground(Color.WHITE ); 
         contentPane.add(btnNewButton);

         JButton button = new JButton("Change password");
         button.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 ChangePassword bo = new ChangePassword(userSes);
                 bo.setTitle("Change Password");
                 bo.setVisible(true);
             }
         });
         
         btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnNewButton.setBounds(454, 400, 228, 50);
         btnNewButton.setBackground(new Color(139, 0, 0));
         btnNewButton.setForeground(Color.WHITE ); 
         contentPane.add(btnNewButton);

         JButton button1 = new JButton("Perfom Test");
         button1.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 PregnancyTestModule bo = new PregnancyTestModule();
                 bo.setTitle("Change Password");
                 bo.setVisible(true);
             }
         });
         
         
         button1.setFont(new Font("Tahoma", Font.PLAIN, 20));
         button1.setBackground(new Color(139, 0, 0));
         button1.setForeground(Color.WHITE); 
         button1.setBounds(214, 224, 228, 50);
         contentPane.add(button1);
         
     
         
         
         JButton btnViewTestDetails = new JButton("Test Results ");
         btnViewTestDetails.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 try {
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

                     String query = "SELECT * FROM tests WHERE UserID = ?";
                     PreparedStatement statement = connection.prepareStatement(query);
                     statement.setInt(1, getUserIdByEmail(userSes));

                     ResultSet resultSet = statement.executeQuery();

                     StringBuilder testDetails = new StringBuilder();
                     while (resultSet.next()) {
                         testDetails.append("TestID: ").append(resultSet.getInt("TestID")).append("\n");
                         testDetails.append("UserID: ").append(resultSet.getInt("UserID")).append("\n");
                         String dateStringFromDB = resultSet.getString("TestDate");
                         SimpleDateFormat dateFormatFromDB = new SimpleDateFormat("dd-MM-yyyy");
                         java.util.Date utilDate = dateFormatFromDB.parse(dateStringFromDB);

                         // Convert to java.sql.Date
                         java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                         testDetails.append("TestDate: ").append(sqlDate).append("\n");
                         testDetails.append("TestResult: ").append(resultSet.getString("Result")).append("\n");
                         
                     }

                   
                     JOptionPane.showMessageDialog(UserHome.this, testDetails.toString(), "Test Details", JOptionPane.INFORMATION_MESSAGE);

                     resultSet.close();
                     statement.close();
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(UserHome.this, "Error retrieving test data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 } catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
             }

             private int getUserIdByEmail(String userSes) {
                 int userId = 0; 

                 try {
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

                     String query = "SELECT UserID FROM user WHERE Email = ?";
                     PreparedStatement statement = connection.prepareStatement(query);
                     statement.setString(1, userSes);

                     ResultSet resultSet = statement.executeQuery();

                     
                     if (resultSet.next()) {
                         userId = resultSet.getInt("UserID");
                     }

                     resultSet.close();
                     statement.close();
                     connection.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                     
                 }

                 return userId;
             }
         });

         btnViewTestDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnViewTestDetails.setBounds(714, 300, 228, 50);
         btnViewTestDetails.setBackground(new Color(139, 0, 0));
         btnViewTestDetails.setForeground(Color.WHITE);
         contentPane.add(btnViewTestDetails);
       
       
         
         
    }

    protected int getUserIdByEmail(String userSes) {
		// TODO Auto-generated method stub
		return 0;
	}


	public UserHome() {
		
	}

	private JButton createButton(String text, int fontSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
        button.setBackground(new Color(139, 0, 0));
        button.setForeground(Color.WHITE);
        return button;
    }
}