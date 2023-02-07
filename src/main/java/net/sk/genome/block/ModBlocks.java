package net.sk.genome.block;


import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sk.genome.Genome;
import net.sk.genome.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Genome.MOD_ID);

    //boilerplate methods using<T>
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> blocks){
        return ModItems.ITEMS.register(name, () -> new BlockItem(blocks.get(),
                new Item.Properties()));
    }
    public static final RegistryObject<Block> FOSSIL_ORE = registerBlock("fossil_ore",
            ()-> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.0f).requiresCorrectToolForDrops(), UniformInt.of(2,6)));



    public static void register(IEventBus eventBus){//adds fml eventbus so can be pointed from genome.java
        BLOCKS.register(eventBus);
    }
}
