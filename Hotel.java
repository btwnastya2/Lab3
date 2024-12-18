package org.example;
//создаем класс Hotel, который отвечает за глвыный массив, то есть номера
public class Hotel {
    //Создаем поле, которое отвечает за количество номеров в гостинице
    public int allrooms;
    //Создаем массив строковый, как бы сами номера
    public String[] h = new String[200];
    public int c=0;
    //Создаем конструктор для создания гостиницы
    public Hotel(int n){
        allrooms=n;
        //Заполянем массив словом "Свободен", то есть изначально все номера свободны
        for (int i=0;i<n;i++){
            h[i]="Свободен";
        }
    }
    //Создаем метод, который возвращает свободные номера
    public String vacantRooms(){
        String vacant="";
        //Если элемент массива равен "Свободен", то записываем его в свободные
        for (int i = 0; i < allrooms; i++) {
            if (h[i].equals("Свободен")){
                String k=""+(i+1)+"; ";
                vacant=vacant+k;

            }
        }
        return String.format ("("+vacant+")");
    }
    //Создаем метод, который возвращает занятые номера
    public String occupiedRooms(){
        String occupied="";
        //Если элемент массива не равен "Свободен", записываем его в занятые
        for (int i = 0; i < allrooms; i++) {
            boolean b = h[i].equals("Свободен");
            if (!b){
                String k=""+(i+1)+"--"+h[i]+"; ";
                occupied=occupied+k;
            }

        }
        return String.format ("("+occupied+")");
    }
    //Создаем метод, который возващает два спика:свободные номера, занятые с именами гостей
    public String Rooms(){
        return "Свободные номера: "+vacantRooms()+";"+" Занятые номера: "+occupiedRooms();
    }
}
