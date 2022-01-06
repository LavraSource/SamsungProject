package com.mygdx.game.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.awt.*;

public class GameHUD {
    public Stage stage;
    private Viewport viewport;

    private Integer gold, wood, turn, manPower;
    Label goldLabel, woodLabel, turnLabel, manPowerLabel;

    @SuppressWarnings("DefaultLocale")
    public GameHUD(SpriteBatch sb) {
        turn = 1;
        gold = 12;
        wood = 12;
        manPower = 12;

        // New viewport needed to display the UI
        viewport = new ScreenViewport(new OrthographicCamera());
        // Stage manages the hierarchy of players
        stage = new Stage(viewport, sb);
        // UI organisation
        Table table = new Table();
        table.top();
        table.setFillParent(true);

        goldLabel = new Label(String.format("%d", gold),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        woodLabel = new Label(String.format("%d", wood),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        manPowerLabel =  new Label(String.format("%d", manPower),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        turnLabel = new Label(String.format("%d", turn),
                new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        // Expand X helps to organise the elements to take the whole width of the screen,
        // By dividing screenX on 4 sectors for each element in a table row
        table.add(new Label("TURN",
                new Label.LabelStyle(new BitmapFont(), Color.WHITE)
        )).expandX().padTop(10);

        table.add(new Label("GOLD",
                new Label.LabelStyle(new BitmapFont(), Color.WHITE)
        )).expandX().padTop(10);

        table.add(new Label("WOOD",
                new Label.LabelStyle(new BitmapFont(), Color.WHITE)
        )).expandX().padTop(10);

        table.add(new Label("MANPOWER",
                new Label.LabelStyle(new BitmapFont(), Color.WHITE)
        )).expandX().padTop(10);

        table.row();

        table.add(turnLabel).expandX();
        table.add(goldLabel).expandX();
        table.add(woodLabel).expandX();
        table.add(manPowerLabel).expandX();

        stage.addActor(table);
    }
}
