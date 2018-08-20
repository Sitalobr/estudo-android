package com.sitalobr.dev.ropasciliz_spock;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sitalobr.dev.ropasciliz_spock.entity.Option;
import com.sitalobr.dev.ropasciliz_spock.entity.ResultComparison;
import com.sitalobr.dev.ropasciliz_spock.service.GameService;

public class MainActivity extends AppCompatActivity {

    private GameService gameService;
    private ImageView appOptionImage;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.gameService = new GameService();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.appOptionImage = findViewById(R.id.imgAppOption);
        this.txtResult = findViewById(R.id.txtResult);
    }

    public void chooseRock(View view) {
        this.doTheMagic(Option.ROCK);
    }

    public void choosePaper(View view) {
        this.doTheMagic(Option.PAPER);
    }

    public void chooseScissors(View view) {
        this.doTheMagic(Option.SCISSORS);
    }

    public void chooseSpock(View view) {
        this.doTheMagic(Option.SPOCK);
    }

    public void chooseLizard(View view) {
        this.doTheMagic(Option.LIZARD);
    }

    private void doTheMagic(Option userOption) {
        Option appOption = this.gameService.randomlyChooseAppOption();

        this.setAppOptionImage(appOption);
        this.setTextResult(userOption, appOption);
    }

    private void setAppOptionImage(Option appOption) {
        switch (appOption) {
            case ROCK:
                this.appOptionImage.setImageResource(R.drawable.rock);
                break;
            case PAPER:
                this.appOptionImage.setImageResource(R.drawable.paper);
                break;
            case SCISSORS:
                this.appOptionImage.setImageResource(R.drawable.scissors);
                break;
            case SPOCK:
                this.appOptionImage.setImageResource(R.drawable.spock);
                break;
            case LIZARD:
                this.appOptionImage.setImageResource(R.drawable.lizard);
                break;
        }
    }

    private void setTextResult(Option userOption, Option appOption) {
        ResultComparison result = userOption.checkWinner(appOption);

        this.txtResult.setText(result.equals(ResultComparison.WIN) ? R.string.you_won :
                result.equals(ResultComparison.DRAW) ? R.string.its_a_draw : R.string.you_lose);
        this.txtResult.setTextColor(result.equals(ResultComparison.WIN) ?
                ContextCompat.getColor(this, R.color.colorSuccess) :
                result.equals(ResultComparison.DRAW) ? ContextCompat.getColor(this, R.color.colorPrimary) :
                        ContextCompat.getColor(this, R.color.colorDanger));
    }
}
