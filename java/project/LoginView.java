package project;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class LoginView extends JFrame{
    public LoginView() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("login");
        
        setLayout(new FlowLayout());
        JButton sign_in_button = new JButton("로그인");
        JButton sign_up_button = new JButton("회원가입");
        
        this.add(sign_in_button);
        this.add(sign_up_button);
        setVisible(true);
    }
}
