package com.thnote.thnotemod.datagen;

import com.thnote.thnotemod.Thnote;
import com.thnote.thnotemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Thnote.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.POTATO_RUBY.get());
    }
}
