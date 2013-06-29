package com.squid.junglerunner.scenes;

import org.cocos2d.layers.CCScene;

import com.squid.junglerunner.layers.LevelSelectLayer;

public class LevelSelectScene extends CCScene {

	public static LevelSelectScene scene() {
		return new LevelSelectScene();
	}

	public LevelSelectScene() {
		super();
		addChild(new LevelSelectLayer());
	}

}
