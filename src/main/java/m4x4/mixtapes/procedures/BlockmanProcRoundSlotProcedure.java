package m4x4.mixtapes.procedures;

import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

public class BlockmanProcRoundSlotProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 51;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
