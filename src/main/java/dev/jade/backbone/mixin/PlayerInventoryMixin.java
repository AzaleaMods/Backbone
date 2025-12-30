package dev.jade.backbone.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.jade.backbone.registry.BackboneItemComponents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PlayerInventory.class)
public abstract class PlayerInventoryMixin {

    @WrapOperation(method = "dropAll", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/PlayerEntity;dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;"))
    private ItemEntity backbone$dropProtectedItems(PlayerEntity instance, ItemStack stack, boolean dropAtSelf, boolean retainOwnership, Operation<ItemEntity> original) {
        stack.set(BackboneItemComponents.DEATH_PROTECTION, true);
        return original.call(instance, stack, dropAtSelf, retainOwnership);
    }

}
