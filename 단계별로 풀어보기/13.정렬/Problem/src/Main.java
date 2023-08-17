import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Set<String> set = new HashSet<>(Arrays.asList(arr));
        arr = set.toArray(new String[0]);
        Arrays.sort(arr, (e1, e2) -> {
            if(e1.length() == e2.length()){
                return e1.compareTo(e2);
            }
            else {
                return e1.length() - e2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob18870() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer arr[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        Integer setArr[] = set.toArray(new Integer[0]);
        Arrays.sort(setArr);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < setArr.length; i++) {
            map.put(setArr[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob18870_time_fail2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer arr[] = new Integer[N];
        Integer tmp[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            tmp[i] = arr[i];
        }

        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        Integer setArr[] = set.toArray(new Integer[0]);
        Arrays.sort(setArr);

        for (int i = 0; i < setArr.length; i++) {
            Collections.replaceAll(Arrays.asList(arr), setArr[i], i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob18870_time_fail() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Integer arr[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        Integer setArr[] = set.toArray(new Integer[0]);
        Arrays.sort(setArr);

        for (int i = 0; i < setArr.length; i++) {
            for (int j = 0; j < N; j++) {
                if(setArr[i].equals(arr[j])){
                    arr[j] = i;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10814() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String person[][] = new String[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i][0] = st.nextToken();
            person[i][1] = st.nextToken();
        }

        Arrays.sort(person, (e1, e2) -> {
            if(e1[0].equals(e2[0])){
                return 0;
            }
            else {
                return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(person[i][0]).append(" ").append(person[i][1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1181() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        String arr[] = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Set<String> set = new HashSet<>(Arrays.asList(arr));
        arr = set.toArray(new String[0]);
        Arrays.sort(arr, (e1, e2) -> {
            if(e1.length() == e2.length()){
                for (int i = 0; i < e1.length(); i++) {
                    if(e1.charAt(i) != e2.charAt(i)){
                        return e1.charAt(i) - e2.charAt(i);
                    }
                }
                return 0;
            }
            else {
                return e1.length() - e2.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11651() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1[1] == e2[1]){
                return e1[0] - e2[0];
            }
            else {
                return e1[1] - e2[1];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11650() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }
            else {
                return e1[0] - e2[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob11650_time_fail() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Integer x[] = new Integer[N];
        Integer y[] = new Integer[N];
        ArrayList<Integer> tmpX = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
            tmpX.add(x[i]);
        }
        Arrays.sort(x);

        Integer resultY[] = new Integer[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < tmpX.size(); j++) {
                if(x[i] == tmpX.get(j)){
                    resultY[i] = y[j];
                    tmpX.set(j, -1000001);
                    break;
                }
            }
        }

        Set<Integer> set = new HashSet<>(Arrays.asList(x));
        Integer setArray[] = set.toArray(new Integer[0]);
        Arrays.sort(setArray);

        ArrayList<Integer> cnts = new ArrayList<>();

        for (int i = 0; i < setArray.length; i++) {
            cnts.add(Collections.frequency(Arrays.asList(x), setArray[i]));
        }

        int num = 0;
        for (int i = 0; i < setArray.length; i++) {
            Arrays.sort(resultY, num, num + cnts.get(i));
            num += cnts.get(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(x[i]).append(" ").append(resultY[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob1427() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int array[] = new int[str.length()];

        for (int i = 0; i <str.length() ; i++) {
            array[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }

        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(array[i]);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10989() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int array[] = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(array[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2751() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int array[] = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(array[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob25305() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> score = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            score.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(score, Collections.reverseOrder());

        bw.write(String.valueOf(score.get(K-1)));
        bw.flush();
        bw.close();
    }

    private static void prob2587() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int array[] = new int[5];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
            sum += array[i];
        }
        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        sb.append(sum / 5).append("\n").append(array[2]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob2750() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int array[] = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++){
            sb.append(array[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}