package com.daboxen.uberutilities.api;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class ShapeableBlock extends Block {
	private VoxelShape[] boxes;
	
	public ShapeableBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}
	public ShapeableBlock(BlockBehaviour.Properties properties, VoxelShape... shapes) {
		super(properties);
		setHitboxes(shapes);
	}
	
	public void setHitboxes(VoxelShape... shapes) {
		this.boxes = shapes;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
		return Shapes.or(Shapes.empty(), boxes);
	}
}