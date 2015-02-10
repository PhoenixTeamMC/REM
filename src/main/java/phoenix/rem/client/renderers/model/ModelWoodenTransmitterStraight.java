package phoenix.rem.client.renderers.model;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import phoenix.rem.blocks.tile.transmitter.TEWoodStraight;
import phoenix.rem.data.ModInfo;

/**
 * Created by Elec332 on 10-2-2015.
 */
public class ModelWoodenTransmitterStraight extends ModelBase {

    private IModelCustom modelWoodenTransmitter;

    public ModelWoodenTransmitterStraight(){
        this.modelWoodenTransmitter = AdvancedModelLoader.loadModel(new ResourceLocation(ModInfo.MODID + ":models/p.obj"));
    }

    public void Render(){
        modelWoodenTransmitter.renderAll();
    }

    public void Render(TEWoodStraight engine, double x, double y, double z){
        float scale = 0.1f;
        Float rotation = getRotation(engine);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y, (float) z + 0.5f);
        GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(scale, scale, scale);
        ResourceLocation test = new ResourceLocation(ModInfo.MODID + ":models/textures/test_0.png");
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
        this.Render();
        GL11.glPopMatrix();
    }
}
