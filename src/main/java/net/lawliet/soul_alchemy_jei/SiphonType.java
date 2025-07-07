package net.lawliet.soul_alchemy_jei;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.component.CustomData;
import org.jetbrains.annotations.NotNull;

public enum SiphonType implements StringRepresentable {
    BASIC("basic"),
    ADVANCED("advanced"),
    CONDENSER("condenser"),
    ELITE("elite");

    private final String name;

    SiphonType(String name) {
        this.name = name;
    }

    @Override
    public @NotNull String getSerializedName() {
        return this.name;
    }

    public String getFullName() {
        return this.name.substring(0,1).toUpperCase() + this.name.substring(1);
    }

    public ResourceLocation getModel(String modId) {
        return ResourceLocation.fromNamespaceAndPath(modId, "siphon_" + this.name);
    }

    public CustomData getCustomData() {
        return  CustomData.EMPTY.update(p -> p.putInt(this.name+"_xp_siphon",1));
    }

    public String getTranslationKey() {
        return "item.soul_alchemy.xp_siphon." + this.name;
    }
    public String getFallbackName() {
        return this.getFullName() + " XP Siphon";
    }
}
