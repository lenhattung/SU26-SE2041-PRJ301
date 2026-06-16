
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Le Nhat Tung
 */
public class Tester {

    public static void main(String[] args) {
        Item item = null;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("1. Create a Vase:");
            System.out.println("2. Create a Statue:");
            System.out.println("3. Create a Painting:");
            System.out.println("4. Display the Item:");
            System.out.println("Input a choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    item = new Vase();
                    ((Vase) item).inputVase();
                    break;
                case 2:
//                    item = new Statue();
//                    ((Statue) item).inputStatue();
                    break;
                case 3:
//                    item = new Painting();
//                    ((Painting) item).inputPainting();
                    break;
                case 4:
                    if (item != null) {
                        if (item instanceof Vase) {
                            Vase v = ((Vase) item);
                            v.outputVase();
                            v.ptX();
                        } else if (item instanceof Statue) {
//                            ((Statue) item).outputStatue();
                        } else if (item instanceof Painting) {
//                            ((Painting) item).outputPainting();
                        }
                    } else {
                        System.out.println(
                                " you need to create an object ");
                        break;
                    }

            }
        } while (choice <= 4);

        System.out.print("");
    }
}
