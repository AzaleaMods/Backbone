package dev.jade.backbone.registry;

import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.item.SextantItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class BackboneItems {

    public static final Item SEXTANT = new SextantItem(new Item.Settings().component(BackboneItemComponents.TIME, 0));

    public static void register() {

        registerItem("sextant", SEXTANT);

    }

    public static void registerItem(String name, Item item) {
        Registry.register(Registries.ITEM, BackboneMod.id(name), item);
    }

}
