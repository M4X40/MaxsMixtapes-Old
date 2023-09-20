package m4x4.mixtapes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;
import m4x4.mixtapes.MaxsMixtapesMod;

public class BlockmanProcSwapOnOpenProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double swapnum = 0;
		boolean CanContinue = false;
		if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanIsQueued) {
			if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).SwapSlotsOnOpen) {
				swapnum = (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanQueueCurrentSlot
						- (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).LastSwappedSlot;
				CanContinue = false;
				if (swapnum > 0) {
					CanContinue = true;
				} else if (swapnum < 0) {
					swapnum = swapnum + swapnum * 2;
					CanContinue = true;
				}
				if (CanContinue) {
					for (int index0 = 0; index0 < (int) swapnum; index0++) {
						MaxsMixtapesMod.queueServerWork(5, () -> {
							BlockmanQueueSwapperProcedure.execute(entity);
						});
					}
					{
						double _setval = (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanQueueCurrentSlot;
						entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LastSwappedSlot = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
		{
			boolean _setval = false;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.SwapSlotsOnOpen = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
