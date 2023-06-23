package oop;

public class ToshibaModel1 extends Toshiba {


    @Override
    public void openCD() {
        super.printMyModel();
        System.out.println("CD is opening");
    }

    @Override
    public void closeCD() {
        System.out.println("CD is closing");

    }
}
