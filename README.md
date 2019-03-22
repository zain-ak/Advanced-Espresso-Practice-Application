<h1><img src="https://camo.githubusercontent.com/737e7380383ffcd2f3b9bf55c678f3b368feb730/68747470733a2f2f6c68352e676f6f676c6575736572636f6e74656e742e636f6d2f2d453259504c6c56416c30552f564a556350726756432d492f414141414141414147464d2f416b715a6e354e387272632f773839302d68313030392f657370726573736f5f6c6f636b75702e706e67" height="75" width="50" /> Android Espresso Practice Application - 🐱 Cat Names</h1> 

A Kotlin-based Android Application for learning some of the more advanced concepts of the Espresso framework for UI Testing. This application is the first of two applications exploring these concepts. The concepts covered in this repo are:
 - Intents
   - Incoming Intents
   - Outgoing Intents
  
The second application, *name*, can be accessed [here](). *name* covers hermetic test environments (Dependency Injections, Dagger).

<br>

_General Note:_ There are two packages in folder for testing, once is for unit testing (**test**) and one is for instrumentation testing (**androidTest**). Instrumentation testing is UI testing so that's what Espresso testing falls under. Create all test files under the *androidTest* package.

<h3>Incoming Intents</h3>

When working with intents in Espresso, `ActivityTestRule` changes, it'll now take in three parameters:

```java
var activityRule = ActivityTestRule(IdeasActivity::class.java, true, false)
```

 - _The class_ that was being used previously, this stays the same;
 - `touchMode`, essentially indicates whether the last interaction performed was with the touch screen. This will be set to _true_;
 - `launchActivity`, this is set to _false_ here because the activity is now not the default one as it was previously. Now you're going to be passing in an intent.

With the initialization changed for `ActivityTestRule`, you'll now have to explicity call the activity before you can start performing tests on it. This will be done using the `ActivityTestRule.launchActivity()` method:

```java
//When calling an empty intent
activityRule.launchActivity(null) 
```
<br>
 - Usually, you'll first create the intent, and add some data to it, then call launchActivity(). 
 - If you're going to be using resources, for example the project is using string resources, you'll need to add a context. Check the first line below.
```java
val context = InstrumentationRegistry.getTargetContext()
val intent = Intent()
intent.putExtra(IdeasActivity.KEY_THEME, "Punny")
activityRule.launchActivity(intent)
```
 \**Note:* You'll use `getTargetContext()` while working with test files. It can be thought of as the equivalent to `getContext()`, which is used in production code. 

Full code from where snippets were taken can be accessed [here](app/src/androidTest/java/android/learning/advancedespressopracticeapplication/IdeasActivityTest.kt)

 ###Outgoing Intents

\* [UI Automator](https://developer.android.com/training/testing/ui-automator) is a testing framework for running UI tests when your app goes into other applications after user input... check it out.

\* The espresso-intents [library](https://developer.android.com/training/testing/espresso/intents) is an extension of espresso for validating and stubbing intents.

Fill this out...

###Hermetic Test Environment

