package cs.eng1.piazzapanic.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import cs.eng1.piazzapanic.stations.Station;

/**
 * A UI element that displays a growing flame texture to indicate an item in the cooking station is burning.
 */
public class BurningUI extends Table {
  private final Station station;
  private final ProgressBar progress;


  public BurningUI(final Station station) {
    this.station = station;
    setVisible(false);
    center();
    bottom();

    ProgressBarStyle progressBarStyle = new ProgressBarStyle(new TextureRegionDrawable(new Texture(
        Gdx.files.internal(
            "food/original/clear.png"))), null);
    progressBarStyle.knobBefore = new TextureRegionDrawable(new Texture(Gdx.files.internal(
      "food/original/fire.png")));
    progress = new ProgressBar(0, 100, 0.1f, true, progressBarStyle);
  }

  /**
   * Initialise and show the flame texture with 0 progress.
   */
  public void showProgressBar() {
    progress.setValue(0);
    add(progress).height(UIOverlay.scale);
    setVisible(true);
  }

  /**
   * @param percentage A value between 0 and 100 representing the percentage completed
   */
  public void updateProgress(float percentage) {
    progress.setValue(percentage);
  }

  public void hideProgressBar() {
    clear();
  }

  @Override
  public void draw(Batch batch, float parentAlpha) {
    Vector3 worldPosition = new Vector3();
    worldPosition.x = station.getX() + station.getWidth() / 2f;
    worldPosition.y = station.getY() + 0.2f;
    Vector3 screenPosition = station.getStage().getCamera().project(worldPosition);
    setPosition(screenPosition.x, screenPosition.y);
    super.draw(batch, parentAlpha);
  }
}
