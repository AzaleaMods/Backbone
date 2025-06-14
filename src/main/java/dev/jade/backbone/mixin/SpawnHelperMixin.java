package dev.jade.backbone.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.SpawnHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static dev.jade.backbone.BackboneMod.*;

@Mixin(SpawnHelper.class)
public class SpawnHelperMixin {

    @ModifyArg(method = "spawnEntitiesInChunk(Lnet/minecraft/entity/SpawnGroup;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/world/chunk/Chunk;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/world/SpawnHelper$Checker;Lnet/minecraft/world/SpawnHelper$Runner;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/SpawnHelper;createMob(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/EntityType;)Lnet/minecraft/entity/mob/MobEntity;"), index = 1)
    private static EntityType<?> backbone$spawnDeepMobs(EntityType<?> type, @Local(argsOnly = true) BlockPos pos) {
        if(pos.getY() > 0 || !DEEP_MOBS.containsKey(type)) return type;
        return DEEP_MOBS.get(type);
    }

}
