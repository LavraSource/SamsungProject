package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.scenes.GameHUD;

public class PlayScreen implements Screen {
    private MyGdxGame game;
    private OrthographicCamera gameCamera;
    private Viewport gamePort;
    private GameHUD hud;
    // Variables for managing the map
    private TmxMapLoader mapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    
    public PlayScreen(MyGdxGame game) {
        this.game = game;
        hud = new GameHUD(game.batch);
        gameCamera = new OrthographicCamera();
        gamePort = new ScreenViewport(gameCamera);

        mapLoader = new TmxMapLoader();
        map = mapLoader.load("test.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        gameCamera.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, 0);
    }

    public void handleInput(float deltaTime) {
        if(Gdx.input.isTouched())
            gameCamera.position.x += 100 * deltaTime;
    }

    // Update the game screen
    public void update(float deltaTime) {
        handleInput(deltaTime);
        gameCamera.update();
        renderer.setView(gameCamera);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        // Fills the empty space with white color
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.render();
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
