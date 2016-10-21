package com.softdesign.devintensive.ui.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.softdesign.devintensive.R;
import com.softdesign.devintensive.utils.ConstantManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG=ConstantManager.TAG_PREFIX + "Main Activity";

    protected EditText mEditText;
    protected Button mRedButton, mGreenButton;
    protected int mColorMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        mRedButton = (Button) findViewById(R.id.red_btn);
        mGreenButton = (Button) findViewById(R.id.green_btn);
        mEditText = (EditText) findViewById(R.id.editText);

        mRedButton.setOnClickListener(this);
        mGreenButton.setOnClickListener(this);

        if (savedInstanceState==null){
            // Активность запускается впервые
        } else {
            // Активность уже создавалась

            mColorMode = savedInstanceState.getInt(ConstantManager.COLOR_MODE_KEY);

            if (mColorMode == Color.RED) {
                mEditText.setBackgroundColor(Color.RED);
            } else if (mColorMode == Color.GREEN) {
                mEditText.setBackgroundColor(Color.GREEN);
            }
        }
    }

    /**
     *  метод вызвается при старте активности перед моментом того как UI станет доступен пользоватлелю
     *  как правило в данном методе происходит регитсрация подписки на события остановка которых была
     *  произведена в onStop()
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    /**
     * метод вызывается когда активность становится доступна пользователю для взаимодействия
     * в данном методе как правило происходит запуск анимаций/аудио/видео/запуск BroadcastReceiver
     * метод должен быть максимально легковесным для максимальной отзывчивости UI
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    /**
     * метод вызывается когда текущая активность теряет фокус но остается видимой (всплытие
     * диалогового окна/частичное перекрытие другой активностью/ и т.д.)
     *
     * в данном методе реализуют сохранение легковесных UI данных/анимаций/аудио/видео и т.д.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    /**
     * метод вызывается когда активности становится невидимым для пользователя.
     * в данном методе происходит отписка от событий, остановка сложных анимаций, сложные операции оп
     * сохранению данных/прерывание запущенных потоков/ и т.д.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    /**
     * метод вызывается при окончании работы активности (когда это происходит или после вызова
     * метода finish())
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * метод вызывается при рестарте активности/возобновлении работы после вызова метода onStop()
     * в данном методе реализуетя специфическая бизнес логика которая должна быть реализована именно
     * при рестарте активности - например запрос к серверу который необходимо вызывать при возвращении
     * из другой активности (обновление данных, подписка на определенное событие проинициализированное
     * на другом экране/специфическая бизнес логика завязанная именно на перезапуске активности)
     */
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.green_btn:
                mEditText.setBackgroundColor(Color.GREEN);
                mColorMode = Color.GREEN;
                break;
            case R.id.red_btn:
                mEditText.setBackgroundColor(Color.RED);
                mColorMode = Color.RED;
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "onSaveInstanceState");
        outState.putInt(ConstantManager.COLOR_MODE_KEY, mColorMode);

    }
}
