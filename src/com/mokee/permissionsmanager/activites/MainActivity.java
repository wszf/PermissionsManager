package com.mokee.permissionsmanager.activites;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.mokee.permissionsmanager.R;
import com.mokee.permissionsmanager.fragments.AppOpsSummary;

public class MainActivity extends Activity implements ActionBar.OnNavigationListener
	{
		public static final String BR_UPDATE="update";
	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.test_main);
			SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
	                R.array.app_ops_categories,
	                R.layout.actionbar_spinner_item);
			ActionBar actionBar = this.getActionBar();
	        actionBar.setDisplayShowTitleEnabled(false);
	        actionBar.setTitle(R.string.title);
	        actionBar.setDisplayShowTitleEnabled(true);
	        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
	        actionBar.setListNavigationCallbacks(mSpinnerAdapter, this );
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
		{
			// Inflate the menu; this adds items to the action bar if it is present.
			//getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId)
		{
			Intent intent=new Intent(BR_UPDATE);
			intent.putExtra(BR_UPDATE, AppOpsSummary.sFilterTemplates[itemPosition]);
			LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
			return false;
		}
	}
