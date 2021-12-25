package com.example.pedrapapeletesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectStone(View view)
    {
        selectedOption("stone");
    }

    public void selectPaper(View view)
    {
        selectedOption("paper");
    }

    public void selectScissors(View view)
    {
        selectedOption("scissors");
    }

    private void selectedOption(String choice)
    {
        String[] choices = {
            "stone",
            "paper",
            "scissors"
        };
        int choiceAppInt = new Random().nextInt(choices.length);
        String choiceApp = choices[choiceAppInt];
        setImage(choiceApp);
        setMessageWinner(choice, choiceApp);
    }

    private void setImage(String choiceApp)
    {
        ImageView imageView = findViewById(R.id.imageChoiceApp);
        switch (choiceApp){
            case "stone":
                imageView.setImageResource(R.drawable.pedra);
                break;
            case "paper":
                imageView.setImageResource(R.drawable.papel);
                break;
            case "scissors":
                imageView.setImageResource(R.drawable.tesoura);
                break;
        }
    }

    private void setMessageWinner(String choice, String choiceApp)
    {
        TextView text = findViewById(R.id.textWinOrLose);
        if((choice.equals("stone") && choiceApp.equals("paper")) ||
           (choice.equals("paper") && choiceApp.equals("scissors")) ||
           (choice.equals("scissors") && choiceApp.equals("stone")))
        {
            text.setText("Você perdeu :(");
        }
        else if((choice.equals("paper") && choiceApp.equals("stone")) ||
                (choice.equals("scissors") && choiceApp.equals("paper")) ||
                (choice.equals("stone") && choiceApp.equals("scissors")))
        {
            text.setText("Você venceu :)");
        }
        else
        {
            text.setText("Empate :|");
        }
    }
}