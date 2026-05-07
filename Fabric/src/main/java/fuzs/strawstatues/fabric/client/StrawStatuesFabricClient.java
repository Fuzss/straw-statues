package fuzs.strawstatues.fabric.client;

import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.strawstatues.common.StrawStatues;
import fuzs.strawstatues.common.client.StrawStatuesClient;
import net.fabricmc.api.ClientModInitializer;

public class StrawStatuesFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(StrawStatues.MOD_ID, StrawStatuesClient::new);
    }
}
