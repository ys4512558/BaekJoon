import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int cnt; //25501

    static int K; //24060
    static int res = -1; //24060
    static int tmp[]; //24060


    public static void main(String[] args) throws IOException {

    }

    private static void prob4779() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input = "";
        while ((input = br.readLine()) != null){
            int N = Integer.parseInt(input);
            int size = (int) Math.pow(3, N);
            char chars[] = new char[size];
            Arrays.fill(chars,'-');

            recur4779(chars, 0, chars.length-1, false);
            for(char c : chars){
                sb.append(c);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void recur4779(char[] chars, int left, int right, boolean check) {
        if(left < right && !check){
            int idx = (right-left) / 3;
            int mid1 = idx + left; //3등분
            int mid2 = idx + mid1 + 1;

            recur4779(chars, left, mid1, false);
            recur4779(chars, mid1+1, mid2, true); //시작값 + mid
            recur4779(chars, mid2+1, right, false);
            merge4779(chars, mid1, mid2);
        }
    }

    private static void merge4779(char[] chars, int mid1, int mid2) {
        for (int i = mid1+1; i <= mid2; i++) {
            chars[i] = ' ';
        }
    }


    private static void prob24060() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        tmp = new int[N];
        mergeSort(arr, 0, arr.length-1);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void mergeSort(int arr[], int left, int right) {
        if(left < right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int part1 = left; //첫번째 배열의 첫번째 인덱스
        int part2 = mid+1; //두번째 배열의 첫번째 인덱스
        int idx = left; //실제 배열 인덱스
        //첫번째 배열, 두번째 배열이 각각 해당 배열의 범위 안에 있는 동안 반복 (분할된 배열)
        while (part1 <= mid && part2 <= right){
            if(arr[part1] <= arr[part2]){
                tmp[idx++] = arr[part1++];
            }
            else {
                tmp[idx++] = arr[part2++];
            }
        }
        //왼쪽 배열이 남은 경우
        while (part1 <= mid){
            tmp[idx++] = arr[part1++];
        }
        while (part2 <= right){
            tmp[idx++] = arr[part2++];
        }
        part1 = left;
        idx = left;
        while (part1 <= right) {
            if (--K == 0){
                res = tmp[idx];
                break;
            }
            arr[part1++] = tmp[idx++];
        }
    }

    private static void prob25501() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            cnt = 0;
            int res = recur25501(input, 0, input.length()-1);
            sb.append(res).append(" ").append(cnt).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int recur25501(String str, int l, int r) {
        cnt++;
        if(l >= r)
            return 1;
        else if (str.charAt(l) != str.charAt(r))
            return 0;
        else
            return recur25501(str, l+1, r-1);
    }

    private static void prob10870() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int res = recur10870(N);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int recur10870(int N){
        if(N == 0 || N == 1){
            return N;
        }
        return recur10870(N-1) + recur10870(N-2);
    }

    private static void prob27433() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long res = recur27433(N);
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static long recur27433(int n){
        if(n <= 1){
            return 1;
        }
        return n * recur27433(n-1);
    }
}