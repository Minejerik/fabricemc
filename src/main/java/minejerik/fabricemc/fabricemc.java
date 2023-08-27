package minejerik.fabricemc;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

import net.minecraft.recipe.RecipeManager;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import static net.minecraft.server.command.CommandManager.*;

public class fabricemc implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("fabric-emc");

	public fabricemcconfig config = new fabricemcconfig("fabricemc");

	@Override
	public void onInitialize() {
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(literal("fabricemc")
				.executes(context -> {
					return 1;
				})));



		// Iterate through all registered items
		for (Item item : Registries.ITEM) {
			// Do something with each item, like printing its identifier


//			System.out.println("Item: " + Registries.ITEM.getId(item));
			String item_id = String.valueOf(Registries.ITEM.getId(item));
//			if (Registries.BLOCK.containsId(Identifier.tryParse(item_id))){
//				continue;
//			}
//			item_id = item_id.replaceAll("minecraft","fabricemc");
			int raw_id = Registries.ITEM.getRawId(item);
//			LOGGER.info("Item: " + item_id);



			// an instance of our new item

			String EMC = config.config.get(item_id);

			if (EMC == null){
				EMC = "80085";
			}

			int int_emc = Integer.parseInt(EMC);



			if (Registries.ITEM.containsId(Identifier.tryParse(item_id)) && !Registries.BLOCK.containsId(Identifier.tryParse(item_id))) {

				Item CUSTOM_ITEM = new fabricemcitem(new FabricItemSettings(), int_emc);

				Registry.register(Registries.ITEM, raw_id, item_id, CUSTOM_ITEM);
			} else if (Registries.BLOCK.containsId(Identifier.tryParse(item_id))) {
				Block block_item = Registries.BLOCK.get(Identifier.tryParse(item_id));
				Registry.register(Registries.ITEM, raw_id, item_id, new fabricemcblockitem(block_item, new FabricItemSettings(), int_emc));
			}
		}
	}
}