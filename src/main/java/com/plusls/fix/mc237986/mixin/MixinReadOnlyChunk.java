package com.plusls.fix.mc237986.mixin;

import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ProtoChunk;
import net.minecraft.world.chunk.ReadOnlyChunk;
import net.minecraft.world.chunk.UpgradeData;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ReadOnlyChunk.class)
public class MixinReadOnlyChunk extends ProtoChunk {

    @Shadow
    @Final
    private WorldChunk wrapped;

    public MixinReadOnlyChunk(ChunkPos chunkPos, UpgradeData upgradeData, HeightLimitView heightLimitView, Registry<Biome> registry) {
        super(chunkPos, upgradeData, heightLimitView, registry);
    }

    @Override
    public boolean hasStructureReferences() {
        return this.wrapped.hasStructureReferences();
    }
}
