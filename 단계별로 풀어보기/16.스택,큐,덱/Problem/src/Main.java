import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue q = new LinkedList();
        for (int i = 0; i < N; i++) {
            q.add(i+1);
        }
        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }
        bw.write(String.valueOf(q.poll()));
        bw.flush();
        bw.close();
    }

    private static void prob18258() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    deque.add(Integer.valueOf(st.nextToken()));
                    break;
                case "pop":
                    sb.append(deque.isEmpty() ? -1 : deque.poll()).append("\n");
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
                default:
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob12789() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < N; i++) {
            q.add(Integer.valueOf(st.nextToken()));
        }
        for (int i = 1; i <= N; i++) {
            if(!q.isEmpty() && q.peek() == i){
                q.poll();
            }
            else if(q.isEmpty()){
                if(s.peek() == i){
                    s.pop();
                }
                else {
                    break;
                }
            }
            else if(!s.isEmpty() && s.peek() == i){
                s.pop();
            }
            else {
                s.push(q.poll());
                i--;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(s.isEmpty()){
            sb.append("Nice");
        }
        else {
            sb.append("Sad");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob4949() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        while (true) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            if(input.charAt(0)=='.'){
                break;
            }
            for (int i = 0; i < input.length(); i++) {
                char tmp = input.charAt(i);
                if(stack.isEmpty() && (tmp == ')' || tmp == ']')){
                    stack.push('n');
                    break;
                }

                if(tmp == '(' || tmp == '['){
                    stack.push(tmp);
                }
                else if(!stack.isEmpty() && tmp == ')'){
                    if(stack.peek() == '['){
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }
                else if(!stack.isEmpty() && tmp == ']'){
                    if(stack.peek() == '('){
                        break;
                    }
                    else {
                        stack.pop();
                    }
                }

            }
            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob9012() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Loop:
        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            if(input.length() % 2 != 0){
                sb.append("NO").append("\n");
                continue;
            }
            else {
                for (int j = 0; j < input.length(); j++) {
                    if(input.charAt(j) == '('){
                        stack.push(input.charAt(j));
                    }
                    else if(stack.isEmpty() && input.charAt(j) == ')'){
                        sb.append("NO").append("\n");
                        continue Loop;
                    }
                    else {
                        stack.pop();
                    }
                }
            }
            if(stack.isEmpty()){
                sb.append("YES").append("\n");
            }
            else {
                sb.append("NO").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob10773() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp != 0){
                stack.push(tmp);
            }
            else {
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (Integer i : stack) {
            sum += i;
        }
        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void prob28278() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (Integer.parseInt(st.nextToken())) {
                case 1:
                    stack.push(Integer.valueOf(st.nextToken()));
                    break;
                case 2:
                    sb.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                    break;
                case 3:
                    sb.append(stack.size()).append("\n");
                    break;
                case 4:
                    sb.append(stack.isEmpty() ? 1 : 0).append("\n");
                    break;
                case 5:
                    sb.append(stack.isEmpty() ? -1 : stack.get(stack.size()-1)).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}