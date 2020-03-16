package com.timkontrakan.myapplication

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern.matches

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun testActivity_inView() {

        onView(withId(R.id.secondary))
            .check(matches(isDisplayed()))

        // Notice this does not effect the next test
        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    // Visibility
    @Test
    fun testVisibility_title_nextButton() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(isDisplayed()))

        onView(withId(R.id.button_back))
            .check(matches(isDisplayed()))
    }

    // Text
    @Test
    fun testTitleTextDisplayed() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(withText(R.string.secondary)))
    }
}