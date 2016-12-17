package Core;

import java.util.ArrayList;


/**
 * Created by Оксана on 30.08.2016.
 */
public class GenericExample {
    class Animal{
        public void makeVoice(){
            System.out.println("Voooice");
        }
    }
    class Cat extends Animal{}
    class Dog extends Animal{}

    class Sphynx extends Cat{
        public void methodForSphynx(){
            System.out.println("Sphynx");
        }
    }

    public  void addCatIntoSphynx(){
        ArrayList<Sphynx> sphynxes = new ArrayList<>();
       //sphynxes.add(new Cat());  // Cat не Sphynx, родительский тип нельзя класть
                                    //в коллекцию наслденика так как у родителя может не быть
                                    //специфичных методов наследника. Это позволяет избежать ошибок в рантайме
    }


    public void methodSuper(ArrayList<? super Sphynx> list){
        list.add(new Sphynx()); // все ок, все аргументы могут принимать в себя сфинксов
        //list.add(new Cat());  //  нельзя, так как аргументом может быть
                                // коллекция сфинксов, @see public  void addCatIntoSphynx()
        //list.get(0).methodForSphynx(); // нельзя, так как аргументом м.б коллекция котов и выше
                                        // у которых нет метода methodForSphynx()
        //list.get(0).makeVoice();   // нельзя, так как аргументом может быть коллекция Object'ов
                                    // у которых нет метода makeVoice()
        list.get(0).toString(); //все ок, методы Object'a будут у всех элементов любого аргумента
    }

    public void methodExtends(ArrayList<? extends Animal> list){
        //list.add(new Animal()); //в таком случае в коллекцию-аргумент вообще ничего
        //list.add(new Dog());   //нельзя добавлять, чтобы не допустить добавление котов в коллекцию собак
        //list.add(new Object()); //или Animal в сфинксов(родительский тип нельзя класть в коллекцию наслденика)

        list.get(0).makeVoice(); //все ок, у всех элементов любой коллекции-аргумента будет метод makeVoice()

        //list.get(0).methodForSphynx() //нельзя, так как коллекция-аргумент может содержать
                                        // элементы(коты, собаки, животные, Object) у которых нет
                                        // метода methodForSphynx().
    }

    public <T extends Animal> void oneMoreMethod(ArrayList<T> list){
//        ArrayList<Sphynx> sphynxes = new ArrayList<>();
//        ArrayList<Cat> cats = new ArrayList<>();
//        ArrayList<Animal> animals = new ArrayList<>();
        list.get(0).makeVoice();

    }


    public static void main(String[] args) {
        ArrayList<Sphynx> sphynxes = new ArrayList<>();
        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Animal> animals = new ArrayList<>();


        GenericExample ge = new GenericExample();

        ge.oneMoreMethod(sphynxes);
        ge.oneMoreMethod(animals);

        ge.methodExtends(sphynxes);
        ge.methodExtends(cats);

        }
    }


