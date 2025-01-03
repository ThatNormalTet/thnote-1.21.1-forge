package com.thnote.thnotemod.datagen;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Thnote.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.POTATO_RUBY.get());
        basicItem(ModItems.MAGIC_WAND.get());

        basicItem(ModItems.POTATO_WATER_BUCKET.get());
        basicItem(ModItems.OXYGEN_BUCKET.get());
    }
}
