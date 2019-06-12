package cn.mycar.mapper;



import cn.mycar.pojo.Threshold;

/**
 * @Author jp
 * @Description //TODO
 * @Date 8:51 2019/4/18 0018
 *
 **/

public interface ThresholdMapper {

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
