package net.lawliet.soul_alchemy_jei.SubtypeInterpreter;

import mezz.jei.api.ingredients.subtypes.ISubtypeInterpreter;
import mezz.jei.api.ingredients.subtypes.UidContext;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemModelSubtypeInterpreter implements ISubtypeInterpreter<ItemStack> {
    public static final ItemModelSubtypeInterpreter INSTANCE = new ItemModelSubtypeInterpreter();

    private ItemModelSubtypeInterpreter() {}

    @Override
    public @Nullable Object getSubtypeData(ItemStack ingredient, @NotNull UidContext context) {
        return ingredient.get(DataComponents.ITEM_MODEL);
    }

}
