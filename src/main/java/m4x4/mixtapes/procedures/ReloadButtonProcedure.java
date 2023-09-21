package m4x4.mixtapes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import java.util.HashMap;

public class ReloadButtonProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		VarViewerGUIThisGUIIsOpenedProcedure.execute(world, entity, guistate);
	}
}
