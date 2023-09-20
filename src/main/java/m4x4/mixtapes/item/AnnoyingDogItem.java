
package m4x4.mixtapes.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

import m4x4.mixtapes.init.MaxsMixtapesModTabs;

public class AnnoyingDogItem extends Item {
	public AnnoyingDogItem() {
		super(new Item.Properties().tab(MaxsMixtapesModTabs.TAB_ITEM_TAB).stacksTo(1).rarity(Rarity.COMMON));
	}
}