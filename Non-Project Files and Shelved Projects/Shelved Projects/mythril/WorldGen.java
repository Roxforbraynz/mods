package rox.mythril;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import rox.mythril.blocks.MythrilOre;

public class WorldGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimensionId()) {
		case -1:
			break;
		case 0: generateOre(MythrilOre.mythril_ore, world, random, chunkX*16, chunkZ*16, 2, 0, 24);
			break;
		case 1:
			break;
		}
	}
	
	private void generateOre(Block block, World world, Random rand, int chunkX, int chunkZ, int chancesToSpawn, int minHeight, int maxHeight){
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal height arguments for world generator");
		
		int heightDiff = maxHeight - minHeight + 1;
		for (int k = 0; k <16; k++){
			int xrand = chunkX+rand.nextInt(16);
			int yrand = minHeight+rand.nextInt(heightDiff);
			int zrand = chunkZ+rand.nextInt(16);
			BlockPos blockPos = new BlockPos(xrand, yrand, zrand);
			new WorldGenMinable(block.getDefaultState(), 8).generate(world, rand, blockPos);
		}
	}
}
