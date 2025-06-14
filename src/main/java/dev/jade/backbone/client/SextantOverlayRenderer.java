package dev.jade.backbone.client;

import dev.jade.backbone.BackboneMod;
import dev.jade.backbone.registry.BackboneItemComponents;
import dev.jade.backbone.registry.BackboneItems;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.math.ColorHelper;

public class SextantOverlayRenderer implements HudRenderCallback {

    @Override
    public void onHudRender(DrawContext context, RenderTickCounter renderTickCounter) {

        MinecraftClient client = MinecraftClient.getInstance();
        TextRenderer textRenderer = client.textRenderer;
        PlayerEntity player = client.player;
        if (player == null) return;

        ItemStack heldStack = player.getMainHandStack();
        if(!heldStack.isOf(BackboneItems.SEXTANT)) return;

        int time = heldStack.get(BackboneItemComponents.TIME);
        if(time < player.age) return;

        int centerX = context.getScaledWindowWidth() / 2;
        int centerY = context.getScaledWindowHeight() / 2;

        String pos = player.getChunkPos().toString();
        int width = textRenderer.getWidth(pos);

        int alpha = (int) Math.clamp(((time - player.age) / 60.0F) * 255, 4, 255);
        int color = ColorHelper.Argb.withAlpha(alpha, 0xEBB552);
        context.drawTextWithShadow(
                textRenderer,
                Text.literal(pos),
                centerX - (width / 2), centerY + 30,
                color
        );

    }

}
