package by.mrkip.apps.epamandroidtraining;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class UserRegActivityTest {

	@Rule
	public ActivityTestRule<UserRegActivity> mActivityTestRule = new ActivityTestRule<>(UserRegActivity.class);

	@Test
	public void userRegActivityTest() {
		ViewInteraction textView = onView(
				allOf(withId(R.id.tv_name), withText(R.string.ur_user_name),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								0),
						isDisplayed()));
		textView.check(matches(isDisplayed()));

		ViewInteraction editText = onView(
				allOf(withId(R.id.et_name),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								1),
						isDisplayed()));
		editText.check(matches(isDisplayed()));

		ViewInteraction button = onView(
				allOf(withId(R.id.bt_checkname),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								2),
						isDisplayed()));
		button.check(matches(isDisplayed()));

		ViewInteraction textView2 = onView(
				allOf(withId(R.id.tv_email), withText(R.string.e_mail),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								3),
						isDisplayed()));
		textView2.check(matches(withText(R.string.e_mail)));

		ViewInteraction editText2 = onView(
				allOf(withId(R.id.et_email),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								4),
						isDisplayed()));
		editText2.check(matches(isDisplayed()));


		ViewInteraction button2 = onView(
				allOf(withId(R.id.bt_save),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								7),
						isDisplayed()));
		button2.check(matches(isDisplayed()));

		ViewInteraction button3 = onView(
				allOf(withId(R.id.bt_save),
						childAtPosition(
								childAtPosition(
										withId(android.R.id.content),
										0),
								7),
						isDisplayed()));
		button3.check(matches(isDisplayed()));

	}

	private static Matcher<View> childAtPosition(
			final Matcher<View> parentMatcher, final int position) {

		return new TypeSafeMatcher<View>() {
			@Override
			public void describeTo(Description description) {
				description.appendText("Child at position " + position + " in parent ");
				parentMatcher.describeTo(description);
			}

			@Override
			public boolean matchesSafely(View view) {
				ViewParent parent = view.getParent();
				return parent instanceof ViewGroup && parentMatcher.matches(parent)
						&& view.equals(((ViewGroup) parent).getChildAt(position));
			}
		};
	}
}
