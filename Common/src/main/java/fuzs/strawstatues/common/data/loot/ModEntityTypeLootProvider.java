package fuzs.strawstatues.common.data.loot;

import fuzs.puzzleslib.common.api.data.v3.loot.AbstractEntityLootSubProvider;
import fuzs.strawstatues.common.init.ModRegistry;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModEntityTypeLootProvider extends AbstractEntityLootSubProvider {

    public ModEntityTypeLootProvider(LootTableSubProvider.Context output) {
        super(output);
    }

    @Override
    public void generate() {
        this.add(ModRegistry.STRAW_STATUE_ENTITY_TYPE.value(), LootTable.lootTable());
    }
}
