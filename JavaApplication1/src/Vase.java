
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Le Nhat Tung
 */
public class Vase extends Item {

    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int value, String creator, int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void inputVase() {
        super.input();
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a height:");
        this.height = sc.nextInt();
        System.out.println("Input a material:");
        sc = new Scanner(System.in);
        this.material = sc.nextLine();
    }

    public void outputVase() {
        super.output();
        System.out.println("Height:" + height);
        System.out.println("Material:" + material);

    }

    @Override
    public String toString() {
        return super.toString() + "\nheight=" + height + "\nmaterial=" + material;
    }

    @Override
    public void ptX() {
        super.ptX(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    

}
