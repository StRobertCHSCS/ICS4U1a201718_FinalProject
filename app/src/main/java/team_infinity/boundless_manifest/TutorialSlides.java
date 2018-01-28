package team_infinity.boundless_manifest;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro2;

/**
 * Created by Vallyath on 2018-01-28.
 */

public class TutorialSlides extends AppIntro2 {

    android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        addSlide(SampleSlide.newInstance(R.layout.tutorial_slide1));
        addSlide(SampleSlide.newInstance(R.layout.tutorial_slide2));
        addSlide(SampleSlide.newInstance(R.layout.tutorial_slide3));
    }

    @Override
    public void onSkipPressed(Fragment fragment){
        ContinueQuest continueQ = new ContinueQuest();
        continueQ.show(fm, "First Pop-up");
    }

    @Override
    public void onDonePressed(Fragment fragment){
        finish();
    }
}
