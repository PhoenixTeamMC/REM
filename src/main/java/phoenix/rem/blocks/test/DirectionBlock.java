package phoenix.rem.blocks.test;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import phoenix.rem.blocks.BlockBase;
import phoenix.rem.data.ModInfo;

/**
 * Created by Elec332 on 12-2-2015.
 */
public class DirectionBlock extends BlockBase {
    @SideOnly(Side.CLIENT)
    public IIcon[] icons = new IIcon[6];

    public DirectionBlock(){
        super(Material.rock, "DirectionBlock");
        this.setBlockTextureName(ModInfo.MODID + ":test");
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[side];
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        for (int i = 0; i < 6; i ++) {
            this.icons[i] = reg.registerIcon(this.textureName + "_" + i);
        }
    }
}
