import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener {

    JTable table;
    JButton back;
    Rooms(){
        setLayout(null);
        setBounds(330,150,600,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("ALL ROOMS");
        title.setBounds(230,10,200,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        table = new JTable();
        table.setBounds(50,90,500,200);
        add(table);

        JLabel l1 = new JLabel("Room no.");
        l1.setBounds(50,70,100,10);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(150,70,100,10);
        add(l2);

        JLabel l3 = new JLabel("Cleaning status");
        l3.setBounds(250,70,100,10);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(350,70,100,10);
        add(l4);

        JLabel l5 = new JLabel("Occupancy");
        l5.setBounds(450,70,100,10);
        add(l5);

        back = new JButton("Back");
        back.setBounds(235,350,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        try{
            Conn conn = new Conn();
            String query = "Select * from rooms";
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
