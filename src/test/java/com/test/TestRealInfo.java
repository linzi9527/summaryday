package com.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.summaryday.framework.db.DBHelper;



public class TestRealInfo {
	
	public static	DBHelper dbHelper=null;
	
	
   public static boolean mainTest(String nn) {
	   dbHelper=DBHelper.getInstance();
	   List<RealInfo> list=new ArrayList<RealInfo>();
		for(int i=0;i<3000;i++){
			RealInfo r=new RealInfo();
			r.setId(nn+"-"+i);
			r.setAngleX("127.2"+i);
			r.setCarId("陕C888"+i);
			r.setStudentId("student00"+i);
			r.setSubTrainId("subTrain00"+i);
			r.setTrainId("train0"+i);
			r.setLat("13.2323432"+i);
			r.setLng("181.232322"+i);
			r.setCollectionTime("time-"+i);
			
			list.add(r);
		}
		return dbHelper.saveByTransaction(list.toArray());
	
   }
   
   public static void main(String[] args) {
	   
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		for (int i = 0; i <5; i++) {
		    fixedThreadPool.execute(new Runnable() {
		        public void run() {
		            try {
		            	System.out.println(Thread.currentThread().getName() + "\t开始批量入库啦....");
		            	long s=System.currentTimeMillis();
		            	boolean f= mainTest("test-"+new Random().nextInt());
		            	long e=System.currentTimeMillis();
		            	System.out.println("结果："+f+",耗时:"+(e-s)/1000);
		                Thread.sleep(500);
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
		        }
		    });
		}
	}
}
