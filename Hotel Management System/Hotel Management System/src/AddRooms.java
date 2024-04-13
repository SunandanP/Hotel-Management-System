import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {

    JTextField tfroomno,tfprice;
    JLabel lblroomno,lblprice,lblavailable,lblstatus,lblbedtype;
    JComboBox cbavailable,cbstatus,cbbedtype;

    JButton addroom,cancel;

    AddRooms(){
        setLayout(null);
        setBounds(200,160,900,490);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("ADD ROOMS");
        title.setBounds(120,30,200,40);
        title.setFont(new Font("Sherif",Font.BOLD,20));
        add(title);

        lblroomno = new JLabel("Room number");
        lblroomno.setBounds(50,100,150,30);
        lblroomno.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblroomno);

        tfroomno = new JTextField();
        tfroomno.setBounds(200,101 , 150,30);
        add(tfroomno);

        lblavailable = new JLabel("Availability");
        lblavailable.setBounds(50,150,150,30);
        lblavailable.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblavailable);

        String available[] = {"Available","Occupied"};
        cbavailable = new JComboBox<>(available);
        cbavailable.setBounds(200,151,150,30);
        cbavailable.setBackground(Color.white);
        add(cbavailable);

        lblstatus = new JLabel("Cleaning status");
        lblstatus.setBounds(50,200,150,30);
        lblstatus.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblstatus);

        String status[] = {"Cleaned","Not cleaned"};
        cbstatus = new JComboBox<>(status);
        cbstatus.setBounds(200,201,150,30);
        cbstatus.setBackground(Color.white);
        add(cbstatus);

        lblprice = new JLabel("Price");
        lblprice.setBounds(50,250,150,30);
        lblprice.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(200,251 , 150,30);
        add(tfprice);

        lblbedtype = new JLabel("Bed type");
        lblbedtype.setBounds(50,300,150,30);
        lblbedtype.setFont(new Font("Tahoma",Font.BOLD,15));
        add(lblbedtype);

        String bedtype[] = {"Single bed","Double bed"};
        cbbedtype = new JComboBox<>(bedtype);
        cbbedtype.setBounds(200,301,150,30);
        cbbedtype.setBackground(Color.white);
        add(cbbedtype);

        addroom = new JButton("Add room");
        addroom.setBounds(50,380,120,30);
        addroom.setBackground(Color.BLACK);
        addroom.setForeground(Color.WHITE);
        addroom.addActionListener(this);
        add(addroom);

        cancel = new JButton("Cancel");
        cancel.setBounds(220,380,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(370,50,500,350);
        add(image);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addroom){
            String roomNumber = tfroomno.getText();
            String availability = (String) cbavailable.getSelectedItem();
            String cleaningStatus = (String)cbstatus.getSelectedItem();
            String price = tfprice.getText();
            String bedType = (String)cbbedtype.getSelectedItem();

            try {
                Conn conn = new Conn();
                String query = "insert into rooms values('" + roomNumber + "','" + availability + "','" + cleaningStatus + "','" + price + "','" + bedType + "')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Room added successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }

}
