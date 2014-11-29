package learn.java;

public class multiThreading implements Runnable{

	String winner;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		multiThreading obj = new multiThreading();
		Thread t1 = new Thread(obj, "Thread 1");
		Thread t2 = new Thread(obj, "Thread 2");
		Thread t3 = new Thread(obj, "Thread 3");
		Thread t4 = new Thread(obj, "Thread 4");
		Thread t5 = new Thread(obj, "Thread 5");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		
		t3.setPriority(Thread.NORM_PRIORITY);
		t4.setPriority(Thread.NORM_PRIORITY);
		
		t5.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		//t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

	public boolean endRace(int distance){
		if(distance == 10){
			winner = Thread.currentThread().getName();
			System.out.println("Winner is :"+winner);
			return true;
		}
		else if(winner == null){
			return false;
		}
		else
			return true;
	}	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean endrace;
		for(int i =0; i <=10 ; i++){
			System.out.println(Thread.currentThread().getName()+": State: "+Thread.currentThread().getState()+" Priority: "+Thread.currentThread().getPriority());
			Thread.yield();
			System.out.println(Thread.currentThread().getName()+": State: "+Thread.currentThread().getState()+", Priority: "+Thread.currentThread().getPriority()+" End");
			if(i == 5 /*&& Thread.currentThread().getName().equalsIgnoreCase("Thread 1")*/){
				try {
					System.out.println("Sleeping");
					Thread.sleep(1000*10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			endrace = endRace(i);
			if(endrace){
				//break;
			}
		}
	}

}
