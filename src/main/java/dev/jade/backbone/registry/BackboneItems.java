package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.item.AmuletItem;
import dev.jade.backbone.item.SextantItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Unit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class BackboneItems {

    public static final Item AMULET = registerItem("amulet", properties ->
            new AmuletItem(properties.component(BackboneItemComponents.FULL, Unit.INSTANCE))
    );

    public static final Item SEXTANT = registerItem("sextant", properties ->
            new SextantItem(properties.component(BackboneItemComponents.TIME, 0))
    );

    public static final Item CLAYMORE = registerItem("claymore", Item::new);

    public static void register() {

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {

            entries.addAfter(Items.CLOCK, SEXTANT);

        });

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {

            entries.addAfter(Items.GHAST_TEAR, AMULET);
            ItemStack emptyAmulet = AMULET.getDefaultInstance().copy();
            emptyAmulet.remove(BackboneItemComponents.FULL);
            entries.addAfter(Items.GHAST_TEAR, emptyAmulet);

        });

    }

    public static Item registerItem(String name, Function<Item.Properties, Item> factory) {
        ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, BackboneMod.id(name));
        return Registry.register(
                BuiltInRegistries.ITEM,
                key,
                factory.apply(new Item.Properties().setId(key))
        );
    }

}
