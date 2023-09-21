package m4x4.mixtapes.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;
import m4x4.mixtapes.MaxsMixtapesMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GetRemainingTimeProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity().level, event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double quotient = 0;
		double dividend = 0;
		double minutes = 0;
		double seconds = 0;
		double lengthsecs = 0;
		if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanIsPlaying) {
			if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanRemainingTicks > 0) {/*Remove a sec*/
				{
					double _setval = (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanRemainingTicks - 20;
					entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BlockmanRemainingTicks = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				quotient = (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanRemainingTicks;/*Ticks to Secs*/
				lengthsecs = quotient / 20;/*Minutes*/
				quotient = 0;
				dividend = lengthsecs;
				while (dividend >= 60) {
					dividend = dividend - 60;
					quotient = quotient + 1;
				}
				minutes = quotient;/*Seconds*/
				seconds = lengthsecs % 60;
				{
					String _setval = (int) Math.round(minutes) + ":" + (int) Math.round(new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(new java.text.DecimalFormat("##").format(seconds)));
					entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BlockmanRemainingTime = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				MaxsMixtapesMod.queueServerWork(20, () -> {
					GetRemainingTimeProcedure.execute(world, entity);
				});
			} else {
				{
					String _setval = "Not Playing";
					entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.BlockmanRemainingTime = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				MaxsMixtapesMod.queueServerWork(20, () -> {
					GetRemainingTimeProcedure.execute(world, entity);
				});
			}
		} else {
			{
				String _setval = " Not Playing";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanRemainingTime = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
