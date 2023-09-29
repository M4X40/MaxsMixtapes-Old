package m4x4.mixtapes.procedures;

import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

public class FormatTimeProcProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double time = 0;
		time = (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).TimeSentTemp;
		if (!(time < 10)) {
			return "" + Math.round(time);
		}
		return "0" + Math.round(time);
	}
}
