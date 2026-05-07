package fuzs.strawstatues.common.network.client;

import fuzs.puzzleslib.common.api.network.v4.message.MessageListener;
import fuzs.puzzleslib.common.api.network.v4.message.play.ServerboundPlayMessage;
import fuzs.strawstatues.common.world.entity.decoration.StrawStatue;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.game.ServerboundPickItemFromEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public record ServerboundPickItemFromEntityMessage(int id, boolean includeData) implements ServerboundPlayMessage {
    public static final StreamCodec<ByteBuf, ServerboundPickItemFromEntityMessage> STREAM_CODEC = ServerboundPickItemFromEntityPacket.STREAM_CODEC.map(
            (ServerboundPickItemFromEntityPacket packet) -> {
                return new ServerboundPickItemFromEntityMessage(packet.id(), packet.includeData());
            },
            (ServerboundPickItemFromEntityMessage message) -> {
                return new ServerboundPickItemFromEntityPacket(message.id(), message.includeData());
            });

    @Override
    public MessageListener<Context> getListener() {
        return new MessageListener<Context>() {
            /**
             * @see net.minecraft.server.network.ServerGamePacketListenerImpl#handlePickItemFromEntity(ServerboundPickItemFromEntityPacket)
             */
            @Override
            public void accept(Context context) {
                Entity entity = context.level().getEntity(ServerboundPickItemFromEntityMessage.this.id());
                if (entity instanceof StrawStatue strawStatue && context.player()
                        .isWithinEntityInteractionRange(entity, 3.0)) {
                    ItemStack itemStack = strawStatue.getPickResult(ServerboundPickItemFromEntityMessage.this.includeData());
                    if (itemStack != null && !itemStack.isEmpty()) {
                        context.packetListener().tryPickItem(itemStack);
                    }
                }
            }
        };
    }
}
