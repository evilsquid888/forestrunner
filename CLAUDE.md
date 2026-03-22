# CLAUDE.md — ForestRunner

## Project Overview

ForestRunner (internally "JungleRunner") is a 2D side-scrolling runner game for Android, built with the **Cocos2d-Android** framework. The player runs through forest/jungle-themed levels, collecting items (cherries, bananas, flowers), avoiding obstacles (traps, fire, dinosaurs), and progressing through six levels at three difficulty settings (easy, normal, hard).

Package: `com.squid.junglerunner`

## Tech Stack

- **Language:** Java
- **Platform:** Android (minSdk 8)
- **Game Engine:** Cocos2d-Android (bundled as `cocos2d-android.jar` in `libs/`)
- **Ads:** Google AdMob SDK 4.0.4 (bundled jar)
- **Build System:** Gradle (legacy Android plugin `com.android.tools.build:gradle:0.4`)
- **Design docs:** UML diagrams (`.asta`), design docs in Chinese (`.pdf`, `.doc`, `.xls`)

## Project Structure

```
src/com/squid/junglerunner/
  JungleRunnerActivity.java    # Main game activity (sets up Cocos2d director + AdMob)
  SplashActivity.java          # Launcher / splash screen
  CustomAlertDialog.java       # Custom dialog component
  common/
    Constants.java             # Game constants (PTM ratio, level lengths, difficulties)
    Game.java                  # Game state singleton
    Levels.java                # Level definitions
    Logger.java                # Logging utility
  data/
    LevelData.java             # Level data model
    LevelDataParser.java       # Parses level files from assets/level/
    ParseStrategy.java         # Strategy interface for parsing
    TxtDataParseStrategy.java  # Text-based level data parser
  layers/
    GameLayer.java             # Main gameplay layer (physics, input, game loop)
    GameLevelBuilder.java      # Builds level from parsed data
    MenuLayer.java             # Main menu UI
    GameOverLayer.java         # Game over screen
    HighScoreLayer.java        # High scores display
    LevelSelectLayer.java      # Level selection UI
    DifficultyLayer.java       # Difficulty picker
    MainGameBackgroundLayer.java  # Parallax background
    MainGameMenuLayer.java     # In-game HUD/menu
    AbstractDialog.java        # Dialog base class
    AlertDialog.java           # Alert dialog
    DifficultyDialog.java      # Difficulty selection dialog
    GameDelegate.java          # Delegate interface for game events
  manager/
    GameManager.java           # Core game logic manager
    SceneManager.java          # Scene transitions
    SoundManager.java          # Audio playback (SFX + background music)
    LocalDataManager.java      # Local persistence (scores, progress)
  scenes/
    MainScene.java             # Main menu scene
    GameScene.java             # Gameplay scene
    GameOverScene.java         # Game over scene
    LevelSelectScene.java      # Level select scene
    DifficultyScene.java       # Difficulty scene
    HighScoreScene.java        # High score scene
  sprites/
    GameSprite.java            # Base sprite class
    Runner.java                # Player character
    Dinosaur.java, Fire.java, Trap.java  # Enemies/hazards
    Cherry.java, Banana.java, Flower.java, Life.java  # Collectibles
    Ground.java, Bridge.java, Stone.java  # Terrain
    Box.java, Cloud.java, Background.java  # Environment
    GoSign.java, StopSign.java  # Level markers
    SpriteType.java            # Sprite type enum
    LevelSelector.java         # Level selection sprite
assets/
  sprites.plist / sprites.png  # Sprite sheet atlas
  menu.plist / menu.png        # Menu sprite atlas
  level/                       # Level data files (text-based)
  font1.*, font2.*             # Bitmap fonts
  Decade.ttf                   # TrueType font
res/
  drawable/                    # UI images, 9-patch backgrounds
  layout/                      # XML layouts (splash screen)
  raw/                         # Sound effects and music (.ogg)
  values/                      # Strings, colors, styles, themes
libs/
  cocos2d-android.jar          # Cocos2d game engine
  GoogleAdMobAdsSdk-4.0.4.jar  # AdMob SDK
```

## Build & Run

This project uses a very old Gradle Android plugin (0.4). It will not build with modern Android Gradle Plugin or current Android Studio without migration work.

```bash
# Legacy build (requires Gradle ~1.6 and Android SDK with build-tools 17):
gradle build

# Install on connected device:
gradle installDebug
```

**Note:** The `build.gradle` contains hardcoded signing config paths and passwords that reference a specific developer machine. These would need updating for any new build environment.

## Key Architecture Notes

- **Cocos2d scene graph:** The game follows the standard Cocos2d pattern of Director -> Scene -> Layer -> Sprite hierarchy. `SceneManager` handles transitions between scenes.
- **Physics:** Uses Box2D via Cocos2d's integration. The `PTM_RATIO` (32 pixels per meter) is defined in `Constants.java`.
- **Level data:** Levels are defined as text files in `assets/level/`, parsed by `LevelDataParser` using a strategy pattern (`ParseStrategy` / `TxtDataParseStrategy`).
- **Game loop:** `GameLayer` is the core gameplay layer handling physics updates, collision detection, sprite management, and user input.
- **Manager pattern:** Managers (`GameManager`, `SceneManager`, `SoundManager`, `LocalDataManager`) centralize game logic, scene transitions, audio, and local storage respectively.
- **Landscape only:** The app is locked to landscape orientation in `AndroidManifest.xml`.

## Coding Conventions

- Java with Android/Cocos2d conventions
- Packages organized by architectural role: `scenes`, `layers`, `sprites`, `manager`, `data`, `common`
- Tab indentation
- `TAG` constant pattern for Android logging
- Constants collected in the `Constants` interface
- No unit tests present in the repository

## Level Design

Six levels of increasing length (30000 to 75000 units), three difficulty modes. Level geometry is defined in text data files under `assets/level/`.
