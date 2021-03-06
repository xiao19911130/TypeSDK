package com.type.sdk.application;

import com.type.sdk.android.TypeSDKLogger;
import com.type.sdk.android.TypeSDKTool;
import com.sqwan.msdk.SQApplication;
import com.type.sdk.android.meizu.TypeSDKBonjour;
import com.type.sdk.notification.PushService;

public class TypeApplication extends SQApplication{

	public TypeApplication() {
		
	}
	
	@Override
	public void onCreate() { 
		super.onCreate();
		TypeSDKLogger.e("TypeApplication");
		String buffStr = TypeSDKTool.getFromAssets(this, "CPSettings.txt");
        TypeSDKLogger.i(buffStr);
    	if(buffStr.length()>0)
    	{
    		TypeSDKBonjour.Instance().platform.StringToData(buffStr);
    		TypeSDKLogger.i(TypeSDKBonjour.Instance().platform.DataToString());
    	}
		PushService.channelName = TypeSDKBonjour.Instance().platform.GetData("channelName");
	}
	
}
