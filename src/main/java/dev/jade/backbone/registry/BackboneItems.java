package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.item.SextantItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Function;

public class BackboneItems {

    public static final Item SEXTANT = registerItem("sextant", properties ->
            new SextantItem(properties.component(BackboneItemComponents.TIME, 0))
    );

    public static void register() {

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {

            entries.addAfter(Items.CLOCK, SEXTANT);

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
