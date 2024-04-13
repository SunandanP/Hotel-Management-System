import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {

    JLabel lblname,lblid,lblRoom,lblAvailability,lblCleaningStatus;
    Choice cname;

    JButton check,update,back;

    JTextField tfid,tfRoom,tfAvailability,tfCleaningStstus;

    UpdateRoom(){
        setLayout(null);
        setBounds(230,160,800,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("Update room status");
        title.setBounds(70,15,200,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        lblname = new JLabel("Customer name");
        lblname.setBounds(30,80,150,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblname);

        cname = new Choice();
        cname.setBounds(210,85,100,40);
        cname.setBackground(Color.WHITE);
        add(cname);

        try{
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customers");
            while (rs.next()) {
                cname.add(rs.getString("customerName"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        lblid = new JLabel("Customer ID");
        lblid.setBounds(30,130,150,25);
        lblid.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(210,131 , 100,25);
        add(tfid);

        lblRoom = new JLabel("Room number");
        lblRoom.setBounds(30,180,150,25);
        lblRoom.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(210,181 , 100,25);
        add(tfRoom);

        lblAvailability = new JLabel("Availability");
        lblAvailability.setBounds(30,230,150,25);
        lblAvailability.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblAvailability);

        tfAvailability = new JTextField();
        tfAvailability.setBounds(210,231 , 100,25);
        add(tfAvailability);

        lblCleaningStatus = new JLabel("Cleaning Status");
        lblCleaningStatus.setBounds(30,280,150,30);
        lblCleaningStatus.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblCleaningStatus);

        tfCleaningStstus = new JTextField();
        tfCleaningStstus.setBounds(210,281 , 100,25);
        add(tfCleaningStstus);


        check = new JButton("Check");
        check.setBounds(30,360,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(190,360,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(115,420,110,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(340,46,420,350);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String name = cname.getSelectedItem();
            String query = "select * from customers where customerName = '"+name+"'";
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);
                while (rs.next()){
                    tfid.setText(rs.getString("idnumber"));
                    tfRoom.setText(rs.getString("room"));
                }
                ResultSet rs2 = conn.s.executeQuery("select * from rooms where room = '"+tfRoom.getText()+"'");
                while (rs2.next()){
                    tfAvailability.setText(rs2.getString("available"));
                    tfCleaningStstus.setText(rs2.getString("status"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
            String availability = tfAvailability.getText();
            String status = tfCleaningStstus.getText();
            try{
                Conn conn = new Conn();
                conn.s.executeUpdate("update rooms set available = '"+availability+"',status = '"+status+"' where room = '"+tfRoom.getText()+"'");
                JOptionPane.showMessageDialog(null,"Data updated successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }


}
