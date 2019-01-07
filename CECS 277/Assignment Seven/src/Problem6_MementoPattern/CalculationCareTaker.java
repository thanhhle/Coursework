package Problem6_MementoPattern;

import java.util.ArrayList;
import java.util.List;

public class CalculationCareTaker
{
	List<MementoCalculator> listCal = new ArrayList<MementoCalculator>();
	
	public void add(MementoCalculator m)
	{
		listCal.add(m);
	}
	
	public MementoCalculator get(int index)
	{
		return listCal.get(index);
	}
}
