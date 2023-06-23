package oop;

public class Notebook extends Computer {

//Почему идея просит создать тут новий конструктор
    public Notebook(String name, int ram, int hdd, double weight) {
        super(name, ram, hdd, weight);
    }

    @Override
    public void  on () {
        print("Notebook: Я Включаюсь " + getName());
    }


}
