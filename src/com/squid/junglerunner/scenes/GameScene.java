package com.squid.junglerunner.scenes;

import org.cocos2d.layers.CCScene;

import com.squid.junglerunner.common.Game;
import com.squid.junglerunner.common.Levels;
import com.squid.junglerunner.common.Logger;
import com.squid.junglerunner.layers.GameLayer;

public class GameScene extends CCScene {
	private static final String TAG = "GameScene";

	public static GameScene scene(int level) {
		Logger.d(TAG, "create game scene...");
		Game.init();
		return new GameScene(level);
	}

	private GameScene(int level) {
		super();
		GameLayer gameLayer = new GameLayer(Levels.getLevelDataPath(level));
		Game.delegate = gameLayer;
		addChild(gameLayer);
	}

}
