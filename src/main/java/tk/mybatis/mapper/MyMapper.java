package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Classname MyMapper
 * @Description [ TODO ]
 * @Author Tang
 * @Date 2020/2/22 9:39
 * @Created by ASUS
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
