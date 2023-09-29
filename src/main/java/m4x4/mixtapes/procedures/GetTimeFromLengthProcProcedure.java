package m4x4.mixtapes.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

public class GetTimeFromLengthProcProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		double quotient = 0;
		double dividend = 0;
		double minutes = 0;
		double seconds = 0;
		double lengthsecs = 0;
		/*Ticks to Secs*/
		lengthsecs = (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCurrentSongLength / 20;/*Minutes*/
		quotient = 0;
		dividend = lengthsecs;
		while (dividend >= 60) {
			dividend = dividend - 60;
			quotient = quotient + 1;
		}
		minutes = quotient;/*Seconds*/
		seconds = lengthsecs % 60;
		{
			double _setval = seconds;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.TimeSentTemp = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		return (int) Math.round(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(new java.text.DecimalFormat("##.##").format(minutes))) + ":" + FormatTimeProcProcedure.execute(entity);
	}
}
