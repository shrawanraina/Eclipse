package learn.java;

import java.util.ArrayList;
import java.util.List;


interface interface1{
	List<String> addStuff(List<String> a);
}



public class Overloading implements interface1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPod ipod = new IPod();
		IPodTouch ipodtouch = new IPodTouch();
		IPod ip = new IPodTouch();
		ip.playIpod();
		ipod.playIpod();
		ipodtouch.playIpod();
		
		Integer temp = new Integer(20);
		Integer temp2 = Integer.valueOf(10);
		System.out.println(temp+temp2);
		Music m = new Music();
		Song s = new Song();
		Music a = new Song();
		ipodtouch.playMusic(s);
		ipodtouch.playMusic(m);
		ipod.playMusic(a);
		ip.playMusic(a);
	}

	@Override
	public List<String> addStuff(List<String> a) {
		// TODO Auto-generated method stub
		a.add("1");
		return a;
	}

}
class Music{
	
}

class Song extends Music{
	
}

class IPod {
	protected void playIpod(){
		System.out.println("Ipod");
	}
	void playMusic(Music m){
		System.out.println("play music");
	}
}

class IPodTouch extends IPod{
	void playMusic(Music m){
		System.out.println("play music"+" with iPod touch");
	}
	void playMusic(Song s){
		System.out.println("play song");
	}
	void playIpodTouch(){
		System.out.println("IpodTouch");
	}
	protected void playIpod(){
		System.out.println("IpodOverridden");
	}
}