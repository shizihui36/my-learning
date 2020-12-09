package com.szh.sm.frame;

import com.szh.sm.entity.Admin;
import com.szh.sm.factory.ServiceFactory;
import com.szh.sm.utils.ResultEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName AdminLoginFrame
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class AdminLoginFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField textField;
    private JPasswordField passwordField1;
    private JButton loginBtn;
    private JButton resetBtn;
    private JLabel 账号;
    private JLabel 密码;

    public AdminLoginFrame() {
        this.setTitle("AdminLoginFrame");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        loginBtn.addActionListener(e -> {
            //获取输入的账号和密码，注意密码框组件的使用方法
            String account = textField.getText().trim();
            String password = new String(passwordField1.getPassword()).trim();
            ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
            JOptionPane.showMessageDialog(mainPanel, resultEntity.getMessage());
            if (resultEntity.getCode() == 0) {
                //关闭登录界面，进入主页面
                this.dispose();
                Admin admin = (Admin) resultEntity.getData();
                new MainFrame(admin.getAdminName());
            } else {
                textField.setText("");
                passwordField1.setText("");
            }
        });

        resetBtn.addActionListener(e -> {
            textField.setText("");
            passwordField1.setText("");
        });
    }

    public static void main(String[] args) {
        new AdminLoginFrame();
    }

}