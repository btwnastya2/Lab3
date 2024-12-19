## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2401`

#### Выполнил: `Овчинникова Анастасия Дмитриевна`

#### Вариант: `18`

### Cодержание:
- [Постановка задачи](#1-постановка-задачи)
- [Выбор структуры данных](#2-выбор-структуры-данных)
- [Алгоритм](#3-алгоритм)
- [Программа](#4-программа)
- [Анализ правильности решения](#5-анализ-правильности-решения)
### 1. Постановка задачи
>Необходимо написать программу Гостиница, со следющим функционалом
- Создание гостиницы
- Вывод списка номеров
- Поселение человка в номер
- Поселение человека в заданный номер
- Поселение человека в первый свободный номер
- Поселение группы людей
- Поселение группы людей начиная с определенного номера
- Выселение человека из номера
- Поселение семьи в соседние номера
- Выселение человека с учетом семьи
- Поселение человека с животным в указанный номер
- Поселение группы людей с животными
- Поселение семьи с животными
  
### 2. Выбор структуры данных
Для написания программы было выбрано написать пять классов: Test(тестовый), Hotel(отвечает за объект гостиница), Manage(отвечает за основные методы, наследует все от Hotel), Guest(Содержит информацию о госте), Family (Содержит информацию о семье)
В классе Hotel поля содержат основную информацию: количество номеров(allrooms), и массив - номера. Массив начальный взят длиной 200, для проверки работы программы этого достаточно. Но рассматриваются в нем первые allrooms элементов.

### 3. Алгоритм
##### class Hotel
>Класс имеет два поля первое типа Integer, он отвечает за число номеров в гостинице. Второе - строковый массив. Элементы являются комнатами гостиницы.
Элемент массива либо строка "Свободен", либо "Имя Гостя". Так мы отличаем свободные номера, от остальных.
Поэтому внутри класса описан метод для вывода двух списков: свободные номера и занятые номера.
##### class Guest
>Данный класс необходим для создания самого гостя. У него единственное поле типа String,
которое хранит имя гостя. Данный тип данных удобен для создания массива гостей.
##### class Family
>Класс имеет два поля: количество людей в семье, фамилия семьи.
Для удобства все члены семьи будут числиться как одна фамилия в отеле.
##### class Manage
>Он отвечает за весь функционал, в нем используется все предыдущие классы. Он наследует весь функционал Hotel, становится основным классом в этой программе.

### 4. Программа
##### class Hotel
```java
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
```

##### class Guest
```java
package org.example;
//Создаем класс Guest
public class Guest {
    //Создаем поле - имя гостя
        public String name;
//Создаем конструктор гостя
        public Guest(String name){
            this.name=name;
        }

    }

```
##### class Family
```java
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
```

##### class Manage
```java
package org.example;
//Создаем класс Manage, который будет отвечать за все остальные методы, он наследует всот класса Hotel
public class manage extends Hotel{
    public manage(int n) {
        super(n);
    }
    //Создаем метод, для заселения гостя в первый свободный номер, он возвращает имя гостя и статус заселения
    public String checkInOne(Guest g1){
        String b="Не заселен";
        //Если в массиве находится свободный номер, меняем его на имя гостя
        for(int i=0;i< allrooms;i++){
            if (b.equals("Заселен"))
                break;
            else{
                if (h[i].equals("Свободен")){
                    h[i]=g1.name;
                    c++;
                    b="Заселен";
                }
                else{
                    b="Не заселен";
                }
            }
        }
        return g1.name +" "+ b;
    }
    //Создаем метод, для заселения гостя в указанный номер, он возвращает имя гостя и статус заселения
    public String checkInOne(Guest g1,int a){
        String b;
        //Если  номер "Свободен", то меняем на имя гостя
        if (h[a-1].equals("Свободен")){
            h[a-1]=g1.name;
            c++;
            b="Заселен";
        }
        else
            b="Не заселен";

        return g1.name +" "+ b;
    }
    //Создаем метод для заселения группы людей, параметр - массив гостей, возвращает число заселенных
    public int checkInGroup(Guest []g2){
        //счетчик заселенных
        int zas=0;
        //счетчик для передвижания по массиву гостей
        int b=0;
        //если комната свободна, заменяем на имя гостя
        for(int i=0; i<allrooms; i++){
            if (b==g2.length)
                break;
            if (h[i].equals("Свободен")){
                h[i]=g2[b].name;
                b++;
                zas++;
            }
        }
        c=c+zas;
        return zas;
    }
    //Создаем метод для заселения группы гостей, начиная с определенного номера
    //Параметры: массив гостей и номер комнаты, возвращает число заселенных
    public int checkInGroupTYT(Guest []g2, int a){
        //Счетчик заселенных
        int zas=0;
        int k=0;
        //Существует ли такой номер вообще
        if(a>allrooms)
            zas=0;
        else{
            //Если существует, то заселяем начиная с этого, в свободные номера
            //Так как это не семья, заселять не обязательно в номера рядом
            for(int i=a;i<allrooms;i++){
                if(k==g2.length)
                    break;
                if (h[i].equals("Свободен")){
                h[i]=g2[k].name;
                k++;
                zas++;
                }
            }
        }
        c=c+zas;
        return zas;
    }
    //Создаем метод для выселения из определенного номера
    //Параметр:номер команты, меняем на "Свободен", возвращаем новый список номеров
    public String checkOutOne(int n){
        h[n-1]="Свободен";
        return Rooms();
    }
    //Создаем метод для заселения семьи, параметр: семья
    public boolean checkInFam(Family a){
        boolean zas;
        int n=-1;
        int free=1;
        //Берем каждый номер, и смотрим его и следующие a.fam-1 номеров, где a.fam число людей в семье
        for(int i=0;i<allrooms-a.fam+1;i++){
            if(free==a.fam)
                break;
            free=0;
            //Если какой-то из них занят, проверяем так со следующего, пока не найдем подяряд свободные
            for(int j=i;j<i+a.fam;j++){
                if(!h[j].equals("Свободен")){
                    break;
                }
                else
                    free++;
                if(free==a.fam){
                    n=i;
                    break;
                }
            }
        }
        //Если не нашли таких номеров возвращаем false
        if (n==-1){
            zas=false;
        }
        //Если нашли, возврщаем true и заселям семью, присваивая каждому номеру a.name
        else{
            zas=true;
            for(int i=n;i<n+a.fam;i++){
                h[i]=a.name;
            }
        }
       return zas;
    }
    //Выселение по фамилии семьи
    public void checkOut(String a){
        int k = -1;
        //Если есть рядом, две одинаковые фамилии, запоминаем, где начинается
        for (int i=0; i<allrooms-1; i++){
                if (h[i].equals(a) && h[i+1].equals(a)){
                    k=i;
                    break;

            }
        }
        //Выселяем, начиная с этого, пока не закончится эта фамилия
        if (k!=-1){
            while (h[k].equals(a)){
                h[k]="Свободен";
                k++;
                if (k==allrooms)
                    break;
            }
        }
        else
        //Либо выселяем первого человека с такой фамилией, то есть у него нет семьи
            for (int i=0; i<allrooms; i++){
                if (h[i].equals(a)){
                    h[i]="Свободен";
                    break;
                }
            }
    }
    //Создаем метод для заселения гостя с животным в конкретный номер, возвращает имя и статус заселения
    public String checkInOneWithPets(Guest g1, int t){
        String itog;
        //Если этот номер свободен и четный, то заселяем
        if ((t-1)%2==0 && h[t].equals("Свободен")){
            h[t-1]=g1.name;
            itog="Заселен";}
        else
            itog="Не заселен";

        return g1.name +" "+ itog;
    }
    //Создаем метод для заселения группы с животными, заселяем их в четные номера свободные
    //Параметр: массив гостей, возвращает количество заселенных
    public int checkInGroupWithPets(Guest []g2){
        int zas=0;
        //Счетчик для передвижения по массиву гостей
        int b=0;
        for(int i=1; i<allrooms; i=i+2){
            if (b==g2.length)
                break;
            if (h[i].equals("Свободен")){
                h[i]=g2[b].name;
                b++;
                zas++;
            }
        }
        return zas;
    }
    //Метод заселение семьи с животными
    //Параметры: семья и количество животных
    public boolean checkInFamWithPets(Family a, int t){
        boolean zas;
        int n=-1;
        int free=1;
        int even=1;
        //Если находится необходимое число свободных подряд номеров, причем четных столько же, сколько животных
        //то заселяем, то есть true
        //Такие номера находим аналогично методу checkInFam(Family a)
        //Возвращает булевую
        for(int i=0;i<allrooms-a.fam+1;i++){
            if(free==a.fam && even==t)
                break;
            free=0;
            even=0;
            for(int j=i;j<i+a.fam;j++){
                if(!h[j].equals("Свободен")){
                    break;
                }
                else{
                    free++;
                    if(j%2!=0)
                        even++;
                }
                if(free==a.fam && even==t){
                    n=i;
                    break;
                }
            }
        }
        if (n==-1){
            zas=false;
        }
        else{
            //Рассматриваем два варианта: заселение с четного номера и заселение с нечетного
            zas=true;
            if(n%2!=0){
                int people=0;
                int pets=0;
                //Сначала селим с животными в четные номера
                for(int i=n;i<n+a.fam;i=i+2){
                    h[i]=a.name;
                    people++;
                    pets++;
                    if(pets==t)
                        break;
                }
                //Если с животными расселили, а люди в семье остались, то селим их в номера нечетые этого промежутка
                if (people<a.fam)
                    for(int i=n+1;i<n+a.fam;i=i+2){
                        if(people==a.fam)
                            break;
                        h[i]=a.name;
                        people++;
                    }
            }
            else{
                int people=0;
                int pets=0;
                for(int i=n+1;i<n+a.fam;i=i+2){
                    h[i]=a.name;
                    people++;
                    pets++;
                    if(pets==t)
                        break;
                }
                if (people<a.fam)
                    for(int i=n;i<n+a.fam;i=i+2){
                        if(people==a.fam)
                            break;
                        h[i]=a.name;
                        people++;
                    }
            }
        }
        return zas;
    }

}
```
##### class Test
```java
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
```

#### 5. Анализ правильности решений
1.  manage hotel = new manage(5);
        hotel.Rooms();
  > Итог:
   Свободные номера: (1; 2; 3; 4; 5; ); Занятые номера: ()
   >Конструктор создает гостиницу с 5 номерами, метод возвращает два списка свободные номера и занятые.

2.   Guest g1 = new Guest("Vasya");
        Guest g2 = new Guest("Petya");
        hotel.checkInOne(g1);
        hotel.checkInOne(g2,3);
     >Итог:
     Vasya Заселен
     Petya Заселен
     >Создаем двух гостей. Одного заселяем в первый свободный номер, программа возвращает имя гостя и статус заселения.
     Второго пробуем заселить в свободный номер первый, такой нномер нашелся, поэтому программа возвращает имя гостя и статус "заселен"ю

3.   Guest [] group1 = new Guest[4];
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
     >Итог:
     >3
     >Свободные номера: (); Занятые номера: (1--Vasya; 2--Lera; 3--Petya; 4--Katya; 5--Tolya; )
     >Создаем массив гостей, заселяем их в любые свободные номера, программа возвращает число заселенных. Проверяем были ли заселены - да.

4.   hotel.checkOutOne(1);
        hotel.checkOutOne(2);
        hotel.checkOutOne(3);
        hotel.checkOutOne(4);
        hotel.checkOutOne(5);
     >Итог:
     >Программа возвращает список номеров, после данного действия все стали свободны. Метод заменяет имя гостя в массиве на "Свободен".
     >
5. Family a = new Family(3, "Ivanov");
        hotel.checkInFam(a);
        Family p = new Family(3,"Smirnov");
        hotel.checkInFam(p);
        hotel.checkOut("Ivanov");
        hotel.checkOut("Smirnov");
        hotel.Rooms();
        hotel.checkInOneWithPets(g1,3);
   >Итог:true
   >false
   >Свободные номера: (1; 2; 3; 4; 5; ); Занятые номера: ()
   >В случае просто заселения семьи, метод есть ли подряд свободных номеров, столько сколько членов семьи, если есть заселяет и возвращает true, если нет -
   >возвращает false
   >В случае заселении семьи с животными, ищет подряд свободных номеров столько сколько членов семьи, причем, чтобы четных было столько, стоклько животных,если есть заселяет и возвращает true, если нет -
   >возвращает false

6. hotel.checkInOneWithPets(g2,3);
   >Итог:
   >Если  номер свободен и является четным, заселяет человека, если нет - возвращает имя и "Не заселен", в данном случае номер нечетный
7. hotel.checkInGroupWithPets(group1);
   >Итог: заселяет людей в четные номера, считается, что у каждого в группе есть животное. Возвращает число заселенных.
8. hotel.checkInGroupTYT(group1,3);
   >Итог: заселяет гостей в свободные номера, начиная с этого номера, если номер свободен. Возвращает количество заселенных.
     
     
   






















