package dev.jade.backbone.mixin;

import com.llamalad7.mixinextras.expression.Definition;
import com.llamalad7.mixinextras.expression.Expression;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.jade.backbone.registry.BackboneItemComponents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    @Shadow public abstract ItemStack getStack();

    public ItemEntityMixin(EntityType<?> type, Level level) {
        super(type, level);
    }

    @Definition(id = "itemAge", field = "Lnet/minecraft/entity/ItemEntity;itemAge:I")
    @Expression("this.itemAge >= 6000")
    @ModifyExpressionValue(method = "tick", at = @At("MIXINEXTRAS:EXPRESSION"))
    private boolean backbone$preventDespawnWithDeathProtection(boolean original) {
        return original && !this.getStack().getOrDefault(BackboneItemComponents.DEATH_PROTECTION, false);
    }

    @ModifyReturnValue(method = "isFireImmune", at = @At("RETURN"))
    private boolean backboneFireImmunity(boolean original) {
        return original || this.getStack().getOrDefault(BackboneItemComponents.DEATH_PROTECTION, false);
    }

    /*@ModifyReturnValue(method = "explosionImmune", at = @At("RETURN"))
    private boolean backboneExplosionImmunity(boolean original) {
        return original || this.getStack().getOrDefault(BackboneItemComponents.DEATH_PROTECTION, false);
    }*/ // this is only a thing on newer versions I fear

    @WrapOperation(method = "onPlayerCollision", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/ItemEntity;getItem()Lnet/minecraft/world/item/ItemStack;"))
    private ItemStack backbone$removeDeathProtectionOnPickup(ItemEntity instance, Operation<ItemStack> original) {
        ItemStack stack = original.call(instance);
        if (stack.has(BackboneItemComponents.DEATH_PROTECTION)) {
            stack.remove(BackboneItemComponents.DEATH_PROTECTION);
        }
        return stack;
    }

}
