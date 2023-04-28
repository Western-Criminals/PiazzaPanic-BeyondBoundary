package cs.eng1.piazzapanic.food;

import com.badlogic.gdx.utils.Queue;
import cs.eng1.piazzapanic.food.recipes.*;
import cs.eng1.piazzapanic.screens.GameScreen;
import cs.eng1.piazzapanic.stations.RecipeStation;
import cs.eng1.piazzapanic.ui.UIOverlay;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CustomerManager {

  private final Queue<Recipe> customerOrders;
  private Recipe currentOrder;
  private final List<RecipeStation> recipeStations;
  private final UIOverlay overlay;
  public boolean isEndless;
  int recipeIndex;
  private Recipe[] possibleRecipes;

  public CustomerManager(UIOverlay overlay, boolean isEndless) {
    this.isEndless = isEndless;
    this.overlay = overlay;
    this.recipeStations = new LinkedList<>();
    customerOrders = new Queue<>();
  }

  /**
   * Reset the scenario to the default scenario.
   *
   * @param textureManager The manager of food textures that can be passed to the recipes
   */
  public void init(FoodTextureManager textureManager) {
    possibleRecipes = new Recipe[]{new Humborge(textureManager), new Salad(textureManager), new JacketPotato(textureManager), new Pizza(textureManager)};
    // Salad, Burger, Burger, Salad, Burger. This can be replaced by randomly selecting from
    // possibleRecipes or by using another scenario

    customerOrders.clear();
    if (!isEndless) {
      int[] recipeIndices = new int[5];
      for (int i = 0; i < 5; i++) {
        recipeIndices[i] = ThreadLocalRandom.current().nextInt(0, 4);
      }
      for (int recipeIndex : recipeIndices) {
        customerOrders.addLast(possibleRecipes[recipeIndex]);
      }
    } else {
      recipeIndex = ThreadLocalRandom.current().nextInt(0, 4);
      currentOrder = possibleRecipes[recipeIndex];
    }
  }

  /**
   * Check to see if the recipe matches the currently requested order.
   *
   * @param recipe The recipe to check against the current order.
   * @return a boolean signifying if the recipe is correct.
   */
  public boolean checkRecipe(Recipe recipe) {
    if (currentOrder == null) {
      return false;
    }
    return recipe.getType().equals(currentOrder.getType());
  }

  /**
   * Complete the current order nad move on to the next one. Then update the UI. If all the recipes
   * are completed, then show the winning UI.
   */
  public void nextRecipe() {
    if (!isEndless) {
      if (customerOrders.isEmpty()) {
        currentOrder = null;
        overlay.updateRecipeCounter(0);
      } else {
        overlay.updateRecipeCounter(customerOrders.size);
        currentOrder = customerOrders.removeFirst();
      }
    } else {
      recipeIndex = ThreadLocalRandom.current().nextInt(0, 4);
      currentOrder = possibleRecipes[recipeIndex];
    }
    notifyRecipeStations();
    overlay.updateRecipeUI(currentOrder);
    if (!GameScreen.isFirstFrame) {
      overlay.updateRep();
    }
    if (currentOrder == null) {
      overlay.finishGameUI();
    }
  }

  /**
   * If one recipe station has been updated, let all the other ones know that there is a new recipe
   * to be built.
   */
  private void notifyRecipeStations() {
    for (RecipeStation recipeStation : recipeStations) {
      recipeStation.updateOrderActions();
    }
  }

  public void addRecipeStation(RecipeStation station) {
    recipeStations.add(station);
  }
}
