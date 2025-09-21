package HaiKang;

import java.util.*;
import java.util.stream.Collectors;

public class TiOne {

    /**
     * 对用户列表进行排序，排序规则：先按照 name 字段的自然顺序排序，name 相同再按照 id 由小到大进行排序
     *
     * @param userList 用户列表
     * @return 排序好的用户列表
     */
    public static List<User> sortUser(List<User> userList) {
        // 请实现该方法

        List<User> ans = new ArrayList<>(userList);

        Collections.sort(ans,new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int StringCom=o1.name.compareTo(o2.name);
                if(StringCom!=0)
                {
                    return StringCom;
                }else
                {
                    return Integer.compare(o1.id,o2.id);
                }
            }
        });
        return  ans;
    }
}

class User {
    Integer id;
    String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

}