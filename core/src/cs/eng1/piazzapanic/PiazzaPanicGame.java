package cs.eng1.piazzapanic;

import com.badlogic.gdx.Game;
import cs.eng1.piazzapanic.screens.GameScreen;
import cs.eng1.piazzapanic.screens.HomeScreen;
import cs.eng1.piazzapanic.ui.*;

public class PiazzaPanicGame extends Game {

  private FontManager fontManager;
  private ButtonManager buttonManager;
  private GameScreen gameScreen;
  private HomeScreen homeScreen;
  private TutorialOverlay tutorialOverlay;
  private SettingsOverlay settingsOverlay;
  private PauseOverlay pauseOverlay;
  private PlayOverlay playOverlay;
  private DifficultyOverlay difficultyOverlay;

  @Override
  public void create() {
    fontManager       = new FontManager();
    buttonManager     = new ButtonManager(fontManager);
    tutorialOverlay   = new TutorialOverlay(this);
    settingsOverlay   = new SettingsOverlay(this);
    pauseOverlay      = new PauseOverlay(this);
    playOverlay       = new PlayOverlay(this);
    difficultyOverlay = new DifficultyOverlay(this);
    loadHomeScreen();
  }

  @Override
  public void dispose() {
    if (gameScreen != null) {
      gameScreen.dispose();
    }
    if (homeScreen != null) {
      homeScreen.dispose();
    }
    fontManager.dispose();
    buttonManager.dispose();
  }

  public void loadHomeScreen() {
    if (homeScreen == null) {
      homeScreen = new HomeScreen(this);
    }
    setScreen(homeScreen);
  }

  public void loadGameScreen() {
    if (gameScreen == null) {
      gameScreen = new GameScreen(this);
    }
    setScreen(gameScreen);
  }

  public TutorialOverlay getTutorialOverlay() {
    return tutorialOverlay;
  }

  public SettingsOverlay getSettingsOverlay() {
    return settingsOverlay;
  }
  public PauseOverlay getPauseOverlay() {
    return pauseOverlay;
  }
  public PlayOverlay getPlayOverlay() {
    return playOverlay;
  }
  public DifficultyOverlay getDifficultyOverlay() {
    return difficultyOverlay;
  }
  public FontManager getFontManager() {
    return fontManager;
  }

  public ButtonManager getButtonManager() {
    return buttonManager;
  }
}
