package com.timkontrakan.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4ClassRunner::class)
    class MainActivityTest{

        @Test
        fun tes_navSecondaryActivity() {

            val activityScenario = ActivityScenario.launch(MainActivity::class.java)
            onView(withId(R.id.button_next_activity)).perform(click())
            onView(withId(R.id.secondary)).check(matches(isDisplayed()))
        }

        @Test
        fun test_backPress_toMainActivity() {

            val activityScenario = ActivityScenario.launch(MainActivity::class.java)
            onView(withId(R.id.button_next_activity)).perform(click())
            onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    //        onView(withId(R.id.button_back)).perform(click()) // Method 1
            pressBack() // Method 2
            onView(withId(R.id.main)).check(matches(isDisplayed()))
        }
    }