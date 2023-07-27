package cs.eng1.piazzapanic.ui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import cs.eng1.piazzapanic.screens.HomeScreen;
import cs.eng1.piazzapanic.ui.ButtonManager.ButtonColour;
import cs.eng1.piazzapanic.PiazzaPanicGame;
import cs.eng1.piazzapanic.ui.Save;

public class CertainOverlay {
    private final Table table = new Table();
    PiazzaPanicGame game;
    public CertainOverlay(final PiazzaPanicGame game) {
        this.game = game;
        table.setFillParent(true);
        table.setVisible(false);
        table.center();
        Pixmap bgPixmap = new Pixmap(1, 1, Pixmap.Format.RGB565);
        bgPixmap.setColor(Color.DARK_GRAY);
        bgPixmap.fill();
        TextureRegionDrawable textureRegionDrawableBg = new TextureRegionDrawable(
                new Texture(bgPixmap));
        table.setBackground(textureRegionDrawableBg);

        Label warning = new Label("Warning! Save file is missing. Create a new one?",
                new Label.LabelStyle(game.getFontManager().getTitleFont(), null));

        TextButton yesButton = game.getButtonManager()
                .createTextButton("Yes", ButtonColour.GREEN);
        yesButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hide();
                try {
                    Save.createSave("save.json");
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
                HomeScreen.showPlayOverlay();
            }
        });

        TextButton noButton = game.getButtonManager()
                .createTextButton("No", ButtonColour.GREY);
        noButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                hide();
                HomeScreen.showPlayOverlay();
            }
        });

        table.add();
        table.add(warning).padBottom(20f);
        table.row();
        table.add(yesButton);
        table.add(noButton);
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
