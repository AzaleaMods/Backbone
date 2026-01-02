package dev.jade.backbone.client;

import dev.jade.backbone.registry.BackboneItemComponents;
import dev.jade.backbone.registry.BackboneItems;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.util.ARGB;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SextantOverlayRenderer implements HudElement {

    @Override
    public void render(GuiGraphics graphics, DeltaTracker tickCounter) {

        Minecraft client = Minecraft.getInstance();
        Font font = client.font;
        Player player = client.player;
        if (player == null) return;

        ItemStack heldStack = player.getMainHandItem();
        if(!heldStack.is(BackboneItems.SEXTANT)) return;

        int time = heldStack.getOrDefault(BackboneItemComponents.TIME, 0);
        if(time <= player.tickCount) return;

        int centerX = graphics.guiWidth() / 2;
        int centerY = graphics.guiHeight() / 2;

        String pos = player.chunkPosition().toString();
        int width = font.width(pos);

        int alpha = (int) Math.clamp(((time - player.tickCount) / 60.0F) * 255, 4, 255);
        int color = ARGB.color(alpha, 0xEBB552);
        graphics.drawStringWithBackdrop(
                font,
                Component.literal(pos),
                centerX - (width / 2), centerY + 30,
                width,
                color
        );

    }

}
