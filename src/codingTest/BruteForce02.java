package codingTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce02 { //15649 //중복허용하지않음, 
	static int N,M;
	static int[] selected;
	
	static StringBuilder sb =new StringBuilder();
	
	
	static void input() {
		FastReader scan =new FastReader();
		N=scan.nextInt();
		M=scan.nextInt();
		selected = new int[M+1];
		
	}
	
	static void rec_func(int k) {
		if(k==M+1) {
			for(int i=1; i<=M; i++) sb.append(selected[i]).append(' ');
			sb.append('\n');
		}else {
			for(int cand = 1; cand <=N; cand++) {
				
				//중복 허용하지 않기 때문에 
				boolean isUsed = false;
				for(int i=1; i<k; i++) {
					if(cand==selected[i])
						isUsed =true;
					
				}
				if(!isUsed) {
					selected[k] =cand;
					rec_func(k+1); //재귀함수
					selected[k]=0;
				}
				
			}
		}
		
	}
	
	//입력속도 빠르게하기위해서 사용 
	static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
	public static void main(String[] args) {
		input();
		
		rec_func(1);
		System.out.println(sb.toString());
	}
	
	

}
