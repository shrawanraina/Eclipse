package learn.java.datastructure;

public class _minStack extends _stack {
		_stack min = new _stack();
		
		public void _push(int x){
			if(_isEmpty()){
				super._push(x);
				min._push(x);
			}
			else{
				super._push(x);
				int y = min._pop();
				min._push(y);
				if(x < y)
					min._push(x);
				else
					min._push(y);
			}
			
		}
		
		public int _pop(){
			int x = super._pop();
			min._pop();
			return x;
		}
		
		public int getMin(){
			int x = min._pop();
			min._push(x);
			return x;
			
		}
}
