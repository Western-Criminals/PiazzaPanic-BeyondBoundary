package cs.eng1.piazzapanic.ui;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import cs.eng1.piazzapanic.PiazzaPanicGame;
import cs.eng1.piazzapanic.ui.ButtonManager.ButtonColour;

import static cs.eng1.piazzapanic.screens.GameScreen.uiOverlay;

public class PlayOverlay {

  private final Table table;
  PiazzaPanicGame game;


  public PlayOverlay(final PiazzaPanicGame game) {
    this.game = game;
    table = new Table();
    table.setFillParent(true);
    table.setVisible(false);
    table.center();
    Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
    bgPixmap.setColor(Color.DARK_GRAY);
    bgPixmap.fill();
    TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(
        new Texture(bgPixmap));
    table.setBackground(textureRegionDrawableBg);

    TextButton backButton = game.getButtonManager()
        .createTextButton("Back", ButtonColour.GREY);
    backButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        hide();
      }
    });

    Label play = new Label("Play",
            new Label.LabelStyle(game.getFontManager().getTitleFont(), null));

    TextButton easyButton = game.getButtonManager()
            .createTextButton("Easy", ButtonColour.GREEN);
    easyButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        hide();
        game.loadGameScreen();
        uiOverlay.updatePatience(0);
      }
    });

    TextButton mediumButton = game.getButtonManager()
            .createTextButton("Medium", ButtonColour.YELLOW);
    mediumButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        hide();
        game.loadGameScreen();
        uiOverlay.updatePatience(1);
      }
    });

    TextButton hardButton = game.getButtonManager()
            .createTextButton("Hard", ButtonColour.RED);
    hardButton.addListener(new ClickListener() {
      @Override
      public void clicked(InputEvent event, float x, float y) {
        hide();
        game.loadGameScreen();
        uiOverlay.updatePatience(2);
      }
    });
    table.add();
    table.add(play).padBottom(20f);
    table.row();
    table.add(easyButton);
    table.add(mediumButton);
    table.add(hardButton);
    table.row();
    table.add();
    table.add(backButton).padTop(60f);
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
