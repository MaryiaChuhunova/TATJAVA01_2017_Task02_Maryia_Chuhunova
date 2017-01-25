package sportShop;

import java.util.ArrayList;

/**
 * describes list of rented equipment
 * Created by Maria on 22.01.2017.
 */
public class RentUnit {
    private ArrayList<SportEquipment> units;

    /**
     * creates instance of list of rented (by one user) equipment
     * @param units list of rented equipment
     */
    public RentUnit(ArrayList<SportEquipment> units) {
        this.units = units;
    }
}
