package io.github.a5b84.convenientmobgriefing.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.github.a5b84.convenientmobgriefing.Mod;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameRules.Rule;
import net.minecraft.world.GameRules.RuleCategory;
import net.minecraft.world.GameRules.RuleKey;
import net.minecraft.world.GameRules.RuleType;

/**
 * Mixin qui enregistre les nouvelles gamerules
 */
public final class GameRulesMixins {

    @Mixin(GameRules.class)
    public static abstract class Post20w17a {

        /** @see GameRules#register */
        @Shadow
        private static <T extends Rule<T>> RuleKey<T> register(String name, RuleCategory category, RuleType<T> type) {
            return null;
        }
    
        @Inject(method = "<clinit>", at = @At("RETURN"))
        private static void onStaticInit(CallbackInfo ci) {
            Mod.LENIENT_GRIEFING = register("mobGriefingLenient", RuleCategory.MOBS, BooleanRuleAccessor.callCreate(true));
            Mod.WITHER_GRIEFING = register("mobGriefingWither", RuleCategory.MOBS, BooleanRuleAccessor.callCreate(true));
            Mod.DRAGON_GRIEFING = register("mobGriefingDragon", RuleCategory.MOBS, BooleanRuleAccessor.callCreate(true));
        }

    }

    @Mixin(GameRules.class)
    public static abstract class Pre20w17a {

        /** @see GameRules#register */
        @Shadow(remap = false)
        private static <T extends Rule<T>> RuleKey<T> method_8359(String name, RuleType<T> type) {
            return null;
        }
    
        @Inject(method = "<clinit>", at = @At("RETURN"))
        private static void onStaticInit(CallbackInfo ci) {
            Mod.LENIENT_GRIEFING = method_8359("mobGriefingLenient", BooleanRuleAccessor.callCreate(true));
            Mod.WITHER_GRIEFING = method_8359("mobGriefingWither", BooleanRuleAccessor.callCreate(true));
            Mod.DRAGON_GRIEFING = method_8359("mobGriefingDragon", BooleanRuleAccessor.callCreate(true));
        }

    }

}