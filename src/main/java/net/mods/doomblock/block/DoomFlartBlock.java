package net.mods.doomblock.block;

import net.mods.doomblock.procedures.DoomFlartMobplayerCollidesBlockProcedure;
import net.mods.doomblock.init.DoomBlockModFluids;
import net.mods.doomblock.procedures.DoomFlartNeighbourBlockChangesProcedure;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;

public class DoomFlartBlock extends LiquidBlock {
	public DoomFlartBlock() {
		super(DoomBlockModFluids.DOOM_FLART.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(125f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		DoomFlartMobplayerCollidesBlockProcedure.execute(world, entity);
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
	    world.scheduleTick(pos, this, 1);
	    double x = pos.getX();
	    double y = pos.getY();
	    double z = pos.getZ();
	    DoomFlartNeighbourBlockChangesProcedure.execute(world, x, y, z);
	}
}