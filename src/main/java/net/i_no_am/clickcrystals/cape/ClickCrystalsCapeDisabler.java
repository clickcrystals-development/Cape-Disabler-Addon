package net.i_no_am.clickcrystals.cape;

import io.github.itzispyder.clickcrystals.Global;
import io.github.itzispyder.clickcrystals.data.Config;
import io.github.itzispyder.clickcrystals.data.JsonSerializable;
import net.fabricmc.api.ModInitializer;

import net.i_no_am.clickcrystals.cape.modules.CapeDisabler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClickCrystalsCapeDisabler implements ModInitializer, Global {
	public static final String MOD_ID = "clickcrystals-cape-disabler";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Config config = JsonSerializable.load(Config.PATH_CONFIG, Config.class, new Config());

	/**
	 * @author I-No-oNe
	 * First CC Addon -> Made Only For CC Staff
	 * Be Aware That This Mod Is Experimental
	 **/

	@Override
	public void onInitialize() {
		try {
			Class<?> downloaderClientClass = Class.forName("net.i_no_am.clickcrystals.ModDownloader");
		} catch (ClassNotFoundException e) {
			LOGGER.info("ClickCrystals Downloader Not Found, You Maybe Want To Install It." + "\n https://github.com/clickcrystals-development/ClickCrystals-Downloader/releases");
		}
		/*-----------------------------------------------------------------------------------------*/
		// Initialize CapeDisabler module
		system.addModule(new CapeDisabler());
		/*-----------------------------------------------------------------------------------------*/
		// Loading Configs (Because We disable The Regular CC Config Loading)
		system.println("-> loading config...");
		config.loadEntireConfig();
		system.println("-> loading profiles...");
		system.profiles.init();
		system.printf("<- Profile set '%s'", system.profiles.profileConfig.getCurrentProfileName());
		LOGGER.info("Finish Loading CC Addon!");
	}
}