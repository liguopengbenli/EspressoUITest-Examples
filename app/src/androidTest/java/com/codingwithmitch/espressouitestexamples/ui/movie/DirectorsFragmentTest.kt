package com.codingwithmitch.espressouitestexamples.ui.movie

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.codingwithmitch.espressouitestexamples.R
import com.codingwithmitch.espressouitestexamples.factory.MovieFragmentFactory
import kotlinx.android.synthetic.main.fragment_directors.view.*
import org.junit.Assert.*
import org.junit.Test

class DirectorsFragmentTest{


    @Test
    fun test_isDirectorsListVisible(){
        //SETUP
        val directors = arrayListOf<String>("R.J. Steward", "James Vanderbilt")
        val fragmentFactory = MovieFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_directors", directors)

        val scenario = launchFragmentInContainer<DirectorsFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        onView(withId(R.id.directors_text))
            .check(matches(withText(
                DirectorsFragment.stringBuilderForDirectors(directors)
            )))
    }


}