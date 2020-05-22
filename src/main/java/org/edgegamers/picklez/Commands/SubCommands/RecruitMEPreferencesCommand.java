package org.edgegamers.picklez.Commands.SubCommands;

import org.edgegamers.picklez.Menus.RecruitMEPreferencesMenu;
import org.mineacademy.fo.command.SimpleCommandGroup;
import org.mineacademy.fo.command.SimpleSubCommand;

public class RecruitMEPreferencesCommand extends SimpleSubCommand {

    public RecruitMEPreferencesCommand(SimpleCommandGroup parent) {
        super(parent, "preferences|prefs|pref|settings");
        setPermission("recruitme.preferences");
    }

    @Override
    protected void onCommand() {

        new RecruitMEPreferencesMenu().displayTo(getPlayer());

    }
}
