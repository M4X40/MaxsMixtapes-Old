package m4x4.mixtapes.procedures;

import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

public class InfoHUDDisplayLogicProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).InfoHUDEnabled) {
			return true;
		}
		return false;
	}
}
