package Week_4.Opdracht_2;

import java.util.*;

public class ViewRegister
{
	// De (abstracte) klasse View is de superklasse van de views (behalve de HoofdView)
	private ArrayList<View> viewListeners;
	
	public ViewRegister()
	{
       viewListeners = new ArrayList<View>();
	}
	
	public void reportChange()
	{
       for (View v : viewListeners)
         v.reportChange();		
	}
	
	public void add (View v)
	{
       viewListeners.add (v);
	}
	
	public void remove (View v)
	{
	   viewListeners.remove (v);
	}	
}
