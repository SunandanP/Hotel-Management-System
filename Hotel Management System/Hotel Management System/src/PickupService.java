import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickupService extends JFrame implements ActionListener {

    JTable table;
    JButton back,search;

    Choice carModel;



    PickupService(){
        setLayout(null);
        setBounds(250,150,750,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("SEARCH DRIVERS");
        title.setBounds(250,10,200,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        JLabel lblbedType = new JLabel("Select car model :");
        lblbedType.setBounds(40,70,130,30);
        add(lblbedType);


        carModel = new Choice();
        carModel.setBounds(170,75,130,30);
        add(carModel);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("Select * from drivers");
            while (rs.next()) {
                carModel.add(rs.getString("carModel"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        table.setBounds(50,150,650,200);
        add(table);

        JLabel l1 = new JLabel("Name");
        l1.setBounds(55,130,90,12);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(150,130,90,12);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(240,130,90,12);
        add(l3);

        JLabel l4 = new JLabel("Company");
        l4.setBounds(335,130,90,12);
        add(l4);

        JLabel l5 = new JLabel("Model");
        l5.setBounds(425,130,90,12);
        add(l5);

        JLabel l6 = new JLabel("Available");
        l6.setBounds(520,130,90,12);
        add(l6);

        JLabel l7 = new JLabel("Location");
        l7.setBounds(612,130,90,12);
        add(l7);

        search = new JButton("Search");
        search.setBounds(170,400,120,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        back = new JButton("Back");
        back.setBounds(455,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == search){
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("Select * from drivers where carModel = '"+carModel.getSelectedItem()+"' ");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }
}
