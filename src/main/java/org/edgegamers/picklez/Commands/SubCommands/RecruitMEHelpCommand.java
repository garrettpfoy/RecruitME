package org.edgegamers.picklez.Commands.SubCommands;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

public class RecruitMEHelpCommand extends SimpleSubCommand {


    public RecruitMEHelpCommand(SimpleCommandGroup parent) {
        super(parent, "help");
    }

    @Override
    protected void onCommand() {

        //Displays help message to a given player

        Common.tell(getPlayer(), "&8&l&m------------[&r &b&lRecruit&d&lME &8&l&m]------------");
        Common.tell(getPlayer(), "&7");
        Common.tell(getPlayer(), "&b&l/ds &8- &7&oSign up to be a dedicated supporter");
        Common.tell(getPlayer(), "&d&l/link &8- &7&oConnect your Minecraft account with an existing forums account");
        Common.tell(getPlayer(), "&b&l/register &8- &7&oRegister a new forums account, and then link it to your Minecraft Account");
        Common.tell(getPlayer(), "&d&l/recruitme top &8- &7&oShows the top recruiters of the month");
        Common.tell(getPlayer(), "&b&l/recruitme preferences &8- &7&oChoose your RecruitME Preferences");
        Common.tell(getPlayer(), "&d&l/recruitme info [Player] &8- &7&oGets a player's information");
        Common.tell(getPlayer(), "&7");
        Common.tell(getPlayer(), "&8&l&m-----------------------------------------");

    }
}
