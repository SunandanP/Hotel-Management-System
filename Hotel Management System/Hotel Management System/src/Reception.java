import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame implements ActionListener{

    JButton newCustomerForm,rooms,Department,employeesInfo,customerInfo,managerInfo,Checkout,updateStatus,updateRoomStatus,pickupService,searchRoom,Logout;
    Reception(){

        setLayout(null);
        setBounds(300,160,695,430);
        getContentPane().setBackground(Color.WHITE);



        newCustomerForm = new JButton("New customer form");
        newCustomerForm.setBounds(20,20,150,20);
        newCustomerForm.setBackground(Color.BLACK);
        newCustomerForm.setForeground(Color.WHITE);
        newCustomerForm.addActionListener(this);
        add(newCustomerForm);

        rooms = new JButton("Rooms Info");
        rooms.setBounds(20,50,150,20);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

         Department = new JButton("Departments Info");
        Department.setBounds(20,80,150,20);
        Department.setBackground(Color.BLACK);
        Department.setForeground(Color.WHITE);
        Department.addActionListener(this);
        add(Department);

         employeesInfo = new JButton("Employees Info");
        employeesInfo.setBounds(20,110,150,20);
        employeesInfo.setBackground(Color.BLACK);
        employeesInfo.setForeground(Color.WHITE);
        employeesInfo.addActionListener(this);
        add(employeesInfo);

         customerInfo = new JButton("Customer Info");
        customerInfo.setBounds(20,140,150,20);
        customerInfo.setBackground(Color.BLACK);
        customerInfo.setForeground(Color.WHITE);
        customerInfo.addActionListener(this);
        add(customerInfo);

         managerInfo = new JButton("Manager Info");
        managerInfo.setBounds(20,170,150,20);
        managerInfo.setBackground(Color.BLACK);
        managerInfo.setForeground(Color.WHITE);
        managerInfo.addActionListener(this);
        add(managerInfo);

         Checkout = new JButton("Checkout");
        Checkout.setBounds(20,200,150,20);
        Checkout.setBackground(Color.BLACK);
        Checkout.setForeground(Color.WHITE);
        Checkout.addActionListener(this);
        add(Checkout);

         updateStatus = new JButton("Customer Status");
        updateStatus.setBounds(20,230,150,20);
        updateStatus.setBackground(Color.BLACK);
        updateStatus.setForeground(Color.WHITE);
        updateStatus.addActionListener(this);
        add(updateStatus);

         updateRoomStatus = new JButton("Update room Status");
        updateRoomStatus.setBounds(20,260,150,20);
        updateRoomStatus.setBackground(Color.BLACK);
        updateRoomStatus.setForeground(Color.WHITE);
        updateRoomStatus.addActionListener(this);
        add(updateRoomStatus);


         pickupService = new JButton("Pickup Service");
        pickupService.setBounds(20,290,150,20);
        pickupService.setBackground(Color.BLACK);
        pickupService.setForeground(Color.WHITE);
        pickupService.addActionListener(this);
        add(pickupService);

         searchRoom = new JButton("Search Room");
        searchRoom.setBounds(20,320,150,20);
        searchRoom.setBackground(Color.BLACK);
        searchRoom.setForeground(Color.WHITE);
        searchRoom.addActionListener(this);
        add(searchRoom);

         Logout = new JButton("Logout");
        Logout.setBounds(20,350,150,20);
        Logout.setBackground(Color.BLACK);
        Logout.setForeground(Color.WHITE);
        Logout.addActionListener(this);
        add(Logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,380,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel( i3);
        image.setBounds(200,20,460,350);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==newCustomerForm){
            new AddCustomer();
        }else if(ae.getSource()==rooms){
            new Rooms();
        }else if(ae.getSource()==Department){
            new Departments();
        } else if (ae.getSource()==employeesInfo) {
            new EmployeesInfo();
        } else if (ae.getSource()==customerInfo) {
            new CustomerInfo();
        } else if (ae.getSource()==managerInfo) {
            new ManagerInfo();
        } else if (ae.getSource()==Checkout) {
            new Checkout();
        } else if (ae.getSource()==searchRoom) {
            new SearchRoom();
        } else if (ae.getSource() == updateStatus) {
            new UpdateCheckout();
        } else if (ae.getSource() == updateRoomStatus) {
            new UpdateRoom();
        } else if (ae.getSource() == pickupService) {
            new PickupService();
        } else if (ae.getSource() == Logout) {
            setVisible(false);

            new Login();
        }
    }

}
