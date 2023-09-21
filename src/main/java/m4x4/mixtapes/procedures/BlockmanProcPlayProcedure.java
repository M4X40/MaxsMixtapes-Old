package m4x4.mixtapes.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import m4x4.mixtapes.world.inventory.VarViewerGUIMenu;
import m4x4.mixtapes.world.inventory.BlockmanPlayerMenu;
import m4x4.mixtapes.network.MaxsMixtapesModVariables;
import m4x4.mixtapes.MaxsMixtapesMod;

import java.util.HashMap;

public class BlockmanProcPlayProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		ItemStack cassette = ItemStack.EMPTY;
		String command = "";
		double OldStoppedCount = 0;
		if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanIsPlaying) {
			BlockmanProcStopProcedure.execute(world, x, y, z, entity);
			{
				double _setval = 51;
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanQueueCurrentSlot = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCheckSlot) {
			BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanIsQueued) {
				{
					boolean _setval = true;
					entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BlockmanNoError = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				BlockmanProcStoreQueueSongsProcedure.execute(world, entity);
				{
					boolean _setval = false;
					entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BlockmanNoError = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (!((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCurrentSong).equals("none")) {
			command = "playsound maxs_mixtapes:" + (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCurrentSong + " record @p ~ ~ ~ 1 1";
			MaxsMixtapesMod.LOGGER.info(command);
			MaxsMixtapesMod.LOGGER.info((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCurrentSong);
			{
				double _setval = (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCurrentSongLength;
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanRemainingTicks = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = true;
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanIsPlaying = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanRemainingTime).equals(" Not Playing")) {
				GetRemainingTimeProcedure.execute(world, entity);
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(), command);
		}
		MaxsMixtapesMod.queueServerWork((int) (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCurrentSongLength, () -> {
			if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).StoppedCount == 0) {
				{
					boolean _setval = false;
					entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BlockmanIsPlaying = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanIsLooped) {
					if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanIsQueued) {
						BlockmanProcQueueSystemProcedure.execute(world, x, y, z, entity, guistate);
						if (!(entity instanceof Player _plr ? _plr.containerMenu instanceof BlockmanPlayerMenu : false)) {
							{
								boolean _setval = true;
								entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.SwapSlotsOnOpen = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else {
							BlockmanQueueSwapperProcedure.execute(entity);
						}
					} else {
						BlockmanProcPlayProcedure.execute(world, x, y, z, entity, guistate);
						{
							boolean _setval = true;
							entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.BlockmanHasLooped = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanIsQueued) {
					BlockmanProcQueueSystemProcedure.execute(world, x, y, z, entity, guistate);
					if (!(entity instanceof Player _plr ? _plr.containerMenu instanceof BlockmanPlayerMenu : false)) {
						{
							boolean _setval = true;
							entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.SwapSlotsOnOpen = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						BlockmanQueueSwapperProcedure.execute(entity);
					}
				}
			} else {
				MaxsMixtapesMod.queueServerWork(800, () -> {
					{
						double _setval = 0;
						entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.StoppedCount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				});
			}
			{
				boolean _setval = true;
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanIsPlaying = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player _plr ? _plr.containerMenu instanceof VarViewerGUIMenu : false) {
				VarViewerGUIThisGUIIsOpenedProcedure.execute(world, entity, guistate);
			}
		});
	}
}
