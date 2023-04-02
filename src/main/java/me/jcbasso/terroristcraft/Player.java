package me.jcbasso.terroristcraft;

import net.minecraft.server.level.ServerPlayer;

import java.util.Objects;

public class Player {
    public final ServerPlayer serverPlayer;

    public Player(ServerPlayer serverPlayer) {
        this.serverPlayer = serverPlayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(serverPlayer, player.serverPlayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serverPlayer);
    }
}
