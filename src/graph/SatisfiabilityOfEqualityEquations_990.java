package graph;

/**
 * @author: Leeyoa
 * @description:
 * @date: 2023/7/29 16:51
 */
public class SatisfiabilityOfEqualityEquations_990 {
    boolean equationsPossible(String[] equations) {
        UFCommon ufCommon = new UFCommon(26);
        // 相等的字母形成连通分量
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                ufCommon.union(x - 'a', y - 'a');
            }
        }

        // 检查不等关系是否打破相等关系的连通性
        for (String eq:equations){
            if (eq.charAt(1) == '!'){
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                // 如果相等关系成立，就是逻辑冲突
                if (ufCommon.connected(x-'a',y-'a'))
                    return false;
            }
        }
        return true;
    }
}
