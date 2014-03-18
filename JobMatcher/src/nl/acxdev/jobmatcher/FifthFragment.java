package nl.acxdev.jobmatcher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FifthFragment extends Fragment{
	public int CVBC;
	public int INDC;
	public int JSCC;
	
	public String text = "";
	public String color = "";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View v = inflater.inflate(R.layout.frag_5, container, false);
	    
	    //Check the status of each crawler and define the text and textcolor for the textviews
	    //and fill the views
	    if(CVBC == 0){
	    	text = "Offline";
	    	color = "#FF0000";
	    } else if(CVBC == 1){
	    	text = "Online";
	    	color = "#11FF00";
	    } else if(CVBC == -1){
	    	text = "Fout in de crawler";
	    	color = "#FF9900";
	    }
	    TextView cvb = (TextView) v.findViewById(R.id.statusCVB);
	    cvb.setText(text);
	    cvb.setTextColor(Color.parseColor(color));
	    
	    if(INDC == 0){
	    	text = "Offline";
	    	color = "#FF0000";
	    } else if(INDC == 1){
	    	text = "Online";
	    	color = "#11FF00";
	    } else if(INDC == -1){
	    	text = "Fout in de crawler";
	    	color = "#FF9900";
	    }
	    TextView ind = (TextView) v.findViewById(R.id.statusIND);
	    ind.setText(text);
	    ind.setTextColor(Color.parseColor(color));
	    
	    if(JSCC == 0){
	    	text = "Offline";
	    	color = "#FF0000";
	    } else if(JSCC == 1){
	    	text = "Online";
	    	color = "#11FF00";
	    } else if(JSCC == -1){
	    	text = "Fout in de crawler";
	    	color = "#FF9900";
	    }
	    TextView jsc = (TextView) v.findViewById(R.id.statusJSR);
	    jsc.setText(text);
	    jsc.setTextColor(Color.parseColor(color));

	    return v;
	}

	public static FifthFragment newInstance(int CVBC, int INDC, int JSCC) {
		//Create the fragment and define the variables
	    FifthFragment f = new FifthFragment();
	    Bundle b = new Bundle();
	    f.CVBC = CVBC;
	    f.INDC = INDC;
	    f.JSCC = JSCC;

	    f.setArguments(b);

	    return f;
	}
}
