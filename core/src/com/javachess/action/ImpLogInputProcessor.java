package com.javachess.action;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import pieces.Piece;

public class ImpLogInputProcessor extends ChessInputProcessor{

    public ImpLogInputProcessor(OrthographicCamera camera,Piece[][] pieces) {
        super(camera,pieces);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        int getX, getY, pixX, pixY;
        if (Gdx.input.isTouched()) {
            getX = Gdx.input.getX() / 100;
            getY = Math.abs(Gdx.input.getY() / 100 - 7); // por algum motivo o y esta errado e esta invertido pois a posicao 0,0 deve ficar no canto inferior esquerdo
            pixY = getY * 100;
            pixX = getX * 100;

        }
        return false;
    }
}
