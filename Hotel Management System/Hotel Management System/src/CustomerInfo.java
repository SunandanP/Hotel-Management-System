import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {

    CustomerInfo(){

        JTable table;
        JButton back;

        setLayout(null);
        setBounds(200,140,900,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel(" CUSTOMERS INFO");
        title.setBounds(360,10,190,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        JLabel l1 = new JLabel("ID");
        l1.setBounds(50,70,100,10);
        add(l1);

        JLabel l2 = new JLabel("Number");
        l2.setBounds(150,70,100,10);
        add(l2);

        JLabel l3 = new JLabel("Name");
        l3.setBounds(250,70,100,10);
        add(l3);

        JLabel l4 = new JLabel("Gender");
        l4.setBounds(350,70,100,10);
        add(l4);

        JLabel l5 = new JLabel("Country");
        l5.setBounds(450,70,100,10);
        add(l5);

        JLabel l6 = new JLabel("Room");
        l6.setBounds(550,70,100,10);
        add(l6);

        JLabel l7 = new JLabel("Check in");
        l7.setBounds(650,70,100,10);
        add(l7);

        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(750,70,100,10);
        add(l8);

        table = new JTable();
        table.setBounds(50,90,800,200);
        add(table);

        back = new JButton("Back");
        back.setBounds(385,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try{
            Conn conn = new Conn();
            String query = "Select * from customers";
            ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch(Exception e){
            e.printStackTrace();
        }
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }

}

