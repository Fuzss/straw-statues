package fuzs.strawstatues.neoforge;

import fuzs.puzzleslib.common.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import fuzs.strawstatues.common.StrawStatues;
import fuzs.strawstatues.common.data.ModRecipeProvider;
import fuzs.strawstatues.common.data.loot.ModEntityTypeLootProvider;
import fuzs.strawstatues.common.data.tags.ModEntityTypeTagsProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.fml.common.Mod;

@Mod(StrawStatues.MOD_ID)
public class StrawStatuesNeoForge {

    public StrawStatuesNeoForge() {
        ModConstructor.construct(StrawStatues.MOD_ID, StrawStatues::new);
        DataProviderBuilder.of(StrawStatues.MOD_ID)
                .addLootProvider(ModEntityTypeLootProvider::new, LootContextParamSets.ENTITY)
                .addProvider(ModEntityTypeTagsProvider::new)
                .addRecipeProvider(ModRecipeProvider::new);
    }
}
