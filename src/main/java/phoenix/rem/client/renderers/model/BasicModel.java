package phoenix.rem.client.renderers.model;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;
import phoenix.rem.api.wrench.BaseTileRotatable;
import phoenix.rem.data.ModInfo;

/**
 * Created by Elec332 on 11-2-2015.
 */
public class BasicModel extends ModelBase {
    private IModelCustom Model;
    private String location;

    public BasicModel(String objFile, String texture) {
        this.Model = AdvancedModelLoader.loadModel(new ResourceLocation(ModInfo.MODID + ":models/" + objFile + ".obj"));
        this.location = texture;
    }

    public void RenderAll(){
        Model.renderAll();
    }

    public void renderEngine(BaseTileRotatable engine, double x, double y, double z){
        float scale = 0.1f;
        float rotation = getRotation(engine);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + 0.5f, (float) y, (float) z + 0.5f);
        GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
        GL11.glScalef(scale, scale, scale);
        ResourceLocation test = new ResourceLocation(ModInfo.MODID + ":models/textures/" + location);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(test);
        this.RenderAll();
        GL11.glPopMatrix();
    }
}
