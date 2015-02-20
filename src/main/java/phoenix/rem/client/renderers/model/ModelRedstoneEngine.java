package phoenix.rem.client.renderers.model;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import phoenix.rem.blocks.tile.engine.TERedstoneEngine;
import phoenix.rem.data.ModInfo;
import cpw.mods.fml.client.FMLClientHandler;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class ModelRedstoneEngine extends ModelBase{

	private IModelCustom EngineModelDC;

	public ModelRedstoneEngine() {
		this.EngineModelDC = AdvancedModelLoader.loadModel(new ResourceLocation(ModInfo.MODID + ":models/DCMotor.obj"));
	}

	public void renderEngine(){
		EngineModelDC.renderAll();
	}

	public void renderEngine(TERedstoneEngine engine, double x, double y, double z){
		float scale = 0.07f;
		Float rotation = getRotation(engine);
		//Tessellator tessellator = Tessellator.instance;
		//IBlockAccess world = engine.getWorldObj();
		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) x + 0.5f, (float) y, (float) z + 0.5f);
		GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
		GL11.glScalef(scale, scale, scale);
		//tessellator.setColorOpaque_F(1, 1, 1);
		//tessellator.startDrawingQuads();
		//int brightness = BlockRegist.RedstoneEngine.getMixedBrightnessForBlock(world, engine.xCoord, engine.yCoord, engine.zCoord);
		//tessellator.setBrightness(brightness);
		ResourceLocation test = new ResourceLocation(ModInfo.MODID + ":models/textures/test_0.png");
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
		this.renderEngine();
		//tessellator.draw();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}
}
