import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JMenuItem addEmployee,addRooms,addDriver;
    Dashboard(){
        setBounds(0,0,1280,700);
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1400,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1280,700);
        add(image);

        JLabel text = new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(315,70,700,50);
        text.setFont(new Font("Tahoma",Font.BOLD,38));
        image.add(text);

        JMenuBar mb = new JMenuBar();
        mb.setBounds(0,0,1280,40);
        mb.setBackground(Color.BLACK);
        image.add(mb);

        JMenu hotelManagement = new JMenu("Hotel Management");
        hotelManagement.setForeground(Color.WHITE);
        mb.add(hotelManagement);

        JMenuItem reception = new JMenuItem("Reception");
        reception.setBackground(Color.BLACK);
        reception.setForeground(Color.WHITE);
        reception.addActionListener(this);
        hotelManagement.add(reception);


        JMenu admin = new JMenu("Admin");
        admin.setForeground(Color.WHITE);
        mb.add(admin);

        addEmployee = new JMenuItem("Add Employee");
        addEmployee.setBackground(Color.BLACK);
        addEmployee.setForeground(Color.WHITE);
        addEmployee.addActionListener(this);
        admin.add(addEmployee);

        addRooms = new JMenuItem("Add Rooms");
        addRooms.setBackground(Color.BLACK);
        addRooms.setForeground(Color.WHITE);
        addRooms.addActionListener(this);
        admin.add(addRooms);

        addDriver = new JMenuItem("Add Drivers");
        addDriver.setBackground(Color.BLACK);
        addDriver.setForeground(Color.WHITE);
        addDriver.addActionListener(this);

        admin.add(addDriver);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addEmployee) {
            new AddEmployee();
        } else if (ae.getSource() == addRooms) {
            new AddRooms();
        } else if (ae.getActionCommand().equals("Reception")) {
            new Reception();
        } else if (ae.getSource() == addDriver) {
            new AddDrivers();
        }
    }
}
