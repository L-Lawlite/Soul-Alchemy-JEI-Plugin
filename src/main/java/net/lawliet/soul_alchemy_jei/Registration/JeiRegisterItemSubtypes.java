package net.lawliet.soul_alchemy_jei.Registration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.ISubtypeRegistration;
import net.lawliet.soul_alchemy_jei.SoulAlchemyJEIPlugin;
import net.lawliet.soul_alchemy_jei.SubtypeInterpreter.ItemModelSubtypeInterpreter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
@JeiPlugin
public class JeiRegisterItemSubtypes implements IModPlugin {
    /**
     * The unique ID for this mod plugin.
     * The namespace should be your mod's modId.
     */
    @NotNull
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(SoulAlchemyJEIPlugin.MODID, "soul_alchemy");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        registration.registerSubtypeInterpreter(Items.WRITTEN_BOOK, ItemModelSubtypeInterpreter.INSTANCE);
        registration.registerSubtypeInterpreter(Items.BOOK, ItemModelSubtypeInterpreter.INSTANCE);
        registration.registerSubtypeInterpreter(Items.SHEARS, ItemModelSubtypeInterpreter.INSTANCE);
        registration.registerSubtypeInterpreter(Items.ARMOR_STAND, ItemModelSubtypeInterpreter.INSTANCE);

    }
}
