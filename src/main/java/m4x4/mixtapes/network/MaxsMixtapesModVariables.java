package m4x4.mixtapes.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import m4x4.mixtapes.MaxsMixtapesMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MaxsMixtapesModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		MaxsMixtapesMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level.isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.BlockmanCurrentSong = original.BlockmanCurrentSong;
			clone.BlockmanCurrentSongLength = original.BlockmanCurrentSongLength;
			clone.BlockmanSongSlot51 = original.BlockmanSongSlot51;
			clone.BlockmanSongSlot52 = original.BlockmanSongSlot52;
			clone.BlockmanSongSlot53 = original.BlockmanSongSlot53;
			clone.BlockmanSongSlot54 = original.BlockmanSongSlot54;
			clone.BlockmanSongSlot55 = original.BlockmanSongSlot55;
			clone.BlockmanSongSlot56 = original.BlockmanSongSlot56;
			clone.BlockmanSongSlot57 = original.BlockmanSongSlot57;
			clone.BlockmanSongSlot58 = original.BlockmanSongSlot58;
			clone.BlockmanSongSlot59 = original.BlockmanSongSlot59;
			clone.BlockmanSongSlot60 = original.BlockmanSongSlot60;
			clone.BlockmanMSCReturnLength = original.BlockmanMSCReturnLength;
			clone.BlockmanLengthSlot51 = original.BlockmanLengthSlot51;
			clone.BlockmanLengthSlot52 = original.BlockmanLengthSlot52;
			clone.BlockmanLengthSlot53 = original.BlockmanLengthSlot53;
			clone.BlockmanLengthSlot54 = original.BlockmanLengthSlot54;
			clone.BlockmanLengthSlot55 = original.BlockmanLengthSlot55;
			clone.BlockmanLengthSlot56 = original.BlockmanLengthSlot56;
			clone.BlockmanLengthSlot57 = original.BlockmanLengthSlot57;
			clone.BlockmanLengthSlot58 = original.BlockmanLengthSlot58;
			clone.BlockmanLengthSlot59 = original.BlockmanLengthSlot59;
			clone.BlockmanLengthSlot60 = original.BlockmanLengthSlot60;
			clone.BlockmanMSCReturn = original.BlockmanMSCReturn;
			clone.InfoHUDEnabled = original.InfoHUDEnabled;
			if (!event.isWasDeath()) {
				clone.BlockmanError = original.BlockmanError;
				clone.BlockmanIsLooped = original.BlockmanIsLooped;
				clone.BlockmanHasLooped = original.BlockmanHasLooped;
				clone.BlockmanIsPlaying = original.BlockmanIsPlaying;
				clone.BlockmanSlotToCheck = original.BlockmanSlotToCheck;
				clone.BlockmanCheckSlot = original.BlockmanCheckSlot;
				clone.BlockmanLoopButtonUsed = original.BlockmanLoopButtonUsed;
				clone.BlockmanIsQueued = original.BlockmanIsQueued;
				clone.BlockmanNoError = original.BlockmanNoError;
				clone.BlockmanQueueCurrentSlot = original.BlockmanQueueCurrentSlot;
				clone.StoppedCount = original.StoppedCount;
				clone.BlockmanPlayButtonUsed = original.BlockmanPlayButtonUsed;
				clone.SwapSlotsOnOpen = original.SwapSlotsOnOpen;
				clone.LastSwappedSlot = original.LastSwappedSlot;
				clone.BlockmanCurrentTick = original.BlockmanCurrentTick;
				clone.BlockmanRemainingTime = original.BlockmanRemainingTime;
				clone.BlockmanRemainingTicks = original.BlockmanRemainingTicks;
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("maxs_mixtapes", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String BlockmanError = "\"Error\"";
		public String BlockmanCurrentSong = "\"\"";
		public double BlockmanCurrentSongLength = 0;
		public boolean BlockmanIsLooped = false;
		public boolean BlockmanHasLooped = false;
		public boolean BlockmanIsPlaying = false;
		public double BlockmanSlotToCheck = 51.0;
		public boolean BlockmanCheckSlot = true;
		public boolean BlockmanLoopButtonUsed = true;
		public boolean BlockmanIsQueued = false;
		public boolean BlockmanNoError = false;
		public String BlockmanSongSlot51 = "\"\"";
		public String BlockmanSongSlot52 = "\"\"";
		public String BlockmanSongSlot53 = "\"\"";
		public String BlockmanSongSlot54 = "\"\"";
		public String BlockmanSongSlot55 = "\"\"";
		public String BlockmanSongSlot56 = "\"\"";
		public String BlockmanSongSlot57 = "\"\"";
		public String BlockmanSongSlot58 = "\"\"";
		public String BlockmanSongSlot59 = "\"\"";
		public String BlockmanSongSlot60 = "\"\"";
		public double BlockmanQueueCurrentSlot = 51.0;
		public double StoppedCount = 0;
		public boolean BlockmanMSCReturnLength = false;
		public double BlockmanLengthSlot51 = 0;
		public double BlockmanLengthSlot52 = 0;
		public double BlockmanLengthSlot53 = 0;
		public double BlockmanLengthSlot54 = 0;
		public double BlockmanLengthSlot55 = 0;
		public double BlockmanLengthSlot56 = 0;
		public double BlockmanLengthSlot57 = 0;
		public double BlockmanLengthSlot58 = 0;
		public double BlockmanLengthSlot59 = 0;
		public double BlockmanLengthSlot60 = 0;
		public boolean BlockmanMSCReturn = false;
		public boolean BlockmanPlayButtonUsed = false;
		public boolean SwapSlotsOnOpen = false;
		public double LastSwappedSlot = 51.0;
		public double BlockmanCurrentTick = 0;
		public String BlockmanRemainingTime = "\" Not Playing\"";
		public double BlockmanRemainingTicks = 0;
		public boolean InfoHUDEnabled = false;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				MaxsMixtapesMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("BlockmanError", BlockmanError);
			nbt.putString("BlockmanCurrentSong", BlockmanCurrentSong);
			nbt.putDouble("BlockmanCurrentSongLength", BlockmanCurrentSongLength);
			nbt.putBoolean("BlockmanIsLooped", BlockmanIsLooped);
			nbt.putBoolean("BlockmanHasLooped", BlockmanHasLooped);
			nbt.putBoolean("BlockmanIsPlaying", BlockmanIsPlaying);
			nbt.putDouble("BlockmanSlotToCheck", BlockmanSlotToCheck);
			nbt.putBoolean("BlockmanCheckSlot", BlockmanCheckSlot);
			nbt.putBoolean("BlockmanLoopButtonUsed", BlockmanLoopButtonUsed);
			nbt.putBoolean("BlockmanIsQueued", BlockmanIsQueued);
			nbt.putBoolean("BlockmanNoError", BlockmanNoError);
			nbt.putString("BlockmanSongSlot51", BlockmanSongSlot51);
			nbt.putString("BlockmanSongSlot52", BlockmanSongSlot52);
			nbt.putString("BlockmanSongSlot53", BlockmanSongSlot53);
			nbt.putString("BlockmanSongSlot54", BlockmanSongSlot54);
			nbt.putString("BlockmanSongSlot55", BlockmanSongSlot55);
			nbt.putString("BlockmanSongSlot56", BlockmanSongSlot56);
			nbt.putString("BlockmanSongSlot57", BlockmanSongSlot57);
			nbt.putString("BlockmanSongSlot58", BlockmanSongSlot58);
			nbt.putString("BlockmanSongSlot59", BlockmanSongSlot59);
			nbt.putString("BlockmanSongSlot60", BlockmanSongSlot60);
			nbt.putDouble("BlockmanQueueCurrentSlot", BlockmanQueueCurrentSlot);
			nbt.putDouble("StoppedCount", StoppedCount);
			nbt.putBoolean("BlockmanMSCReturnLength", BlockmanMSCReturnLength);
			nbt.putDouble("BlockmanLengthSlot51", BlockmanLengthSlot51);
			nbt.putDouble("BlockmanLengthSlot52", BlockmanLengthSlot52);
			nbt.putDouble("BlockmanLengthSlot53", BlockmanLengthSlot53);
			nbt.putDouble("BlockmanLengthSlot54", BlockmanLengthSlot54);
			nbt.putDouble("BlockmanLengthSlot55", BlockmanLengthSlot55);
			nbt.putDouble("BlockmanLengthSlot56", BlockmanLengthSlot56);
			nbt.putDouble("BlockmanLengthSlot57", BlockmanLengthSlot57);
			nbt.putDouble("BlockmanLengthSlot58", BlockmanLengthSlot58);
			nbt.putDouble("BlockmanLengthSlot59", BlockmanLengthSlot59);
			nbt.putDouble("BlockmanLengthSlot60", BlockmanLengthSlot60);
			nbt.putBoolean("BlockmanMSCReturn", BlockmanMSCReturn);
			nbt.putBoolean("BlockmanPlayButtonUsed", BlockmanPlayButtonUsed);
			nbt.putBoolean("SwapSlotsOnOpen", SwapSlotsOnOpen);
			nbt.putDouble("LastSwappedSlot", LastSwappedSlot);
			nbt.putDouble("BlockmanCurrentTick", BlockmanCurrentTick);
			nbt.putString("BlockmanRemainingTime", BlockmanRemainingTime);
			nbt.putDouble("BlockmanRemainingTicks", BlockmanRemainingTicks);
			nbt.putBoolean("InfoHUDEnabled", InfoHUDEnabled);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			BlockmanError = nbt.getString("BlockmanError");
			BlockmanCurrentSong = nbt.getString("BlockmanCurrentSong");
			BlockmanCurrentSongLength = nbt.getDouble("BlockmanCurrentSongLength");
			BlockmanIsLooped = nbt.getBoolean("BlockmanIsLooped");
			BlockmanHasLooped = nbt.getBoolean("BlockmanHasLooped");
			BlockmanIsPlaying = nbt.getBoolean("BlockmanIsPlaying");
			BlockmanSlotToCheck = nbt.getDouble("BlockmanSlotToCheck");
			BlockmanCheckSlot = nbt.getBoolean("BlockmanCheckSlot");
			BlockmanLoopButtonUsed = nbt.getBoolean("BlockmanLoopButtonUsed");
			BlockmanIsQueued = nbt.getBoolean("BlockmanIsQueued");
			BlockmanNoError = nbt.getBoolean("BlockmanNoError");
			BlockmanSongSlot51 = nbt.getString("BlockmanSongSlot51");
			BlockmanSongSlot52 = nbt.getString("BlockmanSongSlot52");
			BlockmanSongSlot53 = nbt.getString("BlockmanSongSlot53");
			BlockmanSongSlot54 = nbt.getString("BlockmanSongSlot54");
			BlockmanSongSlot55 = nbt.getString("BlockmanSongSlot55");
			BlockmanSongSlot56 = nbt.getString("BlockmanSongSlot56");
			BlockmanSongSlot57 = nbt.getString("BlockmanSongSlot57");
			BlockmanSongSlot58 = nbt.getString("BlockmanSongSlot58");
			BlockmanSongSlot59 = nbt.getString("BlockmanSongSlot59");
			BlockmanSongSlot60 = nbt.getString("BlockmanSongSlot60");
			BlockmanQueueCurrentSlot = nbt.getDouble("BlockmanQueueCurrentSlot");
			StoppedCount = nbt.getDouble("StoppedCount");
			BlockmanMSCReturnLength = nbt.getBoolean("BlockmanMSCReturnLength");
			BlockmanLengthSlot51 = nbt.getDouble("BlockmanLengthSlot51");
			BlockmanLengthSlot52 = nbt.getDouble("BlockmanLengthSlot52");
			BlockmanLengthSlot53 = nbt.getDouble("BlockmanLengthSlot53");
			BlockmanLengthSlot54 = nbt.getDouble("BlockmanLengthSlot54");
			BlockmanLengthSlot55 = nbt.getDouble("BlockmanLengthSlot55");
			BlockmanLengthSlot56 = nbt.getDouble("BlockmanLengthSlot56");
			BlockmanLengthSlot57 = nbt.getDouble("BlockmanLengthSlot57");
			BlockmanLengthSlot58 = nbt.getDouble("BlockmanLengthSlot58");
			BlockmanLengthSlot59 = nbt.getDouble("BlockmanLengthSlot59");
			BlockmanLengthSlot60 = nbt.getDouble("BlockmanLengthSlot60");
			BlockmanMSCReturn = nbt.getBoolean("BlockmanMSCReturn");
			BlockmanPlayButtonUsed = nbt.getBoolean("BlockmanPlayButtonUsed");
			SwapSlotsOnOpen = nbt.getBoolean("SwapSlotsOnOpen");
			LastSwappedSlot = nbt.getDouble("LastSwappedSlot");
			BlockmanCurrentTick = nbt.getDouble("BlockmanCurrentTick");
			BlockmanRemainingTime = nbt.getString("BlockmanRemainingTime");
			BlockmanRemainingTicks = nbt.getDouble("BlockmanRemainingTicks");
			InfoHUDEnabled = nbt.getBoolean("InfoHUDEnabled");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.BlockmanError = message.data.BlockmanError;
					variables.BlockmanCurrentSong = message.data.BlockmanCurrentSong;
					variables.BlockmanCurrentSongLength = message.data.BlockmanCurrentSongLength;
					variables.BlockmanIsLooped = message.data.BlockmanIsLooped;
					variables.BlockmanHasLooped = message.data.BlockmanHasLooped;
					variables.BlockmanIsPlaying = message.data.BlockmanIsPlaying;
					variables.BlockmanSlotToCheck = message.data.BlockmanSlotToCheck;
					variables.BlockmanCheckSlot = message.data.BlockmanCheckSlot;
					variables.BlockmanLoopButtonUsed = message.data.BlockmanLoopButtonUsed;
					variables.BlockmanIsQueued = message.data.BlockmanIsQueued;
					variables.BlockmanNoError = message.data.BlockmanNoError;
					variables.BlockmanSongSlot51 = message.data.BlockmanSongSlot51;
					variables.BlockmanSongSlot52 = message.data.BlockmanSongSlot52;
					variables.BlockmanSongSlot53 = message.data.BlockmanSongSlot53;
					variables.BlockmanSongSlot54 = message.data.BlockmanSongSlot54;
					variables.BlockmanSongSlot55 = message.data.BlockmanSongSlot55;
					variables.BlockmanSongSlot56 = message.data.BlockmanSongSlot56;
					variables.BlockmanSongSlot57 = message.data.BlockmanSongSlot57;
					variables.BlockmanSongSlot58 = message.data.BlockmanSongSlot58;
					variables.BlockmanSongSlot59 = message.data.BlockmanSongSlot59;
					variables.BlockmanSongSlot60 = message.data.BlockmanSongSlot60;
					variables.BlockmanQueueCurrentSlot = message.data.BlockmanQueueCurrentSlot;
					variables.StoppedCount = message.data.StoppedCount;
					variables.BlockmanMSCReturnLength = message.data.BlockmanMSCReturnLength;
					variables.BlockmanLengthSlot51 = message.data.BlockmanLengthSlot51;
					variables.BlockmanLengthSlot52 = message.data.BlockmanLengthSlot52;
					variables.BlockmanLengthSlot53 = message.data.BlockmanLengthSlot53;
					variables.BlockmanLengthSlot54 = message.data.BlockmanLengthSlot54;
					variables.BlockmanLengthSlot55 = message.data.BlockmanLengthSlot55;
					variables.BlockmanLengthSlot56 = message.data.BlockmanLengthSlot56;
					variables.BlockmanLengthSlot57 = message.data.BlockmanLengthSlot57;
					variables.BlockmanLengthSlot58 = message.data.BlockmanLengthSlot58;
					variables.BlockmanLengthSlot59 = message.data.BlockmanLengthSlot59;
					variables.BlockmanLengthSlot60 = message.data.BlockmanLengthSlot60;
					variables.BlockmanMSCReturn = message.data.BlockmanMSCReturn;
					variables.BlockmanPlayButtonUsed = message.data.BlockmanPlayButtonUsed;
					variables.SwapSlotsOnOpen = message.data.SwapSlotsOnOpen;
					variables.LastSwappedSlot = message.data.LastSwappedSlot;
					variables.BlockmanCurrentTick = message.data.BlockmanCurrentTick;
					variables.BlockmanRemainingTime = message.data.BlockmanRemainingTime;
					variables.BlockmanRemainingTicks = message.data.BlockmanRemainingTicks;
					variables.InfoHUDEnabled = message.data.InfoHUDEnabled;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
