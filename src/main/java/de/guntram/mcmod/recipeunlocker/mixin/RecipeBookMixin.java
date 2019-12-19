package de.guntram.mcmod.recipeunlocker.mixin;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeBook;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RecipeBook.class)
public abstract class RecipeBookMixin {
    
    @Inject(method="shouldDisplay", at=@At("HEAD"), cancellable = true)
    
    private void onShouldDisplay(CallbackInfoReturnable cir) {
        cir.setReturnValue(true);
        cir.cancel();
    }
    
    @Inject(method="contains(Lnet/minecraft/recipe/Recipe;)Z", at=@At("HEAD"), cancellable = true)
    private void onContains(Recipe<?> recipe, CallbackInfoReturnable cir) {
        cir.setReturnValue(true);
        cir.cancel();
    }

    @Inject(method="contains(Lnet/minecraft/util/Identifier;)Z", at=@At("HEAD"), cancellable = true)
    private void onContains(Identifier id, CallbackInfoReturnable cir) {
        cir.setReturnValue(true);
        cir.cancel();
    }

}
