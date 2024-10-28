import javax.swing.*;

public class App {
    public static void main(String[] args) {
        try {
            CreateLoginForm loginForm = new CreateLoginForm();
            loginForm.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}