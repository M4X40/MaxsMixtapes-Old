
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package m4x4.mixtapes.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import m4x4.mixtapes.client.gui.VarViewerGUIScreen;
import m4x4.mixtapes.client.gui.InfoHudBackGScreen;
import m4x4.mixtapes.client.gui.BlockmanPlayerScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MaxsMixtapesModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(MaxsMixtapesModMenus.BLOCKMAN_PLAYER.get(), BlockmanPlayerScreen::new);
			MenuScreens.register(MaxsMixtapesModMenus.VAR_VIEWER_GUI.get(), VarViewerGUIScreen::new);
			MenuScreens.register(MaxsMixtapesModMenus.INFO_HUD_BACK_G.get(), InfoHudBackGScreen::new);
		});
	}
}
