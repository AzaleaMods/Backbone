package dev.jade.backbone.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.jade.backbone.registry.BackboneItemComponents;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HopperBlockEntity.class)
public abstract class HopperBlockEntityMixin {

    @WrapOperation(method = "extract(Lnet/minecraft/inventory/Inventory;Lnet/minecraft/entity/ItemEntity;)Z", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ItemEntity;getStack()Lnet/minecraft/item/ItemStack;"))
    private static ItemStack backbone$removeDeathProtectionOnExtraction(ItemEntity instance, Operation<ItemStack> original) {
        ItemStack stack = instance.getStack();
        if (stack.contains(BackboneItemComponents.DEATH_PROTECTION)) {
            stack.remove(BackboneItemComponents.DEATH_PROTECTION);
        }
        instance.setStack(stack);
        return original.call(instance);
    }

}
