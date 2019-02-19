/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itja321q2;

/**
 *
 * @author jnaud
 */
public class Student {
    String name;
    String surName;
    int StudentNo;
    String subject;

    public Student(String name, String surName, int StudentNo, String subject) {
        this.name = name;
        this.surName = surName;
        this.StudentNo = StudentNo;
        this.subject = subject;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(int StudentNo) {
        this.StudentNo = StudentNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
    
}
