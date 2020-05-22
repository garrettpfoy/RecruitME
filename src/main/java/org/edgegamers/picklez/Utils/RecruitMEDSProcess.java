package org.edgegamers.picklez.Utils;

import net.wesjd.anvilgui.AnvilGUI;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.edgegamers.picklez.Main.RecruitME;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class RecruitMEDSProcess {

    /*
    new AnvilGUI.Builder()
    .onClose(player -> {                      //called when the inventory is closing
        player.sendMessage("You closed the inventory.");
    })
    .onComplete((player, text) -> {           //called when the inventory output slot is clicked
        if(text.equalsIgnoreCase("you")) {
            player.sendMessage("You have magical powers!");
            return AnvilGUI.Response.close();
        } else {
            return AnvilGUI.Response.text("Incorrect.");
        }
    })
    .preventClose()                           //prevents the inventory from being closed
    .text("What is the meaning of life?")     //sets the text the GUI should start with
    .item(new ItemStack(Material.GOLD_BLOCK)) //use a custom item for the first slot
    .title("Enter your answer.")              //set the title of the GUI (only works in 1.14+)
    .plugin(myPluginInstance)                 //set the plugin instance
    .open(myPlayer);
     */

    public static void process(Player originalPlayer) {

        ItemStack item = ItemCreator.of(CompMaterial.NAME_TAG, "&e&lInformation", "&7", "&7Unlike linking or registering, DS takes some time", "&7before taking affect. Copy and paste the link", "in the rename section to your browser", "&7and follow the instructions to complete the", "&7transaction", "&7", "&c&lNote: &7&oChanges can take up to 24 hours").build().make();

        new AnvilGUI.Builder()
                .onClose(player -> {
                    Common.tell(player, "&b&lRecruit&d&lME &8\u00BB &7Task was cancelled due to exiting the menu!");
                })
                .onComplete((player, text) -> {
                    //Assume player has successfully signed up
                    Common.tell(player, "&b&lRecruit&d&lME &8\u00BB &7Thanks for donating! Perks can take up to 24 hours to become live, however often times take less then an hour. For changes to take affect, simply relog!");
                    return AnvilGUI.Response.close();
                })
                .text("https://www.edge-gamers.com/forums/payments.php")
                .item(item)
                .plugin(RecruitME.getInstance())
                .open(originalPlayer);

    }
}
