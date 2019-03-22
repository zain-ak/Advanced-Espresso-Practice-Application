<h1>Android Espresso Practice Application</h1> 

A Kotlin-based Android Application for learning some of the more advanced concepts of the Espresso framework for UI Testing.
<br>
<img src="https://camo.githubusercontent.com/737e7380383ffcd2f3b9bf55c678f3b368feb730/68747470733a2f2f6c68352e676f6f676c6575736572636f6e74656e742e636f6d2f2d453259504c6c56416c30552f564a556350726756432d492f414141414141414147464d2f416b715a6e354e387272632f773839302d68313030392f657370726573736f5f6c6f636b75702e706e67" height="200" width="175" />
<br>

_Note:_ There are two packages in folder for testing, once is for unit testing (**test**) and one is for instrumentation testing (**androidTest**). Instrumentation testing is UI testing so that's what Espresso testing falls under. Create all test files under the *androidTest* package.

###Incoming Intents

When working with intents in Espresso, `ActivityTestRule` changes, it'll now take in three parameters:
 - _The class_ that was being used previously, this stays the same;
 - `touchMode`, essentially indicates whether the last interaction performed was with the touch screen. This will be set to _true_;
 - `launchActivity`, this is set to _false_ here because the activity is now not the default one as it was previously. Now you're going to be passing in an intent.

With the initialization changed for `ActivityTestRule`, you'll now have to explicity call the activity before you can start performing tests on it. This will be done using the `ActivityTestRule.launchActivity()` method.

Before you do this, you can now create an intent in the test function, and add data to it like you would in a normal activty with the code:
```kotlin
val intent = Intent()
intent.putExtra(_data_)
```

 - If you're going to be using string resources like the project is using, you'll need to add a context using `val context = InstrumentationRegistry.getTargetContext()`. <br>
 
 \* Difference between `getContext()` and `getTargetContext()`: the former will be used in the *real* application code that'll be launched to users and the latter will be used for writinng test for that _real_ application.

 ###Outgoing Intents

\* [UI Automator](https://developer.android.com/training/testing/ui-automator) is a testing framework for running UI tests when your app goes into other applications after user input... check it out.

\* The espresso-intents [library]([https://goo.gl/8okA8f](https://developer.android.com/training/testing/espresso/intents)) is an extension of espresso for validating and stubbing intents.


