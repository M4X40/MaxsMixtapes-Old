
package m4x4.mixtapes.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import m4x4.mixtapes.init.MaxsMixtapesModTabs;

import java.util.List;

public class KnobItem extends Item {
	public KnobItem() {
		super(new Item.Properties().tab(MaxsMixtapesModTabs.TAB_ITEM_TAB).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("Just 999 more!"));
	}
}
