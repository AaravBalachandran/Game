package com.firstgame.game.scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.firstgame.game.TankStars;

public class topbar {
    public Stage stage;
    private Viewport viewport;

    public topbar(SpriteBatch batch){
        viewport = new FitViewport(TankStars.gameWidth,TankStars.gameHeight, new OrthographicCamera());
        stage = new Stage(viewport,batch);

        Table table = new Table();
        table.top();
        stage.addActor(table);
    }
}
