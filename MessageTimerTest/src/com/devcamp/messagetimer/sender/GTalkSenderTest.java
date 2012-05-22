package com.devcamp.messagetimer.sender;

import android.content.Context;
import android.test.AndroidTestCase;
import junit.framework.TestCase;

public class GTalkSenderTest extends AndroidTestCase
{

	public void testSendMessage()
	{
		GTalkSender gs = new GTalkTestSender(mContext);
		gs.sendMessage("jbruchanov@gmail.com", "test haaaleluja");
	}
	
	
	private class GTalkTestSender extends GTalkSender
	{

		public GTalkTestSender(Context context)
		{
			super(context);
		}
		
		@Override
		protected String getUserName()
		{		
			return "joe@scurab.co.cc";
		}
		
		@Override
		protected String getPassword()
		{
			return "312148349fred+-";
		}
		
	}
}
