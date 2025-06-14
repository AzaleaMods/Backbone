package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.item.SextantItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BackboneItems {

    public static final Item SEXTANT = new SextantItem(new Item.Settings().component(BackboneItemComponents.TIME, 0));

    public static void register() {

        registerItem("sextant", SEXTANT);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {

            entries.addAfter(Items.CLOCK, SEXTANT);

        });

    }

    public static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, BackboneMod.id(name), item);
    }

}
