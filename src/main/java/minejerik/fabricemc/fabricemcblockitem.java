package minejerik.fabricemc;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;


import org.jetbrains.annotations.Nullable;

import java.util.List;

public class fabricemcblockitem extends BlockItem {

    private int ITEM_EMC;
    public fabricemcblockitem(Block block, Settings settings, int EMC){
        super(block,settings);
        ITEM_EMC = EMC;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        tooltip.add(Text.literal("§eEMC:§f " + ITEM_EMC));

        super.appendTooltip(stack, world, tooltip, context);
    }
}
