package elec332.repack.core.handler;

import static net.minecraft.util.EnumChatFormatting.GOLD;
import static net.minecraft.util.EnumChatFormatting.RED;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

/**
 * Created by Elec332 on 20-1-2015.
 */
public class UpdateHandler {

    public static LinkedHashMap<String, ArrayList<String>> updates = new LinkedHashMap<String, ArrayList<String>>();

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) event.player;
            for (String modName : updates.keySet()) {
                ArrayList<String> info = updates.get(modName);
                player.addChatComponentMessage(new ChatComponentText( RED +
                        "You are using an outdated version of: " + modName
                ));
                player.addChatComponentMessage(new ChatComponentText( GOLD +
                        "The latest version of " + modName + " is " + info.get(1) + " you are using version " + info.get(0)
                ));
            }
        }
    }
}
