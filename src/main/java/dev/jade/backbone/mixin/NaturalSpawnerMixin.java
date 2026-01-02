package dev.jade.backbone.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.NaturalSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static dev.jade.backbone.BackboneMod.DEEP_MOBS;

@Mixin(NaturalSpawner.class)
public abstract class NaturalSpawnerMixin {

    @ModifyArg(
            method = "spawnCategoryForPosition(Lnet/minecraft/world/entity/MobCategory;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/level/chunk/ChunkAccess;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/NaturalSpawner$SpawnPredicate;Lnet/minecraft/world/level/NaturalSpawner$AfterSpawnCallback;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/level/NaturalSpawner;getMobForSpawn(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/entity/EntityType;)Lnet/minecraft/world/entity/Mob;"
            ),
            index = 1
    )
    private static EntityType<?> backbone$spawnDeepMobs(EntityType<?> type, @Local(argsOnly = true) BlockPos pos) {
        if(pos.getY() > 0 || !DEEP_MOBS.containsKey(type)) return type;
        return DEEP_MOBS.get(type);
    }

}
