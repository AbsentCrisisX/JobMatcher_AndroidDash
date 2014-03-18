package nl.acxdev.jobmatcher;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FourthFragment extends Fragment {
	public int NVBC;
	public int JBC;
	public int IJBC;
	public int JSVC;
	
	String color = "";
	String text = "";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View v = inflater.inflate(R.layout.frag_4, container, false);
	    
	    //Check the status of each crawler and define the text and textcolor for the textviews
	    //and fill the views
	    if(NVBC == 1){
	    	text = "Online";
	    	color = "#11FF00";
	    } else if(NVBC == 0){
	    	text = "Offline";
	    	color = "#FF0000";
	    } else {
	    	text = "Fout in de crawler";
	    	color = "#FF9900";
	    }
	    TextView nvb = (TextView) v.findViewById(R.id.statusNVB);
	    nvb.setText(text);
	    nvb.setTextColor(Color.parseColor(color));
	    
	    if(JBC == 1){
	    	text = "Online";
	    	color = "#11FF00";
	    } else if(JBC == 0){
	    	text = "Offline";
	    	color = "#FF0000";
	    } else {
	    	text = "Fout in de crawler";
	    	color = "#FF9900";
	    }
	    TextView jb= (TextView) v.findViewById(R.id.statusJB);
	    jb.setText(text);
	    jb.setTextColor(Color.parseColor(color));
	    
	    if(IJBC == 1){
	    	text = "Online";
	    	color = "#11FF00";
	    } else if(IJBC == 0){
	    	text = "Offline";
	    	color = "#FF0000";
	    } else {
	    	text = "Fout in de crawler";
	    	color = "#FF9900";
	    }
	    TextView ijb= (TextView) v.findViewById(R.id.statusIJB);
	    ijb.setText(text);
	    ijb.setTextColor(Color.parseColor(color));
	    
	    if(JSVC == 1){
	    	text = "Online";
	    	color = "#11FF00";
	    } else if(JSVC == 0){
	    	text = "Offline";
	    	color = "#FF0000";
	    } else {
	    	text = "Fout in de crawler";
	    	color = "#FF9900";
	    }
	    TextView jsv= (TextView) v.findViewById(R.id.statusJSV);
	    jsv.setText(text);
	    jsv.setTextColor(Color.parseColor(color));

	    return v;
	}

	public static FourthFragment newInstance(int NVBC, int JBC, int IJBC, int JSVC) {
	    //Create the fragment and define the variables
		FourthFragment f = new FourthFragment();
	    f.NVBC = NVBC;
	    f.JBC = JBC;
	    f.IJBC = IJBC;
	    f.JSVC = JSVC;
	    Bundle b = new Bundle();
	    
	    f.setArguments(b);

	    return f;
	}
}
