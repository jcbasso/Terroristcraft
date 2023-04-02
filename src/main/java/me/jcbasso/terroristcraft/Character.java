package me.jcbasso.terroristcraft;

import me.jcbasso.terroristcraft.roles.Role;

import java.util.Objects;

public class Character {

    private final Role role;
    private final Player player;

    public Character(Role role, Player player) {
        this.role = role;
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return Objects.equals(player, character.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player);
    }
}
