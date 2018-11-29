package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AnotherPool {
	private List taskQueue = null;
	  private List<PoolThread> threads = new ArrayList<PoolThread>();
	  private boolean isStopped = false;

	  public AnotherPool(int noOfThreads, int maxNoOfTasks){
	    taskQueue = new ArrayList(maxNoOfTasks);

	    for(int i=0; i<noOfThreads; i++){
	      threads.add(new PoolThread(taskQueue));
	    }
	    for(PoolThread thread : threads){
	      thread.start();
	    }
	  }

	  public  synchronized void execute(Runnable task){
	    if(this.isStopped) throw
	      new IllegalStateException("ThreadPool is stopped");

	    this.taskQueue.remove(task);
	  }

	  public synchronized void stop(){
	    this.isStopped = true;
	    for(PoolThread thread : threads){
	      thread.stop();
	    }
	  }

}

 class PoolThread extends Thread {

	  private List taskQueue = null;
	  private boolean       isStopped = false;

	  public PoolThread(List list){
	    taskQueue = list;
	  }

	  public void run(){
	    while(!isStopped()){
	      try{
	        Runnable runnable = (Runnable) taskQueue.remove(0);
	        runnable.run();
	      } catch(Exception e){
	        //log or otherwise report exception,
	        //but keep pool thread alive.
	      }
	    }
	  }

	  public synchronized void terminate(){
	    isStopped = true;
	    this.interrupt(); //break pool thread out of dequeue() call.
	  }

	  public synchronized boolean isStopped(){
	    return isStopped;
	  }
	}
