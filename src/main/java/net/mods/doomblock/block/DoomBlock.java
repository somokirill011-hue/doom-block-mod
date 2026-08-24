package net.mods.doomblock.block;

import net.mods.doomblock.procedures.DoomRedstoneOnProcedure;
import net.mods.doomblock.procedures.DoomRedstoneOffProcedure;
import net.mods.doomblock.procedures.DoomEntityWalksOnTheBlockProcedure;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class DoomBlock extends Block {
	public static final BooleanProperty KILL = BooleanProperty.create("kill");

	public DoomBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(4.8f, 11.78f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.IRON_XYLOPHONE));
		this.registerDefaultState(this.stateDefinition.any().setValue(KILL, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(KILL);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(KILL, false);
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			DoomRedstoneOnProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		} else {
			DoomRedstoneOffProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		}
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		DoomEntityWalksOnTheBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}
}