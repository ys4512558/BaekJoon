import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

    }

    private static void p25206_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double totalCredit = 0;
        double result = 0;

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            Double credit = Double.valueOf(st.nextToken());
            totalCredit += credit;
            switch (st.nextToken()){
                case "A+" :
                    result += (credit * 4.5);
                    break;
                case "A0" :
                    result += (credit * 4.0);
                    break;
                case "B+" :
                    result += (credit * 3.5);
                    break;
                case "B0" :
                    result += (credit * 3.0);
                    break;
                case "C+" :
                    result += (credit * 2.5);
                    break;
                case "C0" :
                    result += (credit * 2.0);
                    break;
                case "D+" :
                    result += (credit * 1.5);
                    break;
                case "D0" :
                    result += (credit * 1.0);
                    break;
                case "F" :
                    result += (credit * 0.0);
                    break;
                case "P" :
                    totalCredit -= credit;
                    break;
            }
        }

        String str = String.format("%.6f", result/totalCredit);
        System.out.println(str);
    }

    private static void p25206() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Score> scores = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Score score = new Score();
            score.setName(st.nextToken());
            score.setCredit(Double.parseDouble(st.nextToken()));
            switch (st.nextToken()){
                case "A+" :
                    score.setGrade(4.5);
                    break;
                case "A0" :
                    score.setGrade(4.0);
                    break;
                case "B+" :
                    score.setGrade(3.5);
                    break;
                case "B0" :
                    score.setGrade(3.0);
                    break;
                case "C+" :
                    score.setGrade(2.5);
                    break;
                case "C0" :
                    score.setGrade(2.0);
                    break;
                case "D+" :
                    score.setGrade(1.5);
                    break;
                case "D0" :
                    score.setGrade(1.0);
                    break;
                case "F" :
                    score.setGrade(0.0);
                    break;
                case "P" :
                    score.setGrade(-1);
                    break;
            }
            scores.add(score);
        }

        double totalCredit = 0;
        double result = 0;

        for (int j = 0; j < scores.size(); j++) {
            if(scores.get(j).getGrade() == -1){
                continue;
            }
            totalCredit += scores.get(j).getCredit();
            result += (scores.get(j).getGrade() * scores.get(j).getCredit());
        }
        String str = String.format("%.6f", result/totalCredit);
        System.out.println(str);
    }

    static class Score{
        String name;
        double credit;
        double grade;

        public void setName(String name) {
            this.name = name;
        }

        public double getCredit() {
            return credit;
        }

        public void setCredit(double credit) {
            this.credit = credit;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }
    }

    private static void p1316() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        int cnt = 0;

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            ArrayList<Character> characters = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                characters.add(str.charAt(j));
            }
            HashSet<Character> set = new HashSet<>(characters);
            ArrayList<Character> setList = new ArrayList<>(set);

            for (int j = 0; j < setList.size(); j++) {
                Loop1:
                for (int k = 0; k < str.length(); k++) {
                    if(setList.get(j).equals(str.charAt(k))){
                        if ((k+1) < str.length() && str.charAt(k) != str.charAt(k+1)){
                            str = str.replaceFirst(setList.get(j).toString(), " ");
                            break Loop1;
                        }
                        str = str.replaceFirst(setList.get(j).toString(), " ");
                        k--;
                    }
                }
            }
            str = str.replace(" ", "");
            if(str.length() == 0){
                cnt++;
            }
        }

        String s = String.valueOf(cnt);
        bw.write(s);
        bw.flush();
        bw.close();
    }

    private static void p2941() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        ArrayList<String> alpabet = new ArrayList<>();
        alpabet.add("dz=");
        alpabet.add("c=");
        alpabet.add("c-");
        alpabet.add("d-");
        alpabet.add("lj");
        alpabet.add("nj");
        alpabet.add("s=");
        alpabet.add("z=");
        int cnt = 0;
        for (int i = 0; i < alpabet.size(); i++) {
            if (str.contains(alpabet.get(i))){
                cnt++;
                str = str.replaceFirst(alpabet.get(i), " ");
                i = -1;
            }
        }
        str = str.replace(" ", "");
        cnt += str.length();

        System.out.println(cnt);
    }

    private static void p1157() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        char chars[] = str.toCharArray();

        ArrayList<Character> characters = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            characters.add(chars[i]);
        }

        HashSet<Character> set = new HashSet<>(characters);
        ArrayList<Character> setList = new ArrayList<>(set);

        ArrayList<Integer> cnt = new ArrayList<>();

        for (int i = 0; i < setList.size(); i++) {
            Character c = setList.get(i);
            int tmp = 0;
            for (int j = 0; j < characters.size(); j++) {
                if(c == characters.get(j)){
                    tmp++;
                }
            }
            cnt.add(tmp);
        }

        char c = ' ';
        int max = 0;
        for (int i = 0; i < cnt.size(); i++) {
            if(max == cnt.get(i)){
                c = '?';
            }
            else if(cnt.get(i) > max){
                max = cnt.get(i);
                c = setList.get(i);
            }
        }

        if(c >= 97 && c <= 122){
            c -= 32;
        }
        System.out.println(c);
    }

    private static void p4344() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(Integer.valueOf(st.nextToken()));
            }
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += list.get(j);
            }
            double cnt = 0;
            float avg = sum/list.size();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j)>avg){
                    cnt++;
                }
            }
            double per = cnt / n;
            double d = 100 * per;
            String result = String.format("%.3f", d);
            System.out.println(result + "%");
        }
    }

    private static void p10988() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder(br.readLine());

        String reverse = sb.reverse().toString();

        /*if(sb.toString().equals(reverse))
            System.out.println(1);
        else
            System.out.println(0);
        */

        System.out.println(sb.toString().equals(reverse) ? 1 : 0);
    }

    private static void p2444() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());


        for (int i = 1; i <= num; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < num-i; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < (i*2)-1; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }

        for (int i = num-1; i > 0; i--) {
            StringBuilder sb = new StringBuilder();
            for (int j = num-i; j > 0 ; j--) {
                sb.append(" ");
            }
            for (int j = 0; j < (i*2)-1; j++) {
                sb.append("*");
            }
            System.out.println(sb);
        }
    }

    private static void s3003() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(8);

        for (int i = 0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            int result = list.get(i) - num;
            System.out.print(result + " ");
        }
    }
}