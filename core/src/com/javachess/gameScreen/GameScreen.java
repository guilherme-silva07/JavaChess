package com.javachess.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen {
    private BoardScreen chessBoardScreen;
    private LogScreen logScreen;

    public GameScreen(BoardScreen chessBoardScreen, LogScreen logScreen) {
        this.chessBoardScreen = chessBoardScreen;
        this.logScreen = logScreen;
    }

    @Override
    public void show() {
        // Configurações iniciais da tela do jogo
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Renderiza o tabuleiro de xadrez
        chessBoardScreen.render(delta);

        // Renderiza a tela de log
        logScreen.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        // Ajuste das dimensões da tela quando a janela é redimensionada
    }

    @Override
    public void pause() {
        // Lógica de pausa do jogo (se necessário)
    }

    @Override
    public void resume() {
        // Lógica de retomada do jogo (se necessário)
    }

    @Override
    public void hide() {
        // Lógica de ocultação da tela do jogo (se necessário)
    }

    @Override
    public void dispose() {
        // Liberação de recursos da tela do jogo
        chessBoardScreen.dispose();
        logScreen.dispose();
    }
}
