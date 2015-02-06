package phoenix.rem.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import phoenix.rem.api.wrench.IWrenchable;
import phoenix.rem.main.REMMod;

/**
 * Created by Elec332 on 6-2-2015.
 */
public abstract class BaseBlockRotatable extends Block implements IWrenchable{
    public BaseBlockRotatable(Material mat, String name){
        super(mat);
        this.name = name;
    }

    public IIcon[] icons = new IIcon[6];
    String name;

    public void rotate(World world, int x, int y, int z, int side) {
        switch (side) {
            case 2:
                world.setBlockMetadataWithNotify(x, y, z, 5, 2);
                break;
            case 5:
                world.setBlockMetadataWithNotify(x, y, z, 3, 2);
                break;
            case 3:
                world.setBlockMetadataWithNotify(x, y, z, 4, 2);
                break;
            case 4:
                world.setBlockMetadataWithNotify(x, y, z, 2, 2);
                break;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    protected String getTextureName(){
        return REMMod.modID + ":" + name;
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        for (int i = 0; i < 6; i ++) {
            this.icons[i] = register.registerIcon(this.getTextureName() + "_" + i);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.icons[meta];
    }
}
