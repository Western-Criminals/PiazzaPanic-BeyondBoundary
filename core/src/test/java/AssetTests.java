
import com.badlogic.gdx.Gdx;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(GdxTestRunner.class)
public class AssetTests {
    @Test
    public void testChefSpritesExist(){
        assertTrue("If this fails, the 1st chef sprite is not available", Gdx.files.internal("../assets/Kenney-Game-Assets-2/2D assets/Topdown Shooter (620 assets)/PNG/Man Brown/manBrown_hold.png").exists());
        assertTrue("If this fails, the 2nd chef sprite is not available", Gdx.files.internal("../assets/Kenney-Game-Assets-2/2D assets/Topdown Shooter (620 assets)/PNG/Woman Green/womanGreen_hold.png").exists());
        assertTrue("If this fails, the 3rd chef sprite is not available", Gdx.files.internal("../assets/Kenney-Game-Assets-2/2D assets/Topdown Shooter (620 assets)/PNG/Man Blue/manBlue_hold.png").exists());
    }

    @Test
    public void testBurgerSpritesExist(){
        assertTrue("if this fails, the cooked patty is not available", Gdx.files.internal("../assets/food/original/cooked_patty.png").exists());
        assertTrue("if this fails, the uncooked patty is not available", Gdx.files.internal("../assets/food/original/uncooked_patty.png").exists());
        assertTrue("if this fails the burnt patty is not available", Gdx.files.internal("../assets/food/original/burnt_patty.png").exists());

    }

    @Test
    public void testLettuceSpritesExist(){
        assertTrue("if this fails, the lettuce is not available", Gdx.files.internal("../assets/food/glitch/vegetable/lettuce.png").exists());
        assertTrue("if this fails, the chopped lettuce is not available", Gdx.files.internal("../assets/food/original/lettuce_chopped.png").exists());

    }

    public void testTomatoSpritesExist(){
        assertTrue("if this fails, the tomato is not available", Gdx.files.internal("../assets/food/glitch/fruit/tomato.png").exists());
        assertTrue("if this fails, the chopped tomato is not available", Gdx.files.internal("../assets/food/original/tomato_chopped.png").exists());


    }

    @Test
    public void testMiscIngredientSpritesExist(){
        assertTrue("if this fails, the bun is not available", Gdx.files.internal("../assets/food/glitch/misc/bun.png").exists());
        assertTrue("if this fails, the cheese does not exist", Gdx.files.internal("../assets/food/glitch/dairy/cheese_02.png").exists());

    }

    @Test
    public void testPotatoSpritesExist(){
        assertTrue("if this fails, the potato is not available", Gdx.files.internal("../assets/food/glitch/vegetable/potato.png").exists());
        assertTrue("if this fails, the jacket potato is not available", Gdx.files.internal("../assets/food/original/jacket_potato.png").exists());
        assertTrue("if this fails, the burnt jacket potato is not available", Gdx.files.internal("../assets/food/original/burnt_jacket_potato.png").exists());
    }

    @Test
    public void testPizzaSpritesExist(){
        assertTrue("if this fails, the cooked pizza base is not available", Gdx.files.internal("../assets/food/original/cooked_pizza_base.png").exists());
        assertTrue("if this fails, the uncooked pizza base is not available", Gdx.files.internal("../assets/food/original/uncooked_pizza_base.png").exists());
        assertTrue("if this fails, the burnt pizza base is not available", Gdx.files.internal("../assets/food/original/burnt_pizza_base.png").exists());

    }

    @Test
    public void testRecipeSpritesExist(){
        assertTrue("if this fails, the burger is not available", Gdx.files.internal("../assets/food/unknown/humborge.png").exists());
        assertTrue("if this fails, the salad is not available", Gdx.files.internal("../assets/food/glitch/misc/salad.png").exists());
        assertTrue("if this fails, the pizza is not available", Gdx.files.internal("../assets/food/glitch/misc/pizza_02.png").exists());
        assertTrue("if this fails, the cheesy jacket potato is not available", Gdx.files.internal("../assets/food/original/cheesy_jacket_potato.png").exists());
    }




}
