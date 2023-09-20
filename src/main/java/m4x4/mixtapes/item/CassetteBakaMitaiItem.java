
package m4x4.mixtapes.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import m4x4.mixtapes.init.MaxsMixtapesModTabs;

import java.util.List;

public class CassetteBakaMitaiItem extends RecordItem {
	public CassetteBakaMitaiItem() {
		super(0, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("maxs_mixtapes:bm")), new Item.Properties().tab(MaxsMixtapesModTabs.TAB_TAB).stacksTo(1).rarity(Rarity.RARE), 100);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\"You think of the yakuza as a way to die. To me... being yakuza... It's a way to live.\""));
	}
}