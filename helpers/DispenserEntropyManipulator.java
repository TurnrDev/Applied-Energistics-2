package appeng.helpers;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import appeng.items.tools.powered.ToolEntropyManipulator;
import appeng.util.Platform;

final public class DispenserEntropyManipulator extends BehaviorDefaultDispenseItem
{

	@Override
	protected ItemStack dispenseStack(IBlockSource dispenser, ItemStack dispensedItem)
	{
		Item i = dispensedItem.getItem();
		if ( i instanceof ToolEntropyManipulator )
		{
			EnumFacing enumfacing = BlockDispenser.func_149937_b( dispenser.getBlockMetadata() );
			ToolEntropyManipulator tm = (ToolEntropyManipulator) i;

			World w = dispenser.getWorld();
			if ( w instanceof WorldServer )
			{
				int x = dispenser.getXInt() + enumfacing.getFrontOffsetX();
				int y = dispenser.getYInt() + enumfacing.getFrontOffsetY();
				int z = dispenser.getZInt() + enumfacing.getFrontOffsetZ();

				tm.onItemUse( dispensedItem, Platform.getPlayer( (WorldServer) w ), w, x, y, z, enumfacing.ordinal(), 0.5f, 0.5f, 0.5f );
			}
		}
		return dispensedItem;
	}
}
