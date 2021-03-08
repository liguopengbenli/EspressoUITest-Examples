package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.data.DummyMovies.THE_RUNDOWN
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory
import kotlinx.android.synthetic.main.fragment_movie_detail.view.*
import org.junit.Assert.*
import org.junit.Test

class MovieDetailFragmentTest{

    @Test
    fun test_isMovieDataVisible() {
        val movie = THE_RUNDOWN;
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("movie_id", movie.id);

        val scenario = launchFragmentInContainer<MovieDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )
        onView(withId(R.id.movie_title)).check(matches(withText(movie.title)))
        onView(withId(R.id.movie_description)).check(matches(withText(movie.description)))
    }





}