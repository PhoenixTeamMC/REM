package phoenix.rem.client.renderers.model;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import phoenix.rem.blocks.tile.TEDCEngine;
import phoenix.rem.main.REMMod;

/**
 * Created by Elec332 on 8-2-2015.
 */
public class ModelDCEngine extends ModelBase {

    private IModelCustom EngineModelDC;

    public ModelDCEngine(){
        this.EngineModelDC = AdvancedModelLoader.loadModel(new ResourceLocation(REMMod.modID+":models/DCMotor.obj"));
    }

    public void renderEngine(){
        EngineModelDC.renderAll();
    }

    public void renderEngine(TEDCEngine engine, double x, double y, double z)
    {
        float scale = 0.1f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y, (float) z + 0.5f);
        GL11.glScalef(scale, scale, scale);
        ResourceLocation test = new ResourceLocation(REMMod.modID+":models/textures/test_0.png");
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
        this.renderEngine();
        GL11.glPopMatrix();
    }
}
