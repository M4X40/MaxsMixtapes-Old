package m4x4.mixtapes.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

public class BlockmanErrorRandomizerProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double rando = 0;
		rando = Mth.nextInt(RandomSource.create(), 1, 10);
		if (rando == 1) {
			{
				String _setval = "<Blockman Speaker> Yo tf you think you're doing";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (rando == 2) {
			{
				String _setval = "<Blockman Speaker> That item isn't compatible dud.";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (rando == 3) {
			{
				String _setval = "<Blockman Speaker> Thats not a compatible music format.";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (rando == 4) {
			{
				String _setval = "<Blockman Speaker> Please enter a real cassette or disc, not this garbage.";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (rando == 5) {
			{
				String _setval = "<Blockman Speaker> I really hope this is to test my limits and not because you think it actually has sounds.";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (rando == 6) {
			{
				String _setval = "<Blockman Speaker> Chill out, thats not a cassette or disc.";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (rando == 7) {
			{
				String _setval = "<Blockman Speaker> Do that again and I'll explode. Just kidding, I can't.";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (rando == 8) {
			{
				String _setval = "<Blockman Speaker> teehee oopsie woopsie that no workie :3c";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (rando == 9) {
			{
				String _setval = "<Blockman Speaker> I swear to god if you put a piece of bread again in here I'll personally break your pigstep disc.";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				String _setval = "<Blockman Speaker> Wow this is a secret, good job. You managed to hit the 10% chance to find this. Amazing luck right here. Ultimate Lucky Student Alert.";
				entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.BlockmanError = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
