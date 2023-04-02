package me.jcbasso.terroristcraft.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.logging.LogUtils;
import me.jcbasso.terroristcraft.GameManager;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ReadyCommand {
    private final GameManager gameManager;

    public ReadyCommand(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @SubscribeEvent
    public void registerCommandEvent(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands
            .literal(this.getKey())
            .executes((context) -> execute(context.getSource()))
        )
        ;
    }

    public String getKey() {
        return "ready";
    }

    public int execute(CommandSourceStack source) {
        if (!(source.getEntity() instanceof ServerPlayer)) {
            return 0;
        }

        this.gameManager.ready((ServerPlayer) source.getEntity());
        return 1;
    }
}
