package me.jcbasso.terroristcraft.objectives;

public class TreasonObjective implements Objective {
    @Override
    public String getKey() {
        return "treason";
    }

    @Override
    public String description() {
        return "You must betray your comrades by killing them"; // TODO: Update it
    }
}
