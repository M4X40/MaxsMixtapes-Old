
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package m4x4.mixtapes.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import m4x4.mixtapes.world.inventory.VarViewerGUIMenu;
import m4x4.mixtapes.world.inventory.BlockmanPlayerMenu;
import m4x4.mixtapes.MaxsMixtapesMod;

public class MaxsMixtapesModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, MaxsMixtapesMod.MODID);
	public static final RegistryObject<MenuType<BlockmanPlayerMenu>> BLOCKMAN_PLAYER = REGISTRY.register("blockman_player", () -> IForgeMenuType.create(BlockmanPlayerMenu::new));
	public static final RegistryObject<MenuType<VarViewerGUIMenu>> VAR_VIEWER_GUI = REGISTRY.register("var_viewer_gui", () -> IForgeMenuType.create(VarViewerGUIMenu::new));
}
