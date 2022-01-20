package com.demo.mapper;

import com.demo.pojo.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Wangjunliang
 * @since 22-01-19 01:56
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {

}
