package net.lawliet.soul_alchemy_jei;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.WritableBookContent;

public class SoulAchemyAddCreative {
    public static void addCreative(@SuppressWarnings("unused") CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept(SoulInfuser());
        output.accept(EmptyTome());
        output.accept(KnowledgeTome());
        output.accept(SoulShears());
        output.accept(StatueBase());
        for(SiphonType siphonType: SiphonType.values()) {
            output.accept(Siphon(siphonType));
        }
    }

    private static ItemStack SoulInfuser() {
        ItemStack itemStack = new ItemStack(Items.ARMOR_STAND);
        itemStack.set(DataComponents.RARITY, Rarity.UNCOMMON);
        itemStack.set(DataComponents.ITEM_NAME, MutableComponent.create(new TranslatableContents("block.soul_alchemy.soul_infuser", "Soul Infuser", TranslatableContents.NO_ARGS)));
        itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY.update(p -> p.putInt("soul_infuser",1)));
        itemStack.set(DataComponents.ENTITY_DATA, CustomData.EMPTY.update(p -> {
            p.putString("id","minecraft:armor_stand");
            p.put("Tags", new ListTag() {{ add(StringTag.valueOf("soul_infuser"));}});
        }));
        itemStack.set(DataComponents.ITEM_MODEL, ResourceLocation.fromNamespaceAndPath(SoulAlchemyJEIPlugin.SOULALCHEMYNAMESPACE, "soul_infuser"));
        itemStack.set(DataComponents.MAX_STACK_SIZE, 64);
        return itemStack;
    }
    private static ItemStack EmptyTome() {
        ItemStack itemStack = new ItemStack(Items.BOOK);
        itemStack.set(DataComponents.MAX_STACK_SIZE, 16);
        itemStack.set(DataComponents.RARITY, Rarity.COMMON);
        itemStack.set(DataComponents.ITEM_NAME, MutableComponent.create(new TranslatableContents("item.soul_alchemy.tome.empty_tome", "Empty Tome", TranslatableContents.NO_ARGS)));
        itemStack.set(DataComponents.ITEM_MODEL, ResourceLocation.fromNamespaceAndPath(SoulAlchemyJEIPlugin.SOULALCHEMYNAMESPACE, "empty_tome"));
        itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY.update(p -> p.putInt("empty_tome",1)));
        return itemStack;
    }
    private static ItemStack KnowledgeTome() {
        ItemStack itemStack= new ItemStack(Items.WRITTEN_BOOK);
        itemStack.set(DataComponents.RARITY, Rarity.UNCOMMON);
        itemStack.set(DataComponents.ITEM_NAME, MutableComponent.create(new TranslatableContents("item.soul_alchemy.tome.knowledge_tome", "Tome of Knowledge", TranslatableContents.NO_ARGS)));
        itemStack.set(DataComponents.ITEM_MODEL, ResourceLocation.fromNamespaceAndPath(SoulAlchemyJEIPlugin.SOULALCHEMYNAMESPACE, "tome_of_knowledge"));
        itemStack.set(DataComponents.WRITABLE_BOOK_CONTENT,
                WritableBookContent.EMPTY
        );
        return itemStack;
    }
    private static ItemStack SoulShears() {
        ItemStack itemStack = new ItemStack(Items.SHEARS);
        itemStack.set(DataComponents.RARITY, Rarity.RARE);
        itemStack.set(DataComponents.ITEM_NAME, MutableComponent.create(new TranslatableContents("item.soul_alchemy.soul_shears", "Soul Shears", TranslatableContents.NO_ARGS)));
        itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY.update(p -> p.putInt("soul_shears",1)));
        itemStack.set(DataComponents.ITEM_MODEL, ResourceLocation.fromNamespaceAndPath(SoulAlchemyJEIPlugin.SOULALCHEMYNAMESPACE, "soul_shears"));
        itemStack.set(DataComponents.MAX_DAMAGE, 1428);
        return itemStack;
    }
    private static ItemStack StatueBase() {
        ItemStack itemStack = new ItemStack(Items.ARMOR_STAND);
        itemStack.set(DataComponents.MAX_STACK_SIZE, 64);
        itemStack.set(DataComponents.RARITY, Rarity.UNCOMMON);
        itemStack.set(DataComponents.ITEM_NAME, MutableComponent.create(new TranslatableContents("block.soul_alchemy.statue_base", "Statue Base", TranslatableContents.NO_ARGS)));
        itemStack.set(DataComponents.CUSTOM_DATA, CustomData.EMPTY.update(p -> p.putInt("statue_base",1)));
        itemStack.set(DataComponents.ITEM_MODEL, ResourceLocation.fromNamespaceAndPath(SoulAlchemyJEIPlugin.SOULALCHEMYNAMESPACE, "statue_base"));
        itemStack.set(DataComponents.ENTITY_DATA, CustomData.EMPTY.update(p -> {
            p.putString("id","minecraft:armor_stand");
            p.put("Tags", new ListTag() {{ add(StringTag.valueOf("statue_base"));}});
        }));
        return itemStack;
    }

    private static ItemStack Siphon(SiphonType siphonType) {
        ItemStack itemStack = new ItemStack(Items.BOOK);
        itemStack.set(DataComponents.RARITY, Rarity.UNCOMMON);
        itemStack.set(DataComponents.MAX_STACK_SIZE, 1);
        itemStack.set(DataComponents.ITEM_NAME, MutableComponent.create(new TranslatableContents(siphonType.getTranslationKey(), siphonType.getFallbackName(), TranslatableContents.NO_ARGS)));
        itemStack.set(DataComponents.CUSTOM_DATA, siphonType.getCustomData());
        itemStack.set(DataComponents.ITEM_MODEL, siphonType.getModel(SoulAlchemyJEIPlugin.SOULALCHEMYNAMESPACE));
        itemStack.set(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, Boolean.TRUE);
        itemStack.set(DataComponents.CONSUMABLE, Consumables.defaultDrink().consumeSeconds(2147483647).hasConsumeParticles(false).build());
        return itemStack;
    }
}
