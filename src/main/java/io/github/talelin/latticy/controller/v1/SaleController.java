package io.github.talelin.latticy.controller.v1;
import io.github.talelin.latticy.entity.LinOrderInfoHistoryEntity;
import io.github.talelin.latticy.entity.SaleEntity;
import io.github.talelin.latticy.mapper.SaleMapper;
import io.github.talelin.latticy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * CMS-销售视图
 *
 * */
@CrossOrigin //开放前端的跨域访问
@RestController
@RequestMapping("/cms/order")
public class SaleController {
    private String invite = null ;
    private final SaleMapper saleMapper;
    @Autowired
    public SaleController(SaleMapper saleMapper) {
        this.saleMapper = saleMapper;
    }


    /**
     * CMS_订单详情页数据_分页

     * @param page   页数
     * @param pageSize 每页数量
     * @return 分页数据
     * */

    @GetMapping("/by-invite")
    public R getSalesByInvite(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
                              @RequestParam(value = "name") String name) {

        if ("xiaoshou".equals(name)) {
            this.invite = "0617";
        } else {
            this.invite = "";
        }
        int offset = (page - 1) * pageSize;
        List<SaleEntity> sales = saleMapper.getSalesByInvitepage(invite, offset, pageSize);
        // 查询总记录数
        int total = saleMapper.getSalesCountByInvite(invite);
        // 创建包含列表和分页信息的Map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sales", sales);
        resultMap.put("total", total);
        resultMap.put("page", page);
        resultMap.put("pageSize", pageSize);
        // 返回R对象，并设置数据为Map对象
        return R.ok().setData(resultMap);
    }

    /**
     * CMS_首页信息
     *
     * */

    @GetMapping("/homePage")
    public R homePageData(@RequestParam(value = "name") String name) {
        if ("xiaoshou".equals(name)) {
            this.invite = "0617";
        } else {
            this.invite = "";
        }

        Integer sumMoney = saleMapper.getSumMoney(invite);//        累计收入
        Integer count = saleMapper.getSyscount(invite);//           邀请人数
        Integer cashout = saleMapper.getcashOut(invite);//          已提
        Integer undrawn = saleMapper.getundrawn(invite);//          未提取

        // 创建包含列表的Map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sumMoney", sumMoney != null ? sumMoney : 0);
        resultMap.put("totalPeople", count != null ? count : 0);
        resultMap.put("cashOut", cashout != null ? cashout : 0); // Handle null value by using the ternary operator
        resultMap.put("undrawn", undrawn!= null ? undrawn : 0);

        // 返回R对象，并设置数据为Map对象
        return R.ok().setData(resultMap);
    }

    /**
     * CMS_提现
     *
     * */

    @GetMapping("/withdrawal")
    public R withdrawal(@RequestParam(value = "name") String name) {
        String invite;
        if ("xiaoshou".equals(name)) {
            invite = "0617";
        } else {
            invite = "";
        }
//
//        // 获取最新插入数据的信息
//        SaleEntity latestSale = saleMapper.getLatestSaleByInvite(invite);
//
//        if (latestSale != null) {
//            // 将最新插入数据的信息插入到 lin_order_info_history 表中
//            LinOrderInfoHistoryEntity history = new LinOrderInfoHistoryEntity();
////            history.setInviteId(latestSale.getInviteId());
//            history.setInvite(latestSale.getInvite());
//            history.setOrderNo(latestSale.getOrderNo());
//            history.setUserId(latestSale.getUserId());
//            history.setProductId(latestSale.getProductId());
//            history.setTotalFee(latestSale.getTotalFee());
//            history.setOrderStatus(latestSale.getOrderStatus());
//            history.setPointsStatus(latestSale.getPointsStatus());
//            history.setCommissionRatio(latestSale.getCommissionRatio());
//            history.setCommission(latestSale.getCommission());
//            history.setCreateTime(latestSale.getCreateTime());
//            history.setUpdateTime(new Date()); // 更新 update_time 字段为当前时间
//            history.setWithdrawalStatus(2); // 设置提现状态为2（提现中）
//
//            // 插入记录到 lin_order_info_history 表
//            saleMapper.insertOrderInfoHistory(history);
//        }
        // 更新最新插入数据的提现状态为2（提现中）
        saleMapper.updateWithdrawalStatus(invite);

        // 返回 R 对象，并设置消息
        return R.ok().setMessage("提现已发起，对账中");
    }





}
