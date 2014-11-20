package com.example.kjnbradio;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.google.gdata.util.*;
import com.google.gdata.client.spreadsheet.*;
import com.google.gdata.data.spreadsheet.*;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
	
	private String djStatus = "";

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
		
		boolean checked = ((RadioButton) view).isChecked();
		
		switch(view.getId()){
		case R.id.form_edit_4_radio_a:
			if(checked) djStatus = "I am a current KJNB DJ.";
		case R.id.form_edit_4_radio_b:
			if(checked) djStatus = "I am a former KJNB DJ.";
		case R.id.form_edit_4_radio_c:
			if(checked) djStatus = "I have never been a KJNB DJ.";
		case R.id.form_edit_4_radio_d:
			if(checked) djStatus = "I have been a DJ elsewhere.";
		}
		
	}
	
	public void submit(View view) throws AuthenticationException, MalformedURLException, IOException, ServiceException {
		
		new SubmitFormTask().execute();
		
	}
	
	private int getMonth(String month){
		switch(month){
		case "January":
			return 1;
		case "February":
			return 2;
		case "March":
			return 3;
		case "April":
			return 4;
		case "May":
			return 5;
		case "June":
			return 6;
		case "July":
			return 7;
		case "August":
			return 8;
		case "September":
			return 9;
		case "October":
			return 10;
		case "November":
			return 11;
		case "December":
			return 12;
		default:
			return -1;
		}
		
	}
	
	private class SubmitFormTask extends AsyncTask{

		@Override
		protected Object doInBackground(Object... params) {
			try{
				
				//Show a toast if not all required entries are filled out
				Runnable showToast = new Runnable(){
					public void run(){
						Toast toast = Toast.makeText(getApplicationContext(), "Please fill in all required entries", Toast.LENGTH_LONG);
						toast.show();
					}
				};

				//Check if any of the EditTexts are empty
				String names = ((EditText) findViewById(R.id.form_edit_1)).getText().toString();
				if(names.equals("")){
					runOnUiThread(showToast);
					return null;
				}
				
				String showName = ((EditText) findViewById(R.id.form_edit_8)).getText().toString();
				if(showName.equals("")){
					runOnUiThread(showToast);
					return null;
				}
				
				String month = ((Spinner) findViewById(R.id.form_edit_5_month)).getSelectedItem().toString();
				String day = ((Spinner) findViewById(R.id.form_edit_5_day)).getSelectedItem().toString();
				String hour = ((Spinner) findViewById(R.id.form_edit_5_hour)).getSelectedItem().toString();
				String minute = ((Spinner) findViewById(R.id.form_edit_5_minute)).getSelectedItem().toString();
				if(month.equals("Month") || day.equals("Day") || hour.equals("Hr") || minute.equals("Min")){
					runOnUiThread(showToast);
					return null;
				}
				String showStartString = getMonth(month) + "/" + day + " ";
				int showStartHour = Integer.parseInt(hour);
				if(((Spinner) findViewById(R.id.form_edit_5_ampm)).getSelectedItem().toString() == "PM") showStartHour += 12;
				if(showStartHour == 24) showStartHour = 0;
				showStartString += showStartHour + ":" + minute;
				
				String description = ((EditText) findViewById(R.id.form_edit_10)).getText().toString();
				if(description.equals("")){
					runOnUiThread(showToast);
					return null;
				}
				
				String why = ((EditText) findViewById(R.id.form_edit_11)).getText().toString();
				if(why.equals("")){
					runOnUiThread(showToast);
					return null;
				}
				
				String gradYear = ((EditText) findViewById(R.id.form_edit_2)).getText().toString();
				if(gradYear.equals("")){
					runOnUiThread(showToast);
					return null;
				}
				
				String genre = ((EditText) findViewById(R.id.form_edit_9)).getText().toString();
				if(genre.equals("")){
					runOnUiThread(showToast);
					return null;
				}
				
				if(djStatus.equals("")){
					runOnUiThread(showToast);
					return null;
				}
				
				month = ((Spinner) findViewById(R.id.form_edit_6_month)).getSelectedItem().toString();
				day = ((Spinner) findViewById(R.id.form_edit_6_day)).getSelectedItem().toString();
				hour = ((Spinner) findViewById(R.id.form_edit_6_hour)).getSelectedItem().toString();
				minute = ((Spinner) findViewById(R.id.form_edit_6_minute)).getSelectedItem().toString();
				if(month.equals("Month") || day.equals("Day") || hour.equals("Hr") || minute.equals("Min")){
					runOnUiThread(showToast);
					return null;
				}
				String showStartString2 = getMonth(month) + "/" + day + " ";
				showStartHour = Integer.parseInt(hour);
				if(((Spinner) findViewById(R.id.form_edit_6_ampm)).getSelectedItem().toString() == "PM") showStartHour += 12;
				if(showStartHour == 24) showStartHour = 0;
				showStartString2 += showStartHour + ":" + minute;
				
				month = ((Spinner) findViewById(R.id.form_edit_7_month)).getSelectedItem().toString();
				day = ((Spinner) findViewById(R.id.form_edit_7_day)).getSelectedItem().toString();
				hour = ((Spinner) findViewById(R.id.form_edit_7_hour)).getSelectedItem().toString();
				minute = ((Spinner) findViewById(R.id.form_edit_7_minute)).getSelectedItem().toString();
				if(month.equals("Month") || day.equals("Day") || hour.equals("Hr") || minute.equals("Min")){
					runOnUiThread(showToast);
					return null;
				}
				String showStartString3 = getMonth(month) + "/" + day + " ";
				showStartHour = Integer.parseInt(hour);
				if(((Spinner) findViewById(R.id.form_edit_7_ampm)).getSelectedItem().toString() == "PM") showStartHour += 12;
				if(showStartHour == 24) showStartHour = 0;
				showStartString3 += showStartHour + ":" + minute;
				
				
				SpreadsheetService service = new SpreadsheetService("");
				
				URL SPREADSHEET_FEED_URL = new URL(getString(R.string.form_spreadsheet));
				
				SpreadsheetFeed feed = service.getFeed(SPREADSHEET_FEED_URL, SpreadsheetFeed.class);
				List<SpreadsheetEntry> spreadsheets = feed.getEntries();
				SpreadsheetEntry spreadsheet = spreadsheets.get(0);
				
				WorksheetFeed worksheetFeed = service.getFeed(spreadsheet.getWorksheetFeedUrl(), WorksheetFeed.class);
				WorksheetEntry worksheet = worksheetFeed.getEntries().get(0);
				
				URL listFeedUrl = worksheet.getListFeedUrl();
				ListFeed listFeed = service.getFeed(listFeedUrl, ListFeed.class);
				
				ListEntry row = new ListEntry();
				CustomElementCollection elements = row.getCustomElements();
				
				elements.setValueLocal("Timestamp", new SimpleDateFormat("M/d/yyyy HH:mm:ss").format(new Date()));
				elements.setValueLocal("Name, banner ID's, cellphone and email of all DJ's", names);
				elements.setValueLocal("Name of proposed radio show", showName);
				elements.setValueLocal("When do you want to start your show?", showStartString);
				elements.setValueLocal("Show Description", description);
				elements.setValueLocal("Why do you want a radio show?", why);
				elements.setValueLocal("Graduation Year(s)", gradYear);
				elements.setValueLocal("What is your genre?", genre);
				
				//This one is optional - don't need to check
				elements.setValueLocal("Are there any CSB students that need access to Guild Hall?",
						((EditText) findViewById(R.id.form_edit_3)).getText().toString());
				elements.setValueLocal("DJ Status", djStatus);
				elements.setValueLocal("Please choose an alternative time in case your first time is booked.", showStartString2);
				elements.setValueLocal("Please choose a second alternative time in case your second time is booked.", showStartString3);
				
				row = service.insert(listFeedUrl, row);
			}catch(Exception e){
				
			}
			return null;
		}
		
		
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
