package m4x4.mixtapes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.world.inventory.BlockmanPlayerMenu;
import m4x4.mixtapes.network.MaxsMixtapesModVariables;
import m4x4.mixtapes.MaxsMixtapesMod;

import java.util.HashMap;

public class BlockmanProcLoopQueueHandlerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		double OldStoppedCount = 0;
		String command = "";
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
				BlockmanProcQueueSystemProcedure.execute(world, x, y, z, entity, guistate);
			}
		}
		{
			boolean _setval = true;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanIsPlaying = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
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
}
