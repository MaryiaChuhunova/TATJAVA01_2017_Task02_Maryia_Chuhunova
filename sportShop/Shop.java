package sportShop;

import java.util.Map;

/**
 * describes shop with data about equipment in it
 * Created by Maria on 22.01.2017.
 */
public class Shop {
    private Map<SportEquipment, Integer> goods;
    private static Shop shopInstance = new Shop();

    private Shop() {
        goods = EquipmentGetter.getEquipment();
    }

    public static Shop getShopInstance() {
        if(shopInstance == null) {
            shopInstance = new Shop();
        }
        return shopInstance;
    }

    public Map<SportEquipment, Integer> getGoods() {
        return goods;
    }
}
