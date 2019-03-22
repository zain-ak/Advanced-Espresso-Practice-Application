package android.learning.advancedespressopracticeapplication

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.matcher.ComponentNameMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith (AndroidJUnit4::class)
class MainActivityTest {
    @Rule @JvmField
    var activityTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun punnyLaunchActivity() {
        onView(withId(R.id.button_punny))
            .perform(click())

        onView(withId(R.id.theme))
            .check(matches(withText(R.string.theme_punny)))
    }

    @Test
    fun punnyIntended() {
        onView(withId(R.id.button_punny))
            .perform(click())

        val context = InstrumentationRegistry.getTargetContext()
        val theme = context.getString(R.string.theme_punny)
        Intents.intended(hasExtra(IdeasActivity.KEY_THEME, theme))
        Intents.intended(
            hasComponent(
                ComponentNameMatchers
                    .hasClassName("android.learning.advancedespressopracticeapplication.IdeasActivity")
            )
        )

//        Intents.intended(anyIntent())
    }

    fun anyIntent(): Matcher<Intent> {
        return object : TypeSafeMatcher<Intent>() {
            override fun describeTo(description: Description) {
                description.appendText("any intent")
            }

            public override fun matchesSafely(intent: Intent): Boolean {
                return true
            }
        }
    }

    @Test
    fun punnyIntending() {
        val name = "Catalie Portman"

        //Creating an intent that returns the correct result in val result for the test function to confirm with
        val intent = Intent()
        intent.putExtra(IdeasActivity.KEY_NAME, name)
        val result = Instrumentation.ActivityResult(Activity.RESULT_OK, intent)

        //Creating a context as usual and proceeding to use intending() and comparing the return with result above
        val context = InstrumentationRegistry.getTargetContext()
        val theme = context.getString(R.string.theme_punny)
        Intents.intending(hasExtra(IdeasActivity.KEY_THEME, theme)).respondWith(result)

        onView(withId(R.id.button_punny))
            .perform(click())
        onView(withId(R.id.edit_name))
            .check(matches(withText(name)))

    }
}