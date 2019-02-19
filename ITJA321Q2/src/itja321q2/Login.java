/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itja321q2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author jnaud
 */
public class Login {

    registerClass rc = new registerClass();
    
    boolean myLogin(Component frame){
        JPanel p = new JPanel(new BorderLayout(5,5));
        
        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        labels.add(new JLabel("Username", SwingConstants.RIGHT));
        labels.add(new JLabel("Password", SwingConstants.RIGHT));
        p.add(labels, BorderLayout.WEST);

        JPanel controls = new JPanel(new GridLayout(0,1,2,2));
        JTextField username = new JTextField();
        controls.add(username);
        JTextField password = new JTextField();
        
        controls.add(password);
        p.add(controls, BorderLayout.CENTER);

        //LayoutManager l = new GroupLayout(p);
        //p.setLayout(l);
        
        int i = JOptionPane.showConfirmDialog(    
            frame, p, "login", JOptionPane.OK_CANCEL_OPTION);
            //System.out.println(i);   //ok gives 0, Cancle gives 2. 
            if (i == 0) {
                //figure out how to go to registerClass.
                
                return registerClass.validate_login(username.getText(), password.getText());  //returns boolean value.
                
        }else{
                
                System.out.println("Goodbye ;)");
                System.exit(0);
                return false;
                
            }
        
        
    }

    private void showLogin(JFrame frame) {
        JFrame f = new JFrame("Login Required");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f.setSize(400, 300);
        f.setResizable(false);
        f.setLocationByPlatform(true);
        f.setVisible(true);

        for (int i = 0; i < 1; i++) {
            showLogin(f);
        }
    }
}

    
    