package net.lawliet.soul_alchemy_jei;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(SoulAlchemyJEIPlugin.MODID)
public class SoulAlchemyJEIPlugin {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "soul_alchemy_jei";
    public static final String SOULALCHEMYNAMESPACE = "soul_alchemy";
    // Directly reference a slf4j logger
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    @SuppressWarnings("unused")
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SOUL_ALCHEMY_TAB = CREATIVE_MODE_TABS.register("soul_alchemy", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.soul_alchemy_jei")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(SoulAlchemyJEIPlugin::getCreativeTabIcon)
            .displayItems(SoulAchemyAddCreative::addCreative).build());

    private static ItemStack getCreativeTabIcon() {
            ItemStack itemStack = new ItemStack(Items.ARMOR_STAND);
            itemStack.set(DataComponents.ITEM_MODEL, ResourceLocation.fromNamespaceAndPath("soul_alchemy", "soul_infuser"));
            return itemStack;
    }


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public SoulAlchemyJEIPlugin(IEventBus modEventBus,@SuppressWarnings("unused") ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (SoulAlchemyJEIPlugin) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code

    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
    }
}
