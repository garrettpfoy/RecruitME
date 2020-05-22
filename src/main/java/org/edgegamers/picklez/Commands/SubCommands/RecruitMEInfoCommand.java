package org.edgegamers.picklez.Commands.SubCommands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.edgegamers.picklez.API.CpasAPI;
import org.edgegamers.picklez.API.CpasPlayerCacheAPI;
import org.edgegamers.picklez.Storage.RecruitMEPlayerCache;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

public class RecruitMEInfoCommand extends SimpleSubCommand {


    public RecruitMEInfoCommand(SimpleCommandGroup parent) {
        super(parent, "info");
        setMinArguments(1);
        setUsage("[Player]");
        setPermission("recruitme.info");
    }

    @Override
    protected void onCommand() {

        OfflinePlayer player = Bukkit.getOfflinePlayer(args[0]);
        CpasPlayerCacheAPI cache = CpasAPI.getCache(player.getUniqueId());
        RecruitMEPlayerCache recruitCache = RecruitMEPlayerCache.getCache(player.getUniqueId());

        Common.tell(getPlayer(), "&8&l&m------------[&r &b&lRecruit&d&lME &8&l&m]------------");
        Common.tell(getPlayer(), "&7");
        Common.tell(getPlayer(), "&bRegistered: &f" + cache.isRegistered());
        Common.tell(getPlayer(), "&dMember: &f" + cache.isMember());
        Common.tell(getPlayer(), "&bReferrals: &f" + recruitCache.getReferrals());
        Common.tell(getPlayer(), "&7");
        Common.tell(getPlayer(), "&8&l&m-----------------------------------------");


    }
}
