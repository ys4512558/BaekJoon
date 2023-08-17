import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String tmp = s.substring(j,i);
                set.add(tmp);
                System.out.println(tmp);
            }
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }

    private static void prob1269_3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Integer tmp = Integer.valueOf(st.nextToken());
            if (set.contains(tmp)) {
                cnt++;
            }
        }
        bw.write(String.valueOf(N + M - 2 * cnt));
        bw.flush();
        bw.close();
    }

    private static void prob1269_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            Integer tmp = Integer.valueOf(st.nextToken());
            if (set.contains(tmp)) {
                set.remove(tmp);
            }
            else {
                set.add(tmp);
            }
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }

    private static void prob1764_3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set1 = new TreeSet<>();
        Set<String> set2 = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if (set1.contains(tmp)) {
                set2.add(tmp);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(set2.size()).append("\n");
        for(String s : set2){
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11478() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        Set<String> set = new HashSet<>();
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                set.add(s.substring(j, i));
            }
        }
        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
    }

    private static void prob1269() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        Set<Integer> tmp = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            A.add(num);
            tmp.add(num);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B.add(Integer.valueOf(st.nextToken()));
        }

        A.removeAll(B);
        B.removeAll(tmp);
        StringBuilder sb = new StringBuilder();
        sb.append((A.size() + B.size()));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1764_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }
        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if (set1.contains(tmp)) {
                str.add(tmp);
            }
        }
        Collections.sort(str);

        StringBuilder sb = new StringBuilder();
        sb.append(str.size()).append("\n");
        for (String s : str) {
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1764() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set1 = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set1.add(br.readLine());
        }
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < M; i++) {
            set2.add(br.readLine());
        }

        set1.retainAll(set2);
        String str[] = set1.toArray(new String[0]);

        Arrays.sort(str, (e1,e2)->{
            for (int i = 0; i < (e1.length() > e2.length() ? e2.length() : e1.length()); i++) {
                if(e1.charAt(i) != e2.charAt(i)){
                    return e1.charAt(i) - e2.charAt(i);
                }
            }
            return e1.compareTo(e2);
        });

        StringBuilder sb = new StringBuilder();
        sb.append(set1.size()).append("\n");
        for (String s : str) {
            sb.append(s).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10816() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (map.get(input) != null){
                map.replace(input, map.get(input)+1);
            }
            else {
                map.put(input, 1);
            }
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(map.get(num)==null){
                sb.append(0).append(" ");
            }
            else {
                sb.append(map.get(num)).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1620() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String , String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map.put(String.valueOf(i+1), input);
            map.put(input, String.valueOf(i+1));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            sb.append(map.get(input));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob7785() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(st.nextToken().equals("enter")){
                set.add(name);
            }
            else {
                set.remove(name);
            }
        }
        String[] names = set.toArray(new String[0]);
        Arrays.sort(names);
        StringBuilder sb = new StringBuilder();
        for (int i = names.length - 1; i >= 0 ; i--) {
            sb.append(names[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob14425() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            if(set.contains(br.readLine())){
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }

    private static void prob10815_map() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(st.nextToken()), 0);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(map.containsKey(Integer.parseInt(st.nextToken()))){
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10815_set() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(set.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10815_binarySearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer card[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(card);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int idx = Arrays.binarySearch(card, Integer.parseInt(st.nextToken()));
            if(idx >= 0){
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}