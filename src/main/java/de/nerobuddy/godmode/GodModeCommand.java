package de.nerobuddy.godmode;

import com.sun.istack.internal.NotNull;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static de.nerobuddy.godmode.Data.getGodModeList;
import static de.nerobuddy.godmode.Data.getPrefix;

/**
 * @author m_wei
 * @project GodModePlugin
 * @created 01.09.2022 - 21:47
 */

public class GodModeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull final CommandSender sender, @NotNull final Command command, @NotNull final String label, @NotNull final String[] args) {
        if (!(sender instanceof Player)) {
            if (args.length != 1) {
                sender.sendMessage(getPrefix() + "§6Usage /god <player>");
            } else {
                Player player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    UUID uuid = player.getUniqueId();
                    if (getGodModeList().contains(uuid)) {
                        player.setInvulnerable(false);
                        getGodModeList().remove(uuid);
                        player.sendMessage(getPrefix() + "§6GodMode §4deactivated§6!");
                        sender.sendMessage(getPrefix() + "§6GodMode §4deactivated §6for §3" + player.getName() + "§6!");
                    } else {
                        player.setInvulnerable(true);
                        getGodModeList().add(uuid);
                        player.sendMessage(getPrefix() + "§6GodMode §aactivated§6!");
                        sender.sendMessage(getPrefix() + "§6GodMode §aactivated §6for §3" + player.getName() + "§6!");
                    }
                }
            }
            return true;
        }
        Player player = (Player) sender;
        if (!(player.hasPermission("godmode.use"))) {
            player.sendMessage(getPrefix() + "§cYou do not have permission to use that command!");
            return true;
        }
        if (args.length == 0) {
            UUID uuid = player.getUniqueId();
            if (getGodModeList().contains(uuid)) {
                player.setInvulnerable(false);
                getGodModeList().remove(uuid);
                player.sendMessage(getPrefix() + "§6GodMode §4deactivated§6!");
            } else {
                player.setInvulnerable(true);
                getGodModeList().add(uuid);
                player.sendMessage(getPrefix() + "§6GodMode §aactivated§6!");
            }
        } else if (args.length == 1) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {
                UUID uuid = target.getUniqueId();
                if (getGodModeList().contains(uuid)) {
                    target.setInvulnerable(false);
                    getGodModeList().remove(uuid);
                    target.sendMessage(getPrefix() + "§6GodMode §4deactivated§6!");
                    player.sendMessage(getPrefix() + "§6GodMode §4deactivated §6for §3" + target.getName() + "§6!");
                } else {
                    target.setInvulnerable(true);
                    getGodModeList().add(uuid);
                    target.sendMessage(getPrefix() + "§6GodMode §aactivated§6!");
                    player.sendMessage(getPrefix() + "§6GodMode §aactivated §6for §3" + target.getName() + "§6!");
                }
            }
        } else {
            player.sendMessage(getPrefix() + "§6Usage /god <player>");
        }

        return true;
    }
}
