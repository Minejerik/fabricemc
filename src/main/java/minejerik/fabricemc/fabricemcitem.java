package minejerik.fabricemc;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class fabricemcitem extends Item {

    private int ITEM_EMC;
    public fabricemcitem(Settings settings, Integer EMC) {
        super(settings);
        ITEM_EMC = EMC;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context){

        tooltip.add(Text.literal("§eEMC:§f "+ITEM_EMC));

        super.appendTooltip(stack,world,tooltip,context);
    }
}
