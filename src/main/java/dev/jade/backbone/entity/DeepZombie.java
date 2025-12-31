package dev.jade.backbone.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.level.Level;

public class DeepZombie extends Zombie {

    public DeepZombie(EntityType<? extends Zombie> entityType, Level world) {
        super(entityType, world);
    }

}
