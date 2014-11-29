package learn.java;

import java.lang.Thread.State;

public class joinThreads implements Runnable{
	public static Thread firstThread;
	public static Thread secondThread;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		joinThreads jt = new joinThreads();
		firstThread = new Thread(jt,"One");
		secondThread = new Thread(jt,"Two");
		firstThread.start();
		while(true){
			State firstThreadStatus = firstThread.getState();
			State secondThreadStatus = secondThread.getState();
			System.out.println(System.nanoTime()+"fts: "+firstThreadStatus);
			System.out.println(System.nanoTime()+"sts: "+secondThreadStatus);
			if(firstThreadStatus.equals(State.TERMINATED) && secondThreadStatus.equals(State.TERMINATED)){
				break;
			}
		}
		
		
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName());
		if(Thread.currentThread().getName().equals("One")){
			System.out.println("Join");
			joinThreads.secondThread.start();
			joinThreads.secondThread.yield();
			
		}
		
	}

}
