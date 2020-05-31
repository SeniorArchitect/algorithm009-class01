//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        Map<String, List> map = new HashMap<>();
        int[] counter = new int[26];
        for (String str : strs) {
            Arrays.fill(counter, 0);
            char[] strChar = str.toCharArray();
            for (int i = 0; i < strChar.length; i++) {
                counter[strChar[i] - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int count : counter) {
                sb.append(count);
                sb.append("#");
            }
            String key = sb.toString();
            if (!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
