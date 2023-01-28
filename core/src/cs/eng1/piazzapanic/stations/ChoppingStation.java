package cs.eng1.piazzapanic.stations;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.TimeUtils;
import cs.eng1.piazzapanic.ingredients.Ingredient;
import cs.eng1.piazzapanic.ui.StationActionUI;
import cs.eng1.piazzapanic.ui.StationUIController;

import java.util.LinkedList;
import java.util.List;

public class ChoppingStation extends Station {

  protected Ingredient[] validIngredients;
  protected Ingredient currentIngredient = null;
  protected float timeChopped;
  protected float totalTimeToChop = 5f;
  private boolean progressVisible = false;

  public ChoppingStation(int id, TextureRegion image, StationUIController uiController,
      StationActionUI.ActionAlignment alignment, Ingredient[] ingredients) {
    super(id, image, uiController, alignment);
    validIngredients = ingredients; //A list of the ingredients that can be used by this station.
  }

  @Override
  public void act(float delta) {
    //TODO: add time related things here!
    if (inUse) {
      timeChopped += delta;
      uiController.updateProgressValue(this, (timeChopped / totalTimeToChop) * 100f);
      if (timeChopped >= totalTimeToChop && progressVisible) {
        currentIngredient.setIsChopped(true);
        uiController.hideProgressBar(this);
        uiController.showActions(this, getActionTypes());
        progressVisible = false;
        nearbyChef.setPaused(false);
      }
    }
    super.act(delta);
  }

  private boolean isCorrectIngredient(Ingredient ingredientToCheck) {
    if (!ingredientToCheck.getIsChopped()) {
      for (Ingredient item : this.validIngredients) {
        if (ingredientToCheck.getType() == item.getType()) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public List<StationAction.ActionType> getActionTypes() {
    LinkedList<StationAction.ActionType> actionTypes = new LinkedList<>();
    if (nearbyChef == null) {
      return actionTypes;
    }
    if (currentIngredient == null) {
      if (isCorrectIngredient(nearbyChef.getStack().peek())) {
        actionTypes.add(StationAction.ActionType.PLACE_INGREDIENT);
      }
    } else {
      if (currentIngredient.getIsChopped()) {
        actionTypes.add(StationAction.ActionType.GRAB_INGREDIENT);
      }
      if (!inUse) {
        actionTypes.add(StationAction.ActionType.CHOP_ACTION);
      }
    }
    return actionTypes;
  }

  @Override
  public void doStationAction(StationAction.ActionType action) {
    switch (action) {
      case CHOP_ACTION:
        timeChopped = 0;
        inUse = true;
        uiController.hideActions(this);
        uiController.showProgressBar(this);
        nearbyChef.setPaused(true);
        progressVisible = true;
        break;

      case PLACE_INGREDIENT:
        if (this.nearbyChef != null && nearbyChef.hasIngredient() && currentIngredient == null) {
          if ((this.isCorrectIngredient(nearbyChef.getStack().peek()))) {
            currentIngredient = nearbyChef.placeIngredient();
          }
        }
        uiController.showActions(this, getActionTypes());
        break;

      case GRAB_INGREDIENT:
        if (this.nearbyChef != null && nearbyChef.canGrabIngredient()
            && currentIngredient != null) {
          nearbyChef.grabIngredient(currentIngredient);
          currentIngredient = null;
          inUse = false;
        }
        uiController.showActions(this, getActionTypes());
        break;
    }
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {
    super.draw(batch, parentAlpha);
    if (currentIngredient != null) {
      drawIngredientTexture(batch, currentIngredient.getTexture());
    }
  }

}
