package sportShop;

import java.util.Locale;

/**
 * describes sport equipment
 * Created by Maria on 22.01.2017.
 */
public class SportEquipment {
//    private Locale.Category category;
    private String category;
    private String title;
    private int price;

    /**
     * creates instance of sport equipment
     * @param category is a category of equipment
     * @param title is a title of equipment
     * @param price price of equipment
     */
    public SportEquipment(String category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void printEquipmentInfo() {
        System.out.print("Category: " + category + " Title: " + title + " Price:" + price);
    }
}
