import javax.swing.*;
import java.awt.*;

public class CreateMenu extends JFrame {
    CreateMenu()  {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menú Mediateca");
        setSize(600, 600);

        JLabel userRoleId = new JLabel();
        userRoleId.setText("Rol del usuario: " + Globals.getUserRole());
        JPanel menuPanel = new JPanel();

        menuPanel.add(userRoleId);

        add(menuPanel, BorderLayout.CENTER);
    }
}
