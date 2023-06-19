package io.github.talelin.latticy.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.entity.SaleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaleMapper extends BaseMapper<SaleEntity> {
//分页获取
    @Select("SELECT * FROM lin_order_info WHERE invite = #{invite} LIMIT #{offset}, #{pageSize}")
    List<SaleEntity> getSalesByInvitepage(String invite, int offset, int pageSize);
//查询总量
    @Select("SELECT COUNT(*) FROM lin_order_info WHERE invite = #{invite}")
    int getSalesCountByInvite(String invite);

    @Select("SELECT * FROM lin_order_info WHERE invite=#{invite}")
    List<SaleEntity> getSalesByInviteall(String invite);

}
