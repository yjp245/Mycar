package cn.mycar.service;

import cn.mycar.pojo.Threshold;

/**
 * @author JP
 * @title: ThresholdService
 * @projectName 家用燃氣1.1
 * @description:
 * @date 2019/4/18 00189:06
 */

public interface ThresholdService {

    /**
     * 添加阈值设置
     * @param t
     */
    public int add(Threshold t);


    /**
     * 通过设备编号查询阈值配置
     * @param dnum
     * @return
     */
    public Threshold selectByDnum(String dnum);


    /**
     * 修改阈值配置
     * @param threshold
     * @return
     */
    public int updateThreshold(Threshold threshold);

}
