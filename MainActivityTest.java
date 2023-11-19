package com.example.myapplication;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity>mActivityTestRule = new ActivityScenarioRule<MainActivity>(MainActivity.class);
    private MainActivity mActivity = null;
    private TextView text;

    @Before
    public void setUp()throws Exception{
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    @UiThreadTest
    public void checkFirstName()throws Exception{
        assertNotNull(mActivity.findViewByid(R.id.textView1));
        text = mActivity.findViewById(R.id.username);
        text.setText("user1");
        String name = text.getText().toString();
        assertNotEquals("user",name);
    }


}
