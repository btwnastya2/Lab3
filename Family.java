package org.example;
//Создаем класс семья
public class Family {
    //Создаем поле, количество людей в семье
    public int fam;
    //Создаем поле имя семьи, все члены ее будут записаны так
    public String name;
    //Создаем конструктор по заданию семьи
    public Family(int fam, String name) {
        this.fam = fam;
        this.name = name;
    }
}
