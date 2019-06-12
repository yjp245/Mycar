package cn.mycar.service.impl;

import cn.mycar.mapper.ThresholdMapper;
import cn.mycar.pojo.Threshold;
import cn.mycar.service.ThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author JP
 * @title: ThresholdServiceImpl
 * @projectName 汽车阈值
 * @description:
 * @date 2019/4/18 0018
 */
@Component("threshold")
public class ThresholdServiceImpl implements ThresholdService {

    @Autowired
    ThresholdMapper thresholdMapper;

    /**
     * 添加阈值配置
     * @param t
     * @return
     */
    @Override
    public int add(Threshold t) {

       Threshold threshold= thresholdMapper.selectByDnum(t.getDnum());
       if(threshold!=null){
           //说明已经配置过
           threshold.setMq2_s(t.getMq2_s());
           threshold.setWendu(t.getWendu());
           return   thresholdMapper.updateThreshold(threshold);
       }
        return    thresholdMapper.add(t);
    }

    @Override
    public Threshold selectByDnum(String dnum) {
        return    thresholdMapper.selectByDnum(dnum);
    }

    @Override
    public int updateThreshold(Threshold t) {
        Threshold threshold= thresholdMapper.selectByDnum(t.getDnum());
        //查询是否配置过阈值
        if (threshold!=null){
            threshold.setMq2_s(t.getMq2_s());
            threshold.setWendu(t.getWendu());
         return   thresholdMapper.updateThreshold(threshold);
        }
        return 0;
    }
}
