import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {

    JTextField tfname,tfage,tfsalary,tfphone,tfgmail,tfaadhar;
    JLabel lblname,lblage,lblgender,lbljob,lblsalary,lblphone,lblgmail,image,lblaadhar;
    JRadioButton rbmale,rbfemale;
    JComboBox cbjob;

    JButton submit;


    AddEmployee(){
        setLayout(null);
        setBounds(250,160,750,490);
        getContentPane().setBackground(Color.WHITE);

        lblname = new JLabel("Name");
        lblname.setBounds(70,30,100,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190,31 , 150,30);
        add(tfname);

        lblage = new JLabel("Age");
        lblage.setBounds(70,70,100,30);
        lblage.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(190,71 , 150,30);
        add(tfage);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(70,110,100,30);
        lblgender.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(190,110,75,30);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(265,110,75,30);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);

        lbljob = new JLabel("Job");
        lbljob.setBounds(70,150,100,30);
        lbljob.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbljob);

        String str[] = {"Clerk","Porter","Housekeeping","Kitchen staff","Room service","Chef","Waiter/waitres","Manager","Accountant"};
        cbjob = new JComboBox<>(str);
        cbjob.setBounds(190,151,150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);

        lblsalary = new JLabel("Salary");
        lblsalary.setBounds(70,190,100,30);
        lblsalary.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblsalary);

        tfsalary = new JTextField();
        tfsalary.setBounds(190,191 , 150,30);
        add(tfsalary);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(70,230,100,30);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(190,231 , 150,30);
        add(tfphone);

        lblgmail = new JLabel("Gmail");
        lblgmail.setBounds(70,270,100,30);
        lblgmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblgmail);

        tfgmail = new JTextField();
        tfgmail.setBounds(190,271 , 150,30);
        add(tfgmail);

        lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(70,310,100,30);
        lblaadhar.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(190,311 , 150,30);
        add(tfaadhar);

        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.black);
        submit.addActionListener(this);
        submit.setBounds(190,390 , 150,30);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(350,30,400,400);
        add(image);



        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String phone = tfphone.getText();
        String aadhar = tfaadhar.getText();
        String gmail = tfgmail.getText();
        String salary = tfsalary.getText();
        String age = tfage.getText();

        String gender = null;
        if(rbmale.isSelected()){
            gender = "Male";
        } else if (rbfemale.isSelected()) {
            gender = "Female";
        }

        String job = (String) cbjob.getSelectedItem();

        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name field cannot be empty");
            return ;
        }

        try{
            Conn conn = new Conn();
            String query = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+gmail+"','"+aadhar+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
