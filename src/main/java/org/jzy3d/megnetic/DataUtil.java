package org.jzy3d.megnetic;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DataUtil {
    Connection connection=Conn.getConnection();
    ResultSet resultSet=null;
    ArrayList arrayList=new ArrayList();
    /**
     * 获得所有用户  
     * @return ArrayList<sampleData>  
     * */
    public ArrayList<SampleData> queryTable(String tableName){
        ArrayList<SampleData> arrayList = new ArrayList<SampleData>();
        String sql="SELECT * FROM " + tableName;
        try {
            Statement stmt=connection.createStatement();
            resultSet=stmt.executeQuery(sql);
            while(resultSet.next()){
                SampleData sampleData=new SampleData();
                sampleData.setmTag(resultSet.getString("Tag"));
                sampleData.setmX(resultSet.getFloat("X"));
                sampleData.setmY(resultSet.getFloat("Y"));
                sampleData.setmZ(resultSet.getFloat("Z"));
                arrayList.add(sampleData);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayList<SampleData> sampleData=new ArrayList<SampleData>();
        sampleData=new DataUtil().queryTable("tb1");
        System.out.println(sampleData.size());
        for (SampleData temp:sampleData
             ) {
            System.out.println(temp.toString());
        }
    }
    /* ArrayList<SampleData> sampleData=new DataUtil().queryTable("tb1");
        Logger logger=Logger.getLogger ("createDataset");
        logger.info("长度:"+String.valueOf(sampleData.size()));
        DefaultXYDataset xydataset = new DefaultXYDataset();
        int i=0;
        int count=1;
        double[] adx = new double[10];
        double[] ady = new double[10];
        double[] adz = new double[10];
        for (SampleData temp:sampleData
                ) {
            ady[i]=temp.getmY();
            adz[i]=temp.getmZ();
            i++;
            if(i%10==0)
            {
                double ad2[][]={ady,adz};
                xydataset.addSeries("series "+String.valueOf(count),ad2);
                count++;
                i=0;
            }

        }*/

}
