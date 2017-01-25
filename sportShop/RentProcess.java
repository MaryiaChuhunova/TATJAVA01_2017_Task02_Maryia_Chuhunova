package sportShop;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * describes process of renting sport equipment
 * Created by Maria on 22.01.2017.
 */
public class RentProcess {

    /**
     * gets request for exact equipment for user. if it's in stock, asks user if he wants
     * to rent it. If yes, adds this equipment into ArrayList with rented equipment and
     * changes value of quantity in hashmap with equipment in stock
     * @return list with rented equipment
     */
    public static ArrayList<SportEquipment> rent() {

        Scanner sc = new Scanner(System.in);
        int quantity = 0;
        String input;
        SportEquipment resultOfSearch;
        ArrayList<SportEquipment> units = new ArrayList<>();

        while(quantity != 3) {
            System.out.println("equipment title for search");
            input = sc.nextLine();
            resultOfSearch = search(input);
            if(resultOfSearch != null) {
                System.out.println("In stock. Type 'Yes' if want to rent it. Otherwise type 'No'");
                input = sc.nextLine();
                if(input.equals("Yes")) {
                    Shop.getShopInstance().getGoods().put(resultOfSearch, Shop.getShopInstance().getGoods().get(resultOfSearch) - 1);
                    units.add(resultOfSearch);
                    quantity++;
                } else if (input.equals("No")) {
                    continue;
                } else {
                    System.out.println("Unknown instruction. Try again");
                    continue;
                }
                System.out.println("If you don't want to take anything else type 'Done'. Otherwise press enter");
                input = sc.nextLine();
                if(input.equals("Done")) {
                    quantity = 3;
                }
            } else {
                System.out.println("Not in stock");
            }
        }
        return units;
    }

    /**
     * checks if equipment with given title exists in hashmap of equipment in stock
     * @param title is a title of requested equipment
     * @return instance of equipment if it's in stock, and null if it's not
     */
    public static SportEquipment search(String title) {

         ArrayList<SportEquipment> equipmentList = new ArrayList<>(Shop.getShopInstance().getGoods().keySet());
        for(SportEquipment item : equipmentList) {
            if((item.getTitle().equals(title)) && (Shop.getShopInstance().getGoods().get(item) > 0)) {
                return item;
            }
        }
        return null;
    }
}
