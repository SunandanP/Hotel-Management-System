import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField name;
    JPasswordField pass;
    JButton login,cancel;

    Login(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(375,175,550,300);
        setLayout(null);


        JLabel userName = new JLabel("userName");
        userName.setBounds(50,50,100,30);
        add(userName);

        name = new JTextField();
        name.setBounds(170,51,150,30);
        add(name);

        JLabel password = new JLabel("password");
        password.setBounds(50,100,100,30);
        add(password);

        pass = new JPasswordField();
        pass.setBounds(170,101,150,30);
        add(pass);

        login = new JButton("Login");
        login.setBounds(50,170,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,170,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330,0,200,270);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
        String userName = name.getText();
        String passWord = pass.getText();

            try{
                Conn c = new Conn();
                String query = "select * from login where username = '"+userName+"' and password ='"+ passWord+"'";
                //taking userName and passWord single quotes bcz sql will take username and password values in single quote
                ResultSet rs = c.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
//                    setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancel){
            setVisible(false);

        }
    }
}




