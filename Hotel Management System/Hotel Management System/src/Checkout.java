import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {

    Choice cname;
    JLabel lblname,lblRoomNumber,lblCheckinTime,lblCheckoutTime;

    JButton checkout,back,search;
    Checkout(){
        setLayout(null);
        setBounds(250,160,800,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("Checkout");
        title.setBounds(130,15,200,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        lblname = new JLabel("Customer name");
        lblname.setBounds(30,80,150,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblname);

        cname = new Choice();
        cname.setBounds(200,85,150,40);
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

        JLabel lblRoom = new JLabel("Room number");
        lblRoom.setBounds(30,140,150,25);
        lblRoom.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblRoom);

        lblRoomNumber = new JLabel();
        lblRoomNumber.setBounds(200,140,150,25);
        lblRoomNumber.setFont(new Font("Tahoma",Font.BOLD,11));
        add(lblRoomNumber);

        JLabel lblCheckin = new JLabel("Checkin Time");
        lblCheckin.setBounds(30,200,150,25);
        lblCheckin.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblCheckin);

        lblCheckinTime = new JLabel();
        lblCheckinTime.setBounds(200,200,150,25);
        lblCheckinTime.setFont(new Font("Tahoma",Font.BOLD,11));
        add(lblCheckinTime);

        JLabel lblCheckout = new JLabel("Checkout Time");
        lblCheckout.setBounds(30,260,150,25);
        lblCheckout.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblCheckout);

        Date date = new Date();
        lblCheckoutTime = new JLabel(""+date);
        lblCheckoutTime.setBounds(200,260,150,25);
        lblCheckoutTime.setFont(new Font("Tahoma",Font.BOLD,11));
        add(lblCheckoutTime);

        search = new JButton("Search");
        search.setBounds(30,350,140,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);

        checkout = new JButton("Checkout");
        checkout.setBounds(210,350,140,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        back = new JButton("Back");
        back.setBounds(120,400,140,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(381,82,380,330);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            try{
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("Select * from customers where customerName = '"+cname.getSelectedItem()+"' ");
                while (rs.next()){
                    lblRoomNumber.setText(rs.getString("room"));
                    lblCheckinTime.setText(rs.getString("checkin"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == checkout){
            String query1 = "Delete from customers where customerName = '"+cname.getSelectedItem()+"' ";
            String query2 = "update rooms set available = 'Available' where room = '"+lblRoomNumber+"'";

            try{
                Conn conn = new Conn();
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"Checkout successful");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == back){
            setVisible(false);
        }
    }

}
