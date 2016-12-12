/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.afritrend.common.Model;

import java.io.Serializable;

/**
 *
 * @author Xavier
 */
public class UsersModel implements Serializable, Cloneable{

    private String firstname;
    private String middlename;
    private String lastname;
    private String office_tel;
    private String home_tel;
    private String last_login;
    private int password_retries;
    private String designation;
    private String email;
    private String password;
    private String status;
    private String reset_password_Key;
    private String test_Question;
    private String answer;
    private String datecreated;
    private String datemodified;
    private String createdby;
    private int fK_idusergroup;
    private int fK_iddepartment;

    public UsersModel() {
    }

    public UsersModel(String firstname, String middlename, String lastname, String office_tel, String home_tel, String last_login, int password_retries, String designation, String email, String password, String status, String reset_password_Key, String test_Question, String answer, String datecreated, String datemodified, String createdby, int fK_idusergroup, int fK_iddepartment) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.office_tel = office_tel;
        this.home_tel = home_tel;
        this.last_login = last_login;
        this.password_retries = password_retries;
        this.designation = designation;
        this.email = email;
        this.password = password;
        this.status = status;
        this.reset_password_Key = reset_password_Key;
        this.test_Question = test_Question;
        this.answer = answer;
        this.datecreated = datecreated;
        this.datemodified = datemodified;
        this.createdby = createdby;
        this.fK_idusergroup = fK_idusergroup;
        this.fK_iddepartment = fK_iddepartment;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getOffice_tel() {
        return office_tel;
    }

    public void setOffice_tel(String office_tel) {
        this.office_tel = office_tel;
    }

    public String getHome_tel() {
        return home_tel;
    }

    public void setHome_tel(String home_tel) {
        this.home_tel = home_tel;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public int getPassword_retries() {
        return password_retries;
    }

    public void setPassword_retries(int password_retries) {
        this.password_retries = password_retries;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReset_password_Key() {
        return reset_password_Key;
    }

    public void setReset_password_Key(String reset_password_Key) {
        this.reset_password_Key = reset_password_Key;
    }

    public String getTest_Question() {
        return test_Question;
    }

    public void setTest_Question(String test_Question) {
        this.test_Question = test_Question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getDatemodified() {
        return datemodified;
    }

    public void setDatemodified(String datemodified) {
        this.datemodified = datemodified;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public int getfK_idusergroup() {
        return fK_idusergroup;
    }

    public void setfK_idusergroup(int fK_idusergroup) {
        this.fK_idusergroup = fK_idusergroup;
    }

    public int getfK_iddepartment() {
        return fK_iddepartment;
    }

    public void setfK_iddepartment(int fK_iddepartment) {
        this.fK_iddepartment = fK_iddepartment;
    }

    @Override
    public String toString() {
        return "UsersModel{" + "firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", office_tel=" + office_tel + ", home_tel=" + home_tel + ", last_login=" + last_login + ", password_retries=" + password_retries + ", designation=" + designation + ", email=" + email + ", password=" + password + ", status=" + status + ", reset_password_Key=" + reset_password_Key + ", test_Question=" + test_Question + ", answer=" + answer + ", datecreated=" + datecreated + ", datemodified=" + datemodified + ", createdby=" + createdby + ", fK_idusergroup=" + fK_idusergroup + ", fK_iddepartment=" + fK_iddepartment + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
   
}
