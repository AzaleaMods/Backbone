package dev.jade.backbone.mixin.client;

// TO-DO: Rewrite for 26.1
//@Mixin(DebugScreenDisplayer.class)
//public class DebugHudMixin {
//
//    @Shadow @Final private MinecraftClient client;
//
//    @Shadow @Final private TextRenderer textRenderer;
//
//    /**
//     * @author Mercury
//     * @reason Remove all F3 information
//     */
//    @Overwrite
//    public void render(DrawContext context) {
//
//        this.client.getProfiler().push("debug");
//
//        String text = String.format("%d FPS", this.client.getCurrentFps());
//        int width = this.textRenderer.getWidth(text);
//
////        context.fill(
////                2, 2,
////                2 + width + 4, 2 + 10 + 2,
////
////        );
//
//        context.drawTextWithShadow(
//                this.textRenderer,
//                text,
//                4, 4,
//                0xFF97EDCA
//        );
//
//        this.client.getProfiler().pop();
//
//    }
//
//}
