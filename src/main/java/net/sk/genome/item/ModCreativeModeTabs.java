package net.sk.genome.item;


import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sk.genome.Genome;


@Mod.EventBusSubscriber(modid = Genome.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab GENOME_TAB;


    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        GENOME_TAB = event.registerCreativeModeTab(new ResourceLocation(Genome.MOD_ID,"genome_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.DUMMY.get()))
                        .title(Component.translatable("creativemodetab.genome_tab")));
    }

}
