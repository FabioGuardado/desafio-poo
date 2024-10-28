import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateLoginForm extends JFrame implements ActionListener {
    JButton buttonSubmit;
    JPanel formPanel;
    JLabel userLabel, passLabel;
    final JTextField textField1, textField2;

    CreateLoginForm() {
        setSize(600,280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        userLabel = new JLabel();
        userLabel.setText("Correo:");
        userLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        textField1 = new JTextField(25);
        textField1.setFont(new Font("Dialog", Font.PLAIN, 18));

        passLabel = new JLabel();
        passLabel.setText("Contraseña:");
        passLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        textField2 = new JTextField(25);
        textField2.setFont(new Font("Dialog", Font.PLAIN, 18));

        buttonSubmit = new JButton("Iniciar Sesión");
        buttonSubmit.setFont(new Font("Dialog", Font.BOLD, 18));

        SpringLayout layout = new SpringLayout();
        formPanel = new JPanel(layout);

        layout.putConstraint(SpringLayout.WEST, userLabel, 50, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, userLabel, 50, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST, textField1, 180, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, textField1, 50, SpringLayout.NORTH, formPanel);
        formPanel.add(userLabel);
        formPanel.add(textField1);

        layout.putConstraint(SpringLayout.WEST, passLabel, 50, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, passLabel, 100, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST, textField2, 180, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, textField2, 100, SpringLayout.NORTH, formPanel);
        formPanel.add(passLabel);
        formPanel.add(textField2);

        layout.putConstraint(SpringLayout.WEST, buttonSubmit, 220, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.NORTH, buttonSubmit, 160, SpringLayout.NORTH, formPanel);
        formPanel.add(buttonSubmit);

        add(formPanel, BorderLayout.CENTER);

        buttonSubmit.addActionListener(this);
        setTitle("Acceder a Mediateca");
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String userValue = textField1.getText();
        String passValue = textField2.getText();
        
        try {
            MysqlConnection connection = new MysqlConnection();
            Connection dbConnection = connection.getConnection();

            String query = "SELECT * FROM usuario WHERE correo = ? AND password = ?";
            PreparedStatement st = dbConnection.prepareStatement(query);
            st.setString(1, userValue);
            st.setString(2, passValue);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CreateMenu menu = new CreateMenu();
                menu.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas", "Error de autenticación",2);
            }
            connection.disconnect();
        } catch (SQLException e) {
            
        }
    }
}
