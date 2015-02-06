package elec332.repack.core.handler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentText;
import static net.minecraft.util.EnumChatFormatting.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Elec332 on 20-1-2015.
 */
public class UpdateHandler {

    public static LinkedHashMap<String, ArrayList> Updates = new LinkedHashMap<String, ArrayList>();
    public static ArrayList<String> outdatedModList = new ArrayList<String>();

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.player instanceof EntityPlayerMP) {
            EntityPlayerMP player = (EntityPlayerMP) event.player;
            for (String modName : outdatedModList) {
                ArrayList info = Updates.get(modName);
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
