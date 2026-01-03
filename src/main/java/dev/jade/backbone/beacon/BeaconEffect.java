package dev.jade.backbone.beacon;

import net.minecraft.core.BlockBox;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.stream.Collectors;

public abstract class BeaconEffect {

    protected final BlockPos pos;
    protected final Level level;

    protected int range;

    protected BeaconEffect(BlockPos pos, Level level, int range) {
        this.pos = pos;
        this.level = level;
        this.range = range;
    }

    public void tick() {

    }

    public AABB getBoundingBox() {
        return new AABB(this.pos).inflate(range);
    }

    public boolean isInRange(BlockPos pos) {
        return this.getBoundingBox().contains(pos.getCenter());
    }

    public List<Entity> getEntities() {
        return this.level.getEntities(null, this.getBoundingBox());
    }

    public List<Mob> getMobs() {
        return this.getEntities()
                .stream()
                .filter(entity -> entity instanceof Mob)
                .map(entity -> (Mob) entity)
                .collect(Collectors.toList());
    }

}
