package com.example.rock_paper_scissors;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;

import com.example.rock_paper_scissors.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.paperBtn.setOnClickListener(v -> game("보"));
        binding.rockBtn.setOnClickListener(v -> game("바위"));
        binding.scissorsBtn.setOnClickListener(v -> game("가위"));

    }

    private void game(String yourChoice) {
        int ai = random.nextInt(3);
        String aiChoice;

        switch (ai) {
            case 0:
                aiChoice = "가위";
                break;
            case 1:
                aiChoice = "바위";
                break;
            default:
                aiChoice = "보";
        }

        binding.textAI.setText("AI가 " + aiChoice + "를 냈습니다.");
        binding.textYou.setText("당신은 " + yourChoice + "를 냈습니다.");

        String result;

        if (aiChoice.equals(yourChoice)) {
            result = "비겼습니다! :/";
        } else if ((aiChoice.equals("가위") && yourChoice.equals("바위")) || (aiChoice.equals("바위") && yourChoice.equals("보")) || (aiChoice.equals("보") && aiChoice.equals("가위"))) {
            result = "축하합니다! :) 당신은 이겼습니다";
        } else {
            result = "미안합니다 :( 당신은 졌습니다";
        }
        binding.textResult.setText(result);
    }
}