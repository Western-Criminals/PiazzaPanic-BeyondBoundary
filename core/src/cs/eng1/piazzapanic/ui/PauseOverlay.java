package cs.eng1.piazzapanic.ui;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import cs.eng1.piazzapanic.PiazzaPanicGame;
import cs.eng1.piazzapanic.screens.HomeScreen;
import cs.eng1.piazzapanic.ui.ButtonManager.ButtonColour;
import cs.eng1.piazzapanic.ui.UIOverlay;

public class PauseOverlay {

  private final Stage uiStage;
  private final Table table;
  private static UIOverlay uiOverlay = null;
  PiazzaPanicGame game;


  public PauseOverlay(final PiazzaPanicGame game) {
    this.game = game;
    table = new Table();
    table.setFillParent(true);
    table.setVisible(false);
    table.center();
    Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
    bgPixmap.setColor(new Color(0,0,1,0.3f));
    bgPixmap.fill();
    TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(
        new Texture(bgPixmap));
    table.setBackground(textureRegionDrawableBg);
    ScreenViewport uiViewport = new ScreenViewport();
    uiStage = new Stage(uiViewport);
    uiOverlay = new UIOverlay(uiStage, game);

    Label paused = new Label("Paused",
            new Label.LabelStyle(game.getFontManager().getTitleFont(), null));

    TextButton resumeButton = game.getButtonManager()
        .createTextButton("Resume", ButtonColour.GREY);
    resumeButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        //uiOverlay.startTimer();
        hide();
      }
    });

    TextButton homeButton = game.getButtonManager()
            .createTextButton("Back to home screen", ButtonColour.RED);
    homeButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        hide();
        game.loadHomeScreen();
      }
    });

    table.add(paused);
    table.row();
    table.add(homeButton).padTop(20f);
    table.row();
    table.add(resumeButton).padTop(20f);
  }


  public void addToStage(Stage uiStage) {
    uiStage.addActor(table);
  }

  public void show() {
    table.setVisible(true);
  }

  public void hide() {
    table.setVisible(false);
  }
}
