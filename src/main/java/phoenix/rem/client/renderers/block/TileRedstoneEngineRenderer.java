package phoenix.rem.client.renderers.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import phoenix.rem.blocks.tile.engine.TERedstoneEngine;
import phoenix.rem.client.renderers.model.ModelRedstoneEngine;

/**
 * Created by Elec332 on 8-2-2015.
 */
@SideOnly(Side.CLIENT)
public class TileRedstoneEngineRenderer extends TileEntitySpecialRenderer{

    private ModelRedstoneEngine modelRedstoneEngine = new ModelRedstoneEngine();
    private RenderItem renderItem;

    public TileRedstoneEngineRenderer(){
        renderItem = new RenderItem()
        {
            @Override
            public boolean shouldBob()
            {
                return false;
            }
        };
        renderItem.setRenderManager(RenderManager.instance);
    }

    @Override
    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par3, double par4, float par5) {
        modelRedstoneEngine.renderEngine((TERedstoneEngine) par1TileEntity, par2, par3, par4);
    }
}
