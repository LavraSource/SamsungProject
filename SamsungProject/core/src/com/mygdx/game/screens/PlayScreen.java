package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.scenes.GameHUD;

public class PlayScreen implements Screen {
    private MyGdxGame game;
    Texture texture;
    private OrthographicCamera gameCamera;
    private Viewport gamePort;
    private GameHUD hud;
    
    public PlayScreen(MyGdxGame game) {
        this.game = game;
        hud = new GameHUD(game.batch);
        texture = new Texture("grass.png");
        gameCamera = new OrthographicCamera();
        gamePort = new ScreenViewport(gameCamera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        // Fills the empty space with white color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
