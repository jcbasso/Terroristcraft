package me.jcbasso.terroristcraft;

import com.mojang.logging.LogUtils;
import me.jcbasso.terroristcraft.roles.Role;
import me.jcbasso.terroristcraft.roles.RoleManager;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class GameManager {
    private final Set<Player> playersReady;
    private RoleManager roleManager;
    private MinecraftServer server;
    private RoundState state;
    private final Set<Character> playingCharacters;

    public GameManager() {
        this.playersReady = new HashSet<>();
        this.playingCharacters = new HashSet<>();
        this.roleManager = new RoleManager();
        this.state = RoundState.SETUP;
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setServer(MinecraftServer server) {
        this.server = server;
    }

    private int ticks = 0;
    @SubscribeEvent
    public void onTick(TickEvent event) {
        if (event.phase.equals(TickEvent.Phase.END)) return;
        if (++ticks % 500 != 0) return;
        ticks = 0;

        LogUtils.getLogger().info("Players ready: " + playersReady);
        LogUtils.getLogger().info("Total Players: " + server.getPlayerList().getPlayers());
    }

    @SubscribeEvent
    public void onPlayerExit(PlayerEvent.PlayerLoggedOutEvent event) {
        playersReady.remove(event.getPlayer());
    }

    public void ready(ServerPlayer player) {
        if (Objects.requireNonNull(this.state) == RoundState.SETUP) {
            this.playersReady.add(new Player(player));

            if (this.server.getPlayerList().getPlayers().size() == this.playersReady.size()) {
                this.state = RoundState.PLAYING;
                Component message = new TextComponent("Round starting!");
                this.server.getPlayerList().getPlayers().forEach(p -> p.sendMessage(message, p.getUUID()));
                Map<Player, Role> roles = this.roleManager.assignRoles(this.playersReady.stream().toList());
                this.playersReady.forEach(p -> this.playingCharacters.add(new Character(roles.get(p), p)));
            }
        }
    }
}

enum RoundState {
    SETUP,
    PLAYING
}