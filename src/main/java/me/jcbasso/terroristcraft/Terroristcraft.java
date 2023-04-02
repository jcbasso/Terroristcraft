package me.jcbasso.terroristcraft;

import com.mojang.logging.LogUtils;
import me.jcbasso.terroristcraft.commands.ReadyCommand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("terroristcraft")
public class Terroristcraft {

    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    private final GameManager gameManager;

    public Terroristcraft() {
        this.gameManager = new GameManager();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ReadyCommand(this.gameManager));
    }

    @SubscribeEvent
    public void onServerStartingEvent(ServerStartingEvent event) {
        this.gameManager.setServer(event.getServer());
    }
}
