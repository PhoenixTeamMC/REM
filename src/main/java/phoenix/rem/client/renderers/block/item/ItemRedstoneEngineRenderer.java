package phoenix.rem.client.renderers.block.item;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import phoenix.rem.blocks.tile.engine.TERedstoneEngine;
import phoenix.rem.client.renderers.model.ModelRedstoneEngine;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class ItemRedstoneEngineRenderer implements IItemRenderer {
    private ModelRedstoneEngine modelRedstoneEngine;
    private TileEntitySpecialRenderer renderer;
    private TERedstoneEngine dummyTE;

    public ItemRedstoneEngineRenderer(TileEntitySpecialRenderer renderer, TileEntity te) {
        modelRedstoneEngine = new ModelRedstoneEngine();
        this.renderer = renderer;
        this.dummyTE = (TERedstoneEngine) te;
    }

    //@Override
    //public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        //return true;
    //}

    @Override
    public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper) {
		return true;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		switch (type)
		{
			case ENTITY:
				return true;
			case EQUIPPED:
				return true;
			case EQUIPPED_FIRST_PERSON:
				return true;
			case INVENTORY:
				return true;
			default:
				return false;
		}
	}

	@Override
	public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data){
		float scale = 0.08f;
		switch (type) {
		case ENTITY:
			renderDCEngine((RenderBlocks) data[0], item, 0, 0, 0, scale);
			break;
		case EQUIPPED:
			renderDCEngine((RenderBlocks) data[0], item, 0, 0, 0.5f, scale);
			break;
		case EQUIPPED_FIRST_PERSON:
			renderDCEngine((RenderBlocks) data[0], item, +0.5f, 0.5f, +0.5f, scale);
			break;
		case INVENTORY:
			renderDCEngine((RenderBlocks) data[0], item, -0.5f, -0.75f, -0.5f, scale);
			break;
		default:
			break;
		}
	}

    private void renderDCEngine(RenderBlocks render, ItemStack item, float x, float y, float z, float scale) {

        /*GL11.glPushMatrix();
        GL11.glTranslatef(x, y, z);
        GL11.glScalef(scale, scale, scale);
        GL11.glRotatef(180f, 0f, 1f, 0f);
        ResourceLocation test = new ResourceLocation("models/textures/test_0.png");
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
		GL11.glPushMatrix();
        //modelRedstoneEngine.renderEngine();
		modelRedstoneEngine.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
		GL11.glPopMatrix();*/

        /*
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		ResourceLocation test = new ResourceLocation("models/textures/test_0.png");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		this.modelRedstoneEngine.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
        */
        this.renderer.renderTileEntityAt(dummyTE, 0.0, 0.0, 0.0, 0.0F);
    }
}
