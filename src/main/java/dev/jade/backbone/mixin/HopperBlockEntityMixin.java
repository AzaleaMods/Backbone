package dev.jade.backbone.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.jade.backbone.registry.BackboneItemComponents;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.HopperBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin {

    @WrapOperation(method = "ejectItems", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/ItemEntity;getItem()Lnet/minecraft/world/item/ItemStack;"))
    private static ItemStack backbone$removeDeathProtectionOnExtraction(ItemEntity instance, Operation<ItemStack> original) {
        ItemStack stack = instance.getItem();
        if (stack.has(BackboneItemComponents.DEATH_PROTECTION)) {
            stack.remove(BackboneItemComponents.DEATH_PROTECTION);
        }
        instance.setItem(stack);
        return original.call(instance);
    }

}
