package org.edgegamers.picklez.Commands.Groups;

import org.edgegamers.picklez.Commands.SubCommands.RecruitMEHelpCommand;
import org.edgegamers.picklez.Commands.SubCommands.RecruitMEInfoCommand;
import org.edgegamers.picklez.Commands.SubCommands.RecruitMELeaderboardCommand;
import org.mineacademy.fo.command.SimpleCommandGroup;

public class RecruitMECommandGroup extends SimpleCommandGroup {

    @Override
    protected void registerSubcommands() {
        registerSubcommand(new RecruitMEHelpCommand(this));
        registerSubcommand(new RecruitMEInfoCommand(this));
        registerSubcommand(new RecruitMELeaderboardCommand(this));
    }
}
