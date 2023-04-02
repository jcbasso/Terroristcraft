package me.jcbasso.terroristcraft.roles;


import me.jcbasso.terroristcraft.Player;
import net.minecraft.network.chat.TextComponent;

import java.util.*;

public class RoleManager {

    public RoleManager() {}

    // Warning! This function changes the players order.
    public Map<Player, Role> assignRoles(List<Player> players) {
        float terroristRatio = 1f/2f; // TODO: Change this value (test purposes).
        int terroristNumber = Math.round(players.size() * terroristRatio);
        Collections.shuffle(players);

        Map<Player, Role> playerRoleMap = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);

            Role role;
            if ( i < terroristNumber) {
                role = new TerroristRole();
            } else {
                role = new CitizenRole();
            }
            playerRoleMap.put(player, role);
            player.serverPlayer.sendMessage(new TextComponent(role.assignationMessage()), player.serverPlayer.getUUID());
        }

        return playerRoleMap;
    }
}
