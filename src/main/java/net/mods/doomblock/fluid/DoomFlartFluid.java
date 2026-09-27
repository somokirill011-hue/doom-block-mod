package net.mods.doomblock.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.mods.doomblock.init.DoomBlockModItems;
import net.mods.doomblock.init.DoomBlockModFluids;
import net.mods.doomblock.init.DoomBlockModFluidTypes;
import net.mods.doomblock.init.DoomBlockModBlocks;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

public abstract class DoomFlartFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> DoomBlockModFluidTypes.DOOM_FLART_TYPE.get(), () -> DoomBlockModFluids.DOOM_FLART.get(), () -> DoomBlockModFluids.FLOWING_DOOM_FLART.get())
			.explosionResistance(125f).tickRate(4).levelDecreasePerBlock(3).slopeFindDistance(5).bucket(() -> DoomBlockModItems.DOOM_FLART_BUCKET.get()).block(() -> (LiquidBlock) DoomBlockModBlocks.DOOM_FLART.get());

	private DoomFlartFluid() {
		super(PROPERTIES);
	}

	public static class Source extends DoomFlartFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends DoomFlartFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}