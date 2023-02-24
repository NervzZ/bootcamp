package com.github.nervzz.bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {

    @Test
    public void greeTingTextIsUpdatedAndDisplaysCorrectName() {
        String k = "name";
        String v = "Test";

        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra(k, v);

        try (ActivityScenario<GreetingActivity> activity = ActivityScenario.launch(intent)) {
            onView(withId(R.id.greetingMessage)).check(matches(withText(String.format(
                    "Hello %s !",
                    intent.getStringExtra(k)))));
        }
    }
}
