package org.hotamachisubaru.miniutility.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class EnderchestOpenerListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("便利箱")) {  // GUI名が「便利箱」か確認
            event.setCancelled(true);  // インベントリの操作をキャンセル
            Player player = (Player) event.getWhoClicked();
            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null || clickedItem.getType() == Material.AIR) {
                return;
            }

            if (clickedItem.getType() == Material.ENDER_CHEST) {
                player.openInventory(player.getEnderChest());  // エンダーチェストを開く
                //player.closeInventory();  // 便利箱を閉じる
            }
        }
    }
}
