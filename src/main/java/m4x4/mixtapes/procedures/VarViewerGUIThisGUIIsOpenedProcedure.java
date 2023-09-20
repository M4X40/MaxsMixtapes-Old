package m4x4.mixtapes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;
import m4x4.mixtapes.MaxsMixtapesMod;

import java.util.HashMap;

public class VarViewerGUIThisGUIIsOpenedProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		String QueueSlot = "";
		String SlotCheck = "";
		String CurrentSong = "";
		String CurrentLength = "";
		MaxsMixtapesMod.queueServerWork(20, () -> {
			if (guistate.get("text:QueueSlotTB") instanceof EditBox _tf)
				_tf.setValue(("" + (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanQueueCurrentSlot));
			if (guistate.get("text:SlotCheckTB") instanceof EditBox _tf)
				_tf.setValue(("" + (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanSlotToCheck));
			if (guistate.get("text:CurrentSongTB") instanceof EditBox _tf)
				_tf.setValue(((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCurrentSong));
			if (guistate.get("text:CurrentLengthTB") instanceof EditBox _tf)
				_tf.setValue(("" + (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCurrentSongLength));
			if (guistate.get("text:CheckSlotTB") instanceof EditBox _tf)
				_tf.setValue(("" + (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanCheckSlot));
			if (guistate.get("text:SOOTB") instanceof EditBox _tf)
				_tf.setValue(("" + (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).SwapSlotsOnOpen));
			if (guistate.get("text:StopCountTB") instanceof EditBox _tf)
				_tf.setValue(("" + (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).StoppedCount));
			if (guistate.get("text:SCOTB") instanceof EditBox _tf)
				_tf.setValue(("" + (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).StoppedCountOld));
		});
	}
}
