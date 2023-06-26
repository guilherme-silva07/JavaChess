package com.javachess.board;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.javachess.gameScreen.BoardScreen;
import com.javachess.gameScreen.GameScreen;
import com.javachess.gameScreen.LogScreen;

public class JavaChess extends Game {
	private GameScreen gameScreen;
	private BoardScreen boardScreen;
	private LogScreen logScreen;
	private Viewport boardViewport;
	private Viewport logViewport;

	@Override
	public void create() {
		float screenWidth = Gdx.graphics.getWidth();
		float screenHeight = Gdx.graphics.getHeight();

		boardViewport = new FitViewport(screenWidth - 800, screenHeight, new OrthographicCamera());
		logViewport = new FitViewport(800, screenHeight, new OrthographicCamera());

		boardScreen = new BoardScreen(boardViewport);
		logScreen = new LogScreen(logViewport);

		setScreen(new GameScreen(boardScreen, logScreen));
	}

	@Override
	public void render() {
		super.resize(800, 800);
	}
}
