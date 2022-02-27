package pl.starozytny.events;

import com.alonsoaliaga.alonsoleagues.api.AlonsoLeaguesAPI;
import com.alonsoaliaga.alonsolevels.api.AlonsoLevelsAPI;
import com.yapzhenyie.GadgetsMenu.api.GadgetsMenuAPI;
import com.yapzhenyie.GadgetsMenu.player.PlayerManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.PlayerUtil;
import pl.starozytny.util.ConfigFile;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayerKill implements Listener {

	@EventHandler
	public void playerKill(PlayerDeathEvent event) {
		Player killer = event.getEntity().getKiller();
		Player victim = event.getEntity().getPlayer();
		ConfigFile config = ConfigFile.getInstance();
		PlayerManager playerKiller = GadgetsMenuAPI.getPlayerManager(killer);

		List<String> messages_victim;
		List<String> messages_killer;

		if (victim == null) {
			return;
		}

		if (killer == null) {
			return;
		}

		if (PlayerUtil.hasPerm(killer, "mnoznik.gracz")) {
			AlonsoLevelsAPI.addExperience(killer.getUniqueId(), Integer.parseInt(config.DEFAULT_EXPERIENCE));
			playerKiller.addMysteryDust(Integer.parseInt(config.DEFAULT_MONEY));
			AlonsoLeaguesAPI.addPoints(killer.getUniqueId(), Integer.parseInt(config.DEFAULT_POINTS_ADD));
			AlonsoLeaguesAPI.removePoints(killer.getUniqueId(), Integer.parseInt(config.DEFAULT_POINTS_REMOVE));

			messages_victim = config.MESSAGES_DEFAULT_VICTIM.stream().filter(Objects::nonNull).map(rawList -> rawList.
					replace("{victim}", victim.getName()).
					replace("{killer}", killer.getName()).
					replace("{points_add}", config.DEFAULT_POINTS_ADD).
					replace("{points_remove}", config.DEFAULT_POINTS_REMOVE).
					replace("{experience}", config.DEFAULT_EXPERIENCE).
					replace("{money}", config.DEFAULT_MONEY)).collect(Collectors.toList());

			messages_killer = config.MESSAGES_DEFAULT_KILLER.stream().filter(Objects::nonNull).map(rawList -> rawList.
					replace("{victim}", victim.getName()).
					replace("{killer}", killer.getName()).
					replace("{points_add}", config.DEFAULT_POINTS_ADD).
					replace("{points_remove}", config.DEFAULT_POINTS_REMOVE).
					replace("{experience}", config.DEFAULT_EXPERIENCE).
					replace("{money}", config.DEFAULT_MONEY)).collect(Collectors.toList());

			Common.tell(victim, messages_victim);
			Common.tell(killer, messages_killer);

		} else if (PlayerUtil.hasPerm(killer, "mnoznik.vip")) {
			AlonsoLevelsAPI.addExperience(killer.getUniqueId(), Integer.parseInt(config.VIP_EXPERIENCE));
			playerKiller.addMysteryDust(Integer.parseInt(config.VIP_MONEY));
			AlonsoLeaguesAPI.addPoints(killer.getUniqueId(), Integer.parseInt(config.VIP_POINTS_ADD));
			AlonsoLeaguesAPI.removePoints(killer.getUniqueId(), Integer.parseInt(config.VIP_POINTS_REMOVE));

			messages_victim = config.MESSAGES_VIP_VICTIM.stream().filter(Objects::nonNull).map(rawList -> rawList.
					replace("{victim}", victim.getName()).
					replace("{killer}", killer.getName()).
					replace("{points_add}", config.VIP_POINTS_ADD).
					replace("{points_remove}", config.VIP_POINTS_REMOVE).
					replace("{experience}", config.VIP_EXPERIENCE).
					replace("{money}", config.VIP_MONEY)).collect(Collectors.toList());

			messages_killer = config.MESSAGES_VIP_KILLER.stream().filter(Objects::nonNull).map(rawList -> rawList.
					replace("{victim}", victim.getName()).
					replace("{killer}", killer.getName()).
					replace("{points_add}", config.VIP_POINTS_ADD).
					replace("{points_remove}", config.VIP_POINTS_REMOVE).
					replace("{experience}", config.VIP_EXPERIENCE).
					replace("{money}", config.VIP_MONEY)).collect(Collectors.toList());


			Common.tell(victim, messages_victim);
			Common.tell(killer, messages_killer);

		} else if (PlayerUtil.hasPerm(killer, "mnoznik.vip+")) {
			AlonsoLevelsAPI.addExperience(killer.getUniqueId(), Integer.parseInt(config.SVIP_EXPERIENCE));
			playerKiller.addMysteryDust(Integer.parseInt(config.SVIP_MONEY));
			AlonsoLeaguesAPI.addPoints(killer.getUniqueId(), Integer.parseInt(config.SVIP_POINTS_ADD));
			AlonsoLeaguesAPI.removePoints(killer.getUniqueId(), Integer.parseInt(config.SVIP_POINTS_REMOVE));

			messages_victim = config.MESSAGES_SVIP_VICTIM.stream().filter(Objects::nonNull).map(rawList -> rawList.
					replace("{victim}", victim.getName()).
					replace("{killer}", killer.getName()).
					replace("{points_add}", config.SVIP_POINTS_ADD).
					replace("{points_remove}", config.SVIP_POINTS_REMOVE).
					replace("{experience}", config.SVIP_EXPERIENCE).
					replace("{money}", config.SVIP_MONEY)).collect(Collectors.toList());

			messages_killer = config.MESSAGES_SVIP_KILLER.stream().filter(Objects::nonNull).map(rawList -> rawList.
					replace("{victim}", victim.getName()).
					replace("{killer}", killer.getName()).
					replace("{points_add}", config.SVIP_POINTS_ADD).
					replace("{points_remove}", config.SVIP_POINTS_REMOVE).
					replace("{experience}", config.SVIP_EXPERIENCE).
					replace("{money}", config.SVIP_MONEY)).collect(Collectors.toList());

			Common.tell(victim, messages_victim);
			Common.tell(killer, messages_killer);

		} else if (PlayerUtil.hasPerm(killer, "mnoznik.vip+")) {
			AlonsoLevelsAPI.addExperience(killer.getUniqueId(), Integer.parseInt(config.MVIP_EXPERIENCE));
			playerKiller.addMysteryDust(Integer.parseInt(config.MVIP_MONEY));
			AlonsoLeaguesAPI.addPoints(killer.getUniqueId(), Integer.parseInt(config.MVIP_POINTS_ADD));
			AlonsoLeaguesAPI.removePoints(killer.getUniqueId(), Integer.parseInt(config.MVIP_POINTS_REMOVE));

			messages_victim = config.MESSAGES_MVIP_VICTIM.stream().filter(Objects::nonNull).map(rawList -> rawList.
					replace("{victim}", victim.getName()).
					replace("{killer}", killer.getName()).
					replace("{points_add}", config.MVIP_POINTS_ADD).
					replace("{points_remove}", config.MVIP_POINTS_REMOVE).
					replace("{experience}", config.MVIP_EXPERIENCE).
					replace("{money}", config.MVIP_MONEY)).collect(Collectors.toList());

			messages_killer = config.MESSAGES_MVIP_KILLER.stream().filter(Objects::nonNull).map(rawList -> rawList.
					replace("{victim}", victim.getName()).
					replace("{killer}", killer.getName()).
					replace("{points_add}", config.MVIP_POINTS_ADD).
					replace("{points_remove}", config.MVIP_POINTS_REMOVE).
					replace("{experience}", config.MVIP_EXPERIENCE).
					replace("{money}", config.MVIP_MONEY)).collect(Collectors.toList());

			Common.tell(victim, messages_victim);
			Common.tell(killer, messages_killer);
		}
	}
}