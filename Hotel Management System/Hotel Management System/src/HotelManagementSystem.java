import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {
    HotelManagementSystem(){
//        setSize(1200,565);
//        setLocation(50,50);
        setBounds(50,50,1200,565);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0,0,1200,565);
        add(image);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,460,600,60);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Serif",Font.PLAIN,35));
        image.add(text);

        JButton empty = new JButton(" ");
        empty.setBounds(200,150,1,1);
        image.add(empty);

        JButton next = new JButton("Next");
        next.setBounds(865,450,100,30);
//        next.setBackground();
        next.setForeground(Color.MAGENTA);
        next.setBackground(Color.black);
        next.setFont(new Font("Serif",Font.PLAIN,18));
        next.addActionListener(this);
        image.add(next);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
}
