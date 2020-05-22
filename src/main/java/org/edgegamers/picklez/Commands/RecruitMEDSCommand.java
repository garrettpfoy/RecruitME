package org.edgegamers.picklez.Commands;

import org.edgegamers.picklez.API.CpasAPI;
import org.edgegamers.picklez.API.CpasPlayerCacheAPI;
import org.edgegamers.picklez.Storage.RecruitMEPlayerCache;
import org.edgegamers.picklez.Utils.RecruitMEDSProcess;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.Collections;

public class RecruitMEDSCommand extends SimpleCommand {

    public RecruitMEDSCommand() {
        super("ds", Collections.singletonList("dedicatedsupporter"));
        setPermission("recruitme.ds");
    }

    @Override
    public void onCommand() {
        RecruitMEPlayerCache recruitMECache = RecruitMEPlayerCache.getCache(getPlayer().getUniqueId());
        CpasPlayerCacheAPI cache = CpasAPI.getCache(getPlayer().getUniqueId());

        if(cache.isDedicatedSupporter()) {
            //Player is already a dedicated supporter!
            Common.tell(getPlayer(), "&b&lRecruit&d&LME &8\u00BB &7You are already a dedicated supporter!");
        }
        else if(!(cache.isRegistered())) {
            Common.tell(getPlayer(), "&b&lRecruit&d&lME &8\u00BB &7You must link or register a forums account to your Minecraft account!");
            Common.tell(getPlayer(), "&b&lRecruit&d&lME &8\u00BB &7Already have a forums account? Use &b/link");
            Common.tell(getPlayer(), "&b&lRecruit&d&lME &8\u00BB &7Need to sign up for an account? Use &d/register");
        }
        else {
            //User is eligible to sign up for Dedicated Supporter
            //Use Utils Begin DS Signup process
            RecruitMEDSProcess.process(getPlayer());
        }


    }
}
