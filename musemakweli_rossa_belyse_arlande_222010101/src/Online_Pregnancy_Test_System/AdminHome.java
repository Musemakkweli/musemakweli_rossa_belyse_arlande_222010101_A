package Online_Pregnancy_Test_System;



import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author ARLANDE  With certified Copyright.
 */


public class AdminHome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea notificationTextArea;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminHome frame = new AdminHome();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AdminHome(String adminSes) {
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 setTitle("...                                                                           HOME PAGE FOR ADMIN                        OPTS (ONLINE PREGNANCY TEST SYSTEM )                 ...");
    	 setBounds(180, 50, 1014, 597);
         setResizable(true);
         contentPane = new JPanel();
         contentPane.setBackground(Color.pink);
         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
         setContentPane(contentPane);
         contentPane.setLayout(null);
         
         JLabel lblNewUserRegister = new JLabel(" ADMIN DASHBOARD");
         lblNewUserRegister.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 43));
         lblNewUserRegister.setForeground(new Color(139, 0, 0)); 
         lblNewUserRegister.setBounds(362, 18, 350, 80);
         contentPane.add(lblNewUserRegister);
         
         
         //A button to view profile
         JButton btnViewDetails = new JButton("View Your Data");
         btnViewDetails.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 try {
                     
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

                     
                     String query = "SELECT * FROM admin WHERE email = ?";
                     PreparedStatement statement = connection.prepareStatement(query);
                     statement.setString(1, adminSes);

                     
                     ResultSet resultSet = statement.executeQuery();

                     
                     StringBuilder adminData = new StringBuilder();
                     while (resultSet.next()) {
                         adminData.append("AdminID: ").append(resultSet.getInt("AdminID")).append("\n");
                         adminData.append("Name: ").append(resultSet.getString("Name")).append("\n");
                         adminData.append("Email: ").append(resultSet.getString("Email")).append("\n");
                         adminData.append("Role: ").append(resultSet.getString("Role")).append("\n");
                         adminData.append("Password: ").append(resultSet.getString("Password")).append("\n");

                         
                     }

                     
                     JOptionPane.showMessageDialog(AdminHome.this, adminData.toString(), "Admin Details", JOptionPane.INFORMATION_MESSAGE);

                    
                     resultSet.close();
                     statement.close();
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(AdminHome.this, "Error retrieving admin data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
             }
         });
         btnViewDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnViewDetails.setBounds(214, 410, 228, 50);
         btnViewDetails.setBackground(new Color(139, 0, 0));
         btnViewDetails.setForeground(Color.WHITE ); 
         contentPane.add(btnViewDetails);
         
         
         JButton btnViewTable = new JButton("View Table Data");
         btnViewTable.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 try {
                     
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

                     
                     DatabaseMetaData metaData = (DatabaseMetaData) connection.getMetaData();
                     ResultSet tablesResultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
                     List<String> tableNames = new ArrayList<>();
                     while (tablesResultSet.next()) {
                         String tableName = tablesResultSet.getString("TABLE_NAME");
                         tableNames.add(tableName);
                     }
                     tablesResultSet.close();

                     
                     String selectedTable = (String) JOptionPane.showInputDialog(AdminHome.this, "Select a table to view data:", "Select Table",
                             JOptionPane.QUESTION_MESSAGE, null, tableNames.toArray(), tableNames.get(0));

                     
                     String query = "SELECT * FROM " + selectedTable;
                     PreparedStatement statement = connection.prepareStatement(query);

                     ResultSet resultSet = statement.executeQuery();

                    
                     StringBuilder tableData = new StringBuilder();
                     ResultSetMetaData metaData1 = resultSet.getMetaData();
                     int columnCount = metaData1.getColumnCount();
                     while (resultSet.next()) {
                         for (int i = 1; i <= columnCount; i++) {
                             String columnName = metaData1.getColumnName(i);
                             String columnValue = resultSet.getString(i);
                             tableData.append(columnName).append(": ").append(columnValue).append("\n");
                         }
                         tableData.append("\n");
                     }

                    
                     JTextArea textArea = new JTextArea(20, 40);
                     textArea.setText(tableData.toString());
                     textArea.setEditable(false);
                     JScrollPane scrollPane = new JScrollPane(textArea);
                     scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                     JOptionPane.showMessageDialog(AdminHome.this, scrollPane, "Table Data: " + selectedTable, JOptionPane.INFORMATION_MESSAGE);

                     
                     resultSet.close();
                     statement.close();
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(AdminHome.this, "Error retrieving table data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                 }
             }
         });
         btnViewTable.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnViewTable.setBounds(454, 410, 228, 50);
         btnViewTable.setBackground(new Color(139, 0, 0));
         btnViewTable.setForeground(Color.WHITE);
         contentPane.add(btnViewTable);
         
         
         JButton btnDeleteTest = new JButton("Delete Test");
         btnDeleteTest.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 try {
                     
                     Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts",
                             "222010101", "222010101");
                     String testIdToDelete = JOptionPane.showInputDialog(AdminHome.this, "Enter the TestID to delete:");
                     int testId = Integer.parseInt(testIdToDelete);
                     String deleteTestQuery = "DELETE FROM tests WHERE TestID = ?";
                     PreparedStatement deleteTestStatement = connection.prepareStatement(deleteTestQuery);
                     deleteTestStatement.setInt(1, testId);

                     int testRowsDeleted = deleteTestStatement.executeUpdate();
                     if (testRowsDeleted > 0) {
                         JOptionPane.showMessageDialog(AdminHome.this, "Test record deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                     } else {
                         JOptionPane.showMessageDialog(AdminHome.this, "No test record found for deletion.", "No Data", JOptionPane.INFORMATION_MESSAGE);
                     }
                     deleteTestStatement.close();
                     connection.close();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                     JOptionPane.showMessageDialog(AdminHome.this, "Error deleting test record: " + ex.getMessage(), "Error",
                             JOptionPane.ERROR_MESSAGE);
                 } catch (NumberFormatException ex) {
                     JOptionPane.showMessageDialog(AdminHome.this, "Invalid TestID. Please enter a valid numeric value.", "Error",
                             JOptionPane.ERROR_MESSAGE);
                 }
             }
         });

         btnDeleteTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnDeleteTest.setBounds(707, 300, 228, 50);
         btnDeleteTest.setBackground(new Color(139, 0, 0));
         btnDeleteTest.setForeground(Color.WHITE);
         contentPane.add(btnDeleteTest);
         
         

         JButton btnNewButton = new JButton("Logout");
         btnNewButton.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 int a = JOptionPane.showConfirmDialog(btnNewButton, "Are you sure?");
                 if (a == JOptionPane.YES_OPTION) {
                     dispose();
                     AdminLogin obj = new AdminLogin();
                     obj.setTitle("Admin-Login");
                     obj.setVisible(true);
                 }
             }
         });
         btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnNewButton.setBounds(454, 480, 228, 50);
         btnNewButton.setBackground(new Color(139, 0, 0));
         btnNewButton.setForeground(Color.WHITE ); 
         contentPane.add(btnNewButton);

         JButton button = new JButton("Change password");
         button.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 ChangePassword bo = new ChangePassword(adminSes);
                 bo.setTitle("Change Password");
                 bo.setVisible(true);
             }
         });
         button.setFont(new Font("Tahoma", Font.PLAIN, 20));
         button.setBackground(new Color(139, 0, 0));
         button.setForeground(Color.WHITE); 
         button.setBounds(454, 300, 228, 50);
         contentPane.add(button);
         
         
         JButton btnPregnancyTestModule = new JButton("Pregnancy Test");
         btnPregnancyTestModule.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 PregnancyTestModule pregnancyTestModule = new PregnancyTestModule();
                 pregnancyTestModule.setTitle("pregnancy Test Module ");
                 pregnancyTestModule.setVisible(true);
             }
         });
         btnPregnancyTestModule.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnPregnancyTestModule.setBackground(new Color(139, 0, 0));
         btnPregnancyTestModule.setForeground(Color.WHITE); 
         btnPregnancyTestModule.setBounds(214, 300, 228, 50);
         contentPane.add(btnPregnancyTestModule);
         
         JButton btnUserRegistration = new JButton("Register User");
         btnUserRegistration.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
            	 UserRegistration userRegistration = new UserRegistration();
            	 userRegistration.setTitle("User Registration ");
            	 userRegistration.setVisible(true);
             }
         });
         btnUserRegistration.setFont(new Font("Tahoma", Font.PLAIN, 20));
         btnUserRegistration.setBackground(new Color(139, 0, 0));
         btnUserRegistration.setForeground(Color.WHITE); 
         btnUserRegistration.setBounds(214, 200, 228, 50);
         contentPane.add(btnUserRegistration);
         
       
         JButton btnUpdateData = new JButton("Update Your Data");
         btnUpdateData.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 AdminUpdateDataForm updateForm = new AdminUpdateDataForm(adminSes);
                 updateForm.setVisible(true);
             }
         });
         btnUpdateData.setFont(new Font("Tahoma", Font.PLAIN, 16));
         btnUpdateData.setBounds(707, 410, 228, 50);
         btnUpdateData.setBackground(new Color(139, 0, 0));
         btnUpdateData.setForeground(Color.WHITE ); 
         contentPane.add(btnUpdateData);
         
         JButton btnResult = new JButton("Insert Result");
         btnResult.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 ResultsForm resultsForm = new ResultsForm();
                 resultsForm.setVisible(true);
             }
         });
         btnResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
         btnResult.setBounds(707, 200, 228, 50);
         btnResult.setBackground(new Color(139, 0, 0));
         btnResult.setForeground(Color.WHITE ); 
         contentPane.add(btnResult);
         
         
         
      //  Copyright notice
         JLabel copyrightLabel = new JLabel("\u00a9 2024 MUSEMAKWELI ROSSA BELYSE ARLANDE  - (ONLINE PREGNANCY TEST System) . . All rights reserved.");
         copyrightLabel.setForeground(Color.GRAY);
         copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
         copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
         copyrightLabel.setBounds(10, 540, 974, 20); 
         contentPane.add(copyrightLabel);
    }

    protected int getUserIdByEmail(String userEmailToDelete) {
		// TODO Auto-generated method stub
		return 0;
	}

	public AdminHome() {
		// TODO Auto-generated constructor stub
	}

	private JButton createButton(String text, int fontSize) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.PLAIN, fontSize));
        button.setBackground(new Color(139, 0, 0));
        button.setForeground(Color.WHITE);
        return button;
    }
}

