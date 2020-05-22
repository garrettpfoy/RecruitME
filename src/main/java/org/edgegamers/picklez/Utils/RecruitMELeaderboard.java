package org.edgegamers.picklez.Utils;

import org.edgegamers.picklez.Storage.RecruitMEPlayerCache;
import org.mineacademy.fo.collection.SerializedMap;

import java.util.*;

public class RecruitMELeaderboard {


    public static SerializedMap getTopTen() {

        Map<UUID, RecruitMEPlayerCache> cacheMap = RecruitMEPlayerCache.getCacheMap();

        List<Integer> referrals = new ArrayList<Integer>();
        Set<UUID> uuids = cacheMap.keySet();

        for(RecruitMEPlayerCache cache : cacheMap.values()) {
            referrals.add(cache.getReferrals());
        }

        //Now referrals has a list of ALL referrals

        Collections.sort(referrals);
        //Referrals is now an ordered list of referrals

        for(int i = 0; i < referrals.size(); i++) {
            if(!(i <= 9)) {
                referrals.remove(i);
                i--;
            }
        }

        //Now we have the top 10 greatest values, let's assign those babies

        SerializedMap returnMap = new SerializedMap();

        for(int referral : referrals) {
            //Loops through each referral, if a player has the same referral value as them , add them to the serialized map
            for(UUID uuid : uuids) {
                if(cacheMap.get(uuid).getReferrals() == referral) {
                    //Add them to referral, break out of loop, remove uuid from UUIDs
                    uuids.remove(uuid);
                    referrals.remove(referral);
                    returnMap.put(uuid.toString(), referral);
                    break;
                }
            }
        }

        return returnMap;
    }
}
