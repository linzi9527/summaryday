package com.test;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Table.policy;
/**
 *  上报培训内容【终端】
 *  @author zlzhaoe
 *  @version 2017-9-21 下午1:30:06
 */
@Table(name = "st_cti_trainitem", type = policy.VO)
public class Trainitem {

	/**
	 * 主键id
	 */
	@Key(isPrimary = true)
	@Colum(columName = "id", isNUll = false, type = ObjTypes.STRING)
	private String id;
	/**
	 * 学员ID
	 */
	@Colum(columName = "studentId", isNUll = false, type = ObjTypes.STRING)
	private String studentId = "";
	/**
	 * 车辆ID或车牌号
	 */
	@Colum(columName = "carId", isNUll = false, type = ObjTypes.STRING)
	private String carId = "";
	/**
	 * 培训小项标识ID
	 */
	@Colum(columName = "trainId", isNUll = false, type = ObjTypes.STRING)
	private String trainId = "";
	/**
	 * 培训大项标识ID
	 */
	@Colum(columName = "subTrainId", isNUll = false, type = ObjTypes.STRING)
	private String subTrainId = "";
	/**
	 * 培训大项
	 */
	@Colum(columName = "subject", isNUll = false, type = ObjTypes.INTEGER)
	private Integer subject;
	/**
	 * 培训小项
	 */
	@Colum(columName = "item", isNUll = false, type = ObjTypes.INTEGER)
	private Integer item;
	/**
	 * 扣分代码
	 */
	@Colum(columName = "scoreCode", isNUll = false, type = ObjTypes.STRING)
	private String scoreCode = "";
	/**
	 * 项目状态
	 */
	@Colum(columName = "testResult", isNUll = false, type = ObjTypes.STRING)
	private String testResult = "";
	/**
	 * 培训代码
	 */
	@Colum(columName = "praCode", isNUll = false, type = ObjTypes.STRING)
	private String praCode = "";
	/**
	 * 错误纠正代码
	 */
	@Colum(columName = "errorCode", isNUll = false, type = ObjTypes.STRING)
	private String errorCode = "";
	/**
	 * 采集日期，格式： yyyy-MM-dd HH:mm:ss
	 */
	@Colum(columName = "collectionTime", isNUll = false, type = ObjTypes.STRING)
	private String collectionTime = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}

	public String getSubTrainId() {
		return subTrainId;
	}

	public void setSubTrainId(String subTrainId) {
		this.subTrainId = subTrainId;
	}

	public Integer getSubject() {
		return subject;
	}

	public void setSubject(Integer subject) {
		this.subject = subject;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getScoreCode() {
		return scoreCode;
	}

	public void setScoreCode(String scoreCode) {
		this.scoreCode = scoreCode;
	}

	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public String getPraCode() {
		return praCode;
	}

	public void setPraCode(String praCode) {
		this.praCode = praCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
	}

}
