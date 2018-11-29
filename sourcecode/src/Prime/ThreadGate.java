package Prime;

class ThreadGate
{
	private int waitPossition;
	private int generationSize;
	private int openAttempts;
	private int activeSearchThreads;
	private boolean open;
	
	public ThreadGate(int searchThreadsCount)
	{
		activeSearchThreads = searchThreadsCount;
		waitPossition = 0;
		generationSize = 0;
		openAttempts = 0;
		open = true;
	}
	
	public synchronized void await() throws InterruptedException
	{
		int generationIndex = waitPossition;
		generationSize++;
		while (!open && generationIndex ==waitPossition
			&& activeSearchThreads!=0)
			wait();
	}

	public synchronized void close() throws InterruptedException
	{
		open = false;
		openAttempts =0;
		generationSize = 0;
	}
	
	public synchronized void open()
	{
		openAttempts++;
		
		if (generationSize<=openAttempts)
		{
			++waitPossition; //reset the counter		
			open=true;
			generationSize = 0;
			notifyAll();			
		}
	}
	
	synchronized void threadCompleted()
	{
		--activeSearchThreads;
		notifyAll();
	}		
	
	synchronized boolean isActive() {return activeSearchThreads!=0;}
	
	synchronized boolean isClosed(){return !open;}
}