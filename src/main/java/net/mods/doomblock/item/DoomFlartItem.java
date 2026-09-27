package net.mods.doomblock.item;

import net.mods.doomblock.init.DoomBlockModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class DoomFlartItem extends BucketItem {
	public DoomFlartItem() {
		super(DoomBlockModFluids.DOOM_FLART.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.RARE));
	}
}