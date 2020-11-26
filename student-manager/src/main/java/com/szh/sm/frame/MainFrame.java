package com.szh.sm.frame;

import com.szh.sm.entity.Department;
import com.szh.sm.factory.ServiceFactory;
import com.szh.sm.utils.AliOSSUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class MainFrame extends JFrame {
    private JPanel Panel;
    private JPanel topPanel;
    private JButton 院系管理Button;
    private JButton 班级管理Button;
    private JButton 学生管理Button;
    private JButton 奖惩管理Button;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel classPanel;
    private JPanel studentPanel;
    private JPanel rewardPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel buttonPanel;
    private JPanel addPanel;
    private JTextField depNameField;
    private JButton 选择图片Button;
    private JPanel toolPanel;
    private JButton 新增院系Button;
    private JButton 切换显示Button;
    private JPanel contentPanel;
    private JLabel logoLabel;
    private JButton 新增Button;
    private javax.swing.JPanel JPanel;
    private JComboBox depCombobox;
    private JTextField searchField;
    private JButton 新增班级Button;
    private JPanel treePanel;
    private final CardLayout c;

    private String uploadedFileUrl;
    private File file;

    public MainFrame(){
        init();
//        院系管理Button.setOpaque(false);
//        班级管理Button.setOpaque(false);
//        学生管理Button.setOpaque(false);
//        奖惩管理Button.setOpaque(false);
        c= new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1",departmentPanel);
        centerPanel.add("2",classPanel);
        centerPanel.add("3",studentPanel);
        centerPanel.add("4",rewardPanel);


        院系管理Button.addActionListener(e -> {
               c.show(centerPanel,"1");
        });

        班级管理Button.addActionListener(e -> {
            c.show(centerPanel,"2");
        });

        学生管理Button.addActionListener(e -> {
             c.show(centerPanel,"3");
        });

        奖惩管理Button.addActionListener(e -> {
            c.show(centerPanel,"4");
        });
        showDepartments();

        新增院系Button.addActionListener(e -> {
              boolean visible = addPanel.isVisible();
              //不可见
            if (! visible){
                leftPanel.setPreferredSize(new Dimension(180,this.getHeight()-100));
                addPanel.setVisible(true);
            }else {
                leftPanel.setPreferredSize(new Dimension(60,this.getHeight()-100));
                addPanel.setVisible(false);
            }
            leftPanel.revalidate();
        });

        depNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depNameField.setText("");
            }
        });

        选择图片Button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            //默认打开路径
            fileChooser.setCurrentDirectory(new File("C:/Users/Lenovo/Desktop/java"));
            //对话框显示的范围在centerPanel内
            int result = fileChooser.showOpenDialog(centerPanel);
            if (result == JFileChooser.APPROVE_OPTION){
                //选中文件
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                //创建icon对象
                ImageIcon icon = new ImageIcon(name);
                logoLabel.setPreferredSize(new Dimension(60,60));
                //图片强制缩放成和JLabel一样大小
                URL url;
                icon = new ImageIcon(icon.getImage().getScaledInstance(logoLabel.getWidth(),logoLabel.getHeight(),Image.SCALE_DEFAULT));
            }
        });

        新增Button.addActionListener(e -> {
            //上传文件到OSS并返回url
            uploadedFileUrl = AliOSSUtil.ossUpload(file);
            //创建Department对象，并设置相应属性
            Department department = new Department();
            department.setDepartmentName(depNameField.getText().trim());
            department.setLogo(uploadedFileUrl);
            //调用service实现新增功能
            int n = ServiceFactory.getDepartmentServiceInstance().addDepartment(department);
            if (n == 1){
                JOptionPane.showMessageDialog(centerPanel,"新增院系成功");
                //新增成功后，将侧边栏隐藏
                leftPanel.setPreferredSize(new Dimension(60,this.getHeight()-100));
                addPanel.setVisible(false);
                //刷新界面数据
                showDepartments();
                //清空文本框
                depNameField.setText("");
                logoLabel.setIcon(null);
            }else {
                JOptionPane.showMessageDialog(centerPanel,"新增院系失败");
            }
        });
    }


    private void showDepartments(){
        //移除原有数据
        //从service层获取到所有的院系列表

        contentPanel.removeAll();
        List<Department> departmentList= ServiceFactory.getDepartmentServiceInstance().selectAll();
        //获取总数
        int len = departmentList.size();
        //根据院系总数算出行数
        int row = len % 4 == 0 ? len / 4:len / 4 + 1;
        //创建一个网络布局，每行4列，指定水平和垂直间距
        GridLayout gridLayout = new GridLayout(row,4,15,15);
        contentPanel.setLayout(gridLayout);
        for (Department department : departmentList){
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(300,300));
            depPanel.setLayout(new FlowLayout(FlowLayout.CENTER,15,10));
            //depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            JLabel nameLabel = new JLabel(department.getDepartmentName());
            //新建一个JLabel标签，用来放置院系logo，并指定大小
          depPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));

            JLabel logoLabel = new JLabel("<html><img src = '" + department.getLogo() + "'width = '150' height = '150'/><ml>");
            //占位空白标签
            JLabel blankLabel = new JLabel();
            blankLabel.setPreferredSize(new Dimension(200,30));
            //删除按钮
            JButton delBtn = new JButton("删除");
            //院系名称标签加入院系面板
              delBtn.addActionListener(e -> {
                  int n = ServiceFactory.getDepartmentServiceInstance().delDepartment(department,department.getId());
                  if (n == 1){
                      JOptionPane.showMessageDialog(centerPanel,"删除院系成功");
                      showDepartments();
                  }else {
                      JOptionPane.showMessageDialog(centerPanel,"删除院系失败");
                  }
              });
//            depPanel.add(nameLabel);
            // 图标标签加入院系面板
            depPanel.add(logoLabel);
//            depPanel.add(delBtn);
            //院系面板加入主体内容面板
            contentPanel.add(depPanel);

            //按钮加入院系面板
            depPanel.add(delBtn);

            //刷新主体内容面板
            contentPanel.revalidate();
        }
    }
    public void init(){

        this.setContentPane(Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //窗体关闭
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);  //窗体全屏
        this.setVisible(true);     //窗体可见
    }



    public static void main(String[] args) {
        new MainFrame();
    }
}