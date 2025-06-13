package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BackboneItems {

    public static final Item CHARM_BAG = new Item(new Item.Settings());

    public static void register() {
        registerItem("charm_bag", CHARM_BAG);
    }

    public static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, BackboneMod.id(name), item);
    }

}
