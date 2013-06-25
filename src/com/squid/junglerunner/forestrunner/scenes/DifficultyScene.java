package com.squid.junglerunner.forestrunner.scenes;

import org.cocos2d.layers.CCScene;

import com.squid.junglerunner.forestrunner.layers.DifficultyLayer;


public class DifficultyScene extends CCScene {
	
	public static DifficultyScene scene() {
		return new DifficultyScene();
	}

	public DifficultyScene() {
		super();
		addChild(new DifficultyLayer());
	}

}
