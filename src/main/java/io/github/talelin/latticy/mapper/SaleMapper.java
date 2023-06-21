package io.github.talelin.latticy.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.entity.LinOrderInfoHistoryEntity;
import io.github.talelin.latticy.entity.SaleEntity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface SaleMapper extends BaseMapper<SaleEntity> {
//分页获取
    @Select("SELECT * FROM lin_order_info WHERE invite = #{invite} LIMIT #{offset}, #{pageSize}")
    List<SaleEntity> getSalesByInvitepage(String invite, int offset, int pageSize);
//查询总量
    @Select("SELECT COUNT(*) FROM lin_order_info WHERE invite = #{invite}")
    int getSalesCountByInvite(String invite);


//    首页-统计总金额
    @Select("SELECT SUM(total_fee * commission_ratio / 100) AS total_commission FROM lin_order_info WHERE invite = #{invite}")
    Integer getSumMoney(String invite);
//    首页-统计总人数
    @Select("SELECT COUNT(*) AS invite_count FROM sys_user WHERE invite = #{invite}")
    Integer getSyscount(String invite);
//    首页-已提现金额
    @Select("SELECT SUM(commission) AS total_withdrawn_amount FROM lin_order_info WHERE withdrawal_status = 3 AND invite = #{invite}")
    Integer getcashOut(String invite);
//    首页-未提-可提
    @Select("SELECT SUM(commission) AS total_unwithdrawn_amount FROM lin_order_info WHERE withdrawal_status = 1 AND invite = #{invite}")
    Integer getundrawn(String invite);

//更新资金状态 withdrawal_status
//    @Update("UPDATE lin_order_info SET withdrawal_status = 2 WHERE invite = '0617' AND withdrawal_status = 1;")
//    List<SaleEntity> updateWithdrawalStatus(String invite);

    @Select("select lin_order_info SET withdrawal_status = 2 WHERE invite = '0617' AND withdrawal_status = 1;")
    List<SaleEntity> getuserwithdrawal_status(String invite);


    @Update("UPDATE lin_order_info SET withdrawal_status = 2 WHERE invite = #{invite} AND withdrawal_status = 1")
    void updateWithdrawalStatus1(String invite);


    void insertOrderInfoHistory(LinOrderInfoHistoryEntity history);


    @Update("UPDATE lin_order_info SET withdrawal_status = 2 WHERE invite = #{invite} AND withdrawal_status = 1")
    void updateWithdrawalStatus(String invite);
@Select("SELECT * FROM lin_order_info WHERE invite = #{invite} ORDER BY create_time DESC LIMIT 1")
    SaleEntity getLatestSaleByInvite(String invite);





}
