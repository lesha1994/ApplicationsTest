package oop;

public class Ram {

    private String name;
    private double speed;
    private boolean cdWritable;

    public void writeCd() {
        System.out.println("writeCd()");
    }

    public void openCD() {
        System.out.println("openCD()");
    }

    public void closeCD() {

        System.out.println("closeCD()");
    }

    public void readCD() {
        System.out.println("readCD()");
    }






    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isCdWritable() {
        return cdWritable;
    }

    public void setCdWritable(boolean cdWritable) {
        this.cdWritable = cdWritable;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
