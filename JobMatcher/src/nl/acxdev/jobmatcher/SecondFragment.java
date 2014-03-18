package nl.acxdev.jobmatcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {
	int CVB;
	int IND;
	int JSC;
	int TR;
	
	String text = "";
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View v = inflater.inflate(R.layout.frag_2, container, false);
	    
	    //Calculate the percentage of variable, seen from total
	    double CVBP = ((double)CVB/TR) * 100;
        double INDP = ((double)IND/TR) * 100;
        double JSCP = ((double)JSC/TR) * 100;
        
        //Create the horizontal bar graph, with the percentages calculated above
        TextView p1V = (TextView) v.findViewById(R.id.p1R);
        int CVBW = (int)Math.round(((double)CVBP/100) * 300);
        p1V.getLayoutParams().width = (CVBW+125);
        
        TextView p2V = (TextView) v.findViewById(R.id.p2R);
        int INDW = (int)Math.round(((double)INDP/100) * 300);
        p2V.getLayoutParams().width = (INDW+125);
        
        TextView p3V = (TextView) v.findViewById(R.id.p3R);
        int JSCW = (int)Math.round(((double)JSCP/100) * 300);
        p3V.getLayoutParams().width = (JSCW+125);
        
        //enter the values of the crawled resume's per site and total
        //crawled resume's in the textviews
        text = "CV en vacaturebank: " + CVB;        
        TextView cvb = (TextView) v.findViewById(R.id.CVB);
        cvb.setText(text);
        
        text = "Indeed: " + IND;
        TextView ind = (TextView) v.findViewById(R.id.IND);
        ind.setText(text);
        
        text = "Jobselectie: " + JSC;
        TextView jsc = (TextView) v.findViewById(R.id.JSR);
        jsc.setText(text);
        
        text = "Totaal: " + TR;
        TextView tr = (TextView) v.findViewById(R.id.TR);
        tr.setText(text);
	    
	    return v;
	}

	public static SecondFragment newInstance(int CVB, int IND, int JSC, int TR) {
		//Create the fragment and set the variables
	    SecondFragment f = new SecondFragment();
	    Bundle b = new Bundle();
	    f.CVB = CVB;
	    f.IND = IND;
	    f.JSC = JSC;
	    f.TR = TR;
	    
	    f.setArguments(b);

	    return f;
	}
}
