package me.jcbasso.terroristcraft.roles;

public class TerroristRole implements Role {
    @Override
    public String getKey() {
        return "terrorist";
    }

    @Override
    public String assignationMessage() {
        return "You are a Terrorist, kill all Citizens";
    }

    @Override
    public boolean objective() {
        return false;
    }
}
