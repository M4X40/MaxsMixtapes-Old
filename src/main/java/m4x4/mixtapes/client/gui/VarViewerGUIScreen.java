package m4x4.mixtapes.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import m4x4.mixtapes.world.inventory.VarViewerGUIMenu;
import m4x4.mixtapes.network.VarViewerGUIButtonMessage;
import m4x4.mixtapes.MaxsMixtapesMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class VarViewerGUIScreen extends AbstractContainerScreen<VarViewerGUIMenu> {
	private final static HashMap<String, Object> guistate = VarViewerGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox QueueSlotTB;
	EditBox SlotCheckTB;
	EditBox CurrentSongTB;
	EditBox CurrentLengthTB;
	EditBox CheckSlotTB;
	EditBox SOOTB;
	EditBox StopCountTB;
	EditBox SCOTB;
	Button button_empty2;

	public VarViewerGUIScreen(VarViewerGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 423;
		this.imageHeight = 239;
	}

	private static final ResourceLocation texture = new ResourceLocation("maxs_mixtapes:textures/screens/var_viewer_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		QueueSlotTB.render(ms, mouseX, mouseY, partialTicks);
		SlotCheckTB.render(ms, mouseX, mouseY, partialTicks);
		CurrentSongTB.render(ms, mouseX, mouseY, partialTicks);
		CurrentLengthTB.render(ms, mouseX, mouseY, partialTicks);
		CheckSlotTB.render(ms, mouseX, mouseY, partialTicks);
		SOOTB.render(ms, mouseX, mouseY, partialTicks);
		StopCountTB.render(ms, mouseX, mouseY, partialTicks);
		SCOTB.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (QueueSlotTB.isFocused())
			return QueueSlotTB.keyPressed(key, b, c);
		if (SlotCheckTB.isFocused())
			return SlotCheckTB.keyPressed(key, b, c);
		if (CurrentSongTB.isFocused())
			return CurrentSongTB.keyPressed(key, b, c);
		if (CurrentLengthTB.isFocused())
			return CurrentLengthTB.keyPressed(key, b, c);
		if (CheckSlotTB.isFocused())
			return CheckSlotTB.keyPressed(key, b, c);
		if (SOOTB.isFocused())
			return SOOTB.keyPressed(key, b, c);
		if (StopCountTB.isFocused())
			return StopCountTB.keyPressed(key, b, c);
		if (SCOTB.isFocused())
			return SCOTB.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		QueueSlotTB.tick();
		SlotCheckTB.tick();
		CurrentSongTB.tick();
		CurrentLengthTB.tick();
		CheckSlotTB.tick();
		SOOTB.tick();
		StopCountTB.tick();
		SCOTB.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.label_queue_slot"), 4, 7, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.label_slottocheck"), 4, 34, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.label_current_song"), 4, 61, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.label_current_length"), 4, 88, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.label_check_slot"), 4, 115, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.label_swap_on_open"), 4, 142, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.label_stoppedcount"), 4, 169, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.label_stoppedcount_old"), 4, 196, -12829636);
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
		QueueSlotTB = new EditBox(this.font, this.leftPos + 85, this.topPos + 7, 324, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.QueueSlotTB")) {
			{
				setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.QueueSlotTB").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.QueueSlotTB").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.QueueSlotTB").getString());
				else
					setSuggestion(null);
			}
		};
		QueueSlotTB.setMaxLength(32767);
		guistate.put("text:QueueSlotTB", QueueSlotTB);
		this.addWidget(this.QueueSlotTB);
		SlotCheckTB = new EditBox(this.font, this.leftPos + 85, this.topPos + 34, 324, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SlotCheckTB")) {
			{
				setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SlotCheckTB").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SlotCheckTB").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SlotCheckTB").getString());
				else
					setSuggestion(null);
			}
		};
		SlotCheckTB.setMaxLength(32767);
		guistate.put("text:SlotCheckTB", SlotCheckTB);
		this.addWidget(this.SlotCheckTB);
		CurrentSongTB = new EditBox(this.font, this.leftPos + 85, this.topPos + 61, 324, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CurrentSongTB")) {
			{
				setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CurrentSongTB").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CurrentSongTB").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CurrentSongTB").getString());
				else
					setSuggestion(null);
			}
		};
		CurrentSongTB.setMaxLength(32767);
		guistate.put("text:CurrentSongTB", CurrentSongTB);
		this.addWidget(this.CurrentSongTB);
		CurrentLengthTB = new EditBox(this.font, this.leftPos + 85, this.topPos + 88, 324, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CurrentLengthTB")) {
			{
				setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CurrentLengthTB").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CurrentLengthTB").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CurrentLengthTB").getString());
				else
					setSuggestion(null);
			}
		};
		CurrentLengthTB.setMaxLength(32767);
		guistate.put("text:CurrentLengthTB", CurrentLengthTB);
		this.addWidget(this.CurrentLengthTB);
		CheckSlotTB = new EditBox(this.font, this.leftPos + 85, this.topPos + 115, 324, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CheckSlotTB")) {
			{
				setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CheckSlotTB").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CheckSlotTB").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.CheckSlotTB").getString());
				else
					setSuggestion(null);
			}
		};
		CheckSlotTB.setMaxLength(32767);
		guistate.put("text:CheckSlotTB", CheckSlotTB);
		this.addWidget(this.CheckSlotTB);
		SOOTB = new EditBox(this.font, this.leftPos + 85, this.topPos + 142, 324, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SOOTB")) {
			{
				setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SOOTB").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SOOTB").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SOOTB").getString());
				else
					setSuggestion(null);
			}
		};
		SOOTB.setMaxLength(32767);
		guistate.put("text:SOOTB", SOOTB);
		this.addWidget(this.SOOTB);
		StopCountTB = new EditBox(this.font, this.leftPos + 85, this.topPos + 169, 324, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.StopCountTB")) {
			{
				setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.StopCountTB").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.StopCountTB").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.StopCountTB").getString());
				else
					setSuggestion(null);
			}
		};
		StopCountTB.setMaxLength(32767);
		guistate.put("text:StopCountTB", StopCountTB);
		this.addWidget(this.StopCountTB);
		SCOTB = new EditBox(this.font, this.leftPos + 94, this.topPos + 196, 315, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SCOTB")) {
			{
				setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SCOTB").getString());
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SCOTB").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.maxs_mixtapes.var_viewer_gui.SCOTB").getString());
				else
					setSuggestion(null);
			}
		};
		SCOTB.setMaxLength(32767);
		guistate.put("text:SCOTB", SCOTB);
		this.addWidget(this.SCOTB);
		button_empty2 = new Button(this.leftPos + 391, this.topPos + 214, 27, 20, Component.translatable("gui.maxs_mixtapes.var_viewer_gui.button_empty2"), e -> {
			if (true) {
				MaxsMixtapesMod.PACKET_HANDLER.sendToServer(new VarViewerGUIButtonMessage(0, x, y, z));
				VarViewerGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_empty2", button_empty2);
		this.addRenderableWidget(button_empty2);
	}
}
