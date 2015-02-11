package phoenix.rem.client.renderers.block;

import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.client.renderers.model.BasicModel;

/**
 * Created by Elec332 on 11-2-2015.
 */
public class BasicTESR extends TileEntitySpecialRenderer {

    private BasicModel modelRedstoneEngine;
    private RenderItem renderItem;

    public BasicTESR(String objFile, String texture){
        this.modelRedstoneEngine = new BasicModel(objFile, texture);
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
        modelRedstoneEngine.renderEngine((BaseTileRotatable) par1TileEntity, par2, par3, par4);
    }
}
