package org.example;

public class Test {
    public static void main(String[] args) {
        manage hotel = new manage(5);
        hotel.Rooms();
        Guest g1 = new Guest("Vasya");
        Guest g2 = new Guest("Petya");
        hotel.checkInOne(g1);
        hotel.checkInOne(g2,3);
        Guest [] group1 = new Guest[4];
        Guest a1 = new Guest("Lera");
        Guest a2 = new Guest("Katya");
        Guest a3 = new Guest("Tolya");
        Guest a4 = new Guest("Ben");
        group1[0] = a1;
        group1[1] = a2;
        group1[2] = a3;
        group1[3] = a4;
        hotel.checkInGroup(group1);
        hotel.Rooms();
        hotel.checkOutOne(1);
        hotel.checkOutOne(2);
        hotel.checkOutOne(3);
        hotel.checkOutOne(4);
        hotel.checkOutOne(5);
        Family a = new Family(3, "Ivanov");
        hotel.checkInFam(a);
        Family p = new Family(3,"Smirnov");
        hotel.checkInFam(p);
        hotel.checkOut("Ivanov");
        hotel.checkOut("Smirnov");
        hotel.Rooms();
        hotel.checkInOneWithPets(g1,3);
        hotel.checkOut("Vasya");
        hotel.Rooms();
        hotel.checkInFamWithPets(p,2);
        hotel.Rooms();
        hotel.checkInOneWithPets(g2,3);
        hotel.checkOutOne(1);
        hotel.checkOutOne(2);
        hotel.checkOutOne(3);
        hotel.checkOutOne(4);
        hotel.checkOutOne(5);
        hotel.checkInGroupWithPets(group1);
        hotel.checkOutOne(1);
        hotel.checkOutOne(2);
        hotel.checkOutOne(3);
        hotel.checkOutOne(4);
        hotel.checkOutOne(5);
        hotel.checkInGroupTYT(group1,3);
        hotel.checkOutOne(1);







    }
}
