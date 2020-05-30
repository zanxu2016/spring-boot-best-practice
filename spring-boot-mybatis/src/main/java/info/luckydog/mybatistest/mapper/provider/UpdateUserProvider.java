package info.luckydog.mybatistest.mapper.provider;

import info.luckydog.mybatistest.entity.User;

import java.util.Map;

public class UpdateUserProvider {
    public String updateByPrimaryKeySelective(Map<String, Object> params) throws Exception {
        User user = (User) params.get("user");
        if (user == null || user.getId() == null) {
            throw new Exception("the primaryKey can not be null.");
        }
        // 拼装 sql 语句
        StringBuilder updateStrSb = new StringBuilder("update user set ");
        StringBuilder setStrSb = new StringBuilder();
        if (user.getName() != null) {
            setStrSb.append("name = #{user.name},");
        }
        if (user.getPwd() != null) {
            setStrSb.append("number = #{user.pwd},");
        }
        if (user.getAge() != null) {
            setStrSb.append("age = #{user.age},");
        }
        if (user.getGender() != null) {
            setStrSb.append("gender = #{user.gender},");
        }
        if (user.getRemark() != null) {
            setStrSb.append("remark = #{user.remark},");
        }

        if (setStrSb.length() > 0) {
            updateStrSb.append(setStrSb.substring(0, setStrSb.length() - 1)).append(" where id = #{user.id}");
        } else {
            throw new Exception("none element to update.");
        }
        return updateStrSb.toString();
    }
}
