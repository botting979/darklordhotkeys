
package com.darklordhotkeys;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Keybind;

import java.awt.event.KeyEvent;

@ConfigGroup("darklordhotkeys")
public interface DarklordHotkeysConfig extends Config {

    @ConfigItem(
            keyName = "hotkey",
            name = "Hotkey",
            description = "Hotkey to trigger item switch"
    )
    default Keybind hotkey() {
        return new Keybind(KeyEvent.VK_F1, 0);
    }

    @ConfigItem(
            keyName = "itemId",
            name = "Item ID",
            description = "Item ID to use or equip when hotkey is pressed"
    )
    default int itemId() {
        return 4151;
    }
}
