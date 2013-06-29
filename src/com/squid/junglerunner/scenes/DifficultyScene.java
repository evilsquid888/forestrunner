package com.squid.junglerunner.scenes;

import org.cocos2d.layers.CCScene;

import com.squid.junglerunner.layers.DifficultyLayer;


public class DifficultyScene extends CCScene {
	
	public static DifficultyScene scene() {
		return new DifficultyScene();
	}

	public DifficultyScene() {
		super();
		addChild(new DifficultyLayer());
	}

}
