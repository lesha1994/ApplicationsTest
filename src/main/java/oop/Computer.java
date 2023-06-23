package oop;

public class Computer {

    private String name ;

    private int ram;

    private int hdd;

    private double weight;


    public Computer(String name, int ram, int hdd, double weight ) {
        this.name = name;
        this.ram = ram;
        this.hdd = hdd;
        this.weight = weight;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        if ( hdd > 0) {
            this.hdd =hdd;
        }
        else {
            System.out.println("What the fuck " + hdd + " Не может быть отрицательно");
        }

    }

    public void  on () {
        print("Я Включаюсь " +name);
    }


    public void  off () {
        print("Я Выключаюсь ");
    }

    public void load() {
        print("Я Гружусь. Мой обьем равен: " + hdd + "ГБ");

    }

    protected void print (String str) {
        System.out.println(str);
    }



}
