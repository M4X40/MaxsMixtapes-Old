package m4x4.mixtapes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

public class InfoHUDTextProcProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanRemainingTime + " / " + GetTimeFromLengthProcProcedure.execute(world, entity);
	}
}
