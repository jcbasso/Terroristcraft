package me.jcbasso.terroristcraft.roles;

import me.jcbasso.terroristcraft.objectives.Objective;
import me.jcbasso.terroristcraft.objectives.TreasonObjective;
import net.minecraft.world.item.Item;

import java.util.HashSet;
import java.util.Set;

public class WorkerRole implements Role {
    private final Set<Objective> possibleObjectives;

    public WorkerRole() {
        this.possibleObjectives = new HashSet<>();
        this.possibleObjectives.add(new TreasonObjective());
    }

    @Override
    public String getKey() {
        return "worker";
    }

    @Override
    public String assignationMessage() {
        return "You are a Worker, try to survive!\n" +
            "Your objectives are: " + possibleObjectives.stream().map(o -> "\n" + o.getKey() + ": " + o.description());
    }

    @Override
    public Set<Objective> getPossibleObjectives() {
        return this.possibleObjectives;
    }

    @Override
    public Set<Item> getInitialItems() {
        return new HashSet<>();
    }
}
