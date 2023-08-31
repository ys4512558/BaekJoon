import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

    }

    private static void prob20920() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map= new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length() < M){
                continue;
            }
            if(map.containsKey(word)){
                map.put(word, map.get(word)+1);
            }
            else{
                map.put(word, 1);
            }
        }
        String words[] = map.keySet().toArray(new String[0]);

        Arrays.sort(words, (s1,s2)->{
            //횟수로 비교
            if(map.get(s1)==map.get(s2)){
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }
                return s2.length() - s1.length();
            }
            return map.get(s2) - map.get(s1);
        });
        for(String s : words){
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2108() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int array[] = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        double sum = 0;
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i])+1);
            }
            else {
                map.put(array[i], 1);
            }
        }
        Arrays.sort(array);

        ArrayList<Integer> num = new ArrayList<>();
        int freq = 0;
        for (Integer i : map.keySet()) {
            if (freq < map.get(i)) {
                num = new ArrayList<>();
                num.add(i);
                freq = map.get(i);
            }
            else if(freq == map.get(i)){
                num.add(i);
            }
        }
        Collections.sort(num);

        sb.append((int) Math.round(sum / N)).append("\n");
        sb.append(array[N / 2]).append("\n");
        sb.append(num.size() > 1 ? num.get(1) : num.get(0)).append("\n");
        sb.append(array[array.length - 1] - array[0]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob26069() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if (set.contains(str1) && !set.contains(str2)) {
                set.add(str2);
            }
            else if (set.contains(str2) && !set.contains(str1)) {
                set.add(str1);
            }
        }
        sb.append(set.size());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob25192() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<String>();
        int N = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            if (tmp.equals("ENTER")) {
                res += set.size();
                set = new HashSet<>();
            }
            else {
                set.add(tmp);
            }
        }
        res += set.size();
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1037_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int res = A[0] * A[A.length-1];
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1037() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int A[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        int res = A.length % 2 == 0 ? A[0] * A[A.length-1] : A[A.length/2] * A[A.length/2];
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}