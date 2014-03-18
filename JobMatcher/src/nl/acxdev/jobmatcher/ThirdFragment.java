package nl.acxdev.jobmatcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
	int MB50;
	int TM;
	
	String text = "";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View v = inflater.inflate(R.layout.frag_3, container, false);

	    //Calculate the percentage of variable, seen from total
	    double MB50P = ((double)MB50/TM) * 100;
        
        //Set the width of the red bar to the percentage that was calculated
	    TextView p1M = (TextView) v.findViewById(R.id.p1M);
        int MB50W = (int)Math.round(((double)MB50P/100) * 300);
        p1M.getLayoutParams().width = (MB50W+125);
        
        //Enter the text in the textview
        text = "Matches met een score van 50 of hoger: " + MB50;        
        TextView mb50 = (TextView) v.findViewById(R.id.MB50);
        mb50.setText(text);
        
        text = "Totaal: " + TM;
        TextView tm = (TextView) v.findViewById(R.id.TM);
        tm.setText(text);

	    return v;
	}

	public static ThirdFragment newInstance(int MB50, int TM) {
		// Create the fragment and fill the variables
	    ThirdFragment f = new ThirdFragment();
	    Bundle b = new Bundle();
	    f.MB50 = MB50;
	    f.TM = TM;

	    f.setArguments(b);

	    return f;
	}
}
