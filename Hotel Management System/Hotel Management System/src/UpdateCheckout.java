import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheckout extends JFrame implements ActionListener {

    JLabel lblname,lblid,lblRoom,lblAmountPaid,lblPendingAmount,lblCheckin;
    Choice cname;

    JButton check,update,back;

    JTextField tfid,tfRoom,tfAmountPaid,tfPendingAmount,tfCheckin;
    UpdateCheckout(){

        setLayout(null);
        setBounds(250,160,800,500);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("Update status");
        title.setBounds(120,15,200,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        lblname = new JLabel("Customer name");
        lblname.setBounds(50,80,150,30);
        lblname.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblname);

        cname = new Choice();
        cname.setBounds(230,85,150,40);
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
        lblid.setBounds(50,130,150,25);
        lblid.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(230,131 , 150,25);
        add(tfid);

        lblRoom = new JLabel("Room number");
        lblRoom.setBounds(50,180,150,25);
        lblRoom.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblRoom);

        tfRoom = new JTextField();
        tfRoom.setBounds(230,181 , 150,25);
        add(tfRoom);

        lblAmountPaid = new JLabel("Amount paid");
        lblAmountPaid.setBounds(50,230,150,25);
        lblAmountPaid.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblAmountPaid);

        tfAmountPaid = new JTextField();
        tfAmountPaid.setBounds(230,231 , 150,25);
        add(tfAmountPaid);

        lblPendingAmount = new JLabel("Pending amount");
        lblPendingAmount.setBounds(50,280,150,30);
        lblPendingAmount.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblPendingAmount);

        tfPendingAmount = new JTextField();
        tfPendingAmount.setBounds(230,281 , 150,25);
        add(tfPendingAmount);

        lblCheckin = new JLabel("Checkin time");
        lblCheckin.setBounds(50,330,150,30);
        lblCheckin.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblCheckin);

        tfCheckin = new JTextField();
        tfCheckin.setBounds(230,331 , 150,25);
        add(tfCheckin);

        check = new JButton("Check");
        check.setBounds(50,410,100,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.addActionListener(this);
        add(check);

        update = new JButton("Update");
        update.setBounds(160,410,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        back = new JButton("Back");
        back.setBounds(270,410,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(390,90,380,300);
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
                    tfAmountPaid.setText(rs.getString("deposit"));
                    tfCheckin.setText(rs.getString("checkin"));
                }
                ResultSet rs2 = conn.s.executeQuery("select * from rooms where room = '"+tfRoom.getText()+"'");
                while (rs2.next()){
                    String price = rs2.getString("price");
                    int amountPending = Integer.parseInt(price) - Integer.parseInt(tfAmountPaid.getText());
                    tfPendingAmount.setText(""+amountPending);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == update) {
                String newAmountPaid = tfAmountPaid.getText();
                try{
                    Conn conn = new Conn();
                    conn.s.executeUpdate("update customers set deposit = '"+newAmountPaid+"' where room = '"+tfRoom.getText()+"'");
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
