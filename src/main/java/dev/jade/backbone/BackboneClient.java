package dev.jade.backbone;

import dev.jade.backbone.animation.BackboneAnimatedPlayer;
import dev.jade.backbone.client.SextantOverlayRenderer;
import dev.kosmx.playerAnim.api.IPlayable;
import dev.kosmx.playerAnim.api.layered.AnimationStack;
import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.api.layered.modifier.AbstractFadeModifier;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.core.util.Ease;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import static dev.jade.backbone.BackboneMod.*;

public class BackboneClient implements ClientModInitializer {

    public static final KeyBinding SPECIAL = new KeyBinding(
            "key.backbone.special",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_Q,
            "category.backbone"
    );

    @Override
    public void onInitializeClient() {

        KeyBindingHelper.registerKeyBinding(SPECIAL);

        HudRenderCallback.EVENT.register(new SextantOverlayRenderer());

        ClientTickEvents.END_CLIENT_TICK.register(BackboneClient::special);

    }

    private static void special(MinecraftClient client) {

        BackboneAnimatedPlayer player = (BackboneAnimatedPlayer) client.player;
        if (player == null) return;

        while(SPECIAL.wasPressed()) {

            ModifierLayer<IAnimation> animationContainer = player.backbone$getAnimationContainer();
            IAnimation animation = PlayerAnimationRegistry.getAnimation(BackboneMod.id("claymore")).playAnimation();

            animationContainer.replaceAnimationWithFade(AbstractFadeModifier.standardFadeIn(10, Ease.INSINE), animation, true);

        }

    }

}
