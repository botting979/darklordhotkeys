
package com.darklordhotkeys;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.ItemContainer;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.input.KeyManager;
import net.runelite.client.input.KeyListener;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import javax.inject.Inject;
import java.awt.event.KeyEvent;

@Slf4j
@PluginDescriptor(
        name = "Darklord Hotkeys",
        description = "Press a hotkey to use or equip an item by ID",
        tags = {"hotkey", "item", "switcher"}
)
public class DarklordHotkeysPlugin extends Plugin implements KeyListener {

    @Inject private Client client;
    @Inject private ClientThread clientThread;
    @Inject private DarklordHotkeysConfig config;
    @Inject private KeyManager keyManager;

    @Provides
    DarklordHotkeysConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(DarklordHotkeysConfig.class);
    }

    @Override
    protected void startUp() {
        keyManager.registerKeyListener(this);
    }

    @Override
    protected void shutDown() {
        keyManager.unregisterKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == config.hotkey().getKeyCode()) {
            clientThread.invoke(() -> {
                ItemContainer inventory = client.getItemContainer(InventoryID.INVENTORY);
                if (inventory != null) {
                    for (Item item : inventory.getItems()) {
                        if (item != null && item.getId() == config.itemId()) {
                            log.info("Found item with ID: {}", item.getId());
                            // Placeholder for actual use logic
                            // You can implement a click simulation here later
                            break;
                        }
                    }
                }
            });
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
