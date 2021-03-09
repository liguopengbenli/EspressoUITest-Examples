package com.codingwithmitch.espressouitestexamples.ui.movie

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.codingwithmitch.espressouitestexamples.R
import org.junit.Test

class MovieNavigationTest{

    @Test
    fun testMovieFragmentNavigation() {
        //SETUP
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //Nav DirectorsFragment
        onView(withId(R.id.movie_directiors)).perform(click())

        //verify
        onView(withId(R.id.fragment_movie_directors_parent)).check(matches(isDisplayed()))

        pressBack()

        onView(withId(R.id.fragment_movie_details_parent)).check(matches(isDisplayed()))

        onView(withId(R.id.movie_star_actors)).perform(click())

        onView(withId(R.id.fragment_movie_star_actors_parent)).check(matches(isDisplayed()))

    }


}