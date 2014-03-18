package nl.acxdev.jobmatcher;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Fragment {
	int NVB;
	int JB;
	int IJB;
	int JSV;
	int TV;
	
	String text = "";
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_1, container, false);
        
        //Calculate the percentage of variable, seen from total
        double NVBP = ((double)NVB/TV) * 100;
        double JBP = ((double)JB/TV) * 100;
        double IJBP = ((double)IJB/TV) * 100;
        double JSVP = ((double)JSV/TV) * 100;
        
        //Create the horizontal bar graph, with the percentages calculated above
        TextView p1V = (TextView) v.findViewById(R.id.p1V);
        int NVBW = (int)Math.round(((double)NVBP/100) * 300);
        p1V.getLayoutParams().width = (NVBW+125);
        
        TextView p2V = (TextView) v.findViewById(R.id.p2V);
        int JBW = (int)Math.round(((double)JBP/100) * 300);
        p2V.getLayoutParams().width = (JBW+125);
        
        TextView p3V = (TextView) v.findViewById(R.id.p3V);
        int IJBW = (int)Math.round(((double)IJBP/100) * 300);
        p3V.getLayoutParams().width = (IJBW+125);
        
        TextView p4V = (TextView) v.findViewById(R.id.p4V);
        int JSVW = (int)Math.round(((double)JSVP/100) * 300);
        p4V.getLayoutParams().width = (JSVW+125);
        
        //enter the values of the crawled vacancies per site and total
        //crawled vacancies in the textviews
        text = "Nationale vacaturebank: " + NVB;        
        TextView nvb = (TextView) v.findViewById(R.id.NVB);
        nvb.setText(text);
        
        text = "Jobbird: " + JB;
        TextView jb = (TextView) v.findViewById(R.id.JB);
        jb.setText(text);
        
        text = "ITJobboard: " + IJB;
        TextView ijb = (TextView) v.findViewById(R.id.IJB);
        ijb.setText(text);
        
        text = "Jobselectie: " + JSV;
        TextView jsv = (TextView) v.findViewById(R.id.JSV);
        jsv.setText(text);
        
        text = "Totaal: " + TV;
        TextView tv = (TextView) v.findViewById(R.id.TV);
        tv.setText(text);

        return v;
    }

    public static FirstFragment newInstance(int NVB, int JB, int IJB, int JSV, int TV) {
    	//Create the fragment and set the variables
        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        
        f.NVB = NVB;
        f.JB = JB;
        f.IJB = IJB;
        f.JSV = JSV;
        f.TV = TV;

        f.setArguments(b);

        return f;
    }
}