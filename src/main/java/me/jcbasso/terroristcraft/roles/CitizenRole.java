package me.jcbasso.terroristcraft.roles;

public class CitizenRole implements Role {
    @Override
    public String getKey() {
        return "citizen";
    }

    @Override
    public String assignationMessage() {
        return "You are a Citizen, try to survive";
    }

    @Override
    public boolean objective() {
        return false;
    }
}
