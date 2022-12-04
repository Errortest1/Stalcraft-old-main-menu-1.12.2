package by.errortest.stalcraft_menu;

import by.errortest.stalcraft_menu.client.ForgeEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import static by.errortest.stalcraft_menu.Main.MODID;

@Mod(
        name = "Stalcraft Menu",
        modid = MODID,
        version = "1.0.0",
        acceptedMinecraftVersions = "[1.12.2]"
)
public class Main {

    public static final String MODID = "stalcraft_menu";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new ForgeEvent());
    }
}
