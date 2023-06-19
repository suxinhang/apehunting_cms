package io.github.talelin.latticy.controller.v1;
import io.github.talelin.latticy.entity.SaleEntity;
import io.github.talelin.latticy.mapper.SaleMapper;
import io.github.talelin.latticy.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public R homePageData() {
        String invite ="0617";
        List<SaleEntity> sales = saleMapper.getSalesByInviteall(invite);
        // 创建包含列表的Map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sales", sales);

        // 返回R对象，并设置数据为Map对象
        return R.ok().setData(resultMap);
    }

    /**
     * CMS_提现
     *
     * */

    @GetMapping("/withdrawal")
    public R withdrawal() {
        String invite ="0617";
        List<SaleEntity> sales = saleMapper.getSalesByInviteall(invite);
        // 创建包含列表的Map对象
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("sales", sales);

        // 返回R对象，并设置数据为Map对象
        return R.ok().setData(resultMap);
    }


}
