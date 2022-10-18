package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        // 定义相关数据结构，初始化工作
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // 根据需要找的字符串 p，确定 need 哈希表内容
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            need.put(c, need.getOrDefault(c, 0)+1);
        }

        int left = 0, right = 0;
        int valid = 0;
        // 记录结果
        ArrayList<Integer> res = new ArrayList<>();

        // 开始滑动窗口（只要 right 未到达字符串末端）
        while(right < s.length()){
            char c = s.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if (window.get(c).equals(need.get(c)))
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= p.length()){
                // 当窗口符合条件时，把起始索引加入 res
                if (valid == need.size())
                    res.add(left);
                char d = s.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)){
                    if (window.get(d).equals(need.get(d)))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return res;
    }
}
