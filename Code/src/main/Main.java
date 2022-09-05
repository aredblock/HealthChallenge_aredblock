package main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public boolean onCommand(CommandSender sender, Command befehl, String befehsname, String[] args) {
		if (sender instanceof Player) {
			if (befehsname.equalsIgnoreCase("challenge")) {
				if (sender.isOp()) {
					Player p = (Player) sender;

					p.setDisplayName(ChatColor.RED.toString() + "Challange" + ChatColor.GRAY.toString() + " | "
							+ ChatColor.WHITE.toString() + p.getName());
					p.setCustomName(ChatColor.RED.toString() + "Challange" + ChatColor.GRAY.toString() + " | "
							+ ChatColor.WHITE.toString() + p.getName());

					if (args[0].equalsIgnoreCase("easy")) {
						setH(p, 10);
					} else if (args[0].equalsIgnoreCase("hard")) {
						setH(p, 3);
					} else if (args[0].equalsIgnoreCase("god")) {
						setH(p, 1);
					} else if (args[0].equalsIgnoreCase("reset")) {
						setH(p, 20);
						try {
							p.setHealth(20);
							p.setDisplayName(p.getName());
							p.setCustomName(p.getName());
						} catch (Exception e) {
							p.sendMessage("Error");
						}
					}
				}
			}

			if (befehsname.equalsIgnoreCase("ch-help")) {
				sender.sendMessage("HELP: /challenge <command: easy, hard, god, (reset> For reset the challenge!)");
			}
		}
		return true;
	}

	public void setH(Player p, int health) {
		try {

			p.setHealth(health);
			p.setHealthScale(health);
		} catch (Exception e) {
			p.sendMessage("Error");
		}
	}
}
