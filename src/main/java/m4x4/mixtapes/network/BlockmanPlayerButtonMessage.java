
package m4x4.mixtapes.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import m4x4.mixtapes.world.inventory.BlockmanPlayerMenu;
import m4x4.mixtapes.procedures.BlockmanQueueSwapperProcedure;
import m4x4.mixtapes.procedures.BlockmanProcStopProcedure;
import m4x4.mixtapes.procedures.BlockmanProcQueuerProcedure;
import m4x4.mixtapes.procedures.BlockmanProcPlayProcedure;
import m4x4.mixtapes.procedures.BlockmanProcLooperProcedure;
import m4x4.mixtapes.MaxsMixtapesMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockmanPlayerButtonMessage {
	private final int buttonID, x, y, z;

	public BlockmanPlayerButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public BlockmanPlayerButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(BlockmanPlayerButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(BlockmanPlayerButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = BlockmanPlayerMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			BlockmanQueueSwapperProcedure.execute(entity);
		}
		if (buttonID == 1) {

			BlockmanProcPlayProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BlockmanProcStopProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			BlockmanProcLooperProcedure.execute(entity);
		}
		if (buttonID == 4) {

			BlockmanProcQueuerProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		MaxsMixtapesMod.addNetworkMessage(BlockmanPlayerButtonMessage.class, BlockmanPlayerButtonMessage::buffer, BlockmanPlayerButtonMessage::new, BlockmanPlayerButtonMessage::handler);
	}
}
