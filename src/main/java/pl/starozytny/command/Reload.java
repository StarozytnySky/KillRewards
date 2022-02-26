package pl.starozytny.command;

import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleSubCommand;
import pl.starozytny.util.ConfigFile;

public class Reload extends SimpleSubCommand {

	protected Reload() {
		super("reload");
	}

	@Override
	protected void onCommand() {

		ConfigFile.getInstance().reload();

		Common.tell(sender, "Wtyczka zostala przeladowana");

	}
}
