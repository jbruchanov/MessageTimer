package com.devcamp.messagetimer.sender;

import android.content.Context;
import android.test.AndroidTestCase;
import junit.framework.TestCase;

public class ICQSenderTest extends AndroidTestCase
{

	public void testSendMessage()
	{
		try
		{
			ICQTestSender icq = new ICQTestSender(mContext);
			icq.sendMessage("30910177", "Hovno prdel sracka to je nase znacka!");
		}
		catch(Throwable t)
		{
			String q =t.getMessage();
		}
		
	}
	
	private class ICQTestSender extends ICQSender
	{

		public ICQTestSender(Context context)
		{
			super(context);
		}
		
		@Override
		protected String getUserName()
		{
			return "83353655";
		}
		
		@Override
		protected String getPassword()
		{
			return "francek";
		}
	}
}
