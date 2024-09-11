
class SortedList extends IntegerList {
	
	public SortedList() 
	{
		super();
	}
	public SortedList(int capacity) 
	{
		super(capacity);
	}
	@Override
	public void add(int integer) 
	{
		int index = 0; 
		while(index < size && array[index] < integer) 
		{
			index ++;
		}
		insert(index, integer);
	}
	@Override
	public void insert(int index, int integer) 
	{
		throw new UnsupportedOperationException("Cannot insert");
	}
	
}
