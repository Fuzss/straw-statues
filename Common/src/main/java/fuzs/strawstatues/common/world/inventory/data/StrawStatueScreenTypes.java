package fuzs.strawstatues.common.world.inventory.data;

import fuzs.statuemenus.common.api.v1.world.inventory.data.StatueScreenType;
import fuzs.strawstatues.common.StrawStatues;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;

import java.util.List;

public class StrawStatueScreenTypes {
    public static final StatueScreenType ROTATIONS = new StatueScreenType(StrawStatues.id("rotations"),
            new ItemStackTemplate(Items.COMPASS));
    public static final StatueScreenType STYLE = new StatueScreenType(StrawStatues.id("style"),
            new ItemStackTemplate(Items.PAINTING));
    public static final StatueScreenType POSITION = new StatueScreenType(StrawStatues.id("position"),
            new ItemStackTemplate(Items.GRASS_BLOCK));
    public static final StatueScreenType MODEL_PARTS = new StatueScreenType(StrawStatues.id("model_parts"),
            new ItemStackTemplate(Items.YELLOW_WOOL));
    public static final StatueScreenType TEXTURES = new StatueScreenType(StrawStatues.id("textures"),
            new ItemStackTemplate(Items.HAY_BLOCK));
    public static final List<StatueScreenType> TYPES = List.of(ROTATIONS,
            StatueScreenType.POSES,
            STYLE,
            MODEL_PARTS,
            POSITION,
            TEXTURES,
            StatueScreenType.EQUIPMENT);
}
