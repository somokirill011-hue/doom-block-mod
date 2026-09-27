package net.mods.doomblock.block;

import net.mods.doomblock.procedures.DoomRedstoneOnProcedure;
import net.mods.doomblock.procedures.DoomRedstoneOffProcedure;
import net.mods.doomblock.procedures.DoomEntityCollidesInTheBlockProcedure;
import net.mods.doomblock.block.entity.LightBlueDoomBlockEntity;

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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.mods.doomblock.procedures.RightClickOnDoomBlocksProcedure;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.Containers;
import net.minecraft.world.inventory.AbstractContainerMenu;

public class LightBlueDoomBlock extends Block implements EntityBlock {
	public static final BooleanProperty KILL = BooleanProperty.create("kill");
	public static final BooleanProperty KILLING_WITH_A_TOUCH = BooleanProperty.create("killing_with_a_touch");
	public static final BooleanProperty PARTICLES = BooleanProperty.create("particles");
	public static final BooleanProperty CHEST = BooleanProperty.create("chest");
	public LightBlueDoomBlock() {
		super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(4.8f, 11.78f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.IRON_XYLOPHONE));
		this.registerDefaultState(this.stateDefinition.any().setValue(KILL, false).setValue(KILLING_WITH_A_TOUCH, false).setValue(PARTICLES, true).setValue(CHEST, false));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(KILL, KILLING_WITH_A_TOUCH, PARTICLES, CHEST);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockState state = super.getStateForPlacement(context);
		if (state == null)
			return null;
		return state.setValue(KILL, false).setValue(KILLING_WITH_A_TOUCH, false).setValue(PARTICLES, true).setValue(CHEST, false);
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
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		DoomEntityCollidesInTheBlockProcedure.LightBlue.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		DoomEntityCollidesInTheBlockProcedure.LightBlue.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

    @Override
    public InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (!world.isClientSide()) {
            double x = pos.getX();
            double y = pos.getY();
            double z = pos.getZ();

            RightClickOnDoomBlocksProcedure.execute(world, x, y, z, player);
        }
        return InteractionResult.SUCCESS;
    }

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
	    super.onPlace(blockstate, world, pos, oldState, moving);
	    if (!world.isClientSide) {
	        world.scheduleTick(pos, this, 10);
	    }
	}
	
	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
	    boolean kill = blockstate.getValue(KILL);
	    boolean particles = blockstate.getValue(PARTICLES);
	
	    if (kill && particles) {
	        double x = pos.getX() + 0.5;
	        double y = pos.getY() + 0.5;
	        double z = pos.getZ() + 0.5;
	        world.sendParticles(
	            new DustParticleOptions(DustParticleOptions.REDSTONE_PARTICLE_COLOR, 1.0F),
	            x, y, z, 5, 0.3, 0.3, 0.3, 0.0
	        );
	    }
	
	    // Планируем следующий тик — без этого частицы остановятся
	    world.scheduleTick(pos, this, 10);
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new LightBlueDoomBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof LightBlueDoomBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	@Override
	public boolean hasAnalogOutputSignal(BlockState state) {
		return true;
	}

	@Override
	public int getAnalogOutputSignal(BlockState blockState, Level world, BlockPos pos) {
		BlockEntity tileentity = world.getBlockEntity(pos);
		if (tileentity instanceof LightBlueDoomBlockEntity be)
			return AbstractContainerMenu.getRedstoneSignalFromContainer(be);
		else
			return 0;
	}
}