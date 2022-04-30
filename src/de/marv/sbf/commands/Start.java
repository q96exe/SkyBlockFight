package de.marv.sbf.commands;

import de.marv.sbf.gamestates.LobbyState;
import de.marv.sbf.main.Main;
import de.marv.sbf.utils.Data;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Start implements CommandExecutor {

    private Main instance = Main.getInstance();
    private final int startSeconds = 10;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("sbf.start")) {
                if(args.length == 0) {
                    if(instance.getGameStateManager().getCurrentGameState() instanceof LobbyState) {
                        LobbyState lobbyState = (LobbyState) instance.getGameStateManager().getCurrentGameState();
                        if(lobbyState.getLobbyCountdown().isRunning() && lobbyState.getLobbyCountdown().getSeconds() > startSeconds) {
                            lobbyState.getLobbyCountdown().setSeconds(startSeconds);
                            player.sendMessage(Data.prefix + "Du hast das Spiel gestartet!");
                        } else {
                            player.sendMessage(Data.prefix + "Das Spiel ist bereits gestartet!");
                        }
                    } else {
                        player.sendMessage(Data.prefix + "Das Spiel ist bereits gestartet!");
                    }
                } else {
                    player.sendMessage(Data.use + "start");
                }
            } else {
                player.sendMessage(Data.noperms);
            }
        }


        return true;
    }
}
