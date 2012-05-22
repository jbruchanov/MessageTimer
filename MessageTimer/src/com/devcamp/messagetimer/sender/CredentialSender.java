package com.devcamp.messagetimer.sender;

import android.content.Context;

public abstract class CredentialSender extends Sender
{

	public CredentialSender(Context context)
	{
		super(context);
	}
	
	protected abstract String getUserName();
	protected abstract String getPassword();
	
}
