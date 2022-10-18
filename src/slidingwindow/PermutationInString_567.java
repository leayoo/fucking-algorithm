package slidingwindow;

import java.util.HashMap;

public class PermutationInString_567 {
    // 判断 s2 中是否存在 s1 的排列
    // 比如，Input: s1 = "ab", s2 = "eidbaooo"
    boolean checkInclusion(String s1, String s2) {
        // 定义相关数据结构，初始化工作
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;

        // 开始滑动窗口
        while(right < s2.length()){
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)){
                // 更新 window 哈希表数据
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 如果 window 和 need 的该字符 value 相同
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(right - left >= s1.length()){
                // 在这里判断是否找到了合法的子串
                if (valid == need.size()){
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return false;
    }
}
