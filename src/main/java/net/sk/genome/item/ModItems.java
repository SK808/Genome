package net.sk.genome.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sk.genome.Genome;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Genome.MOD_ID);

   public static final RegistryObject<Item> DUMMY = ITEMS.register("dummy",() -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {//registers eventbus
        ITEMS.register(eventBus);
    }
}
