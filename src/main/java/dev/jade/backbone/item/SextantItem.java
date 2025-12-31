package dev.jade.backbone.item;

import dev.jade.backbone.registry.BackboneItemComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class SextantItem extends Item {

    public SextantItem(Properties settings) {
        super(settings);
    }

    @Override
    public InteractionResult use(Level level, Player user, InteractionHand hand) {

        if(!level.isClientSide()) {
            user.getItemInHand(hand).set(BackboneItemComponents.TIME, user.tickCount + 80);
        }

        return super.use(level, user, hand);

    }

}
