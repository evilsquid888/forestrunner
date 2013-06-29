package com.squid.junglerunner.scenes;

import org.cocos2d.layers.CCScene;

import com.squid.junglerunner.common.Game;
import com.squid.junglerunner.layers.GameOverLayer;
import com.squid.junglerunner.layers.GameOverMenuLayer;
import com.squid.junglerunner.layers.GameOverStarLayer;

public class GameOverScene extends CCScene {

	public static GameOverScene scene() {
		return new GameOverScene();
	}

	private GameOverScene() {
		super();
		long score = Game.isWin ? Game.score : 0;
		addChild(new GameOverLayer(score));
		addChild(new GameOverStarLayer(score));
		addChild(new GameOverMenuLayer());
	}

}
