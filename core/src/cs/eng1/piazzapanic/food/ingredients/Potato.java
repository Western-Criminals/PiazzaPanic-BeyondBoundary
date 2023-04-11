package cs.eng1.piazzapanic.food.ingredients;

import com.badlogic.gdx.graphics.Texture;
import cs.eng1.piazzapanic.food.FoodTextureManager;

public class Potato extends Ingredient {

  public Potato(FoodTextureManager textureManager) {
    super("potato", textureManager);
  }

  @Override
  public Texture getTexture() {
    String name = getType() + "_";
    if (isBurnt) {
      name += "burnt";
    } else if (isCooked) {
      name += "cooked";
    } else {
      name += "raw";
    }
    return textureManager.getTexture(name);
  }
}
