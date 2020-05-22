package org.edgegamers.picklez.Commands.SubCommands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.edgegamers.picklez.Utils.RecruitMELeaderboard;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

import java.util.UUID;

public class RecruitMELeaderboardCommand extends SimpleSubCommand {

    public RecruitMELeaderboardCommand(SimpleCommandGroup parent) {
        super(parent, "leaderboard|lb|top");
        setPermission("recruitme.leaderboard");
    }

    @Override
    protected void onCommand() {

        SerializedMap leaderboard = RecruitMELeaderboard.getTopTen();

        Common.tell(getPlayer(), "&8&l&m------------[&r &b&lRecruit&d&lME &8&l&m]------------");
        Common.tell(getPlayer(), "&7");
        int count = 0;
        for(String uuid : leaderboard.keySet()) {
            OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
            int referrals = leaderboard.getInteger(uuid);

            if(count % 2 == 0) {
                Common.tell(getPlayer(), "&b" + player.getName() + " &8\u00BB &7" + referrals);
                count++;
            }
            else {
                Common.tell(getPlayer(), "&d" + player.getName() + " &8\u00BB &7" + referrals);
                count++;
            }
        }
        Common.tell(getPlayer(), "&7");
        Common.tell(getPlayer(), "&8&l&m-----------------------------------------");

    }
}
