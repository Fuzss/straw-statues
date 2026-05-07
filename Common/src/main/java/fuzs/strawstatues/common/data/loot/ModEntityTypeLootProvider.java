package fuzs.strawstatues.common.data.loot;

import fuzs.puzzleslib.common.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.common.api.data.v2.core.DataProviderContext;
import fuzs.strawstatues.common.init.ModRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModEntityTypeLootProvider extends AbstractLootProvider.EntityTypes {

    public ModEntityTypeLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.add(ModRegistry.STRAW_STATUE_ENTITY_TYPE.value(), LootTable.lootTable());
    }

    @Override
    protected boolean canHaveLootTable(EntityType<?> entityType) {
        return entityType == ModRegistry.STRAW_STATUE_ENTITY_TYPE.value() || super.canHaveLootTable(entityType);
    }
}
