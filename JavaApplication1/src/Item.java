
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Le Nhat Tung
 */
public class Item {

    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
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

    public void input() {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.println("Input item:");
            System.out.println("Input value: ");
            int value = 0;
            try {
                value = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Input creator");
            String creator = sc.nextLine();

            if (value <= 0) {
                check = false;
            }
            if (creator.isEmpty()) {
                check = false;
            }
            if (!check) {
                System.out.println("Invalid data! Please re-input (value>0, creator is not empty)!");
            } else {
                this.value = value;
                this.creator = creator;
            }
        } while (!check);
    }

    @Override
    public String toString() {
        return "Value: " + value + "\nCreator:" + creator;
    }

    public void output() {
        System.out.println(toString());
    }
    
    public void ptX(){
        
    }
    
}
