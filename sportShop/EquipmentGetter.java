package sportShop;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * getter of list of available equipment from txt file
 * Created by Maria on 22.01.2017.
 */
public class EquipmentGetter {

    /**
     * gets list of equipment from txt file and puts it into hashmap collection
     * @return hashmap with available equipment
     */
    public static Map<SportEquipment, Integer> getEquipment() {
        Map<SportEquipment, Integer> equipment = new HashMap<SportEquipment, Integer>();
        BufferedReader br = null;
        String goodInfo;
        String[] goodDetails;

        try {
            br = new BufferedReader(new FileReader("./equipment.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while ((goodInfo = br.readLine()) != null) {
                goodDetails = goodInfo.split(" ");
                equipment.put(new SportEquipment(goodDetails[0], goodDetails[1], Integer.parseInt(goodDetails[2])),
                        Integer.parseInt(goodDetails[3]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return equipment;
    }

}
