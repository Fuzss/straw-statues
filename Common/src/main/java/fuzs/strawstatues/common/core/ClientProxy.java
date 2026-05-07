package fuzs.strawstatues.common.core;

import fuzs.strawstatues.common.client.entity.ClientStrawStatue;
import fuzs.strawstatues.common.world.entity.decoration.StrawStatue;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ClientProxy extends ServerProxy {

    @Override
    public StrawStatue createStrawStatue(EntityType<? extends StrawStatue> entityType, Level level) {
        return new ClientStrawStatue(entityType, level, Minecraft.getInstance().playerSkinRenderCache());
    }
}
