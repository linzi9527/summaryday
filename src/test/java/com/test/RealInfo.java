package com.test;

import com.summaryday.framework.a.Colum;
import com.summaryday.framework.a.Colum.ObjTypes;
import com.summaryday.framework.a.Key;
import com.summaryday.framework.a.Table;
import com.summaryday.framework.a.Table.policy;


/**
 * 上报培训过程信息【终端】
 * 
 * @author zlzhaoe
 * @version 2017-9-21 下午1:30:06
 */
@Table(name = "st_cti_realinfo",type = policy.VO)
public class RealInfo {

	/**
	 * 主键id
	 */
	@Key(isPrimary = true)
	@Colum(columName = "id", isNUll = false, type = ObjTypes.STRING)
	private String id;

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
	 * 经度
	 */
	@Colum(columName = "lng", isNUll = false, type = ObjTypes.STRING)
	private String lng = "";

	/**
	 * 纬度
	 */
	@Colum(columName = "lat", isNUll = false, type = ObjTypes.STRING)
	private String lat = "";

	/**
	 * 方向角
	 */
	@Colum(columName = "angleX", isNUll = false, type = ObjTypes.STRING)
	private String angleX = "";

	/**
	 * 采集日期，格式：yyyy-MM-dd HH:mm:ss
	 */
	@Colum(columName = "collectionTime", isNUll = false, type = ObjTypes.STRING)
	private String collectionTime = "";

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getAngleX() {
		return angleX;
	}

	public void setAngleX(String angleX) {
		this.angleX = angleX;
	}

	public String getCollectionTime() {
		return collectionTime;
	}

	public void setCollectionTime(String collectionTime) {
		this.collectionTime = collectionTime;
	}

}
