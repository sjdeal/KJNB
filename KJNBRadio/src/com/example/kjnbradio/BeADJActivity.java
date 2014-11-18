package com.example.kjnbradio;

import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BeADJActivity extends Activity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;
	
	private String djStatus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_be_adj);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		mNavigationDrawerFragment.selectItem(5);
		
		instantiateSpinners();
		
		
	}

	private void instantiateSpinners(){
		Spinner spinner;
		ArrayAdapter<CharSequence> adapter;
		spinner = (Spinner) findViewById(R.id.form_edit_5_month);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Months, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_5_day);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Days, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_5_hour);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Hours, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_5_minute);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Minutes, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_5_ampm);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.AMPM, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		
		
		spinner = (Spinner) findViewById(R.id.form_edit_6_month);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Months, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_6_day);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Days, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_6_hour);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Hours, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_6_minute);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Minutes, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_6_ampm);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.AMPM, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		
		
		spinner = (Spinner) findViewById(R.id.form_edit_7_month);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Months, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_7_day);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Days, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_7_hour);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Hours, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_7_minute);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.Minutes, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		spinner = (Spinner) findViewById(R.id.form_edit_7_ampm);
		adapter = ArrayAdapter.createFromResource(this, 
				R.array.AMPM, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
	}
	
	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		Intent intent;
		switch (number) {
		case 1: //Empty case to prevent crashing... or something
			break;
		case 2: //Home page
			intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			break;
		case 3: //Radio stream
			intent = new Intent(this, RadioStreamActivity.class);
			startActivity(intent);
			break;
		case 4: //Be a DJ
			break;
		case 5: //About
			intent = new Intent(this, AboutActivity.class);
			startActivity(intent);
			break;
		case 6: //About
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.be_adj, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onDJStatusClicked(View view){
		
	}
	
	public void submit(View view){
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(getString(R.string.form_spreadsheet));
	
		List<BasicNameValuePair> results = new ArrayList<BasicNameValuePair>();
		results.add(new BasicNameValuePair("entry.0.single", new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date())));
		results.add(new BasicNameValuePair("entry.1.single", ((EditText) findViewById(R.id.form_edit_1)).getText().toString()));
		results.add(new BasicNameValuePair("entry.2.single", ((EditText) findViewById(R.id.form_edit_8)).getText().toString()));
		
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_be_adj,
					container, false);
			return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((BeADJActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
		}
	}

}
