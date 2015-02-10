package phoenix.rem.client.renderers.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import phoenix.rem.blocks.tile.transmitter.TEWoodStraight;
import phoenix.rem.client.renderers.model.ModelWoodenTransmitterStraight;

/**
 * Created by Elec332 on 10-2-2015.
 */
@SideOnly(Side.CLIENT)
public class TileWoodenTransmitterSRenderer extends TileEntitySpecialRenderer {

    private ModelWoodenTransmitterStraight modelRedstoneEngine = new ModelWoodenTransmitterStraight();
    private RenderItem renderItem;

    public TileWoodenTransmitterSRenderer(){
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
        modelRedstoneEngine.Render((TEWoodStraight) par1TileEntity, par2, par3, par4);
    }
}