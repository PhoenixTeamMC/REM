package phoenix.rem.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import phoenix.rem.api.wrench.IRotatable;
import phoenix.rem.api.wrench.IWrenchable;
import phoenix.rem.data.IConData;

/**
 * Created by Elec332 on 6-2-2015.
 */
public abstract class BaseBlockRotatable extends BlockBase implements IWrenchable, ITileEntityProvider{
    public BaseBlockRotatable(Material mat, String name) {
        super(mat, name);
        this.name = name;
    }

    public IIcon[] icons = new IIcon[6];
    String name;

    @Override
    public void registerBlockIcons(IIconRegister register) {
        for (int i = 0; i < 6; i ++) {
            IIcon icon = register.registerIcon(this.getTextureName() + "_" + i);
            this.icons[i] = icon;
            IConData.IconRegistry.put(name + "_" + i, icon);
        }
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
      return this.icons[side];
    }

    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        IRotatable var6 = (IRotatable)world.getTileEntity(x, y, z);
        return var6 == null?null:var6.getTexture(side);
    }

    public boolean rotateBlock(World world, int x, int y, int z, ForgeDirection direction) {
        TileEntity tile = world.getTileEntity(x, y, z);
        return tile instanceof IRotatable ?((IRotatable)tile).rotateBlock(world, x, y, z):false;
    }
}
