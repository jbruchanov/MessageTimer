package com.devcamp.messagetimer.sender;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;

import com.devcamp.messagetimer.R;

import android.content.Context;
import android.util.Log;

public class ICQSender extends CredentialSender
{

	public ICQSender(Context context)
	{
		super(context);
	}

	@Override
	public void sendMessage(String to, String message)
	{
		Log.v("SMSSender","sendMessage");
//		 Create a connection to the jabber.org server.
		try
		{
			ConnectionConfiguration connConfig = new ConnectionConfiguration("icq.internet-exception.de", 5222);
			//
			XMPPConnection connection = new XMPPConnection(connConfig);
			boolean tls = connection.isUsingTLS();
			connConfig.setSASLAuthenticationEnabled(false);
				
//					else
//			connConfig.setSASLAuthenticationEnabled(true);						
			Message msg = new Message();
			msg.setBody(message);
			for(int i = 0;i<15 && !connection.isConnected();i++)
				connection.connect();
			connection.login(getUserName(), getPassword());

			Presence presence = new Presence(Presence.Type.available);
            connection.sendPacket(presence);
            
			ChatManager chatmanager = connection.getChatManager();
			Chat chat = chatmanager.createChat(to, new MessageListener()
			{
				
				@Override
				public void processMessage(Chat arg0, Message arg1)
				{	
					// TODO Auto-generated method stub
					
				}
			});
			chat.sendMessage(msg);
			connection.disconnect();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected String getUserName()
	{
		return getStringProperty(R.string.PROPERTY_ICQ_LOGIN);
	}
	
	@Override
	protected String getPassword()
	{
		return getStringProperty(R.string.PROPERTY_ICQ_PASSWORD);
	}
}
