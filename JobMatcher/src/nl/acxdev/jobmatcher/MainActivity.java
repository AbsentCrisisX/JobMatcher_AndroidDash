package nl.acxdev.jobmatcher;

import java.util.Locale;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;


public class MainActivity extends FragmentActivity {
	static final String url = "http://145.24.222.153:8080/feed_0866265.py";
		
	public static String xml;
	
	public int NVB;
	public int JB;
	public int IJB;
	public int JSV;
	public int TV;
	
	public int CVB;
	public int IND;
	public int JSC;
	public int TR;
	
	public int MB50;
	public int TM;
	
	public int NVBC;
	public int JBC;
	public int IJBC;
	public int JSVC;
	
	public int CVBC;
	public int INDC;
	public int JSCC;
	
	
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//get the data that wil be needed for the application
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build(); 
		StrictMode.setThreadPolicy(policy);
		loadData();

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void loadData(){
		//Instantiate the parser and get the XML
		XMLParser reader = new XMLParser();
		xml = reader.getXmlFromUrl(url);
		Document doc = reader.getDom(xml);
		
		//Get the data of the crawled vacancies from the XML
		NVB = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("vacancies").item(0), "Nationale_Vacaturebank"));
		JB = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("vacancies").item(0), "Jobbird"));
		IJB = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("vacancies").item(0), "ITJobboard"));
		JSV = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("vacancies").item(0), "JobselectieV"));
		TV = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("vacancies").item(0), "Total_Vacancies"));
		
		//Get the data of the crawled resumes from the XML
		CVB = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("resumes").item(0), "CV_en_Vacaturebank"));
		IND = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("resumes").item(0), "Indeed"));
		JSC = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("resumes").item(0), "JobselectieC"));
		TR = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("resumes").item(0), "Total_Resumes"));
		
		//Get the data of the made matches from the XML
		MB50 = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("matches").item(0), "Matches_above_50"));
		TM = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("matches").item(0), "Total_Matches"));
		
		//Get the status of the vacancy crawlers from the XML
		NVBC = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("Vacancy_Crawlers").item(0), "NVB_Crawler"));
		JBC = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("Vacancy_Crawlers").item(0), "JB_Crawler"));
		IJBC = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("Vacancy_Crawlers").item(0), "IJB_Crawler"));
		JSVC = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("Vacancy_Crawlers").item(0), "JSV_Crawler"));
		
		//Get the status of the resume crawlers from the XML
		CVBC = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("Resume_Crawlers").item(0), "CVB_Crawler"));
		INDC = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("Resume_Crawlers").item(0), "IND_Crawler"));
		JSCC = Integer.parseInt(reader.getVal((Element) doc.getElementsByTagName("Resume_Crawlers").item(0), "JSC_Crawler"));
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}
		
		//Get the needed fragment for the needed page.
		@Override
		public Fragment getItem(int pos) {
			loadData(); 
			switch(pos) {
	            case 0: return FirstFragment.newInstance(NVB,JB,IJB,JSV,TV);
	            case 1: return SecondFragment.newInstance(CVB,IND,JSC,TR);
	            case 2: return ThirdFragment.newInstance(MB50,TM);
	            case 3: return FourthFragment.newInstance(NVBC,JBC,IJBC,JSVC);
	            case 4: return FifthFragment.newInstance(CVBC,INDC,JSCC);
	            default: return FirstFragment.newInstance(NVB,JB,IJB,JSV,TV);
	            }
		}

		@Override
		public int getCount() {
			// Show 5 total pages.
			return 5;
		}
		
		//Get the page titles for the menu
		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			case 4:
				return getString(R.string.title_section5).toUpperCase(l);
			}
			return null;
		}
	}
}