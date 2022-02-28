package pl.starozytny;

import lombok.Getter;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;
import pl.starozytny.command.CommandGroup;
import pl.starozytny.events.PlayerKill;
import pl.starozytny.util.ConfigFile;
import pl.starozytny.util.SettingsFile;

import java.util.Collections;
import java.util.List;

public class KillRewards extends SimplePlugin {

	@Getter
	private final CommandGroup mainCommand = new CommandGroup();

	@Override
	public List<Class<? extends YamlStaticConfig>> getSettings() {
		return Collections.singletonList(SettingsFile.class);
	}

	@Override
	protected void onPluginStart() {
		registerEvents(new PlayerKill());
		ConfigFile.getInstance();
		Common.ADD_TELL_PREFIX = false;
		Common.ADD_LOG_PREFIX = true;
		Common.setLogPrefix("&f[&3KillRewards&f]");

	}
}
