package com.github.nervzz.bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intending;
import static androidx.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void mainGoButtonCreatesAnIntentForGreetingActivity() {
        String k = "name";
        String v = "Test";

        Intents.init();
        onView(withId(R.id.mainName)).perform(typeText(v));
        onView(withId(R.id.mainGoButton)).perform(click());

        ActivityResult res = new ActivityResult(Activity.RESULT_OK, new Intent().putExtra(k, v));
        intending(toPackage(GreetingActivity.class.getName())).respondWith(res);
        Intents.release();
    }
}
