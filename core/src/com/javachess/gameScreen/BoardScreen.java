package com.javachess.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.javachess.action.ImpChessInputProcessor;
import com.javachess.board.CreatePieces;
import pieces.Piece;

public class BoardScreen implements Screen {
    private static final int GRID_SIZE = 8;
    private static final float CELL_SIZE = 100f;
    private Texture squad;
    //	private LogScreen logScreen; // criar uma tela extra onde vai ficar o log
    private OrthographicCamera camera;
    private SpriteBatch batch;
    LogScreen logScreen;
    private Piece [][]pieces;

    public BoardScreen(Viewport viewport) {
        //sobre a tela do jogo
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        //criação do tabuleiro em si
        squad = new Texture("squad.png");
        camera = new OrthographicCamera(screenWidth, screenHeight);
        camera.setToOrtho(false); // FAZER DOCUMENTAÇÂO

        CreatePieces create;
        create = new CreatePieces();
        pieces = create.createPiece();
        //criação das piecas
        create = new CreatePieces();
        pieces = create.createPiece();

        //onde eu instancio as ações do mouse
        Gdx.input.setInputProcessor(new ImpChessInputProcessor(camera, pieces));

        batch = new SpriteBatch();
    }

    @Override
    public void show() {
        // Configurações iniciais da tela do tabuleiro de xadrez
        Gdx.input.setInputProcessor(new ImpChessInputProcessor(camera,pieces));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                float x = col * 100;
                float y = row * 100;

                if ((row + col) % 2 == 0) {
                    batch.setColor(0.8f, 0.8f, 0.8f, 1f);
                } else {
                    batch.setColor(0.2f, 0.2f, 0.2f, 1f);
                }

                batch.draw(squad, x, y, 100, 100);

                if (pieces[row][col] != null) {
                    batch.draw(pieces[row][col].getFigure(), pieces[row][col].getPosX(), pieces[row][col].getPosY());
                }
            }
        }

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        // Ajuste das dimensões da tela quando a janela é redimensionada
    }

    @Override
    public void pause() {
        // Lógica de pausa do tabuleiro de xadrez (se necessário)
    }

    @Override
    public void resume() {
        // Lógica de retomada do tabuleiro de xadrez (se necessário)
    }

    @Override
    public void hide() {
        // Lógica de ocultação do tabuleiro de xadrez (se necessário)
    }

    @Override
    public void dispose() {
        // Liberação de recursos do tabuleiro de xadrez
        batch.dispose();
        squad.dispose();
    }
}
