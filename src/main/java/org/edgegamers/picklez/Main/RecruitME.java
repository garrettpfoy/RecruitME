package org.edgegamers.picklez.Main;

import org.edgegamers.picklez.Commands.Groups.RecruitMECommandGroup;
import org.edgegamers.picklez.Storage.CacheDatabase;
import org.edgegamers.picklez.Storage.RecruitMEDatabase;
import org.edgegamers.picklez.Storage.RecruitMEPlayerCache;
import org.edgegamers.picklez.Storage.SQLConfiguration;
import org.mineacademy.fo.plugin.SimplePlugin;

public class RecruitME extends SimplePlugin {

    @Override
    public void onPluginStart() {

        getLogger().info("Enabling RecruitME v1.0.0");
        getLogger().info("Hi butters!");

        getLogger().info("Registering Commands:");
        registerCommands("recruitme|rme|recruit", new RecruitMECommandGroup());

        getLogger().info("Success!");

        getLogger().info("Connecting to database...");
        SQLConfiguration sqlConfig = new SQLConfiguration();
        RecruitMEDatabase.getInstance().connect(sqlConfig.getHost(), sqlConfig.getPort(), sqlConfig.getDatabase(), sqlConfig.getUser(), sqlConfig.getPassword(), sqlConfig.getTable());

    }
}
