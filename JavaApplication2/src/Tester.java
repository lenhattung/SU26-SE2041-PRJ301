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
        Animal a = new Duck();
        Duck d = new Duck();
        IFlyable i1 = new Duck();
//        IFlyable i2 = new Dog();
        ISwimable i3 = new Duck();
    }
}
