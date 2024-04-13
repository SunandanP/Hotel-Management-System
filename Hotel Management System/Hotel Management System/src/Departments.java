import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Departments extends JFrame implements ActionListener {

    Departments(){
        JTable table;
        JButton back;

            setLayout(null);
            setBounds(330,150,600,500);
            getContentPane().setBackground(Color.WHITE);

            JLabel title = new JLabel(" DEPARTMENTS INFO");
            title.setBounds(200,15,200,40);
            title.setFont(new Font("Sherif",Font.BOLD,20));
            add(title);

            JLabel l1 = new JLabel("Department");
            l1.setBounds(150,70,100,10);
            add(l1);

            JLabel l2 = new JLabel("Funds allocated");
            l2.setBounds(380,70,100,10);
            add(l2);

            table = new JTable();
            table.setBounds(50,90,500,200);
            add(table);

            back = new JButton("Back");
            back.setBounds(235,350,120,30);
            back.setBackground(Color.BLACK);
            back.setForeground(Color.WHITE);
            back.addActionListener(this);
            add(back);

            try{
                Conn conn = new Conn();
                String query = "Select job,salary from employee";
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
