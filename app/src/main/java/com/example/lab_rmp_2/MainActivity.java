package com.example.lab_rmp_2;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends BaseActivity implements MainFragment.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Если приложение только запущено, добавляем MainFragment в контейнер
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, new MainFragment())
                    .commit();
        }
    }

    // Обработка нажатия кнопки для открытия новой активити
    @Override
    public void onFirstButtonClicked() {
        Intent intent = new Intent(this, SecondActivity.class);
        // Флаги позволяют корректно управлять стэком активити при переходе к новому экрану
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    // Обработка нажатия кнопки для замены фрагмента
    @Override
    public void onSecondButtonClicked() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new DetailFragment());
        transaction.addToBackStack(null); // Добавляем транзакцию в back stack для обработки кнопки «назад»
        transaction.commit();
    }
}
