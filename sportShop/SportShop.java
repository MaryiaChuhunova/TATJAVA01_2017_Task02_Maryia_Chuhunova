package sportShop;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maryia_Chuhunova on 1/23/2017.
 */
public class SportShop {

    /**
     * entry point; gets list of rented equipment; contains menu of instructions;
     * @param args
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<SportEquipment> rentedEquipment = RentProcess.rent();

        int answ = 3;

        while (answ != 0) {
            System.out.println("\nIf you want to see a list of rented equipment type '1'");
            System.out.println("If you want to see a list of left equipment type '2'");
            System.out.println("If you want to exit type '0'");
            try {
                answ = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data");
                answ = 4;
            }
            if (answ == 1) {
                printRentedEquipment(rentedEquipment);
            }
            if (answ == 2) {
                printLeftEquipment();
            }
            if (answ > 2 || answ < 0) {
                System.out.println("Unknown instruction");
            }
        }
    }

    /**
     * prints list of available equipment
     */
    public static void printLeftEquipment() {
        ArrayList<SportEquipment> equipmentList = new ArrayList<SportEquipment>(Shop.getShopInstance().getGoods().keySet());
        for (SportEquipment key : equipmentList) {
            key.printEquipmentInfo();
            System.out.println(" Quantity: " + Shop.getShopInstance().getGoods().get(key));
        }
    }

    /**
     * prints list of rented equipment
     * @param rentedEquipment list of rented equipment
     */
    public static void printRentedEquipment(ArrayList<SportEquipment> rentedEquipment) {
        for (SportEquipment item : rentedEquipment) {
            System.out.println();
            item.printEquipmentInfo();
        }
    }
}
