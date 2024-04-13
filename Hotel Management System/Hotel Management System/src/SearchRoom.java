import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back,search;

    JComboBox cbbedType;

    JCheckBox cbOnlyDisplayAvailable;


    SearchRoom(){
        setLayout(null);
        setBounds(250,150,750,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("SEARCH ROOMS");
        title.setBounds(230,10,200,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        JLabel lblbedType = new JLabel("Select bed type :");
        lblbedType.setBounds(40,70,130,30);
        add(lblbedType);

        String bedType[] = {"Single bed","Double bed","Any"};
        cbbedType = new JComboBox<>(bedType);
        cbbedType.setBounds(170,70,130,30);
        add(cbbedType);

        JLabel lblOnlyDisplayAvailable = new JLabel("Display only available :");
        lblOnlyDisplayAvailable.setBounds(440,70,150,30);
        add(lblOnlyDisplayAvailable);

        cbOnlyDisplayAvailable = new JCheckBox();
        cbOnlyDisplayAvailable.setBounds(600,70,20,30);
        add(cbOnlyDisplayAvailable);

        table = new JTable();
        table.setBounds(50,150,640,200);
        add(table);

        JLabel l1 = new JLabel("Room no.");
        l1.setBounds(50,130,100,10);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(180,130,100,10);
        add(l2);

        JLabel l3 = new JLabel("Cleaning status");
        l3.setBounds(310,130,100,10);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(440,130,100,10);
        add(l4);

        JLabel l5 = new JLabel("Occupancy");
        l5.setBounds(570,130,100,10);
        add(l5);

        search = new JButton("Search");
        search.setBounds(175,400,120,30);
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
            if(cbOnlyDisplayAvailable.isSelected()){
                if(cbbedType.getSelectedItem()=="Single bed"){
                    String query = "Select * from rooms where available='Available' and beds = 'Single bed'";
                    try{
                        Conn conn = new Conn();
                        ResultSet rs = conn.s.executeQuery(query);
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else if (cbbedType.getSelectedItem()=="Double bed") {
                    String query = "Select * from rooms where available='Available' and beds = 'Double bed'";
                    try{
                        Conn conn = new Conn();
                        ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else if(cbbedType.getSelectedItem()=="Any"){
                    String query = "Select * from rooms where available='Available'";
                    try{
                        Conn conn = new Conn();
                        ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }else{
                if(cbbedType.getSelectedItem()=="Single bed"){
                    String query = "Select * from rooms where beds = 'Single bed'";
                    try{
                        Conn conn = new Conn();
                        ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else if (cbbedType.getSelectedItem()=="Double bed") {
                    String query = "Select * from rooms where beds = 'Double bed'";
                    try{
                        Conn conn = new Conn();
                        ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                } else if(cbbedType.getSelectedItem()=="Any"){
                    String query = "Select * from rooms";
                    try{
                        Conn conn = new Conn();
                        ResultSet rs = conn.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }else{
            setVisible(false);
        }
    }
}
