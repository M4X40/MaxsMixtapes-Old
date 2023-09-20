package m4x4.mixtapes.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import m4x4.mixtapes.network.MaxsMixtapesModVariables;
import m4x4.mixtapes.init.MaxsMixtapesModItems;
import m4x4.mixtapes.MaxsMixtapesMod;

import java.util.function.Supplier;
import java.util.Map;

public class BlockmanProcMainSlotChangeProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		ItemStack cassette = ItemStack.EMPTY;
		String name = "";
		double length = 0;
		if ((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanIsLooped) {
			if (!(entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanHasLooped) {
				BlockmanProcLooperProcedure.execute(entity);
			}
		}
		MaxsMixtapesMod.queueServerWork(15, () -> {
		});
		cassette = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt
				? ((Slot) _slt.get((int) (entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanSlotToCheck)).getItem()
				: ItemStack.EMPTY);
		if (cassette.getItem() == MaxsMixtapesModItems.AIRPOD.get()) {
			name = "thebeast";
			length = 40;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BIG_POPPA.get()) {
			name = "big_poppa_stereo";
			length = 5060;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BUCKLE.get()) {
			name = "bmp_stereo";
			length = 3040;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_AGENT_RAINBOW.get()) {
			name = "hcas_stereo";
			length = 5240;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_COSMIC.get()) {
			name = "cosmic_stereo";
			length = 9040;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BETTY.get()) {
			name = "betty_stereo";
			length = 2940;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_VIRGINIA.get()) {
			name = "doll_house_stereo";
			length = 3460;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BOW.get()) {
			name = "bow_stereo";
			length = 3600;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ALLEN.get()) {
			name = "botp_stereo";
			length = 4820;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BOX_15.get()) {
			name = "box15_stereo";
			length = 4900;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_MAX.get()) {
			name = "is_it_me_stereo";
			length = 4340;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_LUCAS.get()) {
			name = "matb_stereo";
			length = 3920;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ROSE_MARY.get()) {
			name = "wit_stereo";
			length = 3160;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_DESMOND.get()) {
			name = "histe_stereo";
			length = 6020;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_GOOD_MORNING.get()) {
			name = "good_morning_stereo";
			length = 3920;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_STRONGER.get()) {
			name = "stronger_stereo";
			length = 6260;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_MY_ORDINARY_LIFE.get()) {
			name = "my_ordinary_life_stereo";
			length = 4620;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_FNAF_1.get()) {
			name = "five_long_nights_stereo";
			length = 3760;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_DOORS.get()) {
			name = "dotd_stereo";
			length = 4700;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_GUIDING_LIGHT.get()) {
			name = "guiding_light_stereo";
			length = 1220;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_HERE_I_COME.get()) {
			name = "here_i_come_stereo";
			length = 2960;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_KRATOS.get()) {
			name = "god_of_war_stereo";
			length = 4960;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_LOVE_LIKE_YOU.get()) {
			name = "love_like_you_stereo";
			length = 2880;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_TOMCAT.get()) {
			name = "tomcat_disposables_stereo";
			length = 7140;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_NORMAL_ALBUM.get()) {
			name = "wbtta_stereo";
			length = 5120;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_OKULTRA.get()) {
			name = "okultra_stereo";
			length = 5900;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_LOVE_ME_NORMALLY.get()) {
			name = "love_me_normally_stereo";
			length = 6900;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_TOACW.get()) {
			name = "toacw_stereo";
			length = 5300;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_SLIME_GOD.get()) {
			name = "return_to_slime_stereo";
			length = 5880;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_SCOURGE.get()) {
			name = "sotu_stereo";
			length = 9180;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_THUNDER.get()) {
			name = "thunder_roll_stereo";
			length = 3640;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_UNIVERSAL_COLLAPSE.get()) {
			name = "universal_collapse_stereo";
			length = 5480;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_JUNGLE_DRAGON.get()) {
			name = "jungle_dragon_stereo";
			length = 10100;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_AMERICAN_BOY.get()) {
			name = "american_boy_stereo";
			length = 4800;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_HIGHWIRE.get()) {
			name = "mos_thoser_stereo";
			length = 4440;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_GHOSTS_N_STUFF.get()) {
			name = "ghosts_n_stuff_stereo";
			length = 3760;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_VIRTUAL_INSANITY.get()) {
			name = "virtual_insanity_stereo";
			length = 4520;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_FINAL_DUET.get()) {
			name = "final_duet_stereo";
			length = 2660;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_TULIPS.get()) {
			name = "home_for_flowers_stereo";
			length = 1880;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_MY_TIME.get()) {
			name = "my_time_stereo";
			length = 6300;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_DEATH_BY_GLAMOR.get()) {
			name = "death_by_glamor_stereo";
			length = 2700;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_HOPES_AND_DREAMS.get()) {
			name = "fohad_stereo";
			length = 3240;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_TORIEL.get()) {
			name = "ycach_stereo";
			length = 2020;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_SCARLET_FOREST.get()) {
			name = "scarlet_forest_stereo";
			length = 2580;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BTD_5.get()) {
			name = "btd5_stereo";
			length = 5020;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_GRAVITY.get()) {
			name = "gravity_stereo";
			length = 6220;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ANARCHY_RAINBOW.get()) {
			name = "anarchy_rainbow_stereo";
			length = 7380;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_2_TIME_ZONES.get()) {
			name = "two_time_zones_stereo";
			length = 3240;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BAD_END_THEATER.get()) {
			name = "bad_end_theater_stereo";
			length = 1980;
		} else if (cassette.getItem() == MaxsMixtapesModItems.WILD_SIDE.get()) {
			name = "wild_side_stereo";
			length = 3180;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_LETTER_TO_MY_BROTHER.get()) {
			name = "letter_to_my_brother_stereo";
			length = 4340;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_AFTER_DARK.get()) {
			name = "after_dark_stereo";
			length = 5160;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_STILL_ALIVE.get()) {
			name = "still_alive-stereo";
			length = 3560;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_WANT_YOU_GONE.get()) {
			name = "want_you_gone_stereo";
			length = 2780;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_NIGHTMARE.get()) {
			name = "nightmare_stereo";
			length = 7440;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_FMTTM.get()) {
			name = "fmttm_stereo";
			length = 5320;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ROCKY.get()) {
			name = "sunset_rose_cocktail_stereo";
			length = 2320;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_OLIVE_BRANCH.get()) {
			name = "olive_branch_stereo";
			length = 6320;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_MONSTER.get()) {
			name = "monster_stereo";
			length = 5140;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_PIGSTEP.get()) {
			name = "pigstep_stereo";
			length = 2920;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_A_CYBERS_WORLD.get()) {
			name = "cybers_world_stereo";
			length = 3340;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_1THOT_2THOT.get()) {
			name = "ottt_stereo";
			length = 2640;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ALPHA.get()) {
			name = "alpha_stereo";
			length = 12080;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_UNDERTALE.get()) {
			name = "undertale_stereo";
			length = 7640;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_CEST_LA_VIE.get()) {
			name = "cest_la_vie_stereo";
			length = 3220;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_GOODBYE_TO_A_WORLD.get()) {
			name = "gtaw_stereo";
			length = 6620;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_REJUVENESCENCIA.get()) {
			name = "rejuv_stereo";
			length = 2160;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_WMTAO.get()) {
			name = "wmtao_stereo";
			length = 2460;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_GHOST.get()) {
			name = "ghost_stereo";
			length = 3180;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_IF_WE_FALL.get()) {
			name = "if_we_fall_stereo";
			length = 4840;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_PARASITE.get()) {
			name = "parasite_stereo";
			length = 5820;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_EISOPTROPHOBIA.get()) {
			name = "eisop_stereo";
			length = 1400;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_SANDCASTLE_KINGDOMS.get()) {
			name = "sandcastle_kingdoms_stereo";
			length = 3680;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ALWAYS_COME_BACK.get()) {
			name = "always_come_back_stereo";
			length = 3180;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_LEAVE_ME_BEHIND.get()) {
			name = "leave_me_behind_stereo";
			length = 4040;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BATTLE_BLOCK.get()) {
			name = "bbt_stereo";
			length = 4840;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_SAFE_AND_SOUND.get()) {
			name = "safeandsound_stereo";
			length = 3880;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_PUPPETEER.get()) {
			name = "puppeteer_stereo";
			length = 3440;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_KICK_BACK.get()) {
			name = "kick_back_stereo";
			length = 3920;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_DREAMLAND.get()) {
			name = "dreamland_stereo";
			length = 4880;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_I_DONT_WANNA_BE_FREE.get()) {
			name = "idwbf_stereo";
			length = 2860;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_STOLAS.get()) {
			name = "ywbo_stereo";
			length = 4360;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_GYM.get()) {
			name = "gymbattle_stereo";
			length = 7980;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_THE_LAST_GOODBYE.get()) {
			name = "the_last_goodbye_stereo";
			length = 3980;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ISLAND.get()) {
			name = "island_stereo";
			length = 2180;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_VAMPIRE.get()) {
			name = "riav_stereo";
			length = 3740;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_MATTEL.get()) {
			name = "mattel_stereo";
			length = 6620;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_G.get()) {
			name = "g_stereo";
			length = 4400;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_RASPUTIN.get()) {
			name = "rasputin_stereo";
			length = 5360;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_AMONGUS.get()) {
			name = "amongus_stereo";
			length = 3460;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_FURRYMON.get()) {
			name = "furrymon_stereo";
			length = 4240;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_LIGHTSABERS.get()) {
			name = "lightsabers_stereo";
			length = 5660;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_LIKE_THAT.get()) {
			name = "like_that_stereo";
			length = 3560;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_PIZZA_TIME.get()) {
			name = "pizza_time_stereo";
			length = 4600;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ASAFEWORLD.get()) {
			name = "a_safe_world_stereo";
			length = 3360;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_SAFE_AND_CYBER.get()) {
			name = "sac_stereo";
			length = 3360;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ADDICT.get()) {
			name = "addict_stereo";
			length = 6320;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_SIMOON.get()) {
			name = "simoon_stereo";
			length = 6780;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_GOD_RACE.get()) {
			name = "gr_stereo";
			length = 3200;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ANEMOIA.get()) {
			name = "anemoia_stereo";
			length = 2680;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_WOLF_AND_RABBIT.get()) {
			name = "war_stereo";
			length = 4700;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_STEAM_GARDENS.get()) {
			name = "sg_stereo";
			length = 4700;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_DRUNK.get()) {
			name = "drunk_stereo";
			length = 4520;
		} else if (cassette.getItem() == Items.BREAD) {
			name = "danbread";
			length = 220;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ARCHETYPE.get()) {
			name = "archetype_stereo";
			length = 4860;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_FBC.get()) {
			name = "fbc_stereo";
			length = 3420;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_DJMM.get()) {
			name = "djmm_stereo";
			length = 4240;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BARBIE.get()) {
			name = "barbie_girl_stereo";
			length = 4040;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_CALIFORNIA.get()) {
			name = "cali_girls_stereo";
			length = 4680;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ETERNAL_HORIZONS.get()) {
			name = "eh_stereo";
			length = 3080;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_TOTTFIY.get()) {
			name = "tottfiy_stereo";
			length = 8260;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_OOT.get()) {
			name = "oot_stereo";
			length = 3380;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_TOXIC_COFFEE.get()) {
			name = "toxic_coffee_stereo";
			length = 4000;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BAKA_MITAI.get()) {
			name = "bm_stereo";
			length = 5840;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_IJAM.get()) {
			name = "ijam_stereo";
			length = 5080;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_DAN_TDM.get()) {
			name = "street_fighter_stereo";
			length = 4180;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_SCIENCE_BLASTER.get()) {
			name = "sb_stereo";
			length = 3660;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_MOV.get()) {
			name = "mov_stereo";
			length = 5680;
		} else if (cassette.getItem() == MaxsMixtapesModItems.HANDSOME_DEVIL.get()) {
			name = "rome_reaction";
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_WIGGLECORE.get()) {
			name = "wigglecore_stereo";
			length = 3280;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_BOX_16.get()) {
			name = "box16_stereo";
			length = 6640;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_ROXANNE.get()) {
			name = "roxanne_stereo";
			length = 3240;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_PIGSTEP_JAZZ.get()) {
			name = "pigstep_jazz_stereo";
			length = 7560;
		} else if (cassette.getItem() == MaxsMixtapesModItems.CASSETTE_HERE_I_COME_2.get()) {
			name = "here_i_come_2_stereo";
			length = 3860;
		} else {
			if (!(entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanNoError) {
				BlockmanErrorRandomizerProcedure.execute(entity);
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(((entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new MaxsMixtapesModVariables.PlayerVariables())).BlockmanError)), false);
			}
		}
		{
			String _setval = name;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanCurrentSong = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = length;
			entity.getCapability(MaxsMixtapesModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.BlockmanCurrentSongLength = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		return name;
	}
}
