package org.example;
import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        manage hotel = new manage(5);
        out.println(hotel.Rooms());
        Guest g1 = new Guest("Vasya");
        Guest g2 = new Guest("Petya");
        String b = hotel.checkInOne(g1);
        out.println(b);
        out.println(hotel.checkInOne(g2,3));
        Guest [] group1 = new Guest[4];
        Guest a1 = new Guest("Lera");
        Guest a2 = new Guest("Katya");
        Guest a3 = new Guest("Tolya");
        Guest a4 = new Guest("Ben");
        group1[0] = a1;
        group1[1] = a2;
        group1[2] = a3;
        group1[3] = a4;
        out.println(hotel.checkInGroup(group1));
        out.println(hotel.Rooms());
        out.print(hotel.checkOutOne(1));
        hotel.checkOutOne(2);
        hotel.checkOutOne(3);
        hotel.checkOutOne(4);
        out.println(hotel.checkOutOne(5));
        Family a = new Family(3, "Ivanov");
        out.println(hotel.checkInFam(a));
        Family p = new Family(3,"Smirnov");
        out.println(hotel.checkInFam(p));
        hotel.checkOut("Ivanov");
        hotel.checkOut("Smirnov");
        out.println(hotel.Rooms());
        out.println(hotel.checkInOneWithPets(g1,3));
        hotel.checkOut("Vasya");
        out.println(hotel.Rooms());
        out.println(hotel.checkInFamWithPets(p,2));
        out.println(hotel.Rooms());
        hotel.checkInOneWithPets(g2,3);
        hotel.checkOutOne(1);
        hotel.checkOutOne(2);
        hotel.checkOutOne(3);
        hotel.checkOutOne(4);
        hotel.checkOutOne(5);
        out.print(hotel.checkInGroupWithPets(group1));
        hotel.checkInGroupTYT(group1,3);
        hotel.checkOutOne(1);
        out.print(hotel.Rooms());




    }
}