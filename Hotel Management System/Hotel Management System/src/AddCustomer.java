import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel lblid,lblname,lblnumber,lblcountry,lblgender,lblroom,lblcheckin,time,lbldeposit;
    JComboBox cbid;

    Choice croom;
    JTextField tfname,tfnumber,tfcountry,tfdeposit;

    JRadioButton rbmale,rbfemale;

    JButton addCustomer,cancel;

    AddCustomer(){
        setLayout(null);
        setBounds(250,160,800,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("New Customer Form");
        title.setBounds(120,15,200,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        lblid = new JLabel("ID");
        lblid.setBounds(50,70,150,30);
        lblid.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblid);

        String id[] = {"Passport","Aadhar","Voter's ID","Driving licence"};
        cbid = new JComboBox<>(id);
        cbid.setBounds(200,71,150,30);
        cbid.setBackground(Color.WHITE);
        add(cbid);

        lblnumber = new JLabel("Number");
        lblnumber.setBounds(50,110,150,30);
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(200,111 , 150,30);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(50,150,150,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,151 , 150,30);
        add(tfname);

        lblgender = new JLabel("Gender");
        lblgender.setBounds(50,190,100,30);
        lblgender.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblgender);

        rbmale = new JRadioButton("Male");
        rbmale.setBounds(190,191,75,30);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(265,191,75,30);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(50,230,150,30);
        lblcountry.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(200,231 , 150,30);
        add(tfcountry);

        lblroom = new JLabel("Allocated room");
        lblroom.setBounds(50,270,150,30);
        lblroom.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblroom);

//        String room[] = {"Passport","Aadhar","Voter's ID","Driving licence"};
        croom = new Choice();

        try{
            Conn conn = new Conn();
            String query = "select * from rooms where available = 'Available'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("room"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        croom.setBounds(200,275,150,25);
        croom.setBackground(Color.WHITE);
        add(croom);

        lblcheckin = new JLabel("Check in time");
        lblcheckin.setBounds(50,310,150,30);
        lblcheckin.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblcheckin);

        Date date = new Date();

        time = new JLabel(""+date);
        time.setBounds(200,310,150,30);
        time.setFont(new Font("Tahoma",Font.BOLD,12));
        add(time);

        lbldeposit = new JLabel("Deposit");
        lbldeposit.setBounds(50,350,150,30);
        lbldeposit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200,351 , 150,30);
        add(tfdeposit);

        addCustomer = new JButton("Add Customer");
        addCustomer.setBounds(50,410,120,30);
        addCustomer.setBackground(Color.BLACK);
        addCustomer.setForeground(Color.WHITE);
        addCustomer.addActionListener(this);
        add(addCustomer);

        cancel = new JButton("Cancel");
        cancel.setBounds(230,410,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(400,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,30,400,400);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addCustomer){
            String id = (String) cbid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;

            if(rbfemale.isSelected()){
                gender = "female";
            } else if (rbmale.isSelected()) {
                gender = "male";
            }

            String country = tfcountry.getText();
            String room = croom.getSelectedItem();
            String checkin = time.getText();
            String deposit = tfdeposit.getText();

            try{
                Conn conn = new Conn();
                String query = "insert into customers values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+checkin+"','"+deposit+"');";
                //to add customer in customers table
                String query2 = "update rooms set available = 'Occupied' where room = '"+room+"'";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Customer added successfully");
                setVisible(false);
//                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
//            new Reception();
        }
    }
}
