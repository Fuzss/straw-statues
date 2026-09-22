package fuzs.strawstatues.neoforge.client;

import fuzs.puzzleslib.common.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v3.core.DataProviderBuilder;
import fuzs.strawstatues.common.StrawStatues;
import fuzs.strawstatues.common.client.StrawStatuesClient;
import fuzs.strawstatues.common.data.client.ModLanguageProvider;
import fuzs.strawstatues.common.data.client.ModModelProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = StrawStatues.MOD_ID, dist = Dist.CLIENT)
public class StrawStatuesNeoForgeClient {

    public StrawStatuesNeoForgeClient() {
        ClientModConstructor.construct(StrawStatues.MOD_ID, StrawStatuesClient::new);
        DataProviderBuilder.of(StrawStatues.MOD_ID)
                .addProvider(ModLanguageProvider::new, ModModelProvider::new);
    }
}
