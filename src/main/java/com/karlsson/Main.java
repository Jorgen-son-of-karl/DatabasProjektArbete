package com.karlsson;

import com.karlsson.util.HibernateUtil;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();

        System.out.println("Hibernate started!");

    }
}