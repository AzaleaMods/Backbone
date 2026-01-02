package dev.jade.backbone.item;

import dev.jade.backbone.registry.BackboneItemComponents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AmuletItem extends Item {

    public AmuletItem(Properties properties) {
        super(properties);
    }

    @Override
    public Component getName(ItemStack stack) {
        return stack.has(BackboneItemComponents.FULL) ?
                Component.translatable("item.backbone.amulet.full") :
                Component.translatable("item.backbone.amulet.empty");
    }
}
