package com.loja;
import java.sql.Date;

public class Main {
    public static void main(String args[]) throws Exception {
    Menu menu = new Menu();
    Produto p1 = new Produto("Coca-cola 2L", 12.90, 10, Date.valueOf("2027-10-12"));
    menu.acessarMenu(p1);

    }
}
