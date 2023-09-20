package m4x4.mixtapes.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

import java.util.HashMap;

public class SetButtonProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:QueueSlotTB") ? ((EditBox) guistate.get("text:QueueSlotTB")).getValue() : "");
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanQueueCurrentSlot = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:SlotCheckTB") ? ((EditBox) guistate.get("text:SlotCheckTB")).getValue() : "");
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = guistate.containsKey("text:CurrentSongTB") ? ((EditBox) guistate.get("text:CurrentSongTB")).getValue() : "";
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanCurrentSong = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:CurrentLengthTB") ? ((EditBox) guistate.get("text:CurrentLengthTB")).getValue() : "");
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanCurrentSongLength = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
