package dev.jade.backbone.entity.renderer;

import com.google.common.collect.ImmutableList;
import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.entity.DeepZombieEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.util.Identifier;

import java.util.List;

@Environment(EnvType.CLIENT)
public class DeepZombieEntityRenderer extends ZombieBaseEntityRenderer<DeepZombieEntity, ZombieEntityModel<DeepZombieEntity>> {

    private static final List<Identifier> TEXTURES = ImmutableList.of(
            BackboneMod.id("textures/entity/zombie/deep1.png")
    );

    public DeepZombieEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.ZOMBIE, EntityModelLayers.ZOMBIE_INNER_ARMOR, EntityModelLayers.ZOMBIE_OUTER_ARMOR);
    }

    public DeepZombieEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer) {
        super(ctx, new ZombieEntityModel<>(ctx.getPart(layer)), new ZombieEntityModel<>(ctx.getPart(legsArmorLayer)), new ZombieEntityModel<>(ctx.getPart(bodyArmorLayer)));
    }

    @Override
    public Identifier getTexture(ZombieEntity zombieEntity) {
        return TEXTURES.getFirst();
    }

}
