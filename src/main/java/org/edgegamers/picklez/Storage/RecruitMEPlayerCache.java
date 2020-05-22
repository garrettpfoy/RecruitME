package org.edgegamers.picklez.Storage;

import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RecruitMEPlayerCache extends YamlSectionConfig {

    private static Map<UUID, RecruitMEPlayerCache> cacheMap = new HashMap<>();

    private int referrals; //How many referrals a player has
    private boolean notifications;

    protected RecruitMEPlayerCache(UUID uuid) {
        //Initiates a configuration in data.db and creates a "header" section that mirrors the database
        super(uuid.toString());

        loadConfiguration(null, "data.db");
    }

    public static Map<UUID, RecruitMEPlayerCache> getCacheMap() {
        return cacheMap;
    }

    @Override
    protected void onLoadFinish() {
        //Will, if set, load and initiate all variables defined in the playercache
        if(isSet("Referrals")) {
            referrals = getInteger("Referrals");
        }
        if(isSet("Notifications")) {
            notifications = getBoolean("Notifications");
        }
    }


    public void setReferrals(int referrals) {
        this.referrals = referrals;
        save();
    }

    public void showNotifications(boolean showNotifications) {
        this.notifications = showNotifications;
        save();
    }

    public int getReferrals() {
        return referrals;
    }

    public boolean getNotifications() {
        return notifications;
    }


    @Override
    public SerializedMap serialize() {
        SerializedMap map = new SerializedMap();
        map.putIfExist("Referrals", referrals);
        map.putIfExist("Notifications", notifications);
        return map;
    }


    public static RecruitMEPlayerCache getCache(final UUID uuid) {
        if(cacheMap.keySet().contains(uuid)) {
            RecruitMEPlayerCache cache = cacheMap.get(uuid);
            return cache;
        }
        else {
            RecruitMEPlayerCache cache = new RecruitMEPlayerCache(uuid);
            cacheMap.put(uuid, cache);
            return cache;
        }
    }
}
