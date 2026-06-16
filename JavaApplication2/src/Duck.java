/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Le Nhat Tung
 */
public class Duck extends Animal implements IFlyable, ISwimable{

    @Override
    public void fly() {
        System.out.println("Con vit dang bay!!!");
    }

    @Override
    public void swimming() {
        System.out.println("Con vit dang boi");
    }
    
}
