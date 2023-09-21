
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package m4x4.mixtapes.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import m4x4.mixtapes.network.TestKBMessage;
import m4x4.mixtapes.network.InfoHUDKBMessage;
import m4x4.mixtapes.network.GgMessage;
import m4x4.mixtapes.MaxsMixtapesMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class MaxsMixtapesModKeyMappings {
	public static final KeyMapping TEST_KB = new KeyMapping("key.maxs_mixtapes.test_kb", GLFW.GLFW_KEY_0, "key.categories.mod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new TestKBMessage(0, 0));
				TestKBMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping GG = new KeyMapping("key.maxs_mixtapes.gg", GLFW.GLFW_KEY_N, "key.categories.mod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new GgMessage(0, 0));
				GgMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping INFO_HUDKB = new KeyMapping("key.maxs_mixtapes.info_hudkb", GLFW.GLFW_KEY_X, "key.categories.mod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new InfoHUDKBMessage(0, 0));
				InfoHUDKBMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(TEST_KB);
		event.register(GG);
		event.register(INFO_HUDKB);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				TEST_KB.consumeClick();
				GG.consumeClick();
				INFO_HUDKB.consumeClick();
			}
		}
	}
}
