package by.errortest.stalcraft_menu.client;

import by.errortest.stalcraft_menu.client.gui.StalcraftMenuGui;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeEvent {

    private StalcraftMenuGui stalcraftMenuGui = new StalcraftMenuGui();
    public static int musicCount;



    @SubscribeEvent
    public void initGui(GuiOpenEvent e) {
        if (e.getGui() instanceof GuiMainMenu) {
            e.setGui(stalcraftMenuGui);
            musicCount++;
        }
    }

    @SubscribeEvent
    public void joinWorld(EntityJoinWorldEvent e) {
        musicCount = 0;
    }


}
