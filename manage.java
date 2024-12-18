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
