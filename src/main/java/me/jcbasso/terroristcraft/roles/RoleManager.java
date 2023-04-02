package me.jcbasso.terroristcraft.roles;


import me.jcbasso.terroristcraft.Player;
import net.minecraft.network.chat.TextComponent;

import java.util.*;

public class RoleManager {

    public RoleManager() {}

    // Warning! This function changes the players order.
    public Map<Player, Role> assignRoles(List<Player> players) {
        Collections.shuffle(players);

        Map<Player, Role> playerRoleMap = new HashMap<>();
        Role role = new WorkerRole();
        for (Player player : players) {
            playerRoleMap.put(player, role);
            player.serverPlayer.sendMessage(new TextComponent(role.assignationMessage()), player.serverPlayer.getUUID());
        }

        return playerRoleMap;
    }
}
