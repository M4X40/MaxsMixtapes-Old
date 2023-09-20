package m4x4.mixtapes.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import m4x4.mixtapes.world.inventory.BlockmanPlayerMenu;
import m4x4.mixtapes.network.BlockmanPlayerButtonMessage;
import m4x4.mixtapes.MaxsMixtapesMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BlockmanPlayerScreen extends AbstractContainerScreen<BlockmanPlayerMenu> {
	private final static HashMap<String, Object> guistate = BlockmanPlayerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	ImageButton imagebutton_blockmanbutton_play;
	ImageButton imagebutton_blockmanbutton_stop;
	ImageButton imagebutton_play_button;
	ImageButton imagebutton_stop_button;

	public BlockmanPlayerScreen(BlockmanPlayerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 234;
	}

	private static final ResourceLocation texture = new ResourceLocation("maxs_mixtapes:textures/screens/blockman_player.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("maxs_mixtapes:textures/screens/temp_walkman_2_gui.png"));
		this.blit(ms, this.leftPos + 7, this.topPos + 18, 0, 0, 64, 64, 64, 64);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.blockman_player.label_varmmtblocknamenametext"), 6, 9, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.blockman_player.label_loop"), 6, 198, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.blockman_player.label_queue"), 141, 198, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_empty = new Button(this.leftPos + 160, this.topPos + 36, 9, 20, Component.translatable("gui.maxs_mixtapes.blockman_player.button_empty"), e -> {
			if (true) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new BlockmanPlayerButtonMessage(0, x, y, z));
				BlockmanPlayerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		imagebutton_blockmanbutton_play = new ImageButton(this.leftPos + 115, this.topPos + 36, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_blockmanbutton_play.png"), 16, 32, e -> {
			if (true) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new BlockmanPlayerButtonMessage(1, x, y, z));
				BlockmanPlayerButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blockmanbutton_play", imagebutton_blockmanbutton_play);
		this.addRenderableWidget(imagebutton_blockmanbutton_play);
		imagebutton_blockmanbutton_stop = new ImageButton(this.leftPos + 133, this.topPos + 36, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_blockmanbutton_stop.png"), 16, 32, e -> {
			if (true) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new BlockmanPlayerButtonMessage(2, x, y, z));
				BlockmanPlayerButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_blockmanbutton_stop", imagebutton_blockmanbutton_stop);
		this.addRenderableWidget(imagebutton_blockmanbutton_stop);
		imagebutton_play_button = new ImageButton(this.leftPos + 6, this.topPos + 207, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_play_button.png"), 16, 32, e -> {
			if (true) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new BlockmanPlayerButtonMessage(3, x, y, z));
				BlockmanPlayerButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_play_button", imagebutton_play_button);
		this.addRenderableWidget(imagebutton_play_button);
		imagebutton_stop_button = new ImageButton(this.leftPos + 150, this.topPos + 207, 16, 16, 0, 0, 16, new ResourceLocation("maxs_mixtapes:textures/screens/atlas/imagebutton_stop_button.png"), 16, 32, e -> {
			if (true) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new BlockmanPlayerButtonMessage(4, x, y, z));
				BlockmanPlayerButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_stop_button", imagebutton_stop_button);
		this.addRenderableWidget(imagebutton_stop_button);
	}
}
