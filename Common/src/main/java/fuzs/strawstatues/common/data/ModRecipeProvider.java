package fuzs.strawstatues.common.data;

import fuzs.puzzleslib.common.api.data.v3.recipes.AbstractRecipeProvider;
import fuzs.strawstatues.common.init.ModRegistry;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Blocks;

public class ModRecipeProvider extends AbstractRecipeProvider {

    public ModRecipeProvider(BootstrapContext<Recipe<?>> recipeOutput, BootstrapContext<Advancement> advancementOutput) {
        super(recipeOutput, advancementOutput);
    }

    @Override
    public void buildRecipes() {
        this.shaped(RecipeCategory.DECORATIONS, ModRegistry.STRAW_STATUE_ITEM.value())
                .define('#', Blocks.HAY_BLOCK)
                .define('X', Items.STICK)
                .pattern("XXX")
                .pattern(" X ")
                .pattern("X#X")
                .unlockedBy(getHasName(Blocks.HAY_BLOCK), this.has(Blocks.HAY_BLOCK))
                .save(this.output);
    }
}
