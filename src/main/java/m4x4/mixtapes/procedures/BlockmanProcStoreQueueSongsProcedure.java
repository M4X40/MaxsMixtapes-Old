package m4x4.mixtapes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

public class BlockmanProcStoreQueueSongsProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 60;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot60 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 59;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot59 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 58;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot58 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 57;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot57 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 56;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot56 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 55;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot55 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 54;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot54 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 53;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot53 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 52;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot52 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
		{
			double _setval = 51;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSlotToCheck = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = BlockmanProcMainSlotChangeProcedure.execute(world, entity);
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanSongSlot51 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		BlockmanProcGetLengthQueueProcedure.execute(entity);
	}
}
