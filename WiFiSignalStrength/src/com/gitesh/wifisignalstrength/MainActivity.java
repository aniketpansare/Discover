package com.gitesh.wifisignalstrength;

import java.util.List;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class MainActivity extends Activity {

	WifiManager wifiManager = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeWiFiListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private void initializeWiFiListener(){

    	    	
    	
    	String networkSSID = "test";
        String networkPass = "pass";

        WifiConfiguration conf = new WifiConfiguration();
        conf.SSID = "\"" + networkSSID + "\""; 
        
        conf.wepKeys[0] = "\"" + networkPass + "\""; 
        conf.wepTxKeyIndex = 0;
        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
        conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
        conf.preSharedKey = "\""+ networkPass +"\"";
        conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
        
   
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifiManager.addNetwork(conf);
        List<ScanResult> list_scan_result = wifiManager.getScanResults();
        List<WifiConfiguration> list_wifi_config = wifiManager.getConfiguredNetworks();
        
        if(list_wifi_config != null) {
	        for(WifiConfiguration i: list_wifi_config ) {
	        	System.out.println("\nWiFiConfig " + i.SSID + " | " + i.networkId + " | " + i.status);
	        }
        }
        
        if(list_scan_result != null) {
	        for(ScanResult i: list_scan_result ) {
	        	System.out.println("\nScanResult " + i.SSID + " | " + i.frequency + " | " + i.level);
	        }
        }
        
    	
    	
    	}




}
