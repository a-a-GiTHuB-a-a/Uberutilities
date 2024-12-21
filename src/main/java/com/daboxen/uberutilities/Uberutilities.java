package com.daboxen.uberutilities;

import com.daboxen.uberutilities.additions.items.Uberblocks;
import com.daboxen.uberutilities.additions.machines.MachineRegistrar;
import com.daboxen.uberutilities.additions.materials.Ubermaterials;
import com.daboxen.uberutilities.additions.items.circuits.CircuitHandler;
import com.daboxen.uberutilities.api.RecipeTypes;
import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialRegistryEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegisterEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Uberutilities.MOD_ID)
public class Uberutilities {
	public static final String MOD_ID = "uberutilities";
	public static final Logger LOGGER = LogManager.getLogger();
	public static GTRegistrate UBER_REGISTRATE = GTRegistrate.create(Uberutilities.MOD_ID);

	public Uberutilities(IEventBus modEventBus) {
		modEventBus.register(this);
		modEventBus.addGenericListener(GTRecipeType.class, this::registerRecipeTypes);
		modEventBus.addGenericListener(MachineDefinition.class, this::registerMachines);

		// Most other events are fired on Forge's bus.
		// If we want to use annotations to register event listeners,
		// we need to register our object like this!
		MinecraftForge.EVENT_BUS.register(this);
		
		Uberblocks.init();
		CircuitHandler.registerItems();
		UBER_REGISTRATE.registerRegistrate();
	}

	public static ResourceLocation id(String path) { //yoinked this from GCyR
		return new ResourceLocation(MOD_ID, path);
	}

	@SubscribeEvent
	public void gatherData(GatherDataEvent event) {
		CircuitHandler.gatherData(event);
	}

	@SubscribeEvent
	public void commonSetup(final FMLCommonSetupEvent event) {
		/*event.enqueueWork(() -> {
			LOGGER.info("Hello from common setup! This is *after* registries are done, so we can do this:");
			LOGGER.info("Look, I found a {}!", Items.DIAMOND);
		});*/
	}

	@SubscribeEvent
	public void clientSetup(final FMLClientSetupEvent event) {
		//LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
	}

	// You MUST have this for custom materials.
	// Remember to register them not to GT's namespace, but your own.
	@SubscribeEvent
	public void addMaterialRegistries(MaterialRegistryEvent event) {
		GTCEuAPI.materialManager.createRegistry(Uberutilities.MOD_ID);
	}

	// As well as this.
	@SubscribeEvent
	public void addMaterials(MaterialEvent event) {
		Ubermaterials.init();
	}

	// This is optional, though.
	@SubscribeEvent
	public void modifyMaterials(PostMaterialEvent event) {
		Ubermaterials.modifyMaterials();
	}

	@SubscribeEvent
	public void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
		RecipeTypes.init();
	}

	@SubscribeEvent
	public void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
		MachineRegistrar.init();
	}
}
