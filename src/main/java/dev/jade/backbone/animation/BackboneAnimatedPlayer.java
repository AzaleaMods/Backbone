package dev.jade.backbone.animation;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;

public interface BackboneAnimatedPlayer {

    ModifierLayer<IAnimation> backbone$getAnimationContainer();

}
