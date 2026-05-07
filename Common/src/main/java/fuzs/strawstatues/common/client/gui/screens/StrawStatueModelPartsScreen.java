package fuzs.strawstatues.common.client.gui.screens;

import fuzs.puzzleslib.common.api.network.v4.MessageSender;
import fuzs.statuemenus.common.api.v1.client.gui.components.CheckboxTextButton;
import fuzs.statuemenus.common.api.v1.client.gui.screens.StatueTickBoxScreen;
import fuzs.statuemenus.common.api.v1.network.client.data.DataSyncHandler;
import fuzs.statuemenus.common.api.v1.world.inventory.StatueHolder;
import fuzs.statuemenus.common.api.v1.world.inventory.data.StatueScreenType;
import fuzs.strawstatues.common.network.client.ServerboundStrawStatueModelPartMessage;
import fuzs.strawstatues.common.network.client.ServerboundStrawStatueProfileMessage;
import fuzs.strawstatues.common.world.entity.decoration.StrawStatue;
import fuzs.strawstatues.common.world.inventory.data.StrawStatueScreenTypes;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.PlayerModelPart;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class StrawStatueModelPartsScreen extends StatueTickBoxScreen<PlayerModelPart> {
    public static final Component TEXT_BOX_HINT_TRANSLATION_KEY = Component.translatable(StrawStatueScreenTypes.MODEL_PARTS.id()
            .toLanguageKey("screen", "hint")).withStyle(EditBox.SEARCH_HINT_STYLE);
    public static final Component TEXT_BOX_TOOLTIP_TRANSLATION_KEY = Component.translatable(StrawStatueScreenTypes.MODEL_PARTS.id()
            .toLanguageKey("screen", "tooltip"));

    public StrawStatueModelPartsScreen(StatueHolder statueHolder, Inventory inventory, Component component, DataSyncHandler dataSyncHandler) {
        super(statueHolder, inventory, component, dataSyncHandler);
    }

    @Override
    protected List<PlayerModelPart> getAllTickBoxValues() {
        return List.of(PlayerModelPart.values());
    }

    @Override
    protected AbstractWidget makeTickBoxWidget(LivingEntity livingEntity, int buttonStartY, int index, PlayerModelPart option) {
        StrawStatue strawStatue = (StrawStatue) livingEntity;
        return new CheckboxTextButton(this.leftPos + 96,
                this.topPos + buttonStartY + index * 22,
                6,
                76,
                (Button button) -> {
                    boolean value = !strawStatue.isModelPartShown(option);
                    strawStatue.setModelPartShown(option, value);
                    MessageSender.broadcast(new ServerboundStrawStatueModelPartMessage(option, value));
                },
                option.getName()) {
            @Override
            protected boolean isTicked() {
                return strawStatue.isModelPartShown(option);
            }
        };
    }

    @Override
    protected void syncNameChange(String input) {
        MessageSender.broadcast(new ServerboundStrawStatueProfileMessage(input));
    }

    @Override
    protected int getNameMaxLength() {
        return 16;
    }

    @Override
    protected String getNameValue() {
        return ((StrawStatue) this.getHolder().getEntity()).getProfileName();
    }

    public void applyNameValue() {
        String nameValue = this.getNameValue();
        if (Objects.equals(this.name.getValue().toLowerCase(Locale.ROOT), nameValue.toLowerCase(Locale.ROOT))) {
            this.name.setValue(nameValue);
        }
    }

    @Override
    protected Component getNameHint() {
        return TEXT_BOX_HINT_TRANSLATION_KEY;
    }

    @Override
    protected Component getNameTooltip() {
        return TEXT_BOX_TOOLTIP_TRANSLATION_KEY;
    }

    @Override
    public StatueScreenType getScreenType() {
        return StrawStatueScreenTypes.MODEL_PARTS;
    }
}
