package phoenix.REM.init;

import phoenix.REM.blocks.TestBlock;

/**
 * Created by Elec332 on 5-2-2015.
 */
public class BlockRegist {

    public static final BlockRegist instance = new BlockRegist();

    public void init(){
        new TestBlock("test");
    }
}
