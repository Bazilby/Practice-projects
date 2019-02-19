/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itja321q2;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author jnaud
 */
public class main {

    private static JFrame f;
    private static JFrame ff;
    public static Connection conn;        //this test connection and displays message dialog box.
    public static Statement st;
    public static int num;
    public static JTextField jtf_name = new JTextField();

    public static registerClass rc;

    public static JTextField tf_stud_number;
    public static JTextField tf_stud_name;
    public static JTextField tf_stud_surname;
    public static JTextField tf_stud_subject;

    public static int numlimit;
    public static String Student_name;
    public static String Student_surname;
    public static String Student_subject;
    public static int Student_number;
    public static Student[] studentList;

    public static void main(String[] args) {

        Login aLogin = new Login();
        rc = new registerClass();
        if (aLogin.myLogin(f)) {
            System.out.println(true);
            studentpresent();
        } else {
            System.out.println("false");
        }
        rc.disconnect_db();  //disconnect the db.
    }

    private static void clearTextfield() {
        tf_stud_number.setText("");
        tf_stud_name.setText("");
        tf_stud_surname.setText("");
        tf_stud_subject.setText("");
    }

    private static int studentpresent() {
        int result;
        Student student;
        Student newStudent;

        String number = JOptionPane.showInputDialog("How many students are in you class?", num);
        System.out.println(number); //this prints out 0.
        numlimit = Integer.parseInt(number);
        System.out.println(numlimit);

        studentList = new Student[numlimit];
        JPanel jp = new JPanel();
        jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));

        tf_stud_number = new JTextField();
        tf_stud_name = new JTextField();
        tf_stud_surname = new JTextField();
        tf_stud_subject = new JTextField();

        jp.add(new JLabel("Student Number:"));
        jp.add(tf_stud_number);
        jp.add(new JLabel("Student Name:"));
        jp.add(tf_stud_name);
        jp.add(new JLabel("Student Surname:"));
        jp.add(tf_stud_surname);
        jp.add(new JLabel("Subject:"));
        jp.add(tf_stud_subject);

        Object[] options = {"ADD", "CANCEL ALL"};
        //num is number of loops of input Dialog box.
        for (int y = 0; y < numlimit; y++) {
            clearTextfield();   //call this method.
            result = JOptionPane.showOptionDialog(null, jp, "head", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            System.out.println(result);
            switch (result) {
                case 0:
                    try {
                        Student_name = tf_stud_name.getText().trim();
                        Student_surname = tf_stud_surname.getText().trim();
                        Student_subject = tf_stud_subject.getText().trim();
                        Student_number = Integer.parseInt(tf_stud_number.getText().trim());  //integer.parseInt is needed to convert int to Strring.

                        newStudent = new Student(Student_name, Student_surname, Student_number, Student_subject);
                        studentList[y] = newStudent;   //this is where the problem is.

                    } catch (ArrayIndexOutOfBoundsException aie) {
                        displayMessage("Error", "Array is the wrong size", JOptionPane.ERROR_MESSAGE);
                        aie.printStackTrace();
                    
                    } catch (NumberFormatException nfe) {
                        displayMessage("Error", "Invalid number", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                        nfe.printStackTrace();

                    } catch (NullPointerException npe) {
                        npe.printStackTrace();
                        displayMessage("Error", "No student number entered.", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                    break;
                case 1:
                    numlimit = 0;
                    break;
                default:
                    numlimit = 0;
                    break;
            }
        }
        rc.insertDetails(studentList);
        return numlimit;
    }

    public static void displayMessage(String head, String body, int type) {
        JOptionPane.showMessageDialog(null, body, head, type);
    }

}
