package oop;

import org.assertj.core.condition.Not;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class FirstProgram {

    public static void main(String[] args) {
//          Computer comp = new Computer("HP", 1000, 256 , 2.5);
//        PrintStream ps = new PrintStream(System.out, true, StandardCharsets.UTF_8);
//        System.setOut(ps);
//
//        System.out.println("Hello world");
//    }


//        comp.setName("HP");
//        comp.setHdd(-2048);

//        comp.on();
//        comp.load();
//        comp.off();
// Обязательно ли передавать аргументи в обьект
//         Notebook notebook = new Notebook("HP",1000,256,5.5);
//        notebook.on();
//        notebook.load();
//        notebook.off();

        Toshiba t = new ToshibaModel1();
        t.openCD();
        t.closeCD();
    }
}

