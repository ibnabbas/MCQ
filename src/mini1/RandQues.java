package mini1;

import java.util.LinkedHashSet;
import java.util.Random;

public class RandQues {
	
	public static LinkedHashSet<Integer> linkedHashSet(){
			Random random = new Random();
			int min = 1, max = 15;
			LinkedHashSet<Integer> q_set = new LinkedHashSet<Integer>(10);
			
			while(true) {
			//for(int i = 1; i<=30; i++) {
				int random_int = random.nextInt(max - min + 1) + min;
				//System.out.println(random_int);
				if(q_set.contains(random_int)) {
					//continue
				}else {
					q_set.add(random_int);
					if(q_set.size() == 10) {
						break;
					}
				}
				
			}
			return q_set;	
		}
	}