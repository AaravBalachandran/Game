package com.firstgame.game.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.firstgame.game.TankStars;

public class topbar {
    public Stage stage;
    private Viewport viewport;
    private Integer worldTimer;
    private float timecount;
    private Integer score;

    Label countdownLabeel;
    Label scoreLabel;
    Label timeLabel;
    Label  levelLabel;
    Label marioLabel;
    Label worldLabel;
    public topbar(SpriteBatch batch){
        viewport = new FitViewport(TankStars.gameWidth,TankStars.gameHeight, new OrthographicCamera());
        stage = new Stage(viewport,batch);

        countdownLabeel = new Label(String.format("%03d",worldTimer),new Label.LabelStyle(new BitmapFont(), Color.MAGENTA));
        scoreLabel = new Label(String.format("%06d",score),new Label.LabelStyle(new BitmapFont(), Color.MAGENTA));

        Table table = new Table();
        table.top();
        table.add().expandX().padTop(10);
        stage.addActor(table);
    }
}
