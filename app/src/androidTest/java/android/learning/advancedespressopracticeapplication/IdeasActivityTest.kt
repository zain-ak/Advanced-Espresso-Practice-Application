package android.learning.advancedespressopracticeapplication

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class IdeasActivityTest {
    @Rule @JvmField
    //var activityRule = ActivityTestRule(IdeasActivity::class.java) used when launching activity directly

    //The below activity Rule is used for passing in intents, it has two additional parameters
    var activityRule = ActivityTestRule(IdeasActivity::class.java, true, false)

    @Test
    fun noTheme() {
        activityRule.launchActivity(null) //has to be explicitly called since launchActivty == false, above.
        onView(withId(R.id.theme))
            .check(matches(withText(R.string.missing_theme)))
    }

    @Test
    fun punny() {
        val intent = Intent()
        intent.putExtra(IdeasActivity.KEY_THEME, "Punny")
        activityRule.launchActivity(intent)
        onView(withId(R.id.theme))
            .check(matches(withText(R.string.theme_punny)))

    }

    @Test
    fun popular() {
        val intent = Intent()
        intent.putExtra(IdeasActivity.KEY_THEME, "Popular")
        activityRule.launchActivity(intent)
        onView(withId(R.id.theme))
            .check(matches(withText(R.string.theme_popular)))

    }

    @Test
    fun famous() {
        val intent = Intent()
        intent.putExtra(IdeasActivity.KEY_THEME, "Famous")
        activityRule.launchActivity(intent)
        onView(withId(R.id.theme))
            .check(matches(withText(R.string.theme_famous)))

    }


}