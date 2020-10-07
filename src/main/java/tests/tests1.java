package tests;

import manager.CustomerManager;

import java.text.ParseException;


public class tests1 {

    public static void main(String[] args) throws ParseException {
        CustomerManager cm = new CustomerManager();
        System.out.println("--------- TEST ----------\n");
        cm.insert();
        cm.consult();
        cm.edit();
        cm.remove();
        cm.consult();
    }
}
