package me.libraryaddict.Hungergames.Commands;

import me.libraryaddict.Hungergames.Managers.ChatManager;
import me.libraryaddict.Hungergames.Managers.PlayerManager;
import me.libraryaddict.Hungergames.Types.HungergamesApi;
import me.libraryaddict.Hungergames.Types.Gamer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Build implements CommandExecutor {
    private PlayerManager pm = HungergamesApi.getPlayerManager();
    private ChatManager cm = HungergamesApi.getChatManager();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (sender.hasPermission("hungergames.build")) {
            Gamer gamer = pm.getGamer(sender.getName());
            if (args.length > 0) {
                Player player = sender.getServer().getPlayer(args[0]);
                if (player == null) {
                    sender.sendMessage(cm.getCommandBuildPlayerDoesntExist());
                    return true;
                }
                Gamer game = pm.getGamer(player);
                game.setBuild(!game.canBuild());
                game.getPlayer().sendMessage(
                        String.format(cm.getCommandBuildRecieverBuildChanged(), sender.getName(), game.canBuild()));
                sender.sendMessage(String.format(cm.getCommandBuildSenderBuildChanged(), game.getName(), game.canBuild()));
            } else {
                gamer.setBuild(!gamer.canBuild());
                sender.sendMessage(String.format(cm.getCommandBuildChangedOwnBuild(), gamer.canBuild()));
            }
        } else
            sender.sendMessage(cm.getCommandBuildNoPermission());
        return true;
    }
}
