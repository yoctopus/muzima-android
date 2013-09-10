package com.muzima.view;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;

import com.muzima.R;
import com.muzima.view.preferences.SettingsActivity;

public class DashboardActivity extends Activity {


		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_dashboard);
			getOverflowMenu();

			ActionBar actionBar = getActionBar();
			// actionBar.hide();
			actionBar.setDisplayShowTitleEnabled(true);
			// actionBar.setDisplayShowCustomEnabled(true);
			actionBar.setDisplayShowHomeEnabled(true);
			actionBar.setDisplayHomeAsUpEnabled(false);
			// View cView
			// =getLayoutInflater().inflate(R.layout.actionbar_dashboard,null);
			// actionBar.setCustomView(cView);
		}

		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.dashboard, menu);
			return true;
		}

		@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			Intent intent;
			switch (item.getItemId()) {
			case R.id.action_settings:
				intent = new Intent(this, SettingsActivity.class);
				startActivity(intent);
				return true;
			case R.id.action_help:
				intent = new Intent(this, HelpActivity.class);
				startActivity(intent);
				return true;
			case R.id.action_logout:
				intent = new Intent(this, LogoutActivity.class);
				startActivity(intent);
				return true;
			default:
				return super.onOptionsItemSelected(item);
			}
		}

		private void getOverflowMenu() {

			try {
				ViewConfiguration config = ViewConfiguration.get(this);
				java.lang.reflect.Field menuKeyField = ViewConfiguration.class
						.getDeclaredField("sHasPermanentMenuKey");
				if (menuKeyField != null) {
					menuKeyField.setAccessible(true);
					menuKeyField.setBoolean(config, false);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		protected void onPause() {
			//overridePendingTransition(R.anim.fade_in, R.anim.push_out_to_left);
			super.onPause();
		}


		
		/** Called when the user clicks the Forms area */
		public void formsList(View view) {
			Intent intent = new Intent(this, FormListActivity.class);
			startActivity(intent);

		}
}

