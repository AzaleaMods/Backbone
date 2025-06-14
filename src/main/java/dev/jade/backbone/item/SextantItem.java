package dev.jade.backbone.item;

import dev.jade.backbone.registry.BackboneItemComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SextantItem extends Item {

    public SextantItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(!world.isClient()) {
            user.getStackInHand(hand).set(BackboneItemComponents.TIME, user.age + 80);
        }

        return super.use(world, user, hand);

    }

}
