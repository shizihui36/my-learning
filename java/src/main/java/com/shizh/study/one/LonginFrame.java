package com.shizh.study.one;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName LonginFrame
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/9
 **/
public class LonginFrame extends JFrame {
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JPanel buttonPanel;
    private JPanel rightPanel;
    private JPanel leftPanel;
    private JPanel logoPanel;
    private JPanel loginPanel;
    private JButton loginButton;
    private JTextField accountTextField;
    private JPasswordField passwordTextField;
    private JLabel login;
    private JPasswordField passwordField;

    public LonginFrame() {
        loginButton.addActionListener(e -> {
              LoginService ll = new LoginService();
              String account = accountTextField.getText();
              char[] password = passwordField.getPassword();
              String passString = new String(password);
              boolean result = ll.login(account,passString);
              if (result){
                  JOptionPane.showMessageDialog(null,"登录成功");
              }
        });
    }



    private void init() {
        setTitle("LoginFrame");
        setContentPane(mainPanel);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       setVisible(true);
   }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LonginFrame");
        frame.setContentPane(new LonginFrame().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}