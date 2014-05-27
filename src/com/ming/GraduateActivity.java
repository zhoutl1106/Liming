package com.ming;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class GraduateActivity extends Activity {
    /** Called when the activity is first created. */
	private boolean m_output;
	private ListView list;
	private List<String> group;
	
	private EditText editSinFreq,editRectFreq,editTriFreq,editUpFreq,editDownFreq,editCWCarry,editCWRatio,editCWPeriod,editAnyFs;
	private int sinFreq,rectFreq,triFreq,upFreq,downFreq,cwRatio,cwCarry,cwPeriod,anyFs;
	private ImageButton buttonSin,buttonRect,buttonTri,buttonUp,buttonDown,buttonCW,buttonAny;
	Socket s;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        m_output = false;
        sinFreq = -1;
        rectFreq = -1;
        triFreq = -1;
        upFreq = -1;
        downFreq = -1;
        cwPeriod = -1;
        cwRatio = -1;
        cwCarry = -1;
        anyFs = -1;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()        
    	.detectDiskReads()        
    	.detectDiskWrites()        
    	.detectNetwork()   // or .detectAll() for all detectable problems       
    	.penaltyLog()        
    	.build());        
    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()        
    	.detectLeakedSqlLiteObjects()     
    	.penaltyLog()        
    	.penaltyDeath()        
    	.build());
	    try
		{
			s = new Socket("192.168.7.10", 7777);
		} catch (UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        final LayoutInflater inflater = LayoutInflater.from(this);
        final LinearLayout lin = (LinearLayout)findViewById(R.id.layout);
        list = (ListView)findViewById(R.id.list);
        list.setAdapter(new SimpleAdapter(this,getData(),R.layout.vlist,
                new String[]{"title","img"},
                new int[]{R.id.title,R.id.img}));
        list.setOnItemClickListener(new OnItemClickListener()
		{

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3)
			{
				// TODO Auto-generated method stub
				if(0 == arg2)
				{
					LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.panelsin, null).findViewById(R.id.panelsin);
	            	layout.setMinimumHeight(lin.getHeight());
	            	lin.removeAllViews();
	            	lin.addView(layout);
	                
	                m_output = false;
	                editSinFreq = (EditText)findViewById(R.id.editSinFreq);
	                buttonSin = (ImageButton)findViewById(R.id.buttonSin);
	                buttonSin.setImageResource(R.drawable.buttonred);
	                if(sinFreq != -1)
	                {
	                	editSinFreq.setText(String.valueOf(sinFreq));
	                }
				}
				if(1 == arg2)
				{
					LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.panelrect, null).findViewById(R.id.panelrect);
	            	layout.setMinimumHeight(lin.getHeight());
	            	lin.removeAllViews();
	            	lin.addView(layout);
	                
	                m_output = false;
	                editRectFreq = (EditText)findViewById(R.id.editRectFreq);
	                buttonRect = (ImageButton)findViewById(R.id.buttonRect);
	                buttonRect.setImageResource(R.drawable.buttonred);
	                if(rectFreq != -1)
	                {
	                	editRectFreq.setText(String.valueOf(rectFreq));
	                }
				}
				if(2 == arg2)
				{
					LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.paneltri, null).findViewById(R.id.paneltri);
	            	layout.setMinimumHeight(lin.getHeight());
	            	lin.removeAllViews();
	            	lin.addView(layout);
	                
	                m_output = false;
	                editTriFreq = (EditText)findViewById(R.id.editTriFreq);
	                buttonTri = (ImageButton)findViewById(R.id.buttonTri);
	                buttonTri.setImageResource(R.drawable.buttonred);
	                if(triFreq != -1)
	                {
	                	editTriFreq.setText(String.valueOf(triFreq));
	                }
				}
				if(3 == arg2)
				{
					LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.panelup, null).findViewById(R.id.panelup);
	            	layout.setMinimumHeight(lin.getHeight());
	            	lin.removeAllViews();
	            	lin.addView(layout);
	                
	                m_output = false;
	                editUpFreq = (EditText)findViewById(R.id.editUpFreq);
	                buttonUp = (ImageButton)findViewById(R.id.buttonUp);
	                buttonUp.setImageResource(R.drawable.buttonred);
	                if(upFreq != -1)
	                {
	                	editUpFreq.setText(String.valueOf(upFreq));
	                }
				}
				if(4 == arg2)
				{
					LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.paneldown, null).findViewById(R.id.paneldown);
	            	layout.setMinimumHeight(lin.getHeight());
	            	lin.removeAllViews();
	            	lin.addView(layout);
	                
	                m_output = false;
	                editDownFreq = (EditText)findViewById(R.id.editDownFreq);
	                buttonDown = (ImageButton)findViewById(R.id.buttonDown);
	                buttonDown.setImageResource(R.drawable.buttonred);
	                if(downFreq != -1)
	                {
	                	editDownFreq.setText(String.valueOf(downFreq));
	                }
				}
				if(5 == arg2)
				{
					LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.panelcw, null).findViewById(R.id.panelcw);
	            	layout.setMinimumHeight(lin.getHeight());
	            	lin.removeAllViews();
	            	lin.addView(layout);
	            	
	                m_output = false;
	                editCWCarry = (EditText)findViewById(R.id.editCWCarry);
	                editCWPeriod = (EditText)findViewById(R.id.editCWPeriod);
	                editCWRatio = (EditText)findViewById(R.id.editCWRatio);
	                buttonCW = (ImageButton)findViewById(R.id.buttonCW);
	                buttonCW.setImageResource(R.drawable.buttonred);
	                if(cwCarry != -1  && cwPeriod != -1 && cwRatio != -1)
	                {
	                	editCWCarry.setText(String.valueOf(cwCarry));
	                	editCWPeriod.setText(String.valueOf(cwPeriod));
	                	editCWRatio.setText(String.valueOf(cwRatio));                	
	                }
				}
				if(6 == arg2)
				{
					LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.panelany, null).findViewById(R.id.panelany);
	            	layout.setMinimumHeight(lin.getHeight());
	            	lin.removeAllViews();
	            	lin.addView(layout);
	            	
	                m_output = false;
	                editAnyFs = (EditText)findViewById(R.id.editAnyFs);
	                buttonAny = (ImageButton)findViewById(R.id.buttonAny);
	                buttonAny.setImageResource(R.drawable.buttonred);
	                if(anyFs != -1)
	                {
	                	editAnyFs.setText(String.valueOf(anyFs));
	                }
				}
			}        	
		});
	}

	private String makeCommand(long f, int mode, int radio, int period)
	{
		int f1 = (int) (f/100000);
		int f2 = (int) (f/10000%10);
		int f3 = (int) (f/1000%10);
		int f4 = (int) (f/100%10);
		int f5 = (int) (f/10%10);
		int f6 = (int) (f%10);
		int r1 = radio/10;
		int r2 = radio%10;
		int p1 = period/100;
		int p2 = period/10%10;
		int p3 = period%10;
		return String.valueOf(f1)+String.valueOf(f2)+String.valueOf(f3)+String.valueOf(f4)+
				String.valueOf(f5)+String.valueOf(f6)+String.valueOf(mode)+String.valueOf(r1)+
				String.valueOf(r2)+String.valueOf(p1)+String.valueOf(p2)+String.valueOf(p3);
	}
    public void onSinClick(View v)
    {
    	if(editSinFreq.getText().toString().isEmpty()) 
			Toast.makeText(getApplicationContext(), getText(R.string.setParametersFirstWarning).toString(), Toast.LENGTH_SHORT).show();
    	else if(Integer.valueOf(editSinFreq.getText().toString()) < 1 ||
				Integer.valueOf(editSinFreq.getText().toString()) > 30000) 
    		Toast.makeText(getApplicationContext(), getText(R.string.wrongParametersWarning).toString(), Toast.LENGTH_SHORT).show();
    	else
        {
    		sinFreq = Integer.valueOf(editSinFreq.getText().toString());
			
    		m_output = !m_output;
	        if(m_output)
	        {
	        	buttonSin.setImageResource(R.drawable.buttongreen);
	        	try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(sinFreq,1,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
	        else
	        {
	        	buttonSin.setImageResource(R.drawable.buttonred);
		        try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(sinFreq,9,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
        }
    }
   
    public void onRectClick(View v)
    {
    	if(editRectFreq.getText().toString().isEmpty()) 
			Toast.makeText(getApplicationContext(), getText(R.string.setParametersFirstWarning).toString(), Toast.LENGTH_SHORT).show();
    	else if(Integer.valueOf(editRectFreq.getText().toString()) < 1 ||
				Integer.valueOf(editRectFreq.getText().toString()) > 30000) 
    		Toast.makeText(getApplicationContext(), getText(R.string.wrongParametersWarning).toString(), Toast.LENGTH_SHORT).show();
    	else
        {
    		rectFreq = Integer.valueOf(editRectFreq.getText().toString());
			
    		m_output = !m_output;
    		if(m_output)
	        {
	        	buttonRect.setImageResource(R.drawable.buttongreen);
	        	try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(rectFreq,3,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
	        else
	        {
	        	buttonRect.setImageResource(R.drawable.buttonred);
		        try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(rectFreq,9,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
        }
    }
    
    public void onTriClick(View v)
    {
    	if(editTriFreq.getText().toString().isEmpty()) 
			Toast.makeText(getApplicationContext(), getText(R.string.setParametersFirstWarning).toString(), Toast.LENGTH_SHORT).show();
    	else if(Integer.valueOf(editTriFreq.getText().toString()) < 1 ||
				Integer.valueOf(editTriFreq.getText().toString()) > 30000) 
    		Toast.makeText(getApplicationContext(), getText(R.string.wrongParametersWarning).toString(), Toast.LENGTH_SHORT).show();
    	else
        {
    		triFreq = Integer.valueOf(editTriFreq.getText().toString());
			
    		m_output = !m_output;
    		if(m_output)
	        {
	        	buttonTri.setImageResource(R.drawable.buttongreen);
	        	try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(triFreq,2,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
	        else
	        {
	        	buttonTri.setImageResource(R.drawable.buttonred);
		        try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(triFreq,9,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
        }
    }
    
    public void onUpClick(View v)
    {
    	if(editUpFreq.getText().toString().isEmpty()) 
			Toast.makeText(getApplicationContext(), getText(R.string.setParametersFirstWarning).toString(), Toast.LENGTH_SHORT).show();
    	else if(Integer.valueOf(editUpFreq.getText().toString()) < 1 ||
				Integer.valueOf(editUpFreq.getText().toString()) > 30000) 
    		Toast.makeText(getApplicationContext(), getText(R.string.wrongParametersWarning).toString(), Toast.LENGTH_SHORT).show();
    	else
        {
    		upFreq = Integer.valueOf(editUpFreq.getText().toString());
			
    		m_output = !m_output;
    		if(m_output)
	        {
	        	buttonUp.setImageResource(R.drawable.buttongreen);
	        	try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(upFreq,4,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
	        else
	        {
	        	buttonUp.setImageResource(R.drawable.buttonred);
		        try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(upFreq,9,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
        }
    }
    public void onDownClick(View v)
    {
    	if(editDownFreq.getText().toString().isEmpty()) 
			Toast.makeText(getApplicationContext(), getText(R.string.setParametersFirstWarning).toString(), Toast.LENGTH_SHORT).show();
    	else if(Integer.valueOf(editDownFreq.getText().toString()) < 1 ||
				Integer.valueOf(editDownFreq.getText().toString()) > 30000) 
    		Toast.makeText(getApplicationContext(), getText(R.string.wrongParametersWarning).toString(), Toast.LENGTH_SHORT).show();
    	else
        {
    		downFreq = Integer.valueOf(editDownFreq.getText().toString());
			
    		m_output = !m_output;
    		if(m_output)
	        {
	        	buttonDown.setImageResource(R.drawable.buttongreen);
	        	try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(downFreq,5,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
	        else
	        {
	        	buttonDown.setImageResource(R.drawable.buttonred);
		        try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(downFreq,9,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
        }
    }
    public void onCWClick(View v)
    {
    	if(editCWCarry.getText().toString().isEmpty() || editCWRatio.getText().toString().isEmpty() || editCWPeriod.getText().toString().isEmpty()) 
			Toast.makeText(getApplicationContext(), getText(R.string.setParametersFirstWarning).toString(), Toast.LENGTH_SHORT).show();
    	else if(Integer.valueOf(editCWCarry.getText().toString()) < 1 ||
				Integer.valueOf(editCWCarry.getText().toString()) > 30000 ||
				Integer.valueOf(editCWRatio.getText().toString()) < 0||
				Integer.valueOf(editCWRatio.getText().toString()) > 100 ||
				Integer.valueOf(editCWPeriod.getText().toString()) < 3 ||
				Integer.valueOf(editCWPeriod.getText().toString()) > 1000) 
    		Toast.makeText(getApplicationContext(), getText(R.string.wrongParametersWarning).toString(), Toast.LENGTH_SHORT).show();
    	else
        {
			cwRatio = Integer.valueOf(editCWRatio.getText().toString());
			cwCarry = Integer.valueOf(editCWCarry.getText().toString());
			cwPeriod = Integer.valueOf(editCWPeriod.getText().toString());
			
	        m_output = !m_output;
	        if(m_output)
	        {
	        	buttonCW.setImageResource(R.drawable.buttongreen);
	        	try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(cwCarry,6,cwRatio,cwPeriod));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
	        else
	        {
	        	buttonCW.setImageResource(R.drawable.buttonred);
		        try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(cwCarry,9,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
		}
    }
    public void onAnyClick(View v)
    {
    	if(editAnyFs.getText().toString().isEmpty()) 
			Toast.makeText(getApplicationContext(), getText(R.string.setParametersFirstWarning).toString(), Toast.LENGTH_SHORT).show();
    	else if(Integer.valueOf(editAnyFs.getText().toString()) < 1 ||
				Integer.valueOf(editAnyFs.getText().toString()) > 150000) 
    		Toast.makeText(getApplicationContext(), getText(R.string.wrongParametersWarning).toString(), Toast.LENGTH_SHORT).show();
    	else
        {
			anyFs = Integer.valueOf(editAnyFs.getText().toString());
	        m_output = !m_output;
	        if(m_output)
	        {
	        	buttonAny.setImageResource(R.drawable.buttongreen);
	        	try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(anyFs,7,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
	        else
	        {
	        	buttonAny.setImageResource(R.drawable.buttonred);
		        try {
	              	
	              	// outgoing stream redirect to socket
	              	OutputStream out = s.getOutputStream();
	              	// 注意第二个参数据为true将会自动flush，否则需要需要手动操作out.flush()
	              	PrintWriter output = new PrintWriter(out, true);
	              	output.println(makeCommand(anyFs,9,50,50));
	              	} catch (UnknownHostException e) {
	              	e.printStackTrace();
	              	} catch (IOException e) {
	              	e.printStackTrace();
	              	}
	        }
		}
    }
	private List<Map<String,Object>> getData()
	{
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		 
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", getText(R.string.sin).toString());
        map.put("img", R.drawable.sin);
        list.add(map);
 
        map = new HashMap<String, Object>();
        map.put("title", getText(R.string.rect).toString());
        map.put("img", R.drawable.rect);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", getText(R.string.tri).toString());
        map.put("img", R.drawable.tri);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", getText(R.string.up).toString());
        map.put("img", R.drawable.up);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", getText(R.string.down).toString());
        map.put("img", R.drawable.down);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", getText(R.string.cw).toString());
        map.put("img", R.drawable.cw);
        list.add(map);
        
        map = new HashMap<String, Object>();
        map.put("title", getText(R.string.any).toString());
        map.put("img", R.drawable.any);
        list.add(map);
 
         
        return list;
	}
}