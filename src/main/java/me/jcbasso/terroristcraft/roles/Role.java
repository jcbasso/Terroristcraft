package me.jcbasso.terroristcraft.roles;

import me.jcbasso.terroristcraft.objectives.Objective;
import net.minecraft.world.item.Item;

import java.util.Set;

public interface Role {
    String getKey();

    String assignationMessage();


    Set<Objective> getPossibleObjectives();

    Set<Item> getInitialItems(); //TODO: To define
}
