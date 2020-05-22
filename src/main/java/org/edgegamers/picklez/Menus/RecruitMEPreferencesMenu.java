package org.edgegamers.picklez.Menus;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.edgegamers.picklez.Storage.RecruitMEPlayerCache;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class RecruitMEPreferencesMenu extends Menu {

    private Button enable;
    private Button infoBook;
    private Button disable;

    public RecruitMEPreferencesMenu() {

        setTitle("&bRecruit&dME &8Preferences");
        setSize(9);

        enable = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                RecruitMEPlayerCache cache = RecruitMEPlayerCache.getCache(player.getUniqueId());
                cache.showNotifications(true);

                player.closeInventory();
                String title = Common.colorize("&b&lRecruit&d&lME");
                String subtitle = Common.colorize("&fYou have &aenabled &fnotifications!");

                player.sendTitle(title, subtitle, 20, 40, 20);
            }

            @Override
            public ItemStack getItem() {
                ItemStack item = ItemCreator.of(CompMaterial.LIME_DYE, "&a&lENABLE", "&7", "&7&oClick to enable notifications", "&7&ofrom &bRecruit&dME&7!").build().make();
                return item;
            }
        };

        infoBook = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                new RecruitMEPreferencesMenu().displayTo(player);
            }

            @Override
            public ItemStack getItem() {
                ItemStack item = ItemCreator.of(CompMaterial.BOOK, "&e&lInformation", "&7", "&7&oHere you can enable whether or not you", "&7&owish to see recruitment related notifications", "&7&oClick the green dye to turn on notifications", "&7&oor click the red dye to disable notifications!").build().make();
                return item;
            }
        };

        disable = new Button() {
            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                RecruitMEPlayerCache cache = RecruitMEPlayerCache.getCache(player.getUniqueId());
                cache.showNotifications(false);

                player.closeInventory();
                String title = Common.colorize("&b&lRecruit&d&lME");
                String subtitle = Common.colorize("&fYou have &cdisabled &fnotifications!");

                player.sendTitle(title, subtitle, 20, 40, 20);
            }

            @Override
            public ItemStack getItem() {
                ItemStack item = ItemCreator.of(CompMaterial.RED_DYE, "&c&lDISABLE", "&7", "&7&oClick to disable notifications", "&7&ofrom &bRecruit&dME&7!").build().make();
                return item;
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {
        // 2  4  6
        if(slot == 2) {
            return enable.getItem();
        }
        else if(slot == 4) {
            return infoBook.getItem();
        }
        else if(slot == 6) {
            return disable.getItem();
        }
        else {
            return null;
        }
    }


}
