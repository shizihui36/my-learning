package com.szh.sm.frame;

import com.szh.sm.component.CustomPanel;
import com.szh.sm.entity.Clazz;
import com.szh.sm.entity.Department;
import com.szh.sm.factory.ServiceFactory;
import com.szh.sm.task.TimeThread;
import com.szh.sm.utils.AliOSSUtil;
import com.szh.sm.utils.FormatUtil;
import com.szh.sm.vo.StudentVo;
import sun.swing.table.DefaultTableCellHeaderRenderer;


import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import java.util.List;

/**
 * @ClassName MainFrame
 * @Description TODO
 * @Author Lenovo
 * @Date 2020/11/15
 **/
public class MainFrame extends JFrame {
    private  String adminName;
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
    private JPanel buttomPanel;
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
    private JComboBox<Department> depCombobox;
    private JTextField searchField;
    private JButton 新增班级Button;
    private JPanel treePanel;
    private JPanel classContentPanel;
    private JPanel tPanel;
    private JComboBox<Department> departmentJBox;
    private JComboBox<Clazz> clazzJBox;
    private JTextField searchField2;
    private JButton 搜索Button;
    private JButton 批量导入Button;
    private JButton 新增学生Button;
    private JPanel tablePanel;
    private JLabel timeLabel;
    private JButton 重置Button;

    /**
     * 自定义变量
     */
    private String uploadedFileUrl;
    private File file;
    private int departmentId = 0;
    private final CardLayout c;
    private List<StudentVo> students;

    private CustomPanel stuInfoPanel;
    private JLabel idLabel;
    private JLabel avatar;
    private JTextField depName;
    private JTextField className;
    private JTextField stuName;
    private JLabel gender;
    private JLabel birthday;
    private JTextField phone;
    private JTextField address;
    private JButton editBtn;
    private JButton delBtn;
    private Container mainPanel;

    public MainFrame(String adminName){
        //时间线程
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        this.adminName = adminName;

        init();
        院系管理Button.setOpaque(false);
        班级管理Button.setOpaque(false);
        学生管理Button.setOpaque(false);
        奖惩管理Button.setOpaque(false);
        c= new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("1",departmentPanel);
        centerPanel.add("2",classPanel);
        centerPanel.add("3",studentPanel);
        centerPanel.add("4",rewardPanel);


        院系管理Button.addActionListener(e -> {
               c.show(centerPanel,"1");
               showDepartments();
        });

        班级管理Button.addActionListener(e -> {
            c.show(centerPanel,"2");
            showClazz();
        });

        学生管理Button.addActionListener(e -> {
             c.show(centerPanel,"3");
            //学生数据填充表格
            showStudentTable(ServiceFactory.getStudentServiceInstance().selectAll());

            //初始化院系下拉框数据,第一条数据为提示信息
            departmentJBox.addItem(Department.builder().departmentName("请选择院系").build());
            List<Department> departments = ServiceFactory.getDepartmentServiceInstance().selectAll();
            for (Department department : departments) {
                departmentJBox.addItem(department);
            }


            //两个下拉框初始化提示数据，因为里面元素都是对象，所以这样进行了处理
            Department tip1 = new Department();
            tip1.setDepartmentName("请选择院系");
            departmentJBox.addItem(tip1);
            Clazz tip2 = new Clazz();
            tip2.setClassName("请选择班级");
            clazzJBox.addItem(tip2);
            //初始化院系下拉框数据
            List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
            for (Department department : departmentList) {
                departmentJBox.addItem(department);
            }
            //初始化班级下拉框数据
            List<Clazz> clazzList = (List<Clazz>) ServiceFactory.getClazzServiceInstance().selectAll();
            for (Clazz clazz : clazzList) {
                clazzJBox.addItem(clazz);
            }
            //院系下拉框监听，选中哪项，表格中显示该院系所有学生，并级联查出该院系的所有班级，更新到班级下拉框
            departmentJBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        int index = departmentJBox.getSelectedIndex();
                        //排除第一项，那是提示信息，不能作为查询依据
                        if (index != 0) {
                            departmentId = departmentJBox.getItemAt(index).getId();
                            //获取该院系的学生并显示在表格中
                            List<StudentVo> studentList = ServiceFactory.getStudentServiceInstance().selectByDepId(departmentId);
                            showStudentTable(studentList);
                            //二级联动—班级下拉框的内容随着选择院系的不同而变化
                            List<Clazz> clazzes = ServiceFactory.getClazzServiceInstance().getClazzByDepId(departmentId);
                            //一定要先移除之前的数据，否则下拉框内容会叠加
                            clazzJBox.removeAllItems();
                            Clazz tip = new Clazz();
                            tip.setClassName("请选择班级");
                            clazzJBox.addItem(tip);
                            for (Clazz clazz : clazzes) {
                                clazzJBox.addItem(clazz);
                            }
                        }
                    }
                }
            });
//             showStudents();
            //班级下拉框监听，可以根据选中的班级显示所有学生
            clazzJBox.addItemListener(e1 -> {
                if (e1.getStateChange() == ItemEvent.SELECTED) {
                    int index = clazzJBox.getSelectedIndex();
                    if (index != 0) {
                        int classId = clazzJBox.getItemAt(index).getId();
                        List<StudentVo> studentList = ServiceFactory.getStudentServiceInstance().selectByClassId(classId);
                        showStudentTable(studentList);
                    }
                }
            });
            //右侧个人信息面板
            CustomPanel stuInfoPanel = new CustomPanel("C:/Users/Lenovo/Desktop/图片/1.jpg");
            stuInfoPanel.setPreferredSize(new Dimension(300, 600));
            stuInfoPanel.setLayout(null);
            stuInfoPanel.repaint();
            studentPanel.add(stuInfoPanel, BorderLayout.EAST);
            JLabel title = new JLabel("学生信息");
            title.setFont(new Font("楷体",Font.BOLD,20));

            //学号
            idLabel = new JLabel("学生信息");
            idLabel.setFont(new Font("楷体", Font.BOLD, 20));
            idLabel.setForeground(new Color(97, 174, 239));
            idLabel.setBounds(100, 50, 100, 50);
            //头像
            avatar = new JLabel();
            avatar.setText("<html><img src='https://bpic.588ku.com/element_origin_min_pic/19/04/09/e3330d623cad123abc8545573a86cc38.jpg' width=50 height=50/></html>");
            avatar.setBounds(120, 110, 50, 50);
            //院系
            depName = new JTextField("未选择");
            depName.setBounds(50, 170, 200, 40);
            //班级
            className = new JTextField("未选择");
            className.setBounds(50, 220, 200, 40);
            //姓名
            stuName = new JTextField("未选择");
            stuName.setBounds(50, 270, 200, 40);
            //性别
            gender = new JLabel("未选择");
            gender.setBounds(50, 320, 200, 40);
            //生日
            birthday = new JLabel("未选择");
            birthday.setBounds(50, 370, 200, 40);
            //电话
            phone = new JTextField("未选择");
            phone.setBounds(50, 420, 200, 40);
            //地址
            address = new JTextField("未选择");
            address.setBounds(50, 470, 200, 40);
            //编辑按钮
            editBtn = new JButton("编辑");
            editBtn.setBounds(60, 520, 90, 40);
            //删除按钮
            delBtn = new JButton("删除");
            delBtn.setBounds(160, 520, 90, 40);

            delBtn.addActionListener(ee -> {
                ServiceFactory.getStudentServiceInstance().deleteById(idLabel.getText());
                JOptionPane.showMessageDialog(null, "删除成功");
                showStudentTable(ServiceFactory.getStudentServiceInstance().selectAll());
                reset();
            });
            stuInfoPanel.add(idLabel);
            stuInfoPanel.add(avatar);
            stuInfoPanel.add(depName);
            stuInfoPanel.add(className);
            stuInfoPanel.add(stuName);
            stuInfoPanel.add(gender);
            stuInfoPanel.add(birthday);
            stuInfoPanel.add(phone);
            stuInfoPanel.add(address);
            stuInfoPanel.add(editBtn);
            stuInfoPanel.add(delBtn);

        });

        搜索Button.addActionListener(e ->{
            students = ServiceFactory.getStudentServiceInstance().selectByKeywords(searchField.getText().trim());
            showStudentTable(students);
            searchField.setText("");
        });

        奖惩管理Button.addActionListener(e -> {
            c.show(centerPanel,"4");
        });


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
        //院系名称文本框焦点监听
        depNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
        });
        选择图片Button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            //默认打开路径
            fileChooser.setCurrentDirectory(new File("C:/Users/Lenovo/Desktop/java/"));
            //对话框显示的范围在centerPanel内
            int result = fileChooser.showOpenDialog(centerPanel);
            if (result == JFileChooser.APPROVE_OPTION){
                //选中文件
                file = fileChooser.getSelectedFile();
                String name = file.getAbsolutePath();
                //创建icon对象
                ImageIcon icon = new ImageIcon(name);
                logoLabel.setPreferredSize(new Dimension(150,150));
                //图片强制缩放成和JLabel一样大小

              icon = new ImageIcon(icon.getImage().getScaledInstance(logoLabel.getWidth(),logoLabel.getHeight(),Image.SCALE_DEFAULT));
              logoLabel.setIcon(icon);
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

        depNameField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                depNameField.setText("");
            }
        });
        //获得下拉框选中的院系id
         depCombobox.addActionListener(e -> {
             int index = depCombobox.getSelectedIndex();
           departmentId = depCombobox.getItemAt(index).getId();
         });


        新增班级Button.addActionListener(e -> {
            Clazz clazz = new Clazz();
            clazz.setDepartmentId(departmentId);
            clazz.setClassName(searchField.getText().trim());
            int n = ServiceFactory.getClazzServiceInstance().addClazz(clazz);
            if (n == 1){
                JOptionPane.showMessageDialog(centerPanel,"新增班级成功");
                searchField.setText("");
                showClazz();
            }else {
                JOptionPane.showMessageDialog(centerPanel,"新增班级失败");
            }
        });

        重置Button.addActionListener(e ->{
            reset();
        });

        新增学生Button.addActionListener(e ->{
            new AddStudentFrame(MainFrame.this);
            MainFrame.this.setEnabled(true);
        });
    }
    private void reset() {
        //还原表格数据
        List<StudentVo> studentList = ServiceFactory.getStudentServiceInstance().selectAll();
        showStudentTable(studentList);
        //院系下拉框还原
        departmentJBox.setSelectedIndex(0);
        //班级下拉框还原
        clazzJBox.setSelectedIndex(0);
        Clazz tip2 = new Clazz();
        clazzJBox.addItem(tip2);
        List<Clazz> clazzList = (List<Clazz>) ServiceFactory.getClazzServiceInstance().selectAll();
        for (Clazz clazz : clazzList) {
            clazzJBox.addItem(clazz);
        }
        //右侧个人信息显示区域数据还原
        avatar.setText("<html><img src='https://bpic.588ku.com/element_origin_min_pic/19/04/09/e3330d623cad123abc8545573a86cc38.jpg' width=50 height=50/></html>");
        idLabel.setText("未选择");
        depName.setText("未选择");
        className.setText("未选择");
        stuName.setText("未选择");
        gender.setText("未选择");
        birthday.setText("未选择");
        address.setText("");
        phone.setText("");
        searchField.setText("");
    }


   

    private void showStudents() {
        CustomPanel stuInfoPanel = new CustomPanel("C:/Users/Lenovo/Desktop/java/555.jpg");
        stuInfoPanel.setPreferredSize(new Dimension(300,600));
        JLabel title = new JLabel("学生信息");
        title.setFont(new Font("楷体",Font.BOLD,20));
        title.setForeground(new Color(97,174,239));
        stuInfoPanel.add(title);
        stuInfoPanel.repaint();
        studentPanel.add(stuInfoPanel,BorderLayout.EAST);

        //获取学生列表
        List<StudentVo> students = ServiceFactory.getStudentServiceInstance().selectAll();
        //创建表格对象
        JTable table = new JTable();
        //创建表格数据模型，并设置给表格
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //设置表头内容
        model.setColumnIdentifiers(new String[]{"学号","院系","班级","姓名","性别","地址","手机号","出生日期","头像"});
        //遍历list，生成Object数组，数组中的每个元素就是一行数据
        for (StudentVo student : students){
            Object[] object = new Object[]{
                    student.getId(),student.getDepartmentName(),student.getClassName(),student.getStudentName(),
                    student.getGender(),student.getAddress(),student.getPhone(),student.getBirthday(),student.getAvatar()
            };
            //添加到数据模型
            model.addRow(object);
        }
        //设置最后一列不显示在表格中（头像）
        TableColumn tc = table.getColumnModel().getColumn(8);
        tc.setMaxWidth(0);
        tc.setMinWidth(0);
        //获取表格的表头
        JTableHeader header = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        header.setDefaultRenderer(hr);
        //设置表头字体
        header.setPreferredSize(new Dimension(header.getWidth(),40));
        header.setFont(new Font("楷体",Font.PLAIN,18));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(223,241,234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class,r);
        //表格加入滚动面板，并设置水平和垂直方向均可按需滚动
        JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);

        //表格内容监听，根据点击的行得到不同的数据
        table.getSelectionModel().addListSelectionListener(e ->{
            int row = table.getSelectedRow();
            JOptionPane.showMessageDialog(null,table.getValueAt(row,2).toString()+table.getValueAt(row,3).toString());
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
                  int n = ServiceFactory.getDepartmentServiceInstance().delete(department.getId());
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
//    public void init(){
//
//        this.setContentPane(Panel);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //窗体关闭
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);  //窗体全屏
//        this.setVisible(true);     //窗体可见
//    }

    public void init() {
        this.setTitle("管理员：" + this.adminName);
        this.setContentPane(Panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        showDepartments();
    }
    private void showClazz(){
        List<Department> departments = ServiceFactory.getDepartmentServiceInstance().selectAll();
            showClazz(departments);
            showCombobox(departments);
            showTree(departments);
}
    private void showCombobox(List<Department> departments){
        for (Department department:departments){
            depCombobox.addItem(department);
        }
}
    private void showTree(List<Department> departments){
        treePanel.removeAll();
        //左侧树组件
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("南京工业职业技术大学");
    for (Department department: departments){
        //院系名称作为一级叶子节点
        DefaultMutableTreeNode group = new DefaultMutableTreeNode(department.getDepartmentName());
        //加入根节点，构成一棵树
        root.add(group);
        List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClazzByDepId(department.getId());
        for (Clazz clazz : clazzList){
            //班级结点加入对应到院系结点
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(clazz.getClassName());
            group.add(node);
        }
    }
        //以root为根生成树
    final  JTree tree = new JTree(root);
    tree.setRowHeight(30);
    tree.setFont(new Font("微软雅黑",Font.PLAIN,14));
    treePanel.add(tree,BorderLayout.CENTER);
    treePanel.revalidate();
}
    private void showClazz(List<Department> departments){
        classContentPanel.removeAll();
        classContentPanel.setLayout(new GridLayout(0,5,15,15));
        Font titleFont = new Font("微软雅黑", Font.PLAIN, 16);
        for (Department department : departments){
            JPanel depPanel = new JPanel();
            depPanel.setPreferredSize(new Dimension(120,150));
            depPanel.setBackground(new Color(63,98,131));
            depPanel.setLayout(new BorderLayout());
            JLabel depNameLabel = new JLabel(department.getDepartmentName());
            depNameLabel.setFont(titleFont);
            depNameLabel.setForeground(new Color(255,255,255));
            depPanel.add(depNameLabel,BorderLayout.NORTH);
            List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().getClazzByDepId(department.getId());
            DefaultListModel<Clazz> listModel = new DefaultListModel<>();
            for (Clazz clazz : clazzList){
                listModel.addElement(clazz);
            }
            JList<Clazz> jList = new JList<>(listModel);
            jList.setBackground(new Color(101,134,184));
            JScrollPane scrollPane = new JScrollPane(jList);
            depPanel.add(scrollPane,BorderLayout.CENTER);
            classContentPanel.add(depPanel);

            //对每个JList增加弹出菜单
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem modifyItem = new JMenuItem("修改");
            JMenuItem deleteItem = new JMenuItem("删除");
            jPopupMenu.add(modifyItem);
            jPopupMenu.add(deleteItem);
            jList.add(jPopupMenu);

            jList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //选中项下标
                    int index = jList.getSelectedIndex();
                    //点击鼠标右键
                    if (e.getButton() == 3){
                        //在鼠标位置弹出菜单
                        jPopupMenu.show(jList,e.getX(),e.getY());
                        //取出选中项的班级对象数据
                        Clazz clazz = jList.getModel().getElementAt(index);
                        //对“删除”菜单项添加事件监听
                        deleteItem.addActionListener(e1 -> {
                            int choice = JOptionPane.showConfirmDialog(depPanel,"确定删除吗？");
                            //点击了“确定”
                            if (choice == 0){
                                //根据当前班级的id删除
                                int n = ServiceFactory.getClazzServiceInstance().deleteClazz(clazz.getId());
                                if (n == 1){
                                    //从list数据模型中移除当前项，先从视觉上看到删除效果
                                    listModel.remove(index);
                                    //走后端重新调用下数据
                                    showTree(ServiceFactory.getDepartmentServiceInstance().selectAll());
                                }
                            }
                        });
                    }
                }
            });
        }
     }
    public void showStudentTable(List<StudentVo> studentList) {
        tablePanel.removeAll();
        //创建表格
        JTable table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"学号", "院系", "班级", "姓名", "性别", "地址", "手机号", "出生日期", "头像"});
        //遍历List,转成Object数组
        for (StudentVo student : studentList) {
            Object[] object = new Object[]{student.getId(), student.getDepartmentName(), student.getClassName(), student.getStudentName(), student.getGender(), student.getAddress(), student.getPhone(), student.getBirthday(), student.getAvatar()};
            model.addRow(object);
        }
        //将最后一列隐藏头像地址不显示在表格中
        TableColumn tc = table.getColumnModel().getColumn(8);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);
        //获得表头
        JTableHeader head = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        head.setDefaultRenderer(hr);
        //设置表头大小
        head.setPreferredSize(new Dimension(head.getWidth(), 40));
        //设置表头字体
        head.setFont(new Font("楷体", Font.PLAIN, 16));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(223, 241, 234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板,水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);
        tablePanel.revalidate();
        //表格内容选择监听，点击一行，在右边显示这个学生信息
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            idLabel.setText(table.getValueAt(row, 0).toString());
            depName.setText(table.getValueAt(row, 1).toString());
            className.setText(table.getValueAt(row, 2).toString());
            stuName.setText(table.getValueAt(row, 3).toString());
            gender.setText(FormatUtil.formatGender((Short) table.getValueAt(row, 4)));
            address.setText(table.getValueAt(row, 5).toString());
            phone.setText(table.getValueAt(row, 6).toString());
            birthday.setText(table.getValueAt(row, 7).toString());
            avatar.setText("<html><img src='" + table.getValueAt(row, 8).toString() + "' width=50 height=50/></html>");
        });
    }

    public static void main(String[] args) {

        new MainFrame("石子慧");
    }
}