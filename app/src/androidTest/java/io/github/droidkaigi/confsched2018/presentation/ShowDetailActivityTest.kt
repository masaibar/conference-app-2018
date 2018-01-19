package io.github.droidkaigi.confsched2018.presentation


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import io.github.droidkaigi.confsched2018.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

@RunWith(AndroidJUnit4::class)
class ShowDetailActivityTest {

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun showDetailActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(TimeUnit.SECONDS.toMillis(10))

        val recyclerView = onView(
                allOf(
                        withId(R.id.sessions_recycler),
                        isDescendantOfA(withId(R.id.sessions_view_pager)),
                        isDisplayed()
                )
        )
        recyclerView.check(matches(isDisplayed()))
        recyclerView.perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(TimeUnit.SECONDS.toMillis(10))
        onView(
                allOf(
                        withId(R.id.session_title),
                        withText("Kotlinアンチパターン")
                )
        ).check(matches(isDisplayed()))

    }

}
