package io.github.a5b84.convenientmobgriefing.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.GameRules.BooleanRule;
import net.minecraft.world.GameRules.Type;

/**
 * Mixin qui permet de récupérer la méthode pour créer les gamerules
 */
@Mixin(BooleanRule.class)
public interface BooleanRuleAccessor {

    @Invoker
    static Type<BooleanRule> callCreate(boolean initialValue) {
        return null;
    }

}
