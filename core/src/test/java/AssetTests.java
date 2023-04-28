
import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(GdxTestRunner.class)
public class AssetTests {
    @Test
    public void testChefSpritesExist(){
        assertTrue("If this fails, the chef sprite is not available", Gdx.files.internal("../assets/Kenney-Game-Assets-2/2D assets/Topdown Shooter (620 assets)/PNG/Man Brown/manBrown_hold.png").exists());
        assertTrue("If this fails, the chef sprite is not available", Gdx.files.internal("../assets/Kenney-Game-Assets-2/2D assets/Topdown Shooter (620 assets)/PNG/Woman Green/womanGreen_hold.png").exists());
    }




}
