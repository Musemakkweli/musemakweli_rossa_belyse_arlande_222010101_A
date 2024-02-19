package Online_Pregnancy_Test_System;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PregnancyTestModule extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private List<String> questions;
    private List<JTextField> responseFields;
    private JTextField userIdField;

    public static void main(String[] args) {
        PregnancyTestModule frame = new PregnancyTestModule();
        frame.setVisible(true);
    }

    public PregnancyTestModule() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pregnancy Test Module");
        setBounds(150, 5, 1014, 710);
        setResizable(true);

        contentPane = new JPanel();
        contentPane.setBackground(Color.pink);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPregnancyTest = new JLabel("PREGNANCY TEST");
        lblPregnancyTest.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 35));
        lblPregnancyTest.setForeground(new Color(139, 0, 0));
        lblPregnancyTest.setBounds(362, 40, 325, 50);
        contentPane.add(lblPregnancyTest);

        JLabel lblUserId = new JLabel("User ID:");
        lblUserId.setFont(new Font("Georgia", Font.PLAIN, 17));
        lblUserId.setBounds(58, 100, 99, 29);
        contentPane.add(lblUserId);

        userIdField = new JTextField();
        userIdField.setFont(new Font("Bookman Old Style", Font.PLAIN, 13));
        userIdField.setBounds(610, 100, 328, 30);
        contentPane.add(userIdField);
        userIdField.setColumns(10);

        
        questions = fetchQuestionsFromDatabase();

        
        responseFields = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            int questionNumber = i + 1;  
            
            JLabel questionLabel = new JLabel(questionNumber + ". " + questions.get(i));
            
            
            if (i % 2 == 0) {
                questionLabel.setForeground(Color.black);
            } else {
                questionLabel.setForeground(Color.GRAY);
            }

            questionLabel.setFont(new Font("Footlight MT Light", Font.PLAIN, 17));
            questionLabel.setBounds(58, 140 + i * 30, 500, 29);
            contentPane.add(questionLabel);

            JTextField responseField = new JTextField();

            
            if (i % 2 == 0) {
                responseField.setBackground(Color.GRAY);
            } else {
                responseField.setBackground(Color.lightGray);
            }

            responseField.setFont(new Font("Footlight MT Light", Font.PLAIN, 13));
            responseField.setBounds(610, 140 + i * 30, 328, 25);

            
            responseField.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

            contentPane.add(responseField);
            responseFields.add(responseField);
        }

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                saveResponseToDatabase();
            }
        });
        btnSubmit.setFont(new Font("Algerian", Font.PLAIN, 22));
        btnSubmit.setBounds(430,623,220,30);
        btnSubmit.setBackground(new Color(139, 0, 0));
        btnSubmit.setForeground(Color.WHITE);
        contentPane.add(btnSubmit);

        JLabel copyrightLabel = new JLabel("\u00a9 2024 MUSEMAKWELI ROSSA BELYSE ARLANDE  - (ONLINE PREGNANCY TEST System) . All rights reserved.");
        copyrightLabel.setForeground(Color.GRAY);
        copyrightLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        copyrightLabel.setBounds(154, 637, 705, 50);
        contentPane.add(copyrightLabel);
    }

    private List<String> fetchQuestionsFromDatabase() {
        List<String> questions = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

            String query = "SELECT question_text FROM questions";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                questions.add(resultSet.getString("question_text"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return questions;
    }

    private void saveResponseToDatabase() {
        try {
            int userId = Integer.parseInt(userIdField.getText());

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musemakweli_rossa_belyse_arlande_opts", "222010101", "222010101");

            
            for (int i = 0; i < responseFields.size(); i++) {
                String response = responseFields.get(i).getText();
                String query = "INSERT INTO user_responses (UserID, question_id, response) " +
                        "VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, userId);
                statement.setInt(2, i + 1);  
                statement.setString(3, response);

                statement.executeUpdate();
                statement.close();
            }

            JOptionPane.showMessageDialog(contentPane, "Responses submitted successfully");
            connection.close();
        } catch (NumberFormatException | SQLException ex) {
            JOptionPane.showMessageDialog(contentPane, "Error submitting responses: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
