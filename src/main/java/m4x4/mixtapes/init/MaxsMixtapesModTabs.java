
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package m4x4.mixtapes.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class MaxsMixtapesModTabs {
	public static CreativeModeTab TAB_TAB;
	public static CreativeModeTab TAB_ITEM_TAB;

	public static void load() {
		TAB_TAB = new CreativeModeTab("tabtab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MaxsMixtapesModItems.CASSETTE_ALPHA.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
		TAB_ITEM_TAB = new CreativeModeTab("tabitem_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(MaxsMixtapesModItems.BLANK_TAPE.get());
			}

			@Override
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
