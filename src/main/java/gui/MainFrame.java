package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JTextField email;
    private JPasswordField password;
    private JTextField phone;

    private JButton okBtn;
    private JButton clearBtn;

    public void launchFrame() {
        this.setBounds(100, 100, 300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Send and Receive Emails via MSM");
        this.setBackground(Color.WHITE);
        this.setResizable(false);

        this.email = new JTextField(15);
        this.password = new JPasswordField(15);
        this.phone = new JTextField(15);
        this.okBtn = new JButton("OK");
        this.clearBtn = new JButton("Clear");

        this.setLayout(new GridLayout(4, 1));
        JPanel panel1 =  new JPanel();
        panel1.add(new JLabel("E-mail:  "));
        panel1.add(email);
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Password:  "));
        panel2.add(password);
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("Phone:  "));
        panel3.add(phone);
        JPanel panel4 = new JPanel();
        panel4.add(okBtn);
        panel4.add(clearBtn);

        ButtonListener listener = new ButtonListener();
        this.okBtn.addActionListener(listener);
        this.clearBtn.addActionListener(listener);

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);

        this.setVisible(true);
    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource() == okBtn) {
                Main.setPhone(phone.getText());
                Main.setEmail(email.getText());
                Main.setPassword(new String(password.getPassword()));
            } else {
                phone.setText("");
                email.setText("");
                password.setText("");
            }
        }
    }

}
