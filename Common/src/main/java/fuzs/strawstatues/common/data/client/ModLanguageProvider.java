package fuzs.strawstatues.common.data.client;

import fuzs.puzzleslib.common.api.client.data.v3.language.AbstractLanguageProvider;
import fuzs.puzzleslib.common.api.data.v3.core.DataProviderContext;
import fuzs.strawstatues.common.client.gui.screens.StrawStatueModelPartsScreen;
import fuzs.strawstatues.common.client.gui.screens.StrawStatueTexturesScreen;
import fuzs.strawstatues.common.init.ModRegistry;
import fuzs.strawstatues.common.world.inventory.data.StrawStatuePosePartMutators;
import fuzs.strawstatues.common.world.inventory.data.StrawStatueScreenTypes;
import fuzs.strawstatues.common.world.inventory.data.StrawStatueStyleOptions;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations() {
        this.add(ModRegistry.STRAW_STATUE_ITEM.value(), "Straw Statue");
        this.add(ModRegistry.STRAW_STATUE_ITEM.value(), "named", "%s's Statue");
        this.add(ModRegistry.STRAW_STATUE_ENTITY_TYPE.value(), "Straw Statue");
        this.add(StrawStatueScreenTypes.ROTATIONS.getTranslationKey(), "Rotations");
        this.add(StrawStatueScreenTypes.STYLE.getTranslationKey(), "Style");
        this.add(StrawStatueScreenTypes.MODEL_PARTS.getTranslationKey(), "Model Parts");
        this.add(StrawStatueScreenTypes.POSITION.getTranslationKey(), "Position");
        this.add(StrawStatueScreenTypes.TEXTURES.getTranslationKey(), "Textures & Rotations");
        this.add(StrawStatueModelPartsScreen.TEXT_BOX_HINT_TRANSLATION_KEY, "Player Skin");
        this.add(StrawStatueModelPartsScreen.TEXT_BOX_TOOLTIP_TRANSLATION_KEY,
                "Set a player name to take the statue skin from.");
        this.add(StrawStatueStyleOptions.SMALL.getTranslationKey(), "Small");
        this.add(StrawStatueStyleOptions.SMALL.getDescriptionKey(),
                "Makes the statue half it's size like a baby mob.");
        this.add(StrawStatueStyleOptions.SLIM.getTranslationKey(), "Slim");
        this.add(StrawStatueStyleOptions.SLIM.getDescriptionKey(), "Makes the statue's arms appear less wide.");
        this.add(StrawStatueStyleOptions.PUSHABLE.getTranslationKey(), "Pushable");
        this.add(StrawStatueStyleOptions.PUSHABLE.getDescriptionKey(),
                "Allows other entities to push the statue around. This enables it to enter vehicles such as minecarts and boats.");
        this.add(StrawStatueStyleOptions.DYNAMIC.getTranslationKey(), "Dynamic");
        this.add(StrawStatueStyleOptions.DYNAMIC.getDescriptionKey(),
                "Have the statue automatically resolve to the current skin of the targeted player. Otherwise the player skin at the time it is set is kept forever.");
        this.add(StrawStatueStyleOptions.CROUCHING.getTranslationKey(), "Crouching");
        this.add(StrawStatueStyleOptions.CROUCHING.getDescriptionKey(),
                "Makes the statue show as if it were crouching.");
        this.add(StrawStatueStyleOptions.SEALED.getTranslationKey(), "Sealed");
        this.add(StrawStatueStyleOptions.SEALED.getDescriptionKey(),
                "Disallows changing equipment and opening this menu in survival mode.");
        this.add(StrawStatuePosePartMutators.CAPE.getTranslationKey(), "Cape");
        this.add(StrawStatueTexturesScreen.SKIN_TEXTURE_COMPONENT, "Skin Path:");
        this.add(StrawStatueTexturesScreen.CAPE_TEXTURE_COMPONENT, "Cape Path:");
        this.add(StrawStatueTexturesScreen.ELYTRA_TEXTURE_COMPONENT, "Elytra Path:");
        this.add(StrawStatueTexturesScreen.ROTATION_X_COMPONENT, "X-Rotation:");
        this.add(StrawStatueTexturesScreen.ROTATION_Y_COMPONENT, "Y-Rotation:");
        this.add(StrawStatueTexturesScreen.ROTATION_Z_COMPONENT, "Z-Rotation:");
    }
}
