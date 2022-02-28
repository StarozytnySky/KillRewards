package pl.starozytny.util;

import lombok.Getter;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.settings.YamlConfig;

import java.util.List;

public class ConfigFile extends YamlConfig {

	/**
	 * The singleton of this class
	 */
	@Getter
	public final static ConfigFile instance = new ConfigFile();

	@Override
	protected boolean saveComments() {
		return true;
	}

	public String DEFAULT_EXPERIENCE;
	public String DEFAULT_POINTS_ADD;
	public String DEFAULT_POINTS_REMOVE;
	public String DEFAULT_MONEY;

	public String VIP_EXPERIENCE;
	public String VIP_POINTS_ADD;
	public String VIP_POINTS_REMOVE;
	public String VIP_MONEY;

	public String SVIP_EXPERIENCE;
	public String SVIP_POINTS_ADD;
	public String SVIP_POINTS_REMOVE;
	public String SVIP_MONEY;

	public String MVIP_EXPERIENCE;
	public String MVIP_POINTS_ADD;
	public String MVIP_POINTS_REMOVE;
	public String MVIP_MONEY;

	public List<String> MESSAGES_DEFAULT_VICTIM;
	public List<String> MESSAGES_DEFAULT_KILLER;

	public List<String> MESSAGES_VIP_VICTIM;
	public List<String> MESSAGES_VIP_KILLER;

	public List<String> MESSAGES_SVIP_VICTIM;
	public List<String> MESSAGES_SVIP_KILLER;

	public List<String> MESSAGES_MVIP_VICTIM;
	public List<String> MESSAGES_MVIP_KILLER;

	public Boolean DEBUG;

	public ConfigFile() {

		this.loadConfiguration(this.getSettingsFileName());
	}


	/*
	 * Automatically load the data upon calling CustomDataStorage#getInstance()
	 */
	public String getSettingsFileName() {
		return "config.yml";
	}

	/**
	 * Automatically called when the file is loaded, you can
	 * pull your values from the file here.
	 */
	@Override
	protected void onLoadFinish() {

		DEFAULT_EXPERIENCE = getString("Settings.Rewards.default.experience");
		DEFAULT_POINTS_ADD = getString("Settings.Rewards.default.points.add");
		DEFAULT_POINTS_REMOVE = getString("Settings.Rewards.default.points.remove");
		DEFAULT_MONEY = getString("Settings.Rewards.default.money");

		VIP_EXPERIENCE = getString("Settings.Rewards.vip.experience");
		VIP_POINTS_ADD = getString("Settings.Rewards.vip.points.add");
		VIP_POINTS_REMOVE = getString("Settings.Rewards.vip.points.remove");
		VIP_MONEY = getString("Settings.Rewards.vip.money");

		SVIP_EXPERIENCE = getString("Settings.Rewards.svip.experience");
		SVIP_POINTS_ADD = getString("Settings.Rewards.svip.points.add");
		SVIP_POINTS_REMOVE = getString("Settings.Rewards.svip.points.remove");
		SVIP_MONEY = getString("Settings.Rewards.svip.money");

		MVIP_EXPERIENCE = getString("Settings.Rewards.mvip.experience");
		MVIP_POINTS_ADD = getString("Settings.Rewards.mvip.points.add");
		MVIP_POINTS_REMOVE = getString("Settings.Rewards.mvip.points.remove");
		MVIP_MONEY = getString("Settings.Rewards.mvip.money");

		MESSAGES_DEFAULT_VICTIM = getStringList("Messages.default.victim");
		MESSAGES_DEFAULT_KILLER = getStringList("Messages.default.killer");

		MESSAGES_VIP_VICTIM = getStringList("Messages.vip.victim");
		MESSAGES_VIP_KILLER = getStringList("Messages.vip.killer");

		MESSAGES_SVIP_VICTIM = getStringList("Messages.svip.victim");
		MESSAGES_SVIP_KILLER = getStringList("Messages.svip.killer");

		MESSAGES_MVIP_VICTIM = getStringList("Messages.mvip.victim");
		MESSAGES_MVIP_KILLER = getStringList("Messages.mvip.killer");

		DEBUG = getBoolean("Settings.Debug");

	}

	/**
	 * Collect all data from this class that can be saved.
	 * Called automatically on save.
	 */
	@Override
	protected SerializedMap serialize() {
		return SerializedMap.ofArray();

	}
}
