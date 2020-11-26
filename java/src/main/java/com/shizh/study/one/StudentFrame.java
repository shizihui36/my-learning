package com.shizh.study.one;

import com.shizh.study.week2.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.swing.*;

@Builder
@Data
@AllArgsConstructor

/**
 * @ClassName StudentFrame
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/7
 **/
public class StudentFrame {
    private JPanel mainPanle;
    private JButton button3;
    private JButton button4;
    private JPanel centerPanel;
    private JPanel topPanel;
    private JButton button1;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JPanel leftPanel;
    private JTextField nameTextField;
    private JTextField weightField;
    private JButton 检查Button;

    public StudentFrame() {
        检查Button.addActionListener(e -> {
            //点击按钮需要做的逻辑
            System.out.println("click");
            String name = nameTextField.getText();
            String weight = weightField.getText();
          //  Student student = Student.builder().name(name).weight(Integer.parseInt(weight)).build();
           // StudentService ss = new  StudentServiceImpl();

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("StudentFrame");
        frame.setContentPane(new StudentFrame().mainPanle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        //frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private class StudentServiceImpl {
    }
}
