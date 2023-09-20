package m4x4.mixtapes.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;

import java.util.function.Supplier;
import java.util.Map;

public class BlockmanQueueSwapperProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack s60c = ItemStack.EMPTY;
		ItemStack currentCassette = ItemStack.EMPTY;
		ItemStack s54c = ItemStack.EMPTY;
		ItemStack s55c = ItemStack.EMPTY;
		ItemStack s52c = ItemStack.EMPTY;
		ItemStack s53c = ItemStack.EMPTY;
		ItemStack s58c = ItemStack.EMPTY;
		ItemStack s59c = ItemStack.EMPTY;
		ItemStack s56c = ItemStack.EMPTY;
		ItemStack s57c = ItemStack.EMPTY;
		currentCassette = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(51)).getItem() : ItemStack.EMPTY);
		s52c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(52)).getItem() : ItemStack.EMPTY);
		s53c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(53)).getItem() : ItemStack.EMPTY);
		s54c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(54)).getItem() : ItemStack.EMPTY);
		s55c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(55)).getItem() : ItemStack.EMPTY);
		s56c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(56)).getItem() : ItemStack.EMPTY);
		s57c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(57)).getItem() : ItemStack.EMPTY);
		s58c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(58)).getItem() : ItemStack.EMPTY);
		s59c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(59)).getItem() : ItemStack.EMPTY);
		s60c = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(60)).getItem() : ItemStack.EMPTY);
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = currentCassette;
			_setstack.setCount(1);
			((Slot) _slots.get(60)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s60c;
			_setstack.setCount(1);
			((Slot) _slots.get(59)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s59c;
			_setstack.setCount(1);
			((Slot) _slots.get(58)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s58c;
			_setstack.setCount(1);
			((Slot) _slots.get(57)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s57c;
			_setstack.setCount(1);
			((Slot) _slots.get(56)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s56c;
			_setstack.setCount(1);
			((Slot) _slots.get(55)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s55c;
			_setstack.setCount(1);
			((Slot) _slots.get(54)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s54c;
			_setstack.setCount(1);
			((Slot) _slots.get(53)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s53c;
			_setstack.setCount(1);
			((Slot) _slots.get(52)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = s52c;
			_setstack.setCount(1);
			((Slot) _slots.get(51)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
		{
			double _setval = (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanQueueCurrentSlot;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.LastSwappedSlot = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
