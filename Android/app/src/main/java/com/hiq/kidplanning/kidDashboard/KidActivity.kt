package com.hiq.kidplanning.kidDashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hiq.kidplanning.R

class KidActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kid)
    }

    /*

Design Questions:

General Questions:

1. Do we have any specific Fonts that we should use?

2. Icons:
	a. Are the icons in the designs available for commercial use? Do we have the rights to use them?
	b. How many do we have?

3. Dashboard KidView:
	a. Do we want that white border around the pictures?
	b. What will the "Daily Progress" look like when at 100% complete?
	c. How does the kid access the Kid's View? How does a parent access Parent's View?
	d. Does the parent need to "approve" a child's claim to be finished with a task?
	e. Are there different colors on the "Hello ..." messages?

4. Dashboard ParentView:
	a. Do we want the "Add Kid" button to always be shown? Hide it within the list maybe?
	b. Do we want the kid numbers? Seems to be an unnecessary identifier.
	c. All designs appears to not have any top action bar. Do we want one?
	d. Should the background to the chores keep the color background of the kid's viewCard?
	e. Are there any default colors?

5. Weeks:
	a. Do we save old weeks? For how far back do we save? 1 year or more?
	b. Should user/parent/kid be able to view and older week?
	c.
     */
}