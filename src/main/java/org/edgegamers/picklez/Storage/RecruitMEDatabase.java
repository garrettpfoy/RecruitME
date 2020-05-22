package org.edgegamers.picklez.Storage;

import fr.xephi.authme.data.auth.PlayerCache;
import lombok.Getter;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.database.SimpleFlatDatabase;

import java.util.ArrayList;
import java.util.List;

public class RecruitMEDatabase extends SimpleFlatDatabase<RecruitMEPlayerCache> {

    @Getter
    private final static RecruitMEDatabase instance = new RecruitMEDatabase();

    public static RecruitMEDatabase getInstance() {
        return instance;
    }

    @Override
    public void onLoad(SerializedMap serializedMap, RecruitMEPlayerCache playerCache) {
        /*
        Loads the player's serializedMap, if it contains a value, we load it, if not, we create a default value as a placeholder
         */
        if (serializedMap.keySet().contains("Referrals")) {

            int referrals = serializedMap.getInteger("Referrals");
            playerCache.setReferrals(referrals);
        } else {
            SerializedMap map = new SerializedMap();
            map.put("Referrals", 0);

            int referrals = map.getInteger("Referrals");
            playerCache.setReferrals(referrals);
        }


        if(serializedMap.keySet().contains("Notifications")) {
            boolean showNotifications = serializedMap.getBoolean("Notifications");
            playerCache.showNotifications(showNotifications);

        }
        else {
            SerializedMap map = new SerializedMap();
            map.put("Notifications", true);

            boolean showNotifications = map.getBoolean("Notifications");
            playerCache.showNotifications(showNotifications);

        }
    }

    @Override
    protected SerializedMap onSave(RecruitMEPlayerCache playerCache) {
        SerializedMap map = new SerializedMap();

        map.put("Referrals", playerCache.getReferrals());

        return map;
    }
}
